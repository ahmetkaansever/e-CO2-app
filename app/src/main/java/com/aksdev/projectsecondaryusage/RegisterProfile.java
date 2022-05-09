package com.aksdev.projectsecondaryusage;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
//import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegisterProfile extends AppCompatActivity {

    //Firebase Data
    private Button RegisterProfileBtn;
    private EditText ProfileDetailsNameText;

    //Getters
    public String getProfileDetailsNameRegProfile() {
        return ProfileDetailsNameText.toString();
    }
    public String getProfileDetailsSirnameRegProfile() {
        return ProfileDetailsSirnameText.toString();
    }
    public Uri getImageRegProfile() {
        return image;
    }
    private EditText ProfileDetailsSirnameText;

    //Archive & Image (Uri)
    private static final int IMAGE_REQUEST = 1;
    private ImageView imageView;
    private Uri image;
    private Button ProfileDetailsArchiveBtn;

    //FireBase Image Upload / References
    private StorageReference storageRef;
    private DatabaseReference dataRef;

    //FireBase User register / References
    final private FirebaseDatabase firebaseDatabaseReg = FirebaseDatabase.getInstance();
    public DatabaseReference dataUserRef = firebaseDatabaseReg.getReference("eC02_DataBase");
    //private StorageTask uploadImageTask; --> if only once is allowed

    //FireBase auth object --> ( DataBase )
    private FirebaseAuth authRegProf;

    static int uploadCounter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_profile);

        ProfileDetailsSirnameText = findViewById(R.id.ProfileDetailsSirnameText);
        ProfileDetailsNameText = findViewById(R.id.ProfileDetailsNameText);

        RegisterProfileBtn=  findViewById(R.id.RegisterProfileBtn);
        ProfileDetailsArchiveBtn = findViewById(R.id.ProfileDetailsArchiveBtn);

        //Image PlaceHolder --> ImageView
        imageView = findViewById(R.id.imageView);

        //FireBase Image References
        storageRef = FirebaseStorage.getInstance().getReference("eC02_DataBase/Profile_Picture_DataBase");
        dataRef = FirebaseDatabase.getInstance().getReference("Profile_Picture_DataBase");

        //FireBase User authentication reference
        authRegProf = FirebaseAuth.getInstance();

        RegisterProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**  --> if only once is allowed
                 if(uploadImageTask != null && uploadImageTask.isInProgress()){
                 Toast.makeText(RegisterProfile.this, "Unable to upload", Toast.LENGTH_LONG);
                 }
                 else {
                 UploadImage();
                 }
                 */
                //UploadImage();
                UploadUser();
                Intent intReg = new Intent(RegisterProfile.this, LogIn.class );
                startActivity(intReg);
                finish();
            }
        });
    // Image
        ProfileDetailsArchiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                archiveChooser();
            }
        });
    }
    //User
    private void UploadUser() {
        Intent intent = getIntent();
            String username = intent.getStringExtra(com.aksdev.projectsecondaryusage.Register.EXTRA_USERNAME);
            String password = intent.getStringExtra(com.aksdev.projectsecondaryusage.Register.EXTRA_PASSWORD);
            String mail = intent.getStringExtra(com.aksdev.projectsecondaryusage.Register.EXTRA_MAIL);
            //New User
            User user = new User(getProfileDetailsNameRegProfile(), getProfileDetailsSirnameRegProfile(), username, password, mail ,getImageRegProfile());

        //FireBase User register References
        DatabaseReference userRef =  dataUserRef.child("Users");
        DatabaseReference newUserRef = userRef.child(username);
            HashMap<String, User> userList = new HashMap<>();
            //List with userNames
            userList.put( "User Data:" , user);
            newUserRef.setValue(userList);
            dataUserRef.setValue(newUserRef);

    }
    // User
    // Ouside Source https://developer.android.com/reference/android/content/ContentResolver
    private String getImageExt(Uri image){
        ContentResolver contRes = getContentResolver();
        MimeTypeMap mapMime = MimeTypeMap.getSingleton();
        return ""+mapMime.getExtensionFromMimeType(contRes.getType(image));
    }

    // Ouside Source https://firebase.google.com/docs/reference/android/com/google/firebase/storage/StorageReference
    // https://gist.github.com/codinginflow/afbbb9060cdd9898bdef2c554844e5f4
    private void UploadImage() {
      //  if(image != null){
        StorageReference newStorageRef = storageRef.child(System.currentTimeMillis() + "." + getImageExt(image));
        // uploadImageTask =  --> if only once is allowed
        newStorageRef.putFile(image).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(RegisterProfile.this, "Succesfully uploaded", Toast.LENGTH_SHORT).show();
                uploadCounter++;
                //Instances
                //Dynamic renaming
                String nameImage = "UploadedImage" + uploadCounter;
                String uploadId = dataRef.push().getKey();

                Upload uloadImage = new Upload(nameImage, taskSnapshot.getUploadSessionUri().toString());
                dataRef.child(uploadId).setValue(uloadImage);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterProfile.this, "Something went wrong... Try again", Toast.LENGTH_SHORT).show();
            }
        });
       // }
       //  else {
       // Toast.makeText(RegisterProfile.this, "Select a image for profile picture ", Toast.LENGTH_SHORT).show();
       //  }

    }
    private void archiveChooser() {
        Intent archive = new Intent();
        archive.setType("image/*");
        archive.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(archive,IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == IMAGE_REQUEST ){
            if( resultCode == RESULT_OK ){
                if( data !=null){
                    if( data.getData() != null){
                        image = data.getData();
                        //Picasso.with(this).load(image).into(imageView);
                    }
                }
            }
        }
    }
    //Image
}


