package com.example.st.myapplication.Telegram.data;

/**
 * Created by st on 12.07.2016.
 */
public class TelegramResult {
    private long update_id;
    private TelegramMessage message;


    public long getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(long update_id) {
        this.update_id = update_id;
    }

    public TelegramMessage getMessage() {
        return message;
    }

    public void setMessage(TelegramMessage message) {
        this.message = message;
    }
}

