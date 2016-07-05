package com.example.st.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SaveToSharedPreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String FILE_NAME_SHAR_PREF = "SaveFileSharPref.txt";
    EditText eTextSaveShar;
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_to_shared_preferences);

        eTextSaveShar = (EditText) findViewById(R.id.editTextSaveSharPref);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSaveSharedPre:
                saveText();
                break;
            case R.id.buttonOpenSharedPre:
                loadText();
                break;
        }
    }

    void saveText() {
        sPref = getSharedPreferences(FILE_NAME_SHAR_PREF, MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(FILE_NAME_SHAR_PREF, eTextSaveShar.getText().toString());
        ed.apply();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        sPref = getSharedPreferences(FILE_NAME_SHAR_PREF, MODE_PRIVATE);
        String savedText = sPref.getString(FILE_NAME_SHAR_PREF, "");
        eTextSaveShar.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveText();
        Toast.makeText(this, "Text saved OnPause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadText();
        Toast.makeText(this, "Text loaded onResume", Toast.LENGTH_SHORT).show();
    }
}
