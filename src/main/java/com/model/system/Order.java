package com.model.system;

import java.util.Date;

public class Order {
    private String orderId;

    private Date orderCreatetime;

    private String orderType;

    private String orderState;

    private String orderDesc;

    private String userId;

    private String orderTotal;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderCreatetime() {
        return orderCreatetime;
    }

    public void setOrderCreatetime(Date orderCreatetime) {
        this.orderCreatetime = orderCreatetime;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCreatetime=" + orderCreatetime + ", orderType=" + orderType
				+ ", orderState=" + orderState + ", orderDesc=" + orderDesc + ", userId=" + userId + ", orderTotal="
				+ orderTotal + "]";
	}
}