package com.example.glist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);

        if (user != null) {
            TextView itemName = (TextView) convertView.findViewById(R.id.textItemName);
            TextView quantity = (TextView) convertView.findViewById(R.id.textQuantity);
            TextView price = (TextView) convertView.findViewById(R.id.textPrice);
            if (itemName != null) {
                itemName.setText(user.getItemName());
            }
            if (quantity != null) {
                quantity.setText((user.getQuantity()));
            }
            if (price != null) {
                price.setText((user.getPrice()));
            }
        }

        return convertView;
    }

}
