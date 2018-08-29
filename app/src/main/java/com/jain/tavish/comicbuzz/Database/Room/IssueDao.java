package com.jain.tavish.comicbuzz.Database.Room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface IssueDao {

    @Insert
    void insertId(IssueEntity id);

    @Delete
    void deleteId(IssueEntity id);

    @Update
    void updateID(IssueEntity id);

    @Query("SELECT * from entity WHERE id = :id")
    LiveData<IssueEntity> getFavIssue(int id);

    @Query("SELECT * from entity")
    List<IssueEntity> getAllFavIssues();

}
