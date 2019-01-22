package com.model.system;

public class Product {

	private String productId;

    private String productName;

    private String productMoney;

    private String productType;

    private String productDsc;

    private String pruductKucun;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductMoney() {
        return productMoney;
    }

    public void setProductMoney(String productMoney) {
        this.productMoney = productMoney;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDsc() {
        return productDsc;
    }

    public void setProductDsc(String productDsc) {
        this.productDsc = productDsc;
    }

    public String getPruductKucun() {
        return pruductKucun;
    }

    public void setPruductKucun(String pruductKucun) {
        this.pruductKucun = pruductKucun;
    }

	public Product() {
		super();
		
	}

	public Product(String productId, String productName, String productMoney, String productType, String productDsc,
			String pruductKucun) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productMoney = productMoney;
		this.productType = productType;
		this.productDsc = productDsc;
		this.pruductKucun = pruductKucun;
	}
    
	 @Override
		public String toString() {
			return "Product [productId=" + productId + ", productName=" + productName + ", productMoney=" + productMoney
					+ ", productType=" + productType + ", productDsc=" + productDsc + ", pruductKucun=" + pruductKucun
					+ "]";
		}
}