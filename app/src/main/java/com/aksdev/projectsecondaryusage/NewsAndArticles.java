package com.aksdev.projectsecondaryusage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewsAndArticles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsandarticles);

        Button article1 = findViewById(R.id.article1btn);
        Button article2 = findViewById(R.id.article2btn);
        Button article3 = findViewById(R.id.article3btn);
        Button article4 = findViewById(R.id.article4btn);
        Button article5 = findViewById(R.id.article5btn);
        Button article6 = findViewById(R.id.article6btn);
        Button article7 = findViewById(R.id.article7btn);
        Button article8 = findViewById(R.id.article8btn);

        article1.setAllCaps(false);
        article2.setAllCaps(false);
        article3.setAllCaps(false);
        article4.setAllCaps(false);
        article5.setAllCaps(false);
        article6.setAllCaps(false);
        article7.setAllCaps(false);
        article8.setAllCaps(false);

    }

    public void displayArticle1(View view) {

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.enn.com/"));
        startActivity(browserIntent);

        /*WebView webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.journaldev.com");*/

        /*File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/1_The_recycling_of_solid.pdf");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(intent);*/
    }

    public void displayArticle2(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=9298789"));
        startActivity(browserIntent);
    }

    public void displayArticle3(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.treehugger.com/news-4846010"));
        startActivity(browserIntent);
    }

    public void displayArticle4(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://marcobertini.com/wp-content/uploads/2021/05/cf-final.pdf"));
        startActivity(browserIntent);
    }

    public void displayArticle5(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mdpi.com/1996-1073/15/8/2946"));
        startActivity(browserIntent);
    }

    public void displayArticle6(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.recyclethis.co.uk/"));
        startActivity(browserIntent);
    }

    public void displayArticle7(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mdpi.com/2072-6643/13/6/1926"));
        startActivity(browserIntent);
    }

    public void displayArticle8(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.protocol.com/climate/?utm_campaign=pro_climate_v2_gs&utm_medium=search&utm_source=google&gclid=Cj0KCQjwmuiTBhDoARIsAPiv6L_apTiu5sq6VPmvcHCLnT-RnaBZpTHwOzxfl1mNtRtH6Pt0mXzozc8aAv6AEALw_wcB"));
        startActivity(browserIntent);

    }

}