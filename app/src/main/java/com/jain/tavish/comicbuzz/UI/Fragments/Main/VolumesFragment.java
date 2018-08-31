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

import com.facebook.shimmer.ShimmerFrameLayout;
import com.jain.tavish.comicbuzz.Adapters.VolumeAdapter;
import com.jain.tavish.comicbuzz.ModelClasses.Main.Volumes.Volumes;
import com.jain.tavish.comicbuzz.ModelClasses.Main.Volumes.VolumesResult;
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

public class VolumesFragment extends Fragment {

    public Call<Volumes> volumeCall;
    public List<VolumesResult> resultList;
    @BindView(R.id.shimmer_view_container) ShimmerFrameLayout shimmerFrameLayout;
    @BindView(R.id.recycler_view_main) RecyclerView recyclerView;

    public VolumesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_file, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setVisibility(View.GONE);
        shimmerFrameLayout.startShimmer();

        resultList = new ArrayList<>();

        final int spanCount = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ? 2 : 1;

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        volumeCall = apiInterface.getVolumesList(ConstantUtils.API_KEY, "json", "date_added:desc");

        volumeCall.enqueue(new Callback<Volumes>() {
            @Override
            public void onResponse(@NonNull Call<Volumes> call, @NonNull Response<Volumes> response) {
                if (response.body() != null) {
                    if (response.body() != null) {
                        resultList = response.body().getResults();
                    }
                    VolumeAdapter volumeAdapter = new VolumeAdapter(getContext(), resultList);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new GridLayoutManager(container.getContext() , spanCount));
                    recyclerView.setAdapter(volumeAdapter);
                    shimmerFrameLayout.stopShimmer();
                    shimmerFrameLayout.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(getContext(), "Error Retrieving Data !!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Volumes> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "failed", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
