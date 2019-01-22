package com.model.system;

public class UserMsg {
    private String userMsgId;

    private String userId;

    private String userAge;

    private String userSex;

    private String userEmail;

    private String userPhone;

    private String userAddr;

    private String userProHobby;

    public String getUserMsgId() {
        return userMsgId;
    }

    public void setUserMsgId(String userMsgId) {
        this.userMsgId = userMsgId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserProHobby() {
        return userProHobby;
    }

    public void setUserProHobby(String userProHobby) {
        this.userProHobby = userProHobby;
    }

	public UserMsg(String userMsgId, String userId, String userAge, String userSex, String userEmail, String userPhone,
			String userAddr, String userProHobby) {
		super();
		this.userMsgId = userMsgId;
		this.userId = userId;
		this.userAge = userAge;
		this.userSex = userSex;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddr = userAddr;
		this.userProHobby = userProHobby;
	}

	public UserMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserMsg [userMsgId=" + userMsgId + ", userId=" + userId + ", userAge=" + userAge + ", userSex="
				+ userSex + ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userAddr=" + userAddr
				+ ", userProHobby=" + userProHobby + "]";
	}
    
}