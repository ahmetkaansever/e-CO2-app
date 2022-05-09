package com.aksdev.projectsecondaryusage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class PrimaryUsage extends AppCompatActivity implements Calculatable{
    static int totalPrimaryUsage;

    //FireBase references
    final FirebaseDatabase firebaseDatabaseUser = FirebaseDatabase.getInstance();
    DatabaseReference userDataBaseRef =  firebaseDatabaseUser.getReference("eC02_DataBase");
    String userId =   Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName();
    DatabaseReference updateUserDataBaseRef = userDataBaseRef.child("Users").child(userId);

    int[] Primerylist = new int[8];
    private Button SaveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_usage);
        Toast.makeText(this, "Please write how much you have spent on given areas this month", Toast.LENGTH_LONG).show();

        SaveButton = findViewById(R.id.SaveButton);
        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText hauseholdEditText =  findViewById(R.id.hauseholdEditText);
                if(hauseholdEditText.getText().toString().equals("")){
                    Primerylist[0] = 0;
                }
                else {
                    Primerylist[0] = Integer.parseInt(hauseholdEditText.getText().toString());
                }

                EditText electricityEditText =  findViewById(R.id.electricityEditText);
                if(electricityEditText.getText().toString().equals("")){
                    Primerylist[1] = 0;
                }
                else {
                    Primerylist[1] = Integer.parseInt(electricityEditText.getText().toString());
                }

                EditText naturalGasEditText =  findViewById(R.id.naturalGasEditText);
                if(naturalGasEditText.getText().toString().equals("")){
                    Primerylist[2] = 0;
                }
                else {
                    Primerylist[2] = Integer.parseInt(naturalGasEditText.getText().toString());
                }

                EditText lpgEditText =  findViewById(R.id.lpgEditText);
                if(lpgEditText.getText().toString().equals("")){
                    Primerylist[3] = 0;
                }
                else {
                    Primerylist[3] =Integer.parseInt(lpgEditText.getText().toString());
                }

                EditText flightEditText =  findViewById(R.id.flightEditText);
                if(flightEditText.getText().toString().equals("")){
                    Primerylist[4] = 0;
                }
                else{
                    Primerylist[4] = Integer.parseInt(flightEditText.getText().toString());
                }

                EditText carEditText =  findViewById(R.id.carEditText);
                if(carEditText.getText().toString().equals("")){
                    Primerylist[5] = 0;
                }
                else{
                    Primerylist[5] = Integer.parseInt(carEditText.getText().toString());
                }

                EditText subwayEditText =  findViewById(R.id.subwayEditText);
                if(subwayEditText.getText().toString().equals("")){
                    Primerylist[6] = 0;
                }
                else {
                    Primerylist[6] = Integer.parseInt(subwayEditText.getText().toString());
                }

                EditText busEditText =  findViewById(R.id.busEditText);
                if(busEditText.getText().toString().equals("")){
                    Primerylist[7] = 0;
                }
                else{
                    Primerylist[7] = Integer.parseInt(busEditText.getText().toString());
                }

                userDataBaseRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        User currentUser = snapshot.getValue(User.class);
                        currentUser.totalPrimaryEmission += totalPrimaryUsage;
                        updateUserDataBaseRef.setValue(currentUser);
                        System.out.println(totalPrimaryUsage);
                        Toast.makeText(PrimaryUsage.this, "Successfully submitted.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
    public int calculatePrimary(int[] primerylist){
        int result =0;
        int multp = primerylist[0];
        int index = 1;
        /**
         * index
         *  0:  household in int
         *  1:  electricity in kW
         *  2:  natural gas in m^3
         *  3:  lpg in m^3
         *  4:  flight in miles
         *  5:  car in km
         *  6:  subway in km
         *  7:  bus in km
         */
        while(index < 8){
            String indexString = ""+index;
            switch (indexString){
                case "1" : result += (10.5)* primerylist[index];
                    break;
                case "2" : result += (10.5)* primerylist[index];
                    break;
                case "3" : result += (11.3)* primerylist[index];
                    break;
                case "4" : result += (1.1)* primerylist[index];
                    break;
                case "5" : result += (0.8)* primerylist[index];
                    break;
                case "6" : result += (0.2)* primerylist[index];
                    break;
                case "7" : result += (0.3)* primerylist[index];
                    break;
                default: result+= 0;
                    break;
            }
            index++;
        }
        return (int) (result * multp * 10);
    }

    @Override
    public void calculate() {
        totalPrimaryUsage = calculatePrimary(Primerylist);
    }
}