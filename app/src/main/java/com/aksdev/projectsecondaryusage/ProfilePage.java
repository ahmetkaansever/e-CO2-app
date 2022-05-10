package com.aksdev.projectsecondaryusage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {
    static TextView userName, score, rank;
    Button changePasswordButton, changeNameButton, aboutUsButton;
    de.hdodenhof.circleimageview.CircleImageView profilePicture;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile_layout);

        userName = findViewById(R.id.userNameText);
        score = findViewById(R.id.scoreText);
        rank = findViewById(R.id.rankTextView);

        changeNameButton = findViewById(R.id.changeNameButton);
        changePasswordButton = findViewById(R.id.changePasswordButton);
        aboutUsButton = findViewById(R.id.aboutUsButton);
        profilePicture = findViewById(R.id.profilePicture);

        user = LogIn.userProfile;

        userName.setText(user.getUserName() + "");
        score.setText(user.getScore() + "");

        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutUs();
            }
        });
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, passwordPopUp.class );
                startActivity(intent);
            }
        });
        changeNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfilePage.this, NamePopUp.class);
                startActivity(intent);
            }
        });

    }
    public void openAboutUs(){
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }
}