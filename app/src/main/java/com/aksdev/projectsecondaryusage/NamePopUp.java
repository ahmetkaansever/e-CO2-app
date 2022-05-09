package com.aksdev.projectsecondaryusage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class NamePopUp extends Activity {
    private String currentName = null;
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
            currentName = nameInputString;
            Toast toast = Toast.makeText(NamePopUp.this, "Username changed ", Toast.LENGTH_LONG);
            toast.show();
            finish();
        }
    }
}
