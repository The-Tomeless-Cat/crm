package com.model.system;

import java.util.Date;

public class User {
    private String userId;

    private Integer userAge;

    private String userSex;

    private String userPhone;

    private String loginName;

    private String loginPassword;

    private Date userBirthday;

    private Date createTime;

    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

	public User(String userId, Integer userAge, String userSex, String userPhone, String loginName,
			String loginPassword, Date userBirthday, Date createTime, String userName) {
		super();
		this.userId = userId;
		this.userAge = userAge;
		this.userSex = userSex;
		this.userPhone = userPhone;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.userBirthday = userBirthday;
		this.createTime = createTime;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAge=" + userAge + ", userSex=" + userSex + ", userPhone=" + userPhone
				+ ", loginName=" + loginName + ", loginPassword=" + loginPassword + ", userBirthday=" + userBirthday
				+ ", createTime=" + createTime + ", userName=" + userName + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}