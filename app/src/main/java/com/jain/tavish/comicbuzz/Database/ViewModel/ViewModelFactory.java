package com.jain.tavish.comicbuzz.Database.ViewModel;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.jain.tavish.comicbuzz.Database.Room.IssueDao;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final IssueDao issueDao;
    private final int issueID;
    private Application application;

    public ViewModelFactory(Application application, IssueDao issueDao, int issueID) {
        this.application = application;
        this.issueDao = issueDao;
        this.issueID = issueID;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ViewModelClass(application, issueDao, issueID);
    }
}