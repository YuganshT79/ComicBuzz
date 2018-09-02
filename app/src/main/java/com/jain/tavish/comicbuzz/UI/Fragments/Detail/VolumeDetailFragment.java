package com.jain.tavish.comicbuzz.UI.Fragments.Detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jain.tavish.comicbuzz.ModelClasses.Details.Volume.Volume;
import com.jain.tavish.comicbuzz.ModelClasses.Details.Volume.VolumeResult;
import com.jain.tavish.comicbuzz.Networking.ApiInterface;
import com.jain.tavish.comicbuzz.Networking.RetrofitClient;
import com.jain.tavish.comicbuzz.R;
import com.jain.tavish.comicbuzz.Utils.ConstantUtils;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VolumeDetailFragment extends Fragment {

    int id ;
    Call<Volume> volumeCall;
    VolumeResult volumeResult;
    // @BindView(R.id.iv_issue_detail_image_view) ImageView imageView;
    // @BindView(R.id.tv_issue_detail_issue_name) TextView issueName;
    // @BindView(R.id.tv_issue_number) TextView issueNumber;
    // @BindView(R.id.tv_issue_detail_volume_name) TextView volumeName;
    // @BindView(R.id.tv_issue_detail_date_published) TextView datePublished;
    // @BindView(R.id.tv_issue_detail_cover_date) TextView coverDate;
    // @BindView(R.id.tv_issue_detail_description) TextView description;

    public VolumeDetailFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_volume_detail, container, false);

        // ButterKnife.bind(getActivity(), view);

        if (getArguments() != null) {
            id = getArguments().getInt(ConstantUtils.BUNDLE_ID);
        }

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        volumeCall = apiInterface.getVolumeDetails(Integer.toString(id), ConstantUtils.API_KEY, "json");

        volumeCall.enqueue(new Callback<Volume>() {
            @Override
            public void onResponse(@NonNull Call<Volume> call, @NonNull Response<Volume> response) {
                if(response.body() != null){
                    if (response.body() != null) {
                        volumeResult = response.body().getResults();
                    }

                    ImageView imageView = container.findViewById(R.id.iv_volume_detail_image_view);
                    TextView volumeName = container.findViewById(R.id.tv_volume_detail_volume_name);
                    TextView noOfIssues = container.findViewById(R.id.tv_volume_detail_no_of_issues);
                    TextView publisher = container.findViewById(R.id.tv_volume_detail_publisher);
                    TextView startYear = container.findViewById(R.id.tv_volume_detail_start_year);
                    TextView description = container.findViewById(R.id.tv_volume_detail_description);
                    TextView characterList = container.findViewById(R.id.tv_volume_detail_character_list);
                    ImageView volumeDetailMainLayout = container.findViewById(R.id.iv_volume_detail_main_layout);

                    Picasso.get()
                            .load(volumeResult.getImage().getScreenUrl())
                            .placeholder(R.drawable.loading)
                            .error(R.drawable.error_404)
                            .into(volumeDetailMainLayout);
                    volumeDetailMainLayout.setAlpha((float) 0.2);

                    Picasso.get()
                            .load(volumeResult.getImage().getSmallUrl())
                            .placeholder(R.drawable.loading)
                            .error(R.drawable.error_404)
                            .into(imageView);

                    getActivity().setTitle(volumeResult.getName());

                    volumeName.setText(volumeResult.getName());
                    volumeName.setText("Volume Name : " + volumeResult.getName());
                    noOfIssues.setText("Number Of Issues : " + volumeResult.getCountOfIssues() + 1);
                    description.setText("Description : " + volumeResult.getDeck());
                    publisher.setText("Publisher : " + volumeResult.getPublisher().getName());
                    startYear.setText("Start Year : " + volumeResult.getStartYear());

                    if(volumeResult.getPeople() != null) {
                        for (int i = 0; i < volumeResult.getPeople().size(); i++) {
                            characterList.append("\n" + volumeResult.getPeople().get(i).getName());
                        }
                    }else{
                        characterList.append("\n" + R.string.not_available);
                    }

                }else{
                    Toast.makeText(getContext(), R.string.error_getting_data, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Volume> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), R.string.failed, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
