package com.example.productswithpictures;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductsAdapter extends SimpleCursorAdapter {
    Picasso p;
    public ProductsAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        p  = new Picasso.Builder(context).build();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return super.newView(context, cursor, parent);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvId = view.findViewById(R.id.id);
        ImageView picture = view.findViewById(R.id.picture);
        TextView tvName = view.findViewById(R.id.name);
        TextView tvPrice = view.findViewById(R.id.price);

        String name = cursor.getString(cursor.getColumnIndex("name"));
        int price = cursor.getInt(cursor.getColumnIndex("price"));
        int id = cursor.getInt(cursor.getColumnIndex("_id"));
        String url = cursor.getString(cursor.getColumnIndex("picture"));

        tvName.setText(name);
        tvId.setText(Integer.toString(id));
        tvPrice.setText(Integer.toString(price));

        picture.setImageResource(R.drawable.user_unknown);
        p.load(url).error(R.drawable.no_image).into(picture);
    }
}
