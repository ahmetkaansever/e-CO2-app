package com.aksdev.projectsecondaryusage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Recycle extends AppCompatActivity {

    private final int paper = 2;
    private final int plastic = 5;
    private final int glass=4;
    private final int oil=8;
    private final int battery=10;
    private final int clothes=6;
    DatabaseReference userDataBaseRef;
    FirebaseDatabase firebaseDatabaseUser;
    FirebaseAuth userAuth;
    User user;
    DatabaseReference updateUserDataBaseRef;
    String userId;
    
    private int totalScore;
    private int paperAmount, plasticAmount, glassAmount, oilAmount, batteryAmount,clothesAmount;

    EditText paperInput;
    EditText plasticInput;
    EditText glassInput;
    EditText oilInput;
    EditText batteryInput;
    EditText clothesInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        firebaseDatabaseUser = FirebaseDatabase.getInstance();
        userDataBaseRef =  firebaseDatabaseUser.getReference("Users");
        userAuth = FirebaseAuth.getInstance();
        Button submit = findViewById(R.id.button);

        user = LogIn.userProfile;

        paperInput = findViewById(R.id.paperInput);
        plasticInput = findViewById(R.id.plasticInput);
        glassInput = findViewById(R.id.glassInput);
        oilInput = findViewById(R.id.oilInput);
        batteryInput = findViewById(R.id.batteryInput);
        clothesInput = findViewById(R.id.clothesInput);


        EditText clothesInput = findViewById(R.id.clothesInput);

        if(!Objects.isNull(userAuth)){
            FirebaseUser firebaseUser = userAuth.getCurrentUser();
            if(!Objects.isNull(firebaseUser)){
                userId = firebaseUser.getDisplayName();
            }
        }
        if(!Objects.isNull(userId)){
            updateUserDataBaseRef = userDataBaseRef.child("Users").child(userId);
        }
        else{
            updateUserDataBaseRef = null;
        }
        //submit.setOnClickListener(onBtnClick());

    }

    public void btn (View view)
    {


        if(!paperInput.getText().toString().equals(""))
        {
            paperAmount = Integer.parseInt(paperInput.getText().toString());
        }
        
        if(!plasticInput.getText().toString().equals(""))
        {
            plasticAmount = Integer.parseInt(plasticInput.getText().toString());
        }
        
        if(!glassInput.getText().toString().equals(""))
        {
            glassAmount = Integer.parseInt(glassInput.getText().toString());
        }
        
        if(!oilInput.getText().toString().equals(""))
        {
            oilAmount = Integer.parseInt(oilInput.getText().toString());
        }
        
        if(!batteryInput.getText().toString().equals(""))
        {
            batteryAmount = Integer.parseInt(batteryInput.getText().toString());
        }
        
        if(!clothesInput.getText().toString().equals(""))
        {
            clothesAmount = Integer.parseInt(clothesInput.getText().toString());
        }

        //ACTUAL METHOD WITH USER CLASS
        userDataBaseRef.child(userAuth.getCurrentUser().getUid()).child("score").setValue(user.getScore() + calculateScore());
        user.setScore(calculateScore());
    }

    public int calculateScore()
    {
            totalScore = paperAmount*paper + plasticAmount*plastic + glassAmount*glass + oilAmount*oil + batteryAmount*battery + clothesAmount*clothes;
            System.out.println("" + totalScore);
            return totalScore;
    }

}


