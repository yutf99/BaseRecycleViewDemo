package com.destiny.baserecycleviewdemo.model;

import java.io.Serializable;
import java.util.List;

/**
 * ======================================================
 * 作    者：谢光亚
 * <p/>
 * 版    本：1.0
 * <p/>
 * 创建日期：2016/4/21
 * <p/>
 * 描   述：
 * <p/>
 * ======================================================
 */
public class DrawBack implements Serializable {

    private String result;
    private String msg;

    private List<DataListBean> dataList;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBean {
        private String phone_number;
        private String location;
        private String operation_time;
        private String openTime;
        private String cover_img;
        private String descriptions;
        private String change_time;
        private String numbers;
        private String info1;
        private String latitudes;
        private String discount_details;
        private String info2;
        private String tags;
        private int rim_id;
        private String consumeTime;
        private int user_discount;
        private int mall_id;
        private String busInfo;
        private String theme;
        private String mall_en_name;
        private String longitudes;
        private int discount_status;
        private String tips;
        private String business_type;
        private String ticketInfo;
        private String discount_privilege;
        private String discount_application;
        private String mall_cn_name;

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getOperation_time() {
            return operation_time;
        }

        public void setOperation_time(String operation_time) {
            this.operation_time = operation_time;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public String getDescriptions() {
            return descriptions;
        }

        public void setDescriptions(String descriptions) {
            this.descriptions = descriptions;
        }

        public String getChange_time() {
            return change_time;
        }

        public void setChange_time(String change_time) {
            this.change_time = change_time;
        }

        public String getNumbers() {
            return numbers;
        }

        public void setNumbers(String numbers) {
            this.numbers = numbers;
        }

        public String getInfo1() {
            return info1;
        }

        public void setInfo1(String info1) {
            this.info1 = info1;
        }

        public String getLatitudes() {
            return latitudes;
        }

        public void setLatitudes(String latitudes) {
            this.latitudes = latitudes;
        }

        public String getDiscount_details() {
            return discount_details;
        }

        public void setDiscount_details(String discount_details) {
            this.discount_details = discount_details;
        }

        public String getInfo2() {
            return info2;
        }

        public void setInfo2(String info2) {
            this.info2 = info2;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public int getRim_id() {
            return rim_id;
        }

        public void setRim_id(int rim_id) {
            this.rim_id = rim_id;
        }

        public String getConsumeTime() {
            return consumeTime;
        }

        public void setConsumeTime(String consumeTime) {
            this.consumeTime = consumeTime;
        }

        public int getUser_discount() {
            return user_discount;
        }

        public void setUser_discount(int user_discount) {
            this.user_discount = user_discount;
        }

        public int getMall_id() {
            return mall_id;
        }

        public void setMall_id(int mall_id) {
            this.mall_id = mall_id;
        }

        public String getBusInfo() {
            return busInfo;
        }

        public void setBusInfo(String busInfo) {
            this.busInfo = busInfo;
        }

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public String getMall_en_name() {
            return mall_en_name;
        }

        public void setMall_en_name(String mall_en_name) {
            this.mall_en_name = mall_en_name;
        }

        public String getLongitudes() {
            return longitudes;
        }

        public void setLongitudes(String longitudes) {
            this.longitudes = longitudes;
        }

        public int getDiscount_status() {
            return discount_status;
        }

        public void setDiscount_status(int discount_status) {
            this.discount_status = discount_status;
        }

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }

        public String getBusiness_type() {
            return business_type;
        }

        public void setBusiness_type(String business_type) {
            this.business_type = business_type;
        }

        public String getTicketInfo() {
            return ticketInfo;
        }

        public void setTicketInfo(String ticketInfo) {
            this.ticketInfo = ticketInfo;
        }

        public String getDiscount_privilege() {
            return discount_privilege;
        }

        public void setDiscount_privilege(String discount_privilege) {
            this.discount_privilege = discount_privilege;
        }

        public String getDiscount_application() {
            return discount_application;
        }

        public void setDiscount_application(String discount_application) {
            this.discount_application = discount_application;
        }

        public String getMall_cn_name() {
            return mall_cn_name;
        }

        public void setMall_cn_name(String mall_cn_name) {
            this.mall_cn_name = mall_cn_name;
        }
    }
}
