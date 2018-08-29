package com.jain.tavish.comicbuzz.ModelClasses.Details.Issue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IssueResult {

    @SerializedName("aliases")
    @Expose
    private Object aliases;
    @SerializedName("api_detail_url")
    @Expose
    private String apiDetailUrl;
    @SerializedName("character_credits")
    @Expose
    private List<IssueCharacterCredits> characterCredits = null;
    @SerializedName("character_died_in")
    @Expose
    private List<Object> characterDiedIn = null;
    @SerializedName("concept_credits")
    @Expose
    private List<Object> conceptCredits = null;
    @SerializedName("cover_date")
    @Expose
    private String coverDate;
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
    @SerializedName("first_appearance_characters")
    @Expose
    private Object firstAppearanceCharacters;
    @SerializedName("first_appearance_concepts")
    @Expose
    private Object firstAppearanceConcepts;
    @SerializedName("first_appearance_locations")
    @Expose
    private Object firstAppearanceLocations;
    @SerializedName("first_appearance_objects")
    @Expose
    private Object firstAppearanceObjects;
    @SerializedName("first_appearance_storyarcs")
    @Expose
    private Object firstAppearanceStoryarcs;
    @SerializedName("first_appearance_teams")
    @Expose
    private Object firstAppearanceTeams;
    @SerializedName("has_staff_review")
    @Expose
    private Boolean hasStaffReview;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private IssueImage image;
    @SerializedName("issue_number")
    @Expose
    private String issueNumber;
    @SerializedName("location_credits")
    @Expose
    private List<IssueLocationCredits> locationCredits = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("object_credits")
    @Expose
    private List<IssueObjectCredits> objectCredits = null;
    @SerializedName("person_credits")
    @Expose
    private List<IssuePersonCredits> personCredits = null;
    @SerializedName("site_detail_url")
    @Expose
    private String siteDetailUrl;
    @SerializedName("store_date")
    @Expose
    private Object storeDate;
    @SerializedName("story_arc_credits")
    @Expose
    private List<Object> storyArcCredits = null;
    @SerializedName("team_credits")
    @Expose
    private List<IssueTeamCredits> teamCredits = null;
    @SerializedName("team_disbanded_in")
    @Expose
    private List<Object> teamDisbandedIn = null;
    @SerializedName("volume")
    @Expose
    private IssueVolume volume;

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

    public List<IssueCharacterCredits> getCharacterCredits() {
        return characterCredits;
    }

    public void setCharacterCredits(List<IssueCharacterCredits> characterCredits) {
        this.characterCredits = characterCredits;
    }

    public List<Object> getCharacterDiedIn() {
        return characterDiedIn;
    }

    public void setCharacterDiedIn(List<Object> characterDiedIn) {
        this.characterDiedIn = characterDiedIn;
    }

    public List<Object> getConceptCredits() {
        return conceptCredits;
    }

    public void setConceptCredits(List<Object> conceptCredits) {
        this.conceptCredits = conceptCredits;
    }

    public String getCoverDate() {
        return coverDate;
    }

    public void setCoverDate(String coverDate) {
        this.coverDate = coverDate;
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

    public Object getFirstAppearanceCharacters() {
        return firstAppearanceCharacters;
    }

    public void setFirstAppearanceCharacters(Object firstAppearanceCharacters) {
        this.firstAppearanceCharacters = firstAppearanceCharacters;
    }

    public Object getFirstAppearanceConcepts() {
        return firstAppearanceConcepts;
    }

    public void setFirstAppearanceConcepts(Object firstAppearanceConcepts) {
        this.firstAppearanceConcepts = firstAppearanceConcepts;
    }

    public Object getFirstAppearanceLocations() {
        return firstAppearanceLocations;
    }

    public void setFirstAppearanceLocations(Object firstAppearanceLocations) {
        this.firstAppearanceLocations = firstAppearanceLocations;
    }

    public Object getFirstAppearanceObjects() {
        return firstAppearanceObjects;
    }

    public void setFirstAppearanceObjects(Object firstAppearanceObjects) {
        this.firstAppearanceObjects = firstAppearanceObjects;
    }

    public Object getFirstAppearanceStoryarcs() {
        return firstAppearanceStoryarcs;
    }

    public void setFirstAppearanceStoryarcs(Object firstAppearanceStoryarcs) {
        this.firstAppearanceStoryarcs = firstAppearanceStoryarcs;
    }

    public Object getFirstAppearanceTeams() {
        return firstAppearanceTeams;
    }

    public void setFirstAppearanceTeams(Object firstAppearanceTeams) {
        this.firstAppearanceTeams = firstAppearanceTeams;
    }

    public Boolean getHasStaffReview() {
        return hasStaffReview;
    }

    public void setHasStaffReview(Boolean hasStaffReview) {
        this.hasStaffReview = hasStaffReview;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IssueImage getImage() {
        return image;
    }

    public void setImage(IssueImage image) {
        this.image = image;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public List<IssueLocationCredits> getLocationCredits() {
        return locationCredits;
    }

    public void setLocationCredits(List<IssueLocationCredits> locationCredits) {
        this.locationCredits = locationCredits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IssueObjectCredits> getObjectCredits() {
        return objectCredits;
    }

    public void setObjectCredits(List<IssueObjectCredits> objectCredits) {
        this.objectCredits = objectCredits;
    }

    public List<IssuePersonCredits> getPersonCredits() {
        return personCredits;
    }

    public void setPersonCredits(List<IssuePersonCredits> personCredits) {
        this.personCredits = personCredits;
    }

    public String getSiteDetailUrl() {
        return siteDetailUrl;
    }

    public void setSiteDetailUrl(String siteDetailUrl) {
        this.siteDetailUrl = siteDetailUrl;
    }

    public Object getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(Object storeDate) {
        this.storeDate = storeDate;
    }

    public List<Object> getStoryArcCredits() {
        return storyArcCredits;
    }

    public void setStoryArcCredits(List<Object> storyArcCredits) {
        this.storyArcCredits = storyArcCredits;
    }

    public List<IssueTeamCredits> getTeamCredits() {
        return teamCredits;
    }

    public void setTeamCredits(List<IssueTeamCredits> teamCredits) {
        this.teamCredits = teamCredits;
    }

    public List<Object> getTeamDisbandedIn() {
        return teamDisbandedIn;
    }

    public void setTeamDisbandedIn(List<Object> teamDisbandedIn) {
        this.teamDisbandedIn = teamDisbandedIn;
    }

    public IssueVolume getVolume() {
        return volume;
    }

    public void setVolume(IssueVolume volume) {
        this.volume = volume;
    }

}