package com.example.st.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class QuestionnaireActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    Button buttonSend;
    private static SeekBar seekBar;
    private static TextView textView_seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        // SeekBar
        seekBar = (SeekBar) findViewById(R.id.seekBar_nights);
        textView_seekBar = (TextView) findViewById(R.id.textView_nights_seekBar);
        seekBar();

        // пожелания
        editText = (EditText) findViewById(R.id.editText_Suggestion);

        // кнопка отправки
        buttonSend = (Button) findViewById(R.id.button_Send);


    }


    @Override
    public void onClick(View v) {

    }

    public void seekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // textView_seekBar.setText(String.valueOf(progress) + "дней");
                textView_seekBar.setText(progress + " дней");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

}
