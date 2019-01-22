package com.model.system;

import java.util.Date;

public class AfterSales {
    private String afterSalesId;

    private String orderInformation;

    private String afterSalesDsc;

    private Date afterSalesCreateTime;

    private String waiterId;

    public String getAfterSalesId() {
        return afterSalesId;
    }

    public void setAfterSalesId(String afterSalesId) {
        this.afterSalesId = afterSalesId;
    }

    public String getOrderInformation() {
        return orderInformation;
    }

    public void setOrderInformation(String orderInformation) {
        this.orderInformation = orderInformation;
    }

    public String getAfterSalesDsc() {
        return afterSalesDsc;
    }

    public void setAfterSalesDsc(String afterSalesDsc) {
        this.afterSalesDsc = afterSalesDsc;
    }

    public Date getAfterSalesCreateTime() {
        return afterSalesCreateTime;
    }

    public void setAfterSalesCreateTime(Date afterSalesCreateTime) {
        this.afterSalesCreateTime = afterSalesCreateTime;
    }

    public String getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId;
    }

	@Override
	public String toString() {
		return "AfterSales [afterSalesId=" + afterSalesId + ", orderInformation=" + orderInformation
				+ ", afterSalesDsc=" + afterSalesDsc + ", afterSalesCreateTime=" + afterSalesCreateTime + ", waiterId="
				+ waiterId + "]";
	}

	public AfterSales() {
		super();
	}

	public AfterSales(String afterSalesId, String orderInformation, String afterSalesDsc, Date afterSalesCreateTime,
			String waiterId) {
		super();
		this.afterSalesId = afterSalesId;
		this.orderInformation = orderInformation;
		this.afterSalesDsc = afterSalesDsc;
		this.afterSalesCreateTime = afterSalesCreateTime;
		this.waiterId = waiterId;
	}
    
    
}