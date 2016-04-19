package com.epicodus.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button mSubmitEntries;
    private String[] storiesArray = {"Standard", "Exciting", "Boring"};
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, storiesArray);
        mSpinner.setAdapter(adapter);

        mSubmitEntries = (Button) findViewById(R.id.submitEntriesButton);

        mSubmitEntries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String storyType = mSpinner.getSelectedItem().toString();
//                String name = mNameEditText.getText().toString();
//                String place = mPlaceEditText.getText().toString();
//                String verb = mVerbEditText.getText().toString();
//                String animal = mAnimalEditText.getText().toString();
//                String adjective = mAdjectiveEditText.getText().toString();
//                Log.d(TAG, storyType);
//                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
//                intent.putExtra("name", name);
//                intent.putExtra("place", place);
//                intent.putExtra("verb", verb);
//                intent.putExtra("animal", animal);
//                intent.putExtra("adjective", adjective);
//                startActivity(intent);
                if (storyType .equals("Standard")) {
                    Intent intent = new Intent(MainActivity.this, StandardActivity.class);
                    startActivity(intent);
                } else if (storyType.equals("Boring")) {
                    Intent intent = new Intent(MainActivity.this, BoringActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, ExcitingActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
