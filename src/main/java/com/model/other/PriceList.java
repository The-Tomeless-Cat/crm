package com.model.other;

import java.util.Date;

public class PriceList {
    private String priceListId;

    private String productPriceName;

    private String productListDesc;

    private String productUnitPrice;

    private String productSellingPrice;

    private String productSourceCompany;

    private String productRemark;

    private Date productListCreatetime;

    public String getPriceListId() {
        return priceListId;
    }

    public void setPriceListId(String priceListId) {
        this.priceListId = priceListId;
    }

    public String getProductPriceName() {
        return productPriceName;
    }

    public void setProductPriceName(String productPriceName) {
        this.productPriceName = productPriceName;
    }

    public String getProductListDesc() {
        return productListDesc;
    }

    public void setProductListDesc(String productListDesc) {
        this.productListDesc = productListDesc;
    }

    public String getProductUnitPrice() {
        return productUnitPrice;
    }

    public void setProductUnitPrice(String productUnitPrice) {
        this.productUnitPrice = productUnitPrice;
    }

    public String getProductSellingPrice() {
        return productSellingPrice;
    }

    public void setProductSellingPrice(String productSellingPrice) {
        this.productSellingPrice = productSellingPrice;
    }

    public String getProductSourceCompany() {
        return productSourceCompany;
    }

    public void setProductSourceCompany(String productSourceCompany) {
        this.productSourceCompany = productSourceCompany;
    }

    public String getProductRemark() {
        return productRemark;
    }

    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark;
    }

    public Date getProductListCreatetime() {
        return productListCreatetime;
    }

    public void setProductListCreatetime(Date productListCreatetime) {
        this.productListCreatetime = productListCreatetime;
    }

	@Override
	public String toString() {
		return "PriceList [priceListId=" + priceListId + ", productPriceName=" + productPriceName + ", productListDesc="
				+ productListDesc + ", productUnitPrice=" + productUnitPrice + ", productSellingPrice="
				+ productSellingPrice + ", productSourceCompany=" + productSourceCompany + ", productRemark="
				+ productRemark + ", productListCreatetime=" + productListCreatetime + "]";
	}
}