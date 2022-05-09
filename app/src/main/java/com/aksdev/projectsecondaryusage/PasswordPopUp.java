package com.aksdev.projectsecondaryusage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PasswordPopUp extends Activity {
    private String password = "password";
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

        if(oldPasswordString.equals(password)){
            if(newPasswordString.equals(oldPasswordString) ) {
                Toast toast = Toast.makeText(PasswordPopUp.this, "Given new password is same with previous password", Toast.LENGTH_LONG);
                toast.show();
            }
            else{
                password = newPasswordString;
                Toast toast = Toast.makeText(PasswordPopUp.this, "Password changed", Toast.LENGTH_LONG);
                toast.show();
                finish();
            }
        }
        else{
            Toast toast = Toast.makeText(PasswordPopUp.this, "Given old password is not same with current password", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
