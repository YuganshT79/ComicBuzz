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

import com.jain.tavish.comicbuzz.ModelClasses.Details.Character.Character;
import com.jain.tavish.comicbuzz.ModelClasses.Details.Character.CharacterResults;
import com.jain.tavish.comicbuzz.Networking.ApiInterface;
import com.jain.tavish.comicbuzz.Networking.RetrofitClient;
import com.jain.tavish.comicbuzz.R;
import com.jain.tavish.comicbuzz.Utils.ConstantUtils;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterDetailFragment extends Fragment {

    int id ;
    Call<Character> characterCall;
    CharacterResults characterResults;
    // @BindView(R.id.iv_issue_detail_image_view) ImageView imageView;
    // @BindView(R.id.tv_issue_detail_issue_name) TextView issueName;
    // @BindView(R.id.tv_issue_number) TextView issueNumber;
    // @BindView(R.id.tv_issue_detail_volume_name) TextView volumeName;
    // @BindView(R.id.tv_issue_detail_date_published) TextView datePublished;
    // @BindView(R.id.tv_issue_detail_cover_date) TextView coverDate;
    // @BindView(R.id.tv_issue_detail_description) TextView description;

    public CharacterDetailFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_character_detail, container, false);

        // ButterKnife.bind(getActivity(), view);

        if (getArguments() != null) {
            id = getArguments().getInt(ConstantUtils.BUNDLE_ID);
        }

        ApiInterface apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        characterCall = apiInterface.getCharacterDetails(Integer.toString(id), ConstantUtils.API_KEY, "json");

        characterCall.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(@NonNull Call<Character> call, @NonNull Response<Character> response) {

                if(response.body() != null){
                    if (response.body() != null) {
                        characterResults = response.body().getResults();
                    }

                    ImageView imageView = container.findViewById(R.id.iv_character_detail_image_view);
                    ImageView characterDetailMainLayout = container.findViewById(R.id.iv_character_detail_main_layout);
                    TextView characterName = container.findViewById(R.id.tv_character_detail_character_name);
                    TextView countOfIssues = container.findViewById(R.id.tv_character_detail_count_of_issue_appearances);
                    TextView publisher = container.findViewById(R.id.tv_character_detail_publisher);
                    TextView dateAdded = container.findViewById(R.id.tv_character_detail_date_added);
                    TextView description = container.findViewById(R.id.tv_character_detail_description);
                    TextView gender = container.findViewById(R.id.tv_character_detail_gender);
                    TextView firstAppeared = container.findViewById(R.id.tv_character_detail_first_appeared_in);
                    TextView enemy = container.findViewById(R.id.tv_character_detail_character_enemies);
                    TextView friends = container.findViewById(R.id.tv_character_detail_character_friends);
                    TextView creators = container.findViewById(R.id.tv_character_detail_character_creators);

                    Picasso.get()
                            .load(characterResults.getImage().getSmallUrl())
                            .placeholder(R.drawable.loading)
                            .error(R.drawable.error_404)
                            .into(imageView);

                    Picasso.get()
                            .load(characterResults.getImage().getScreenLargeUrl())
                            .placeholder(R.drawable.loading)
                            .error(R.drawable.error_404)
                            .into(characterDetailMainLayout);
                    characterDetailMainLayout.setAlpha((float) 0.2);

                    characterName.setText("Character Name : " + characterResults.getName());
                    countOfIssues.setText("Count Of Issues : " + characterResults.getCountOfIssueAppearances());
                    publisher.setText("Publisher : " + characterResults.getPublisher().getName());
                    dateAdded.setText("Date Added : " + characterResults.getDateAdded());
                    description.setText("Description : " + characterResults.getDeck().toString());

                    switch (characterResults.getGender()) {
                        case 1:
                            gender.setText("Gender : Male");
                            break;
                        case 2:
                            gender.setText("Gender : Female");
                            break;
                        case 0:
                            gender.setText("Gender : Other");
                            break;
                    }

                    firstAppeared.setText("First Appeared in : " +
                            characterResults.getFirstAppearedInIssue().getName() + " #" +
                            characterResults.getFirstAppearedInIssue().getIssueNumber());
/*
                    if(characterResults.getCharacterEnemies() != null) {
                        for (int i = 0; i < characterResults.getCharacterEnemies().size(); i++) {
                            enemy.append("\n" + characterResults.getCharacterEnemies().get(i));
                            Log.e("tavish", characterResults.getCharacterEnemies().get(i).toString());
                        }
                    }

                    if(characterResults.getCharacterFriends() != null) {
                        for (int i = 0; i < characterResults.getCharacterFriends().size(); i++) {
                            friends.append("\n" + characterResults.getCharacterFriends().get(i));
                        }
                    }

                    if(characterResults.getCreators() != null) {
                        for (int i = 0; i < characterResults.getCreators().size(); i++) {
                            creators.append("\n" + characterResults.getCreators().get(i));
                        }
                    }
*/


                }else{
                    Toast.makeText(getContext(), "Error Retrieving Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Character> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
