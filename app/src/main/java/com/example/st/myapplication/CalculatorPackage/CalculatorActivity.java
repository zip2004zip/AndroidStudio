package com.example.st.myapplication.CalculatorPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.st.myapplication.CalculatorPackage.Operations;
import com.example.st.myapplication.R;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Operations operations = null;
    private int a = 0;
    private int b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        editText = (EditText) findViewById(R.id.editText2);
        // editText.getText();

        // Button buttonSum = (Button) findViewById(R.id.buttonSum);
        //  buttonSum.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.buttonSum: {
                operations = Operations.SUMMA;
                a = Integer.valueOf(editText.getText().toString());
                editText.setText("");
                break;
            }

            case R.id.buttonMinus: {
                operations = Operations.MINUS;
                a = Integer.valueOf(editText.getText().toString());
                editText.setText("");
                break;
            }

            case R.id.buttonMultiply: {
                operations = Operations.MULTIPLY;
                a = Integer.valueOf(editText.getText().toString());
                editText.setText("");
                break;
            }

            case R.id.buttonDivide: {
                operations = Operations.DIVIDE;
                a = Integer.valueOf(editText.getText().toString());
                editText.setText("");
                break;
            }

            case R.id.buttonC: {
                editText.setText("0");
                break;
            }

            case R.id.buttonDelete: {

                break;
            }

            case R.id.buttonComma: {

                break;
            }

            case R.id.buttonResult: {
                b = Integer.valueOf(editText.getText().toString());
                editText.setText("");
                switch (operations) {
                    case SUMMA:
                        editText.setText(String.valueOf(a + b));
                        break;
                }
                break;
            }

            default: {
                editText.setText(editText.getText() + v.getContentDescription().toString());
            }
        }
    }
}


class CalculatorOperations {

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double minus(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}


// cybern.ru/calcjava.html
// javatalks.ru/topics/8142
// pro-java.ru/gotovye-programmy-java/prostoj-kalkulyator-na-java/