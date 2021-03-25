package com.example.productswithpictures;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] products_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.products_list);
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase productsDB = helper.getWritableDatabase();

        Cursor p = productsDB.rawQuery("SELECT * FROM products", null);
        products_list = p.getColumnNames();
        int[] views = { R.id.id, R.id.name, R.id.price, R.id.picture };
        ProductsAdapter adapter = new ProductsAdapter(this, R.layout.item, p, products_list, views,0);
        lv.setAdapter(adapter);
    }
}
