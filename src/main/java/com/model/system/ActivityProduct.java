package com.model.system;

public class ActivityProduct {

	private String activityProductId;

    private String activityId;

    private String productId;

    public String getActivityProductId() {
        return activityProductId;
    }

    public void setActivityProductId(String activityProductId) {
        this.activityProductId = activityProductId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

	public ActivityProduct() {
		super();
		
	}

	public ActivityProduct(String activityProductId, String activityId, String productId) {
		super();
		this.activityProductId = activityProductId;
		this.activityId = activityId;
		this.productId = productId;
	}
    
	 @Override
		public String toString() {
			return "ActivityProduct [activityProductId=" + activityProductId + ", activityId=" + activityId + ", productId="
					+ productId + "]";
		}
}