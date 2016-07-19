package com.example.st.myapplication.Telegram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.st.myapplication.R;

import java.io.IOException;

public class SendMessageActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText eTextSendMessage;
    private Button buttonSendMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        eTextSendMessage = (EditText) findViewById(R.id.editTextSendMessage);
        buttonSendMessage = (Button) findViewById(R.id.buttonSendMessage);

    }

    @Override
    public void onClick(View v) {
        String text = eTextSendMessage.getText().toString();
        long chatID = getIntent().getLongExtra(MessageAdapter.CHAT_ID, -1);
        if (chatID == -1) {
            Toast.makeText(this, "Error ID", Toast.LENGTH_SHORT).show();
        } else {
            new AsyncTaskSendMessage(this, chatID, text).execute();
        }
    }
}
