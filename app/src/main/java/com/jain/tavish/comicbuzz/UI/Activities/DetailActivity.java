package com.jain.tavish.comicbuzz.UI.Activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.jain.tavish.comicbuzz.R;
import com.jain.tavish.comicbuzz.UI.Fragments.Detail.CharacterDetailFragment;
import com.jain.tavish.comicbuzz.UI.Fragments.Detail.IssueDetailFragment;
import com.jain.tavish.comicbuzz.UI.Fragments.Detail.VolumeDetailFragment;
import com.jain.tavish.comicbuzz.Utils.ConstantUtils;

import java.util.Objects;

import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        fragmentManager = getSupportFragmentManager();
        int activityName = Objects.requireNonNull(getIntent().getExtras()).getInt(ConstantUtils.BUNDLE_ACTIVITY_NAME);
        int id = Objects.requireNonNull(getIntent().getExtras().getInt(ConstantUtils.BUNDLE_ID));

        Bundle bundle = new Bundle();
        bundle.putInt(ConstantUtils.BUNDLE_ID, id);

        if (activityName == ConstantUtils.NAV_ITEM_ISSUES) {
            IssueDetailFragment issueDetailFragment = new IssueDetailFragment();
            issueDetailFragment.setArguments(bundle);

            fragmentManager.beginTransaction()
                    .replace(R.id.detail_activity_frame_layout, issueDetailFragment)
                    .commit();
        }else if(activityName == ConstantUtils.NAV_ITEM_VOLUMES){
            VolumeDetailFragment volumeDetailFragment = new VolumeDetailFragment();
            volumeDetailFragment.setArguments(bundle);

            fragmentManager.beginTransaction()
                    .replace(R.id.detail_activity_frame_layout, volumeDetailFragment)
                    .commit();
        }else if(activityName == ConstantUtils.NAV_ITEM_CHARACTERS){
            CharacterDetailFragment characterDetailFragment = new CharacterDetailFragment();
            characterDetailFragment.setArguments(bundle);

            fragmentManager.beginTransaction()
                    .replace(R.id.detail_activity_frame_layout, characterDetailFragment)
                    .commit();
        }

    }
}
