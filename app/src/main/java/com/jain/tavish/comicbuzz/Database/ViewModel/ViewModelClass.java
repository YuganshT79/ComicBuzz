package com.jain.tavish.comicbuzz.Database.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.jain.tavish.comicbuzz.Database.Room.IssueDao;
import com.jain.tavish.comicbuzz.Database.Room.IssueEntity;

public class ViewModelClass extends AndroidViewModel {

    private LiveData<IssueEntity> issueEntityLiveData;

    public ViewModelClass(@NonNull Application application,IssueDao issueDao, int id) {
        super(application);
        issueEntityLiveData = issueDao.getFavIssue(id);
    }

    public LiveData<IssueEntity> getIssueEntityLiveData(){
        return issueEntityLiveData;
    }

}
