package com.example.st.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        EditText editText = (EditText) findViewById(R.id.editText2);
        editText.getText();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSum:
            case R.id.buttonMinus:
            case R.id.buttonMultiply:
            case R.id.buttonDivide: {

                break;
            }

            case R.id.buttonC: {

                break;
            }


        }

    }
}


// cybern.ru/calcjava.html
// javatalks.ru/topics/8142
// pro-java.ru/gotovye-programmy-java/prostoj-kalkulyator-na-java/