package com.example.productswithpictures;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "products.db";
    final static String TABLE_NAME = "products";
    final static String CREATE = "CREATE TABLE "+TABLE_NAME+ "( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL, `price` INTEGER NOT NULL, `picture` TEXT NOT NULL)";
    // при изменении структуры БД меняется и версия
    private static final int DATABASE_VERSION = 10;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // выполняется, если базы данных нет
        db.execSQL(CREATE);
        db.execSQL("INSERT INTO products VALUES (1, 'pion', 300, 'https://centre-flower.ru/wp-content/uploads/p/2/9/7/4/2974-Pion-Sara-Bernar.jpg' )," +
                "(2, 'rose', 600, 'https://pocvetam.ru/wp-content/uploads/2020/08/1-roza-1.jpg' );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // выполняется, если версия базы данных отличается
        db.execSQL("DROP DATABASE "+DB_NAME);
        this.onCreate(db);
    }
}
