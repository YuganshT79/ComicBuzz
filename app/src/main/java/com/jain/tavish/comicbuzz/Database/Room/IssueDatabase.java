package com.jain.tavish.comicbuzz.Database.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {IssueEntity.class}, version = 1, exportSchema = false)
public abstract class IssueDatabase extends RoomDatabase {

    public abstract IssueDao IssueDatabase();

}
