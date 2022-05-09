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

public class PasswordPopUp extends Activity {
    private String currentPassword = "password";

    //Firebase reference
    final FirebaseDatabase firebaseDatabaseUser = FirebaseDatabase.getInstance();
    DatabaseReference userDataBaseRef =  firebaseDatabaseUser.getReference("eC02_DataBase");
    String userId =   Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
    DatabaseReference updateUserDataBaseRef = userDataBaseRef.child("Users").child(userId);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_pop);
    }
    public void passwordBtnOnClick(View view){

        TextView oldPassword = findViewById(R.id.oldPassword);
        String oldPasswordString = oldPassword.getText().toString().trim();

        TextView newPassword = findViewById(R.id.newPassword);
        String newPasswordString = newPassword.getText().toString().trim();

        if(oldPasswordString.equals(currentPassword)){
            if(newPasswordString.equals(oldPasswordString) ) {
                Toast toast = Toast.makeText(PasswordPopUp.this, "Given new password is same with previous password", Toast.LENGTH_LONG);
                toast.show();
            }
            else{
                currentPassword = newPasswordString;
                Toast toast = Toast.makeText(PasswordPopUp.this, "Password changed", Toast.LENGTH_LONG);
                toast.show();
                finish();
            }
        }
        else{
            currentPassword = newPasswordString;
            updateUserDataBaseRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User currentUser = snapshot.getValue(User.class);
                    currentUser.setPassword(currentPassword);
                    updateUserDataBaseRef.setValue(currentUser);
                    Toast toast = Toast.makeText(PasswordPopUp.this, "Password changed ", Toast.LENGTH_LONG);
                    toast.show();
                    finish();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(PasswordPopUp.this, "Something went wrong... try again", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
