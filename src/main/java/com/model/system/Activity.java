package com.model.system;

public class Activity {
    private String activityId;

    private String activityName;

    private String activityType;

    private String activityStatus;

    private String activityDescription;

    private String activityTime;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

	public Activity(String activityId, String activityName, String activityType, String activityStatus,
			String activityDescription, String activityTime) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.activityType = activityType;
		this.activityStatus = activityStatus;
		this.activityDescription = activityDescription;
		this.activityTime = activityTime;
	}

	public Activity() {
		super();
	}

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", activityName=" + activityName + ", activityType="
				+ activityType + ", activityStatus=" + activityStatus + ", activityDescription=" + activityDescription
				+ ", activityTime=" + activityTime + "]";
	}
    
}