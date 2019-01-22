package com.model.system;

import java.util.Date;


public class ProductCollect {
    private String productMsgId;

	private String productName;

	private String productType;

	private Date marketTime;

	public String getProductMsgId() {
		return productMsgId;
	}

	public void setProductMsgId(String productMsgId) {
		this.productMsgId = productMsgId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Date getMarketTime() {
		return marketTime;
	}

	public void setMarketTime(Date marketTime) {
		this.marketTime = marketTime;
	}


	public ProductCollect(String productMsgId, String productName, String productType, Date marketTime) {
		super();
		this.productMsgId = productMsgId;
		this.productName = productName;
		this.productType = productType;
		this.marketTime = marketTime;
	}

	public ProductCollect() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductCollect [productMsgId=" + productMsgId + ", productName=" + productName + ", productType="
				+ productType + ", marketTime=" + marketTime + "]";
	}
    
}