package com.aksdev.projectsecondaryusage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PdfActivity extends AppCompatActivity {
    private Button basicPdfBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_activity);
        basicPdfBtn = findViewById(R.id.basicPdfBtn);
        basicPdfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PdfActivity.this, PdfPage.class));

            }
        });
    }
}