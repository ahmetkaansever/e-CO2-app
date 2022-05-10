package com.aksdev.projectsecondaryusage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NamePopUp extends AppCompatActivity {
    Button submit;
    EditText newUserName;
    String newUserNameString;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_pop_up);
        user = LogIn.userProfile;
        submit = findViewById(R.id.changeUserNameButton);
        newUserName = findViewById(R.id.newUserName);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * 0.8), (int)(height* 0.8));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!newUserName.getText().toString().equals("")) {
                    newUserNameString = newUserName.getText().toString();
                    user.setUserName(newUserNameString);
                    ProfilePage.userName.setText(newUserNameString);
                }
            }
        });

    }
}