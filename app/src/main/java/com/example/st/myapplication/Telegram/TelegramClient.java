package com.example.st.myapplication.Telegram;

import com.example.st.myapplication.Telegram.data.TelegramGetUpdates;
import com.example.st.myapplication.Telegram.data.TelegramSendMessage;
import com.example.st.myapplication.Telegram.dataAvatarClient.TelegramGetAvatar;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by st on 30.06.2016.
 */

public class TelegramClient {

    public final static String API_KEY = "172880107:AAEWf0LdTwNt9FkKkAJzodftcHWKHfLZ96w";
    public final static String GETUPDATES_URL = "https://api.telegram.org/bot" + API_KEY +"/getUpdates";
    public final static String SENDMESSAGE_URL = "https://api.telegram.org/bot" + API_KEY +"/sendmessage";
    public final static String GETAVATAR_URL = "https://api.telegram.org/bot" + API_KEY;


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

        String json = get(GETUPDATES_URL);
        TelegramGetUpdates result = gson.fromJson(json, TelegramGetUpdates.class);
        return result;
    }

    public TelegramSendMessage sendMessage(long chat_id, String text) throws IOException {
        Gson gson = new Gson();

        String json = get(SENDMESSAGE_URL + "?chat_id=" + chat_id + "&" + "text=" + text);
        TelegramSendMessage result = gson.fromJson(json, TelegramSendMessage.class);
        return result;
    }

    /*public TelegramGetAvatar getAvatar (long user_id){
        Gson gson = new Gson();

        String json = get(GETAVATAR_URL + "getFile?")
    }*/
}
