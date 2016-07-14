package com.example.st.myapplication.Telegram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.st.myapplication.Adapter.Message;
import com.example.st.myapplication.R;
import com.example.st.myapplication.Telegram.data.TelegramMessage;
import com.example.st.myapplication.Telegram.data.TelegramResult;

import java.util.List;

/**
 * Created by st on 14.07.2016.
 */

public class MessageAdapter extends BaseAdapter {

    private List<TelegramResult> messages;
    private Context context;

    public MessageAdapter(List<TelegramResult> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TelegramResult message = messages.get(position);
        View resultView;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        resultView = layoutInflater.inflate(R.layout.list_view_message, parent, false);
        ((TextView) resultView.findViewById(R.id.textViewText)).setText(message.getMessage().getText());
        ((TextView) resultView.findViewById(R.id.textViewName)).setText(message.getMessage().getFrom().getFirst_name() + " " + message.getMessage().getFrom().getLast_name());
        ((TextView) resultView.findViewById(R.id.textViewDate)).setText(String.valueOf(message.getMessage().getDate()));


        return resultView;
    }

    public List<TelegramResult> getMessages() {
        return messages;
    }
}
