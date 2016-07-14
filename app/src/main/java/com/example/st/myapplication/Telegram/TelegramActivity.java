package com.example.st.myapplication.Telegram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.st.myapplication.R;
import com.example.st.myapplication.Telegram.data.TelegramResult;

import java.util.ArrayList;


public class TelegramActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram);

        listView = (ListView) findViewById(R.id.listViewTelegram);
        listView.setAdapter(new MessageAdapter(new ArrayList<TelegramResult>(), this));
    }

    @Override
    public void onClick(View v) {
        new AsyncTaskTelegram(this).execute();
    }
}