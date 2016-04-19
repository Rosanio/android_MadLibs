package com.epicodus.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class StandardActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mSubmitEntries;
    private EditText mNameEditText;
    private EditText mPlaceEditText;
    private EditText mVerbEditText;
    private EditText mAnimalEditText;
    private EditText mAdjectiveEditText;


    public void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void setupUI(View view) {
        if(!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideKeyboard(StandardActivity.this);
                    return false;
                }
            });
        }

        if(view instanceof ViewGroup) {
            for(int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        setupUI(findViewById(R.id.parentContainer));



        mSubmitEntries = (Button) findViewById(R.id.submitEntriesButton);
        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mPlaceEditText = (EditText) findViewById(R.id.placeEditText);
        mVerbEditText = (EditText) findViewById(R.id.verbEditText);
        mAnimalEditText = (EditText) findViewById(R.id.animalEditText);
        mAdjectiveEditText = (EditText) findViewById(R.id.adjectiveEditText);

        mSubmitEntries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEditText.getText().toString();
                String place = mPlaceEditText.getText().toString();
                String verb = mVerbEditText.getText().toString();
                String animal = mAnimalEditText.getText().toString();
                String adjective = mAdjectiveEditText.getText().toString();
                Intent intent = new Intent(StandardActivity.this, StoryActivity.class);
                intent.putExtra("storyType", "Standard");
                intent.putExtra("name", name);
                intent.putExtra("place", place);
                intent.putExtra("verb", verb);
                intent.putExtra("animal", animal);
                intent.putExtra("adjective", adjective);
                startActivity(intent);

            }
        });

    }
}
