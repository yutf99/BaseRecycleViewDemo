package com.destiny.baserecycleviewdemo.utils;

/**
 * 常量类
 */
public class Constant {

    /**
     * 服务器地址
     */
    public static final String HOST = "http://120.24.183.230:9898";//正式
//    public static final String HOST = "http://10.0.0.7:6010";//正式

    /**
     * 服务器接口地址
     * 示例：http://10.0.0.7:6010/mailtrip-web/apppostcard/getPostcardList.do?code=1&token=716fcb6cc4a14549a2327513f65048b8
     * 测试
     */
    public static final String INTERFACE_HOST = HOST + "/mailtrip-web/";

    /**
     * 七牛资源默认路径
     * 格式：Constants.QiNiuURL+服务端返回文件名
     */
    public static final String QINIU_ADDRESS = "http://7xsyn6.com2.z0.glb.qiniucdn.com/";

}