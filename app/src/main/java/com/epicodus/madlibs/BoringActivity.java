package com.epicodus.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.AlignmentSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class BoringActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mSubmitEntries;
    private EditText mNameEditText;
    private EditText mWorkplaceEditText;
    private EditText mVerbEditText;
    private EditText mFoodEditText;
    private EditText mAdjectiveEditText;


    public void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void setupUI(View view) {
        if(!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideKeyboard(BoringActivity.this);
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
        setContentView(R.layout.activity_boring);
        setupUI(findViewById(R.id.parentContainer));



        mSubmitEntries = (Button) findViewById(R.id.submitEntriesButton);
        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mWorkplaceEditText = (EditText) findViewById(R.id.workplaceEditText);
        mVerbEditText = (EditText) findViewById(R.id.verbEditText);
        mFoodEditText = (EditText) findViewById(R.id.foodEditText);
        mAdjectiveEditText = (EditText) findViewById(R.id.adjectiveEditText);

        mSubmitEntries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEditText.getText().toString();
                String workplace = mWorkplaceEditText.getText().toString();
                String verb = mVerbEditText.getText().toString();
                String food = mFoodEditText.getText().toString();
                String adjective = mAdjectiveEditText.getText().toString();
                Intent intent = new Intent(BoringActivity.this, StoryActivity.class);
                intent.putExtra("storyType", "Boring");
                intent.putExtra("name", name);
                intent.putExtra("workplace", workplace);
                intent.putExtra("verb", verb);
                intent.putExtra("food", food);
                intent.putExtra("adjective", adjective);
                startActivity(intent);
            }
        });

    }
}
