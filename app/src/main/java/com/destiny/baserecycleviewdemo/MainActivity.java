package com.destiny.baserecycleviewdemo;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.destiny.baserecycleviewdemo.adapter.BaseRecyclerAdapter;
import com.destiny.baserecycleviewdemo.adapter.RecyclerViewHolder;
import com.destiny.baserecycleviewdemo.model.DrawBack;
import com.destiny.baserecycleviewdemo.model.JsonGenericsSerializator;
import com.destiny.baserecycleviewdemo.okhttp.OkHttpUtils;
import com.destiny.baserecycleviewdemo.okhttp.callback.GenericsCallback;
import com.destiny.baserecycleviewdemo.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

public class MainActivity extends AppCompatActivity implements OnRefreshListener, OnLoadMoreListener {
    private static final int LOAD_MORE = 1;//加载更多
    private static final int REFRESH = 2;//刷新

    @Bind(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;
    @Bind(R.id.swipe_target)
    RecyclerView mRecycleview;

    private int showCount = 2;//每页数量
    private int currentPage = 1;//页码
    private int type ;

    private BaseRecyclerAdapter adapter;

    private List<DrawBack.DataListBean> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (datas == null || datas.size() == 0) {
            loadData(showCount, currentPage);
        }

        swipeToLoadLayout.setOnRefreshListener(this);

        swipeToLoadLayout.setOnLoadMoreListener(this);
    }

    private void loadData(int count, int page) {
        String url = Constant.INTERFACE_HOST + "appdiscount/getAllDiscount";
        OkHttpUtils
                .post()
                .url(url)
                .tag(this)
                .addParams("rim_id", "12")
                .addParams("showCount", count+"")
                .addParams("currentPage", page + "")
                .build()
                .execute(new GenericsCallback<DrawBack>(new JsonGenericsSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        if (swipeToLoadLayout != null) {//请求出错时结束刷新或加载
                            swipeToLoadLayout.setRefreshing(false);
                            swipeToLoadLayout.setLoadingMore(false);
                        }
                        System.out.println("msg===>" + e.getMessage());
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(DrawBack response, int id) {
                        if (swipeToLoadLayout != null) {//正在刷新或加载时防止重复刷新或加载
                            if (swipeToLoadLayout.isRefreshing()) {
                                swipeToLoadLayout.setRefreshing(false);
                            } else if (swipeToLoadLayout.isLoadingMore()) {
                                swipeToLoadLayout.setLoadingMore(false);
                            }
                        }
                        datas = response.getDataList();
                        if (datas != null && datas.size() > 0) {
                            if (LOAD_MORE == type) {//加载更多，将返回的数据添加到适配器
                                adapter.append(datas);
                            } else {//刷新，重新加载数据
                                initData();
                            }
                        } else {
                            if (LOAD_MORE == type) {//加载更多时返回size为0说明没有更多数据了
                                Toast.makeText(MainActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                                swipeToLoadLayout.setLoadingMore(false);
                            }
                        }

                    }
                });
    }

    private void initData() {
        /**
         * 基于RecycleView的实现
         * ListView用LinearLayoutManager，
         * GridView用GridLayoutManager，
         *瀑布流用StaggeredGridLayoutManager
         * RecycleView默认没有分隔线，需自行添加。
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleview.setLayoutManager(layoutManager);

        adapter = new BaseRecyclerAdapter<DrawBack.DataListBean>(this, R.layout.item_recycleview, datas) {
            @Override
            protected void bindData(RecyclerViewHolder holder, int position, DrawBack.DataListBean item) {
                holder.setImageUrl(R.id.iv_recycle_item, item.getCover_img());
            }

        };
        mRecycleview.setAdapter(adapter);

        /**
         * 滚动监听，当滚动到底部时自动加载更多
         */
        mRecycleview.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (!ViewCompat.canScrollVertically(recyclerView, 1)) {
                        swipeToLoadLayout.setLoadingMore(true);
                    }
                }
            }
        });

    }

    @Override
    public void onLoadMore() {
        type = LOAD_MORE;
        loadData(showCount,++currentPage);
    }

    @Override
    public void onRefresh() {
        type = REFRESH;
        loadData(showCount,currentPage);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 网络请求时设置tag为当前activity，当activity被销毁时取消该activity的所有网络请求
         */
        OkHttpUtils.getInstance().cancelTag(this);
    }
}
