package com.example.carlo.amst5;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterItem extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Category> items;

    public AdapterItem(Activity activity, ArrayList<Category> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Category> category) {
        for (int i = 0; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_category, null);
        }

        Category dir = items.get(position);

        TextView title = (TextView) v.findViewById(R.id.txt_num_tanque);
        title.setText("ID Tanque:   "+dir.getTitle());

        TextView description = (TextView) v.findViewById(R.id.txt_estado_tanque);
        description.setText(" Estado:   "+dir.getDescription());

        TextView ubicacion = (TextView) v.findViewById(R.id.txt_ubicacion) ;
        ubicacion.setText(" Fecha:   "+dir.getUbicacion());

        ImageView imagen = (ImageView) v.findViewById(R.id.img_tanque);
        imagen.setImageDrawable(dir.getImage());

        return v;
    }
}