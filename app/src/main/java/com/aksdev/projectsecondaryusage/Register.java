package com.aksdev.projectsecondaryusage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Register extends AppCompatActivity {
    //Data Pass
    public static final String EXTRA_USERNAME = "com.aksdev.projectsecondaryusage.EXTRA_USERNAME";
    public static final String EXTRA_MAIL= "com.aksdev.projectsecondaryusage.EXTRA_MAIL";
    public static final String EXTRA_PASSWORD= "com.aksdev.projectsecondaryusage.EXTRA_PASSWORD";

    //FireBase auth object --> ( DataBase )
    private FirebaseAuth auth;
    Register Button;
    private Button registerPageBtn;

    //EdiT Text
    private EditText userNameEditText;
    private EditText mailEditText;
    private EditText passwordEditText;

    //Getters
    public String getNameReg() {
        return  userNameEditText.getText().toString();
    }
    public String getMailReg() {
        return mailEditText.toString();
    }
    public String getPasswordReg() {
        return passwordEditText.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        mailEditText = findViewById(R.id.editTextTextEmailAddress);
        userNameEditText = findViewById(R.id.nameEdit);
        registerPageBtn = findViewById(R.id.registerPageBtn);
        passwordEditText = findViewById(R.id.editTextNumberPassword);

        registerPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textMail = mailEditText.getText().toString();
                String textPassword = passwordEditText.getText().toString();
                String textName = userNameEditText.getText().toString();

                registerUser(textMail, textPassword, textName);
            }
        });
    }
    private void registerUser(String textMail, String textPassword, String textName) {
        if(textMail.isEmpty() || textPassword.isEmpty() || textName.isEmpty() ){
            if(textMail.isEmpty()){
                userNameEditText.setError("Username can not be left empty");
                userNameEditText.requestFocus();
                return;
            }
            else if (textPassword.isEmpty()) {
                passwordEditText.setError("Password can not be left empty");
                passwordEditText.requestFocus();
                return;
            }
            else {
                mailEditText.setError("Mail can not be left empty");
                mailEditText.requestFocus();
                return;
            }
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(textMail).matches()){
            mailEditText.setError("Please enter a valid mail");
            mailEditText.requestFocus();
            return;
        }
        if(textPassword.length() < 6){
            passwordEditText.setError("Password can not be smaller than 6 numbers");
            passwordEditText.requestFocus();
            return;
        }

       auth.createUserWithEmailAndPassword(textMail, textPassword)
               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {

                       if(task.isSuccessful()){
                           User user = new User(textName, textMail);

                           FirebaseDatabase.getInstance().getReference("Users")
                                   .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                   .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                       @Override
                                       public void onComplete(@NonNull Task<Void> task) {
                                           if(task.isSuccessful()){
                                               Toast.makeText(Register.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                                           }
                                           else{
                                               Toast.makeText(Register.this, "Failed to register, try again.", Toast.LENGTH_SHORT).show();
                                           }
                                       }
                                   });
                       }
                   }
               });

        Intent intent = new Intent(Register.this, Online.class);
        startActivity(intent);

    }


}