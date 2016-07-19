package com.example.st.myapplication.Telegram.data;

import java.util.List;

/**
 * Created by st on 12.07.2016.
 *
 */

public class TelegramSendMessage {
    private boolean ok;
    private TelegramResult result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public TelegramResult getResult() {
        return result;
    }

    public void setResult(TelegramResult result) {
        this.result = result;
    }
}
