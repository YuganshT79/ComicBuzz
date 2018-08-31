package com.jain.tavish.comicbuzz.UI.Fragments.Main;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jain.tavish.comicbuzz.Adapters.MyFavsAdapter;
import com.jain.tavish.comicbuzz.Database.Room.DatabaseCreator;
import com.jain.tavish.comicbuzz.Database.Room.IssueDao;
import com.jain.tavish.comicbuzz.Database.Room.IssueEntity;
import com.jain.tavish.comicbuzz.ModelClasses.Details.Issue.Issue;
import com.jain.tavish.comicbuzz.Networking.ApiInterface;
import com.jain.tavish.comicbuzz.Networking.RetrofitClient;
import com.jain.tavish.comicbuzz.R;
import com.jain.tavish.comicbuzz.Utils.ConstantUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyFavouritesFragment extends Fragment {

    public Call<Issue> issueCall;
    public List<Issue> issueList;
    @BindView(R.id.rv_my_fav_fragment) RecyclerView recyclerView;
    IssueDao issueDao;
    List<IssueEntity> issueEntityList;
    MyFavsAdapter myFavsAdapter;

    public MyFavouritesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_favs, container, false);

        issueList = new ArrayList<>();
        ButterKnife.bind(this, view);

        issueDao = DatabaseCreator.getIssueDatabase(container.getContext()).IssueDatabase();
        issueEntityList = issueDao.getAllFavIssues();

        Toast.makeText(getContext(), "" + issueEntityList.size(), Toast.LENGTH_SHORT).show();

        final int spanCount = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ? 2 : 1;

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        for (int i = 0; i < issueEntityList.size(); i++) {

            issueCall = apiInterface.getIssueDetails(String.valueOf(issueEntityList.get(i).getId()), ConstantUtils.API_KEY, "json");

            issueCall.enqueue(new Callback<Issue>() {
                @Override
                public void onResponse(@NonNull Call<Issue> call, @NonNull Response<Issue> response) {
                    issueList.add(response.body());

                    myFavsAdapter = new MyFavsAdapter(getActivity(), issueList);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new GridLayoutManager(container.getContext() , spanCount));
                    recyclerView.setAdapter(myFavsAdapter);
                }

                @Override
                public void onFailure(@NonNull Call<Issue> call, @NonNull Throwable t) {

                }
            });
        }

        return view;
    }
}
