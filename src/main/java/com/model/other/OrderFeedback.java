package com.model.other;

import java.util.Date;

public class OrderFeedback {
    private String feedbackId;

    private String userName;

    private String userSex;

    private String userContact;

    private String productName;

    private String productBuydate;

    private String productProblem;

    private Date feedbackCreatetime;

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBuydate() {
        return productBuydate;
    }

    public void setProductBuydate(String productBuydate) {
        this.productBuydate = productBuydate;
    }

    public String getProductProblem() {
        return productProblem;
    }

    public void setProductProblem(String productProblem) {
        this.productProblem = productProblem;
    }

    public Date getFeedbackCreatetime() {
        return feedbackCreatetime;
    }

    public void setFeedbackCreatetime(Date feedbackCreatetime) {
        this.feedbackCreatetime = feedbackCreatetime;
    }

}