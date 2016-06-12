package com.example.st.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class QuestionnaireActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        editText = (EditText) findViewById(R.id.editText_Suggestion);

        buttonSend = (Button) findViewById(R.id.button_Send);

    }


    @Override
    public void onClick(View v) {

    }
}
