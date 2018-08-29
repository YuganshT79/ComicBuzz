package com.jain.tavish.comicbuzz.Database.Room;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class IssueAsyncTask {

    public static void writeToDatabase(final Context context, final IssueDao issueDao, final IssueEntity issueEntity, final int id){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                issueEntity.setId(id);
                issueDao.insertId(issueEntity);
                issueDao.updateID(issueEntity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Toast.makeText(context, "Added to Favourites !!!", Toast.LENGTH_SHORT).show();
                super.onPostExecute(aVoid);
            }
        }.execute();
    }

    public static void deleteFromDatabase(final Context context, final IssueDao issueDao, final IssueEntity issueEntity, final int id){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                issueEntity.setId(id);
                issueDao.deleteId(issueEntity);
                issueDao.updateID(issueEntity);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Toast.makeText(context, "Deleted from Favourites !!!", Toast.LENGTH_SHORT).show();
                super.onPostExecute(aVoid);
            }
        }.execute();
    }

}
