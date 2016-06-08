package com.example.st.myapplication.CalculatorPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.st.myapplication.CalculatorPackage.Operations;
import com.example.st.myapplication.R;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    Button buttonSum;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivide;
    private Operations operations = null;
    private double a = 0;
    private double b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        editText = (EditText) findViewById(R.id.editText2);

        buttonSum = (Button) findViewById(R.id.buttonSum);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);

        buttonSum.setTag(Operations.SUMMA);
        buttonMinus.setTag(Operations.MINUS);
        buttonMultiply.setTag(Operations.MULTIPLY);
        buttonDivide.setTag(Operations.DIVIDE);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.buttonSum: {
                operations = Operations.SUMMA;
                a = Double.valueOf(editText.getText().toString());
                editText.setText("");
                break;
            }

            case R.id.buttonMinus: {
                operations = Operations.MINUS;
                a = Double.valueOf(editText.getText().toString());
                editText.setText("");
                break;
            }

            case R.id.buttonMultiply: {
                operations = Operations.MULTIPLY;
                a = Double.valueOf(editText.getText().toString());
                editText.setText("");
                break;
            }

            case R.id.buttonDivide: {
                operations = Operations.DIVIDE;
                a = Double.valueOf(editText.getText().toString());
                editText.setText("");
                break;
            }

            case R.id.buttonC: {
                editText.setText("0");
                break;
            }

            case R.id.buttonDelete: {
                editText.setText(editText.getText().delete(editText.getText().length() - 1, editText.getText().length()));
                if (editText.getText().toString().trim().length() == 0) {
                    editText.setText("0");
                }
                break;
            }

            case R.id.buttonComma: {
                //  editText.setText("0" + v.getContentDescription().toString());
                if (!editText.getText().toString().contains(".")) {
                    editText.setText(editText.getText() + ".");
                }
                break;
            }

            case R.id.buttonResult: {
                b = Double.valueOf(editText.getText().toString());
                // editText.setText("");
                switch (operations) {
                    case SUMMA:
                        if (a + b % 1 == 0) {
                            editText.setText(String.valueOf((int) a + b));
                        } else {
                            editText.setText(String.valueOf(a + b));
                        }
                        break;

                    case MINUS:
                        if (a - b % 1 == 0) {
                            editText.setText(String.valueOf((int) a - b));
                        } else {
                            editText.setText(String.valueOf(a - b));
                        }
                        break;

                    case DIVIDE:
                        if (b == 0) {
                            Toast.makeText(this, "На ноль делить нельзя!\nВведите число еще раз", Toast.LENGTH_LONG).show();
                            return;
                        }
                        if (a / b % 1 == 0) {
                            editText.setText(String.valueOf((int) a / b));
                        } else {
                            editText.setText(String.valueOf(a / b));
                        }
                        break;

                    case MULTIPLY:
                        if (a * b % 1 == 0) {
                            editText.setText(String.valueOf((int) a * b));
                        } else {
                            editText.setText(String.valueOf(a * b));
                        }
                        break;
                }
                break;
            }

            default: {
                if (editText.getText().toString().equals("0")) { //что бы спереди когда начинаем вводить цифры не стоял сразу 0, то он удаляется 092
                    editText.setText(v.getContentDescription().toString());
                } else {
                    editText.setText(editText.getText() + v.getContentDescription().toString());
                }
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