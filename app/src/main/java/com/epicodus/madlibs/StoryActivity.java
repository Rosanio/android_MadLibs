package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    private TextView mStoryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        mStoryTextView = (TextView) findViewById(R.id.storyTextView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String place = intent.getStringExtra("place");
        String verb = intent.getStringExtra("verb");
        String animal = intent.getStringExtra("animal");
        String adjective = intent.getStringExtra("adjective");
        mStoryTextView.setText(name + " woke up in a(n) " + place + ". 'Where the hell am I', wondered " + name + ". ");
    }
}
