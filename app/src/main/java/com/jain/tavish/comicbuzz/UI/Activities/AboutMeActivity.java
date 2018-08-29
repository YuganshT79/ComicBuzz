package com.jain.tavish.comicbuzz.UI.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Objects;

import mehdi.sakout.aboutpage.AboutPage;

public class AboutMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setTitle("About the Developer");

        View aboutPage = new AboutPage(this)
                .isRTL(false)
              //  .setImage(R.drawable.dummy_image)
                .setDescription("Hey There !!! \n My name is Tavish Jain and I am an undergraduate student at Delhi Technological University pursuing Software Engineering. I am a Budding Software and Android Developer. I also have interest in Machine Learning and Artificial Intelligence")
                .addGroup("Connect with me")
                .addEmail("jaintavish@gmail.com")
                .addWebsite("http://tavishjain.github.io/")
                .addFacebook("tavishjain")
                .addTwitter("iAmTavishJain")
                .addInstagram("tavish.jain")
                .addGitHub("tavishjain")
                .create();

        setContentView(aboutPage);
    }
}
