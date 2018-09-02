package com.jain.tavish.comicbuzz.UI.Fragments.Main;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.jain.tavish.comicbuzz.Adapters.IssueAdapter;
import com.jain.tavish.comicbuzz.ModelClasses.Main.Issues.Issues;
import com.jain.tavish.comicbuzz.ModelClasses.Main.Issues.IssuesResult;
import com.jain.tavish.comicbuzz.Networking.ApiInterface;
import com.jain.tavish.comicbuzz.Networking.RetrofitClient;
import com.jain.tavish.comicbuzz.R;
import com.jain.tavish.comicbuzz.Utils.ConstantUtils;
import com.jain.tavish.comicbuzz.Widget.NewIssuesWidget;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IssuesFragment extends Fragment {

    public Call<Issues> issuesCall;
    public List<IssuesResult> resultList;
    @BindView(R.id.shimmer_view_container) ShimmerFrameLayout shimmerFrameLayout;
    @BindView(R.id.recycler_view_main) RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    IssueAdapter issueAdapter;

    public Parcelable mLayoutManagerSavedState;

    public IssuesFragment() {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(ConstantUtils.BUNDLE_RECYCLER_VIEW_STATE_INT_KEY, recyclerView.getLayoutManager().onSaveInstanceState());
        super.onSaveInstanceState(outState);
    }

    public void saveDataToSharedPrefs(List<IssuesResult> resultListSharedPref, ViewGroup container){

        Intent intent = new Intent(container.getContext(), NewIssuesWidget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

        int[] ids = AppWidgetManager.getInstance(container.getContext())
                .getAppWidgetIds(new ComponentName(container.getContext(), NewIssuesWidget.class));

        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
        container.getContext().sendBroadcast(intent);

        StringBuilder builder = new StringBuilder();
        int temp = 0;

        for (int i = 0; i < resultListSharedPref.size(); i++) {
            if (resultListSharedPref.get(i).getName() != null) {
                temp++;
                builder.append( temp + ". " + resultListSharedPref.get(i).getName()).append("\n");
            }

            if (temp == 5){
                break;
            }
        }

        SharedPreferences sharedPref = container.getContext().getSharedPreferences("Issues", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString( ConstantUtils.SHARED_PREF_KEY_NAME, builder.toString());
        editor.apply();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {

        if (savedInstanceState != null){
            mLayoutManagerSavedState = savedInstanceState.getParcelable(ConstantUtils.BUNDLE_RECYCLER_VIEW_STATE_INT_KEY);
        }

        View view = inflater.inflate(R.layout.fragment_layout_file, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setVisibility(View.GONE);
        shimmerFrameLayout.startShimmer();
        final int spanCount = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ? 2 : 1;

        resultList = new ArrayList<>();

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        issuesCall = apiInterface.getIssuesList(ConstantUtils.API_KEY, "json", "date_added:desc");

        issuesCall.enqueue(new Callback<Issues>() {
            @Override
            public void onResponse(@NonNull Call<Issues> call, @NonNull Response<Issues> response) {
                if (response.body() != null) {
                    if (response.body() != null) {
                        resultList = response.body().getResults();
                    }

                    issueAdapter = new IssueAdapter(getActivity(), resultList);
                    recyclerView.setAdapter(issueAdapter);

                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);

                    gridLayoutManager = new GridLayoutManager(container.getContext() , spanCount);

                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(gridLayoutManager);

                    if (mLayoutManagerSavedState != null) {
                        recyclerView.getLayoutManager().onRestoreInstanceState(mLayoutManagerSavedState);
                        mLayoutManagerSavedState = null;
                    }

                    saveDataToSharedPrefs(resultList, container);
                }else{
                    shimmerFrameLayout.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "Error Retrieving Data !!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Issues> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
