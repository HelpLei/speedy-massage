package com.bootdo.phry.weixin.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangj
 * @email j.wang@huidutech.com.cn
 * @date 2018-09-21 15:22:37
 */
public class WeixinEntity implements Serializable {

    //审核状态状态字符串
    private String examineStatusStr;
    //单据状态字符串
    private String statusStr;
    //天数
    private String days;
    //费用
    private String money;
    //时间
    private String timeStr;
    //生产任务指令单详情生产状态字符串
    private String detailStatusStr;
    //物料出库单使用地点字符串
    private String useAddressStr;

    private String stuffInStoreDateStr;

    private String deliverTimeStr;
    //付款状态字符串
    private String paymentStatusStr;

    public void setExamineStatusStr(String examineStatusStr) {
        this.examineStatusStr = examineStatusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getExamineStatusStr() {
        return examineStatusStr;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public String getDays() {
        return days;
    }


    public void setMoney(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setDetailStatusStr(String detailStatusStr) {
        this.detailStatusStr = detailStatusStr;
    }

    public String getDetailStatusStr() {
        return detailStatusStr;
    }

    public void setUseAddressStr(String useAddressStr) {
        this.useAddressStr = useAddressStr;
    }

    public String getUseAddressStr() {
        return useAddressStr;
    }

    public void setStuffInStoreDateStr(String stuffInStoreDateStr) {
        this.stuffInStoreDateStr = stuffInStoreDateStr;
    }

    public void setDeliverTimeStr(String deliverTimeStr) {
        this.deliverTimeStr = deliverTimeStr;
    }

    public String getStuffInStoreDateStr() {
        return stuffInStoreDateStr;
    }

    public String getDeliverTimeStr() {
        return deliverTimeStr;
    }

    public void setPaymentStatusStr(String paymentStatusStr) {
        this.paymentStatusStr = paymentStatusStr;
    }

    public String getPaymentStatusStr() {
        return paymentStatusStr;
    }

}
