package com.pennapps.xpresscart;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by xe on 2016-01-23.
 */
public class GroceryAdapter extends ArrayAdapter<ScanObject> {
    private final Context context;
    private final ArrayList<ScanObject> values;

    public GroceryAdapter(Context context, ArrayList<ScanObject> values)
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
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        if (convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grocery_item, parent, false);
        }
        Button subtract= (Button) convertView.findViewById(R.id.subtract);
        Button add = (Button) convertView.findViewById(R.id.add);
        subtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                values.get(position).decreaseQuantity();
                notifyDataSetChanged();
            }
        });
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                values.get(position).increaseQuantity();
                notifyDataSetChanged();
            }
        });


        TextView itemName = (TextView) convertView.findViewById(R.id.itemName);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        TextView quantity = (TextView) convertView.findViewById(R.id.quantity);
        itemName.setText(values.get(position).getItemName());
        price.setText("$" + String.valueOf(values.get(position).getPrice()));
        quantity.setText(String.valueOf(values.get(position).getQuantity()));

        return convertView;
    }



}
