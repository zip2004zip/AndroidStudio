package com.example.st.myapplication.Adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.st.myapplication.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        listView = (ListView) findViewById(R.id.listViewAdapter);

        List<Message> messageList = new ArrayList<>();
        Message message1 = new Message();
        message1.setDate(new Date());
        message1.setText("jgkdfsg k dgkn fgkdnf knk kdn fgnkd");
        message1.setName("name");
        messageList.add(message1);
        Message message2 = new Message();
        message2.setDate(new Date());
        message2.setText(" dngfkj ndfkjgn dfkljgn kjdf g");
        message2.setName("name2");
        messageList.add(message2);
        Message message3 = new Message();
        message3.setDate(new Date());
        message3.setText("dnkjnfg kdfn");
        message3.setName("name3");
        messageList.add(message3);
        MessageAdapter messageAdapter = new MessageAdapter(messageList, this);
        listView.setAdapter(messageAdapter);

    }
}

// https://youtu.be/QNR2sd4p0og