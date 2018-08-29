package com.jain.tavish.comicbuzz.ModelClasses.Details.Volume;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VolumeResult {

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
    private Object description;
    @SerializedName("first_issue")
    @Expose
    private VolumeFirstIssue firstIssue;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private VolumeImage image;
    @SerializedName("issues")
    @Expose
    private List<VolumeIssue> issues = null;
    @SerializedName("last_issue")
    @Expose
    private VolumeLastIssue lastIssue;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("people")
    @Expose
    private List<VolumePerson> people = null;
    @SerializedName("publisher")
    @Expose
    private VolumePublisher publisher;
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

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public VolumeFirstIssue getFirstIssue() {
        return firstIssue;
    }

    public void setFirstIssue(VolumeFirstIssue firstIssue) {
        this.firstIssue = firstIssue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VolumeImage getImage() {
        return image;
    }

    public void setImage(VolumeImage image) {
        this.image = image;
    }

    public List<VolumeIssue> getIssues() {
        return issues;
    }

    public void setIssues(List<VolumeIssue> issues) {
        this.issues = issues;
    }

    public VolumeLastIssue getLastIssue() {
        return lastIssue;
    }

    public void setLastIssue(VolumeLastIssue lastIssue) {
        this.lastIssue = lastIssue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VolumePerson> getPeople() {
        return people;
    }

    public void setPeople(List<VolumePerson> people) {
        this.people = people;
    }

    public VolumePublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(VolumePublisher publisher) {
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