package com.aksdev.projectsecondaryusage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogIn extends AppCompatActivity {

    static User userProfile;

    private FirebaseAuth auth;
    private FirebaseUser user;
    private DatabaseReference referance;
    private String userID;

    private Button logInBtn;
    private TextView mailText;
    private TextView passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        auth = FirebaseAuth.getInstance();
        mailText = findViewById(R.id.LogInMail);
        passwordText  =findViewById(R.id.LogInPassword);

        logInBtn = findViewById(R.id.LogInPageBtn);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInUser();
            }
        });
    }

    private void logInUser() {
        String email = mailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

        if(email.isEmpty()){
            mailText.setError("Email is required");
            mailText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mailText.setError("Please enter a valid email");
            mailText.requestFocus();
            return;
        }
        if(password.isEmpty()){
            passwordText.setError("Password is required");
            passwordText.requestFocus();
            return;
        }
        if(password.length() < 6){
            passwordText.setError("Password length cannot be less than 6");
            passwordText.requestFocus();
            return;
        }

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    referance = FirebaseDatabase.getInstance().getReference("Users");
                    userID = user.getUid();
                    System.out.println("test");
                    referance.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            System.out.println("test1");
                            Toast.makeText(LogIn.this, "Logged in", Toast.LENGTH_SHORT).show();
                            userProfile = snapshot.getValue(User.class);
                            if(userProfile != null){
                                System.out.println("not null anymore");
                            }
                            System.out.println(user.getUid());
                            System.out.println(userProfile);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            System.out.println("test2");
                            Toast.makeText(LogIn.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
                        }
                    });
                    Intent intent = new Intent(LogIn.this, MainPage.class);
                    intent.putExtra("currentUser", userProfile);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LogIn.this, "Failed to Log In", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}