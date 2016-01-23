package com.pennapps.xpresscart;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by xe on 2016-01-23.
 */
public class GroceryAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public GroceryAdapter(Context context, String[] values)
    {
        super(context, -1, values);
        this.context =context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        
    }

}
