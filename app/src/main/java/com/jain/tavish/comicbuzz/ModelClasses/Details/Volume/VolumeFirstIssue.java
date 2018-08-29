package com.jain.tavish.comicbuzz.ModelClasses.Details.Volume;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VolumeFirstIssue {

    @SerializedName("api_detail_url")
    @Expose
    private String apiDetailUrl;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("issue_number")
    @Expose
    private String issueNumber;

    public String getApiDetailUrl() {
        return apiDetailUrl;
    }

    public void setApiDetailUrl(String apiDetailUrl) {
        this.apiDetailUrl = apiDetailUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

}