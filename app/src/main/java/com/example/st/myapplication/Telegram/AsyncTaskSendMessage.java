package com.example.st.myapplication.Telegram;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.st.myapplication.R;
import com.example.st.myapplication.Telegram.data.TelegramSendMessage;

import java.io.IOException;

/**
 * Created by ST on 19.07.2016.
 */

public class AsyncTaskSendMessage extends AsyncTask<Void, Void, TelegramSendMessage> {

    private Activity activity;
    long chat_id;
    String text;

    public AsyncTaskSendMessage(Activity activity, long chat_id, String text) {
        this.activity = activity;
        this.chat_id = chat_id;
        this.text = text;
    }

    @Override
    protected TelegramSendMessage doInBackground(Void... params) {
        TelegramClient telegramClient = new TelegramClient();
        try {
            return telegramClient.sendMessage(chat_id, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(TelegramSendMessage telegramSendMessage) {
        super.onPostExecute(telegramSendMessage);
        if (telegramSendMessage != null && telegramSendMessage.isOk()) {
            Intent intent = new Intent(activity, TelegramActivity.class);
            activity.startActivity(intent);
        } else {
            Toast.makeText(activity, "Текста нет", Toast.LENGTH_LONG).show();
        }
    }
}
