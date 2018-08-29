package com.jain.tavish.comicbuzz.Networking;

import com.jain.tavish.comicbuzz.ModelClasses.Details.Character.Character;
import com.jain.tavish.comicbuzz.ModelClasses.Details.Issue.Issue;
import com.jain.tavish.comicbuzz.ModelClasses.Details.Volume.Volume;
import com.jain.tavish.comicbuzz.ModelClasses.Main.Characters.Characters;
import com.jain.tavish.comicbuzz.ModelClasses.Main.Issues.Issues;
import com.jain.tavish.comicbuzz.ModelClasses.Main.Volumes.Volumes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("issues/")
    Call<Issues> getIssuesList(@Query("api_key")String api_key, @Query("format") String format, @Query("sort")String sort);

    @GET("volumes/")
    Call<Volumes> getVolumesList(@Query("api_key")String api_key, @Query("format") String format, @Query("sort")String sort);

    @GET("characters/")
    Call<Characters> getCharactersList(@Query("api_key")String api_key, @Query("format") String format, @Query("sort")String sort);

    @GET("issue/4000-{id}/")
    Call<Issue> getIssueDetails(@Path(value = "id", encoded = true) String id, @Query("api_key")String api_key, @Query("format") String format);

    @GET("volume/4050-{id}/")
    Call<Volume> getVolumeDetails(@Path(value = "id", encoded = true) String id, @Query("api_key")String api_key, @Query("format") String format);

    @GET("character/4005-{id}/")
    Call<Character> getCharacterDetails(@Path(value = "id", encoded = true) String id, @Query("api_key")String api_key, @Query("format") String format);

}