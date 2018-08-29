package com.jain.tavish.comicbuzz.ModelClasses.Main.Volumes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VolumesResult {

    @SerializedName("aliases")
    @Expose
    private Object aliases;
    @SerializedName("api_detail_url")
    @Expose
    private String apiDetailUrl;
    @SerializedName("count_of_issues")
    @Expose
    private Integer countOfIssues;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("date_last_updated")
    @Expose
    private String dateLastUpdated;
    @SerializedName("deck")
    @Expose
    private Object deck;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("first_issue")
    @Expose
    private VolumesFirstIssue volumesFirstIssue;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private VolumesImage image;
    @SerializedName("last_issue")
    @Expose
    private VolumesLastIssue volumesLastIssue;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("publisher")
    @Expose
    private VolumesPublisher publisher;
    @SerializedName("site_detail_url")
    @Expose
    private String siteDetailUrl;
    @SerializedName("start_year")
    @Expose
    private String startYear;

    public Object getAliases() {
        return aliases;
    }

    public void setAliases(Object aliases) {
        this.aliases = aliases;
    }

    public String getApiDetailUrl() {
        return apiDetailUrl;
    }

    public void setApiDetailUrl(String apiDetailUrl) {
        this.apiDetailUrl = apiDetailUrl;
    }

    public Integer getCountOfIssues() {
        return countOfIssues;
    }

    public void setCountOfIssues(Integer countOfIssues) {
        this.countOfIssues = countOfIssues;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(String dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public Object getDeck() {
        return deck;
    }

    public void setDeck(Object deck) {
        this.deck = deck;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VolumesFirstIssue getVolumesFirstIssue() {
        return volumesFirstIssue;
    }

    public void setVolumesFirstIssue(VolumesFirstIssue volumesFirstIssue) {
        this.volumesFirstIssue = volumesFirstIssue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VolumesImage getImage() {
        return image;
    }

    public void setImage(VolumesImage image) {
        this.image = image;
    }

    public VolumesLastIssue getVolumesLastIssue() {
        return volumesLastIssue;
    }

    public void setVolumesLastIssue(VolumesLastIssue volumesLastIssue) {
        this.volumesLastIssue = volumesLastIssue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VolumesPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(VolumesPublisher publisher) {
        this.publisher = publisher;
    }

    public String getSiteDetailUrl() {
        return siteDetailUrl;
    }

    public void setSiteDetailUrl(String siteDetailUrl) {
        this.siteDetailUrl = siteDetailUrl;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

}