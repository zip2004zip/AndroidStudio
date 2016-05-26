package com.example.st.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        Button button = (Button) findViewById(R.id.newActivity1Button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                final TextView textView = (TextView) findViewById(R.id.textId);
                //  textView.setTextColor(Color.BLUE);
                textView.setTextColor(getResources().getColor(R.color.colorTextPosleNazhatia));  //изменяем цвет текста после нажатия
                textView.setBackgroundColor(getResources().getColor(R.color.colorFonPosleNazhatia)); // изменяем фон текста после нажатия
                EditText editText = (EditText) findViewById(R.id.editText);
                textView.setText(editText.getText());
                textView.setText("Text v MainActivity"); // изменяем текст после нажатия
                Toast.makeText(this, "текст изменен успешно", Toast.LENGTH_LONG).show(); // всплываемое оно
                Log.d("TAG", "msg d");
                Log.e("TAG", "msg e");
                break;
            case R.id.newActivity1Button:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Старт", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Рестарт", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Возобновить", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Пауза", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Стоп", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Уничтожить", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
