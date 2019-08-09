package org.jerfan.red.vo;

import java.io.Serializable;

public class TradeOrderBean implements Serializable {

    private static final long serialVersionUID = -7342462638424711918L;

    private String tradeNo;

    private String orderNo;

    private String orderFrom;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }
}
