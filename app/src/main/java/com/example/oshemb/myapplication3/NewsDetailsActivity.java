package com.example.oshemb.myapplication3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NewsDetailsActivity extends AppCompatActivity {

    public static void startActyvity(Context context, String title, String imageUrl, String category, String publishDate, String previewText, String fullText){
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("imageUrl", imageUrl);
        intent.putExtra("category", category);
        intent.putExtra("publishDate", publishDate);
        intent.putExtra("previewText", previewText);
        intent.putExtra("fullText", fullText);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);


        TextView textViewPreview  = findViewById(R.id.textView_preview);
        ImageView imageView = findViewById(R.id.imageView);
        TextView textViewDate = findViewById(R.id.textView_date);
        TextView textViewFull = findViewById(R.id.textView_full);
        Intent intent = getIntent();
        textViewPreview.setText(intent.getExtras().getString("title"));
        Glide.with(this).load(intent.getExtras().getString("imageUrl")).into(imageView);
        textViewDate.setText(intent.getExtras().getString("publishDate"));
        textViewFull.setText(intent.getExtras().getString("fullText"));

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle(intent.getExtras().getString("category"));
    }
}
