package com.jain.tavish.comicbuzz.UI.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jain.tavish.comicbuzz.R;
import com.jain.tavish.comicbuzz.UI.Fragments.Main.CharacterFragment;
import com.jain.tavish.comicbuzz.UI.Fragments.Main.IssuesFragment;
import com.jain.tavish.comicbuzz.UI.Fragments.Main.MyFavouritesFragment;
import com.jain.tavish.comicbuzz.UI.Fragments.Main.VolumesFragment;
import com.jain.tavish.comicbuzz.Utils.ConstantUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;
    public FragmentManager fragmentManager;
    Bundle savedState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        savedState = savedInstanceState;

        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        loadIssues();
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void loadIssues(){
        navigationView.getMenu().getItem(ConstantUtils.NAV_ITEM_ISSUES).setChecked(true);
        getSupportActionBar().setTitle("Issues");
        if(savedState == null) {
            IssuesFragment issuesFragment = new IssuesFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.activity_main_frame_layout, issuesFragment)
                    .commit();
        }
    }

    public void loadVolumes(){
        navigationView.getMenu().getItem(ConstantUtils.NAV_ITEM_VOLUMES).setChecked(true);
        getSupportActionBar().setTitle("Volumes");
        if(savedState == null) {
            VolumesFragment volumesFragment = new VolumesFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.activity_main_frame_layout, volumesFragment)
                    .commit();
        }
    }

    public void loadCharacters(){
        navigationView.getMenu().getItem(ConstantUtils.NAV_ITEM_CHARACTERS).setChecked(true);
        getSupportActionBar().setTitle("Characters");
        if(savedState == null) {
            CharacterFragment characterFragment = new CharacterFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.activity_main_frame_layout, characterFragment)
                    .commit();
        }
    }

    public void loadMyFavs(){
        navigationView.getMenu().getItem(ConstantUtils.NAV_ITEM_MY_FAVS).setChecked(true);
        getSupportActionBar().setTitle("My Favorites");
        if(savedState == null) {
            MyFavouritesFragment myFavouritesFragment = new MyFavouritesFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.activity_main_frame_layout, myFavouritesFragment)
                    .commit();
        }

    }

    public void loadAboutMe(){
        Intent intent = new Intent(MainActivity.this, AboutMeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_issue:
                loadIssues();
                break;
            case R.id.nav_volumes:
                loadVolumes();
                break;
            case R.id.nav_characters:
                loadCharacters();
                break;
            case R.id.nav_my_favs:
                loadMyFavs();
                break;
            case R.id.nav_about_me:
                loadAboutMe();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
