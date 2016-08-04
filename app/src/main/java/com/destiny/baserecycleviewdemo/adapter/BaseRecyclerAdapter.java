package com.destiny.baserecycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于RecycleView的万能适配器
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {
    protected final List<T> mItems;
    protected final Context mContext;
    protected LayoutInflater mInflater;
    private OnItemClickListener mClickListener;
    private OnItemLongClickListener mLongClickListener;
    private int layoutId;//RecycleView的Item布局id

    public BaseRecyclerAdapter(Context ctx,int layoutId, List<T> list) {
        mItems = (list != null) ? list : new ArrayList<T>();
        this.layoutId = layoutId;
        mContext = ctx;
        mInflater = LayoutInflater.from(ctx);

    }

    /**
     * 用于上拉加载时添加更多数据
     * @param items
     */
    public void append(List<T> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        final RecyclerViewHolder holder = new RecyclerViewHolder(mContext, mInflater.inflate(layoutId, parent, false));
        if (mClickListener != null) {//注册点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        mClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });
        }
        if (mLongClickListener != null) {//注册长按事件
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                        mLongClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                    return true;
                }
            });
        }
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
         bindData(holder, position, mItems.get(position));
    }


    @Override
    final public int getItemCount() {
        return mItems.size();
    }

    //添加数据到特定的位置
    public void add(int pos,T item) {
            mItems.add(item);
            notifyItemInserted(pos);
    }

    //在特定位置删除数据
    public void delete(int pos) {
            mItems.remove(pos);
            notifyItemRemoved(pos);
    }


    final public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    final public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mLongClickListener = listener;
    }

    /**
     * 重写该方法进行item数据项视图的数据绑定
     *
     * @param holder   通过holder获得item中的子View，进行数据绑定
     * @param position 该item的position
     * @param item     映射到该item的数据
     */
    abstract protected void bindData(RecyclerViewHolder holder, int position, T item);

    public interface OnItemClickListener {
        void onItemClick(View itemView, int pos);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View itemView, int pos);
    }

}
