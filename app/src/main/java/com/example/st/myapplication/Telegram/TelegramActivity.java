package com.example.st.myapplication.Telegram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.st.myapplication.R;
import com.example.st.myapplication.Telegram.data.TelegramResult;

import java.util.ArrayList;

/**
 * jsonviewer.stack.hu/
 * http://doc.artofweb.ru/doc/%D0%9E%D1%81%D0%BD%D0%BE%D0%B2%D1%8B_Android
 */


public class TelegramActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telegram);

        listView = (ListView) findViewById(R.id.listViewTelegram);
        listView.setAdapter(new MessageAdapter(new ArrayList<TelegramResult>(), this));
    }

    @Override
    protected void onResume() {
        new AsyncTaskTelegram(this).execute();
        super.onResume();

    }
}