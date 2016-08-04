package com.destiny.baserecycleviewdemo.okhttp.builder;


import com.destiny.baserecycleviewdemo.okhttp.OkHttpUtils;
import com.destiny.baserecycleviewdemo.okhttp.request.OtherRequest;
import com.destiny.baserecycleviewdemo.okhttp.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends com.destiny.baserecycleviewdemo.okhttp.builder.GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
