package com.jain.tavish.comicbuzz.ModelClasses.Main.Characters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CharactersResult {

    @SerializedName("aliases")
    @Expose
    private String aliases;
    @SerializedName("api_detail_url")
    @Expose
    private String apiDetailUrl;
    @SerializedName("birth")
    @Expose
    private Object birth;
    @SerializedName("count_of_issue_appearances")
    @Expose
    private Integer countOfIssueAppearances;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("date_last_updated")
    @Expose
    private String dateLastUpdated;
    @SerializedName("deck")
    @Expose
    private String deck;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("first_appeared_in_issue")
    @Expose
    private CharactersFirstAppearedInIssue charactersFirstAppearedInIssue;
    @SerializedName("gender")
    @Expose
    private Integer gender;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private CharactersImage charactersImage;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("origin")
    @Expose
    private CharactersOrigin origin;
    @SerializedName("publisher")
    @Expose
    private CharactersPublisher publisher;
    @SerializedName("real_name")
    @Expose
    private String realName;
    @SerializedName("site_detail_url")
    @Expose
    private String siteDetailUrl;

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getApiDetailUrl() {
        return apiDetailUrl;
    }

    public void setApiDetailUrl(String apiDetailUrl) {
        this.apiDetailUrl = apiDetailUrl;
    }

    public Object getBirth() {
        return birth;
    }

    public void setBirth(Object birth) {
        this.birth = birth;
    }

    public Integer getCountOfIssueAppearances() {
        return countOfIssueAppearances;
    }

    public void setCountOfIssueAppearances(Integer countOfIssueAppearances) {
        this.countOfIssueAppearances = countOfIssueAppearances;
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

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CharactersFirstAppearedInIssue getCharactersFirstAppearedInIssue() {
        return charactersFirstAppearedInIssue;
    }

    public void setCharactersFirstAppearedInIssue(CharactersFirstAppearedInIssue charactersFirstAppearedInIssue) {
        this.charactersFirstAppearedInIssue = charactersFirstAppearedInIssue;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CharactersImage getCharactersImage() {
        return charactersImage;
    }

    public void setCharactersImage(CharactersImage charactersImage) {
        this.charactersImage = charactersImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharactersOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(CharactersOrigin origin) {
        this.origin = origin;
    }

    public CharactersPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(CharactersPublisher publisher) {
        this.publisher = publisher;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSiteDetailUrl() {
        return siteDetailUrl;
    }

    public void setSiteDetailUrl(String siteDetailUrl) {
        this.siteDetailUrl = siteDetailUrl;
    }

}