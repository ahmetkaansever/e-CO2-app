package com.aksdev.projectsecondaryusage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


//import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Random;

public class MainPage extends AppCompatActivity {


    private ArrayList<String> quotes = new ArrayList<>();
    private String currentQuote;

    ImageButton btnOnline;
    /*
    ImageButton btnNews ;
    ImageButton btnHome;
    ImageButton btnUsage;
    ImageButton btnGps;*/
    //
    //Button btnProfile;
    TextView quote; //= findViewById(R.id.quote);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        //“The Earth is what we all have in common.” —Wendell Berry
        //“The best way to predict the future is to create it.” ~ Alan Kay
        //“Those who have the privilege to know have the duty to act.” ~ Albert Einstein
        //“The world is changed by your example, not by your opinion.” ~ Paul Coelho
        //“We are the first generation to feel the impact of climate change and the last generation that can do something about it.” ~ Barack Obama
        //“We do not inherit the Earth from our ancestors. We borrow it from our children.” ~ American Indian proverb
        //“There are no passengers on spaceship earth. We are all crew.” ~ Marshall McLuhan
        //“Nature is not a place to visit. It is home.” ~ Gary Snyder

        quotes.add("“The Earth is what we all have in common.” —Wendell Berry");
        quotes.add("“The best way to predict the future is to create it.” ~ Alan Kay");
        quotes.add("“Those who have the privilege to know have the duty to act.” ~ Albert Einstein");
        quotes.add("“The world is changed by your example, not by your opinion.” ~ Paul Coelho");
        quotes.add("“We are the first generation to feel the impact of climate change and the last generation that can do something about it.” ~ Barack Obama");
        quotes.add("“We do not inherit the Earth from our ancestors. We borrow it from our children.” ~ American Indian proverb");
        quotes.add("“There are no passengers on spaceship earth. We are all crew.” ~ Marshall McLuhan");
        quotes.add("“Nature is not a place to visit. It is home.” ~ Gary Snyder");
        quote = findViewById(R.id.quote);
        /*
        btnOnline = findViewById(R.id.online);;
        btnNews = findViewById(R.id.news);
        btnHome = findViewById(R.id.home);
        btnUsage = findViewById(R.id.usage);
        btnGps = findViewById(R.id.gps);
        btnProfile = findViewById(R.id.profile)*/

        //set quote to the randomly selected one
        currentQuote = randomQuote();
        quote.setText(currentQuote);

        //set profile button color to the one selected by user
        //btnProfile.setBackgroundColor(profile.getColor);


        //listeners for the buttons
        /*
        btnOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), Online.class));
                finish();

            }
        });
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationInfo(), News.class));

            }
        });


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this, this.class));
                finish();

            }
        });
        btnUsage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this, DailyUsage.class));
                finish();

            }
        });
        btnGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this, Gps.class));
                finish();

            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this, Profile.class));
                finish();

            }
        });*/

    }


    public String randomQuote()
    {
        Random rand  = new Random();
        int pos = rand.nextInt(quotes.size());
        return quotes.get(pos);
    }
}