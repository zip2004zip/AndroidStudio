package com.example.st.myapplication.Preference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.st.myapplication.R;

public class SaveToPreferenceActivity extends AppCompatActivity {

    TextView tViewSavePreference;
    SharedPreferences sPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_to_preference);

        tViewSavePreference = (TextView) findViewById(R.id.textViewSavePreference);


    }
}