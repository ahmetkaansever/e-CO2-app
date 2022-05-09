package com.aksdev.projectsecondaryusage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class NamePopUp extends Activity {
    //Firebase reference
    final FirebaseDatabase firebaseDatabaseUser = FirebaseDatabase.getInstance();
    DatabaseReference userDataBaseRef =  firebaseDatabaseUser.getReference("eC02_DataBase");
    String userId =   Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
    DatabaseReference updateUserDataBaseRef = userDataBaseRef.child("Users").child(userId);

    private String currentName = "name";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_pop);

    }
    public void nameBtnOnClick(View view) {
        TextView nameInput = findViewById(R.id.nameInput);
        String nameInputString = nameInput.getText().toString().trim();
        if(nameInputString.equals(currentName) && currentName.length() > 0){
            if(currentName.length() == 0){
                Toast toast = Toast.makeText(NamePopUp.this, "You can not left blank space", Toast.LENGTH_LONG);
                toast.show();
            }
            else{
                Toast toast = Toast.makeText(NamePopUp.this, "Given username is same with previous username", Toast.LENGTH_LONG);
                toast.show();
            }
        }
        else {
            updateUserDataBaseRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    currentName = nameInputString;
                    User currentUser = snapshot.getValue(User.class);
                    currentUser.setUserName(currentName);
                    updateUserDataBaseRef.setValue(currentUser);
                    Toast toast = Toast.makeText(NamePopUp.this, "Username changed ", Toast.LENGTH_LONG);
                    toast.show();
                    finish();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(NamePopUp.this, "Something went wrong... try again", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
