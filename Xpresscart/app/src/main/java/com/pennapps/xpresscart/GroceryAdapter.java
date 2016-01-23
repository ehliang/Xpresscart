package com.pennapps.xpresscart;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by xe on 2016-01-23.
 */
public class GroceryAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;

    public GroceryAdapter(Context context, ArrayList<String> values)
    {
        super(context, -1, values);
        this.context =context;
        this.values = values;
    }

    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.grocery_item,parent,false);
        TextView itemName = (TextView) convertView.findViewById(R.id.price);
        itemName.setText(values.get(position));
        return convertView;
    }

}
