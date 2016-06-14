package com.example.st.myapplication.Quesionnaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.st.myapplication.R;

public class QuestionnaireActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private EditText eTextFirstName;
    private EditText eTextLastName;

    private TextView tViewDate;
    private TextView tViewTime;

    private SeekBar seekBar;
    private TextView tViewSeekBar;

    private TextView tViewSex;
    private RadioGroup radioGroup;

    private EditText eTextSuggestion;

    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        // editText_FirstName editText_LastName
        eTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        eTextLastName = (EditText) findViewById(R.id.editTextLastName);

        tViewDate = (TextView) findViewById(R.id.textViewDate);
        tViewTime = (TextView) findViewById(R.id.textViewTime);

        // SeekBar
        seekBar = (SeekBar) findViewById(R.id.seekBarNights);
        tViewSeekBar = (TextView) findViewById(R.id.textViewNightsSeekBar);
        seekBar();

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        // пожелания
        eTextSuggestion = (EditText) findViewById(R.id.editTextSuggestion);

        // кнопка отправки
        buttonSend = (Button) findViewById(R.id.buttonSend);
    }


    @Override
    public void onClick(View v) {

    }

    public void seekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // textView_seekBar.setText(String.valueOf(progress) + "дней");
                tViewSeekBar.setText(progress + " дней");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
      //  radioGroup.setOnCheckedChangeListener(new RadioGroup());
    }
}
