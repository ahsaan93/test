package com.example.muhammadahsan.smartchat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdaptor extends ArrayAdapter<Message>{
    public MessageAdaptor(Context context, ArrayList<Message> messageArrayList) {
        super(context, 0, messageArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.mgslayout, parent,false);
        }

        Message mgs = getItem(position);

        TextView mess = (TextView) view.findViewById(R.id.tv_message);
        TextView messTime = (TextView) view.findViewById(R.id.tv_time);

        mess.setText(mgs.getMessage());
        messTime.setText(mgs.getTime());

        //view.setRotationX(365);
        return view;
    }
}
