package com.example.st.myapplication.Quesionnaire;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.st.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class QuestionnaireActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private EditText eTextFirstName;
    private EditText eTextLastName;

    private GregorianCalendar gregorianCalendar;
    private TextView tViewDate;
    private DatePickerDialog datePickerDialog;
    private TextView tViewTime;
    private TimePickerDialog timePickerDialog;

    private SeekBar seekBar;
    private TextView tViewSeekBar;



    private TextView tViewSex;
    private RadioGroup radioGroup;

    private EditText eTextSuggestion;

    private Button buttonSend;

    private Questionnaire questionnaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        // editText_FirstName editText_LastName
        eTextFirstName = (EditText) findViewById(R.id.editTextFirstName);
        eTextLastName = (EditText) findViewById(R.id.editTextLastName);

        // Date and Time of arrive
        gregorianCalendar = new GregorianCalendar();
        tViewDate = (TextView) findViewById(R.id.textViewDate);
        datePickerDialog = new DatePickerDialog(this, this, gregorianCalendar.get(GregorianCalendar.YEAR), gregorianCalendar.get(GregorianCalendar.MONTH), gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH));

        tViewTime = (TextView) findViewById(R.id.textViewTime);
        timePickerDialog = new TimePickerDialog(this, this, gregorianCalendar.get(GregorianCalendar.HOUR_OF_DAY), gregorianCalendar.get(GregorianCalendar.MINUTE), true);


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
        switch (v.getId()) {
            case R.id.textViewDate:
                datePickerDialog.show();
                break;
            case R.id.textViewTime:
                timePickerDialog.show();
                break;
            case R.id.buttonSend:
                Questionnaire questionnaire = createQuestionnaire();



        }
    }

    private Questionnaire createQuestionnaire() {
        questionnaire = new Questionnaire();
        questionnaire.setFirstName(eTextFirstName.getText().toString());
        questionnaire.setLastName(eTextLastName.getText().toString());

        questionnaire.setDateAndTimeOfArrive(gregorianCalendar);

        questionnaire.setNights(Integer.valueOf(tViewSeekBar.getText().toString()));



        return questionnaire;
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

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        gregorianCalendar.set(year, monthOfYear, dayOfMonth);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        tViewDate.setText(simpleDateFormat.format(gregorianCalendar.getTime()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        gregorianCalendar.set(GregorianCalendar.HOUR_OF_DAY, hourOfDay);
        gregorianCalendar.set(GregorianCalendar.MINUTE, minute);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        tViewTime.setText(simpleDateFormat.format(gregorianCalendar.getTime()));
    }
}
