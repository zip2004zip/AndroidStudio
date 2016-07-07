package com.example.st.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.st.myapplication.R;

import java.util.List;

/**
 * Created by st on 07.07.2016.
 * этот класс отображает сообщения
 * создали массив, что бы их отобразить
 * конструкторы для
 */

public class MessageAdapter extends BaseAdapter {

    private List<Message> messages;
    private Context context;

    public MessageAdapter(List<Message> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @Override
    public int getCount() {  //возвращает сколько сообщений
        return messages.size();
    }

    @Override
    public Object getItem(int position) { //
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //он возвращает вьюв для
        Message message = messages.get(position);
        View resultView;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        resultView = layoutInflater.inflate(R.layout.list_view_message, parent, false);
        ((TextView) resultView.findViewById(R.id.textViewText)).setText(message.getText());
        ((TextView) resultView.findViewById(R.id.textViewName)).setText(message.getName());
        ((TextView) resultView.findViewById(R.id.textViewDate)).setText(message.getDate().toString());


        return resultView;
    }
}
