package com.example.st.myapplication.Adapter;

import java.util.Date;

/**
 * Created by st on 07.07.2016.
 */
public class Message {
    private String text;
    private String name;
    private String id;
    private Date date;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
