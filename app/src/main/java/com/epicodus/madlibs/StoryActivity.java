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
        if(intent.getStringExtra("storyType").equals("Standard")) {
            String name = intent.getStringExtra("name");
            String place = intent.getStringExtra("place");
            String verb = intent.getStringExtra("verb");
            String animal = intent.getStringExtra("animal");
            String adjective = intent.getStringExtra("adjective");
            mStoryTextView.setText(name + " woke up in a(n) " + place + ". 'Where the hell am I', wondered " + name + ". Suddenly, " + name + " entered a frenzied panic. 'I forgot to " + verb + " the " + animal + "', " + name + " said to themselves. They " + adjective + " ran home to " + verb + " their " + animal + ".");
        } else if(intent.getStringExtra("storyType").equals("Boring")) {
            String name = intent.getStringExtra("name");
            String workplace = intent.getStringExtra("workplace");
            String verb = intent.getStringExtra("verb");
            String food = intent.getStringExtra("food");
            String adjective = intent.getStringExtra("adjective");
            mStoryTextView.setText(name + " woke up in their home. They drove into work at " + workplace + " and had a standard day where they " + verb + "ed some papers. Then " + name + " went home and ate some " + food + " in a severely uninteresting manner. They went for a walk that was not at all " + adjective + " and then went back to sleep.");
        } else {
            String name = intent.getStringExtra("name");
            String place = intent.getStringExtra("place");
            String verb = intent.getStringExtra("verb");
            String animal = intent.getStringExtra("animal");
            String adjective = intent.getStringExtra("adjective");
            mStoryTextView.setText(name + " woke up in a(n) " + place + "!!!!!!! 'Where the hell am I', wondered " + name + "!!!!!!!!! Suddenly, " + name + " entered a frenzied panic!!!!!!!!!!! 'I forgot to " + verb + " the " + animal + "', " + name + " said to themselves!!!!!!!!!!!!!! They " + adjective + " ran home to " + verb + " their " + animal + "!!!!!!!!!!!!!");
        }

    }
}
