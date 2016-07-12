package com.example.st.myapplication.Telegram.data;

import java.util.List;

/**
 * Created by st on 12.07.2016.
 *
 */

public class TelegramGetUpdates {
    private boolean ok;
    private List<TelegramResult> result;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<TelegramResult> getResult() {
        return result;
    }

    public void setResult(List<TelegramResult> result) {
        this.result = result;
    }
}
