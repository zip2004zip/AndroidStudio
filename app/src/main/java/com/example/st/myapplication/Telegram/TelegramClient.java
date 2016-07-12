package com.example.st.myapplication.Telegram;

import com.example.st.myapplication.Telegram.data.TelegramGetUpdates;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by st on 30.06.2016.
 * http://jsonviewer.stack.hu/
 */

public class TelegramClient {

    private String get(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public TelegramGetUpdates getUpdates() throws IOException {
        Gson gson = new Gson();

        String json = get("https://api.telegram.org/bot172880107:AAEWf0LdTwNt9FkKkAJzodftcHWKHfLZ96w/getUpdates");
        TelegramGetUpdates result = gson.fromJson(json, TelegramGetUpdates.class);
        return result;
    }
}
