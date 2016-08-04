package com.destiny.baserecycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.destiny.baserecycleviewdemo.R;
import com.destiny.baserecycleviewdemo.utils.Constant;

/**
 * 基于RecyclerView的ViewHolder
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    /**
     *集合类，layout里包含的View,以view的id作为key，value是view对象
     */
    private SparseArray<View> mViews;
    private Context mContext;

    public RecyclerViewHolder(Context ctx, View itemView) {
        super(itemView);
        mContext = ctx;
        mViews = new SparseArray<View>();
    }

    public View getItemView(){
        return itemView;
    }
    private <T extends View> T findViewById(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getView(int viewId) {
        return findViewById(viewId);
    }

    public TextView getTextView(int viewId) {
        return (TextView) getView(viewId);
    }

    public Button getButton(int viewId) {
        return (Button) getView(viewId);
    }

    public ImageView getImageView(int viewId) {
        return (ImageView) getView(viewId);
    }

    public ImageButton getImageButton(int viewId) {
        return (ImageButton) getView(viewId);
    }

    public EditText getEditText(int viewId) {
        return (EditText) getView(viewId);
    }

    /**
     *设置view的点击事件
     */
    public RecyclerViewHolder setClickListener(int viewId, View.OnClickListener listener) {
        View view = findViewById(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     *设置网络图片地址
     */
    public RecyclerViewHolder setImageUrl(int viewId, String  url) {
        ImageView view = findViewById(viewId);
        Glide.with(mContext).load(Constant.QINIU_ADDRESS+url).placeholder(R.drawable.default_img).centerCrop().into(view);
        return this;
    }

    public RecyclerViewHolder setText(int viewId, String value) {
        TextView view = findViewById(viewId);
        view.setText(value);
        return this;
    }

    public RecyclerViewHolder setBackground(int viewId, int resId) {
        View view = findViewById(viewId);
        view.setBackgroundResource(resId);
        return this;
    }

    /**
     * 其他方法可自行扩展……
     */
}
