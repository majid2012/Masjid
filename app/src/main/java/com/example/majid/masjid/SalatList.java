package com.example.majid.masjid;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Majid on 29-Oct-17.
 */

public class SalatList extends ArrayAdapter<Salat> {

    private Activity context;
    private List<Salat> salatList;

    public SalatList(Activity context, List<Salat> salatList) {
        super(context, R.layout.list_layout, salatList);
        this.context = context;
        this.salatList = salatList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewTime = (TextView) listViewItem.findViewById(R.id.textViewTime);
        TextView textViewAfter = (TextView) listViewItem.findViewById(R.id.textViewAfter);

        Salat salat = salatList.get(position);

        textViewName.setText(salat.getSalat_name());
        textViewTime.setText(salat.getSalat_time());
        textViewAfter.setText(salat.getSalat_after());

        if(position % 2==0){
            listViewItem.setBackgroundColor(Color.parseColor("#4DB6AC"));
        }

        return listViewItem;
    }
}