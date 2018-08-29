package com.jain.tavish.comicbuzz.Database.Room;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseCreator {

    private static IssueDatabase issueDatabase;
    private static final Object LOCK = new Object();

    public synchronized static IssueDatabase getIssueDatabase(Context context){
        if(issueDatabase == null) {
            synchronized (LOCK) {
                if (issueDatabase == null) {
                    issueDatabase = Room.databaseBuilder(context,
                            IssueDatabase.class, "IssueDB")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return issueDatabase;
    }
}