package com.jain.tavish.comicbuzz.ModelClasses.Details.Character;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterResults {

    @SerializedName("aliases")
    @Expose
    private Object aliases;
    @SerializedName("api_detail_url")
    @Expose
    private String apiDetailUrl;
    @SerializedName("birth")
    @Expose
    private Object birth;
    @SerializedName("character_enemies")
    @Expose
    private List<Object> characterEnemies = null;
    @SerializedName("character_friends")
    @Expose
    private List<Object> characterFriends = null;
    @SerializedName("count_of_issue_appearances")
    @Expose
    private Integer countOfIssueAppearances;
    @SerializedName("creators")
    @Expose
    private List<Object> creators = null;
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
    @SerializedName("first_appeared_in_issue")
    @Expose
    private CharacterFirstAppearedInIssue firstAppearedInIssue;
    @SerializedName("gender")
    @Expose
    private Integer gender;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private CharacterImage image;
    @SerializedName("issue_credits")
    @Expose
    private List<CharacterIssueCredit> issueCredits = null;
    @SerializedName("issues_died_in")
    @Expose
    private List<Object> issuesDiedIn = null;
    @SerializedName("movies")
    @Expose
    private List<Object> movies = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("origin")
    @Expose
    private CharacterOrigin origin;
    @SerializedName("powers")
    @Expose
    private List<Object> powers = null;
    @SerializedName("publisher")
    @Expose
    private CharacterPublisher publisher;
    @SerializedName("real_name")
    @Expose
    private String realName;
    @SerializedName("site_detail_url")
    @Expose
    private String siteDetailUrl;
    @SerializedName("story_arc_credits")
    @Expose
    private List<Object> storyArcCredits = null;
    @SerializedName("team_enemies")
    @Expose
    private List<Object> teamEnemies = null;
    @SerializedName("team_friends")
    @Expose
    private List<Object> teamFriends = null;
    @SerializedName("teams")
    @Expose
    private List<Object> teams = null;
    @SerializedName("volume_credits")
    @Expose
    private List<CharacterVolumeCredit> volumeCredits = null;

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

    public Object getBirth() {
        return birth;
    }

    public void setBirth(Object birth) {
        this.birth = birth;
    }

    public List<Object> getCharacterEnemies() {
        return characterEnemies;
    }

    public void setCharacterEnemies(List<Object> characterEnemies) {
        this.characterEnemies = characterEnemies;
    }

    public List<Object> getCharacterFriends() {
        return characterFriends;
    }

    public void setCharacterFriends(List<Object> characterFriends) {
        this.characterFriends = characterFriends;
    }

    public Integer getCountOfIssueAppearances() {
        return countOfIssueAppearances;
    }

    public void setCountOfIssueAppearances(Integer countOfIssueAppearances) {
        this.countOfIssueAppearances = countOfIssueAppearances;
    }

    public List<Object> getCreators() {
        return creators;
    }

    public void setCreators(List<Object> creators) {
        this.creators = creators;
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

    public CharacterFirstAppearedInIssue getFirstAppearedInIssue() {
        return firstAppearedInIssue;
    }

    public void setFirstAppearedInIssue(CharacterFirstAppearedInIssue firstAppearedInIssue) {
        this.firstAppearedInIssue = firstAppearedInIssue;
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

    public CharacterImage getImage() {
        return image;
    }

    public void setImage(CharacterImage image) {
        this.image = image;
    }

    public List<CharacterIssueCredit> getIssueCredits() {
        return issueCredits;
    }

    public void setIssueCredits(List<CharacterIssueCredit> issueCredits) {
        this.issueCredits = issueCredits;
    }

    public List<Object> getIssuesDiedIn() {
        return issuesDiedIn;
    }

    public void setIssuesDiedIn(List<Object> issuesDiedIn) {
        this.issuesDiedIn = issuesDiedIn;
    }

    public List<Object> getMovies() {
        return movies;
    }

    public void setMovies(List<Object> movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(CharacterOrigin origin) {
        this.origin = origin;
    }

    public List<Object> getPowers() {
        return powers;
    }

    public void setPowers(List<Object> powers) {
        this.powers = powers;
    }

    public CharacterPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(CharacterPublisher publisher) {
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

    public List<Object> getStoryArcCredits() {
        return storyArcCredits;
    }

    public void setStoryArcCredits(List<Object> storyArcCredits) {
        this.storyArcCredits = storyArcCredits;
    }

    public List<Object> getTeamEnemies() {
        return teamEnemies;
    }

    public void setTeamEnemies(List<Object> teamEnemies) {
        this.teamEnemies = teamEnemies;
    }

    public List<Object> getTeamFriends() {
        return teamFriends;
    }

    public void setTeamFriends(List<Object> teamFriends) {
        this.teamFriends = teamFriends;
    }

    public List<Object> getTeams() {
        return teams;
    }

    public void setTeams(List<Object> teams) {
        this.teams = teams;
    }

    public List<CharacterVolumeCredit> getVolumeCredits() {
        return volumeCredits;
    }

    public void setVolumeCredits(List<CharacterVolumeCredit> volumeCredits) {
        this.volumeCredits = volumeCredits;
    }

}