package com.aksdev.projectsecondaryusage;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;

public class MonthlyCalculator extends AppCompatActivity implements Calculatable{
    static double totalCalEmision;
    //private TextView dateText = findViewById(R.id.dateText);  // Display current date
    private TextView dateText;

    //FireBase references
    final FirebaseDatabase firebaseDatabaseUser = FirebaseDatabase.getInstance();
    DatabaseReference userDataBaseRef =  firebaseDatabaseUser.getReference("eC02_DataBase");
    String userId =   Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
    DatabaseReference updateUserDataBaseRef = userDataBaseRef.child("Users").child(userId);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.monthly_calculator);
        dateText = findViewById(R.id.dateText);

    }
    public void  onBtnClick(View view ){
        Boolean check = false;
        //Date Log-in

        Calendar currentCalender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(currentCalender.getTime());
        dateText.setText(currentDate);
        //Primary Usage
        String primary = findViewById(R.id.PrimaryText).toString();
        int primaryInt = Integer.parseInt(primary);
        //Secondary Usage
        String secondary = findViewById(R.id.SecondaryEditText).toString();
        int secondaryInt = Integer.parseInt(secondary);

        if(primaryInt >= 0 && secondaryInt >= 0){
            //PastCalculations Object
            try{
                PastCalculations newCalculation = new PastCalculations(primaryInt, secondaryInt, currentDate);
            }
            catch (Exception e){
                String cause = e.getCause().toString();
                switch (cause){
                    case  "ArithmeticException" :
                        Toast.makeText(MonthlyCalculator.this, "Please Enter Valid values", Toast.LENGTH_LONG);
                        break;
                    default:
                        Toast.makeText(MonthlyCalculator.this, "Something went wrong", Toast.LENGTH_LONG);
                        break;
                }
            }
        }
        else{
            Toast.makeText(MonthlyCalculator.this, "Please Enter Valid Values", Toast.LENGTH_LONG);
        }
        //Monthly calculate object
        calculate();

    }
    @Override
    public void calculate() {
        userDataBaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User currentUser = snapshot.getValue(User.class);
                currentUser.totalEmission += currentUser.totalPrimaryEmission + currentUser.totalSecondaryEmission;
                totalCalEmision = currentUser.totalPrimaryEmission + currentUser.totalSecondaryEmission;
                updateUserDataBaseRef.setValue(currentUser);
                Toast.makeText(MonthlyCalculator.this, "Successfully submitted.", Toast.LENGTH_SHORT).show();
                System.out.println(totalCalEmision);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
}