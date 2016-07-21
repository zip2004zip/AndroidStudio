package com.example.st.myapplication.Telegram.dataAvatarClient;

import java.util.List;

/**
 * Created by st on 21.07.2016.
 */

public class TelegramResultAvatar {
    private int total_count;
    private List<TelegramPhoto> photos;

    public int getTotal_count() {
        return total_count;
    }

    public List<TelegramPhoto> getPhotos() {
        return photos;
    }
}
