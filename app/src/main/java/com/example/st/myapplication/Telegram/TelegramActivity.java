package com.example.st.myapplication.Telegram;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.st.myapplication.R;

import java.io.IOException;

public class TelegramActivity extends AppCompatActivity implements View.OnClickListener {

    private String response;
    private TextView tViewTelegram;
    private AsyncTask<String, Void, String> asyncTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram);

        tViewTelegram = (TextView) findViewById(R.id.textViewTelegram);
        asyncTask = new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... params) {

                TelegramClient telegramClient = new TelegramClient();

                try {
                    response = String.valueOf(telegramClient.getUpdates());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return response;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                tViewTelegram.setText(s);
            }
        };
    }

    @Override
    public void onClick(View v) {
        asyncTask.execute();
    }
}
