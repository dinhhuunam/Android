package com.example.practice1.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.practice1.model.B12_Item;

import java.util.ArrayList;
import java.util.List;

public class B12_SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ChiTieu.db";
    private static int DATABASE_VERSION=1;
    public B12_SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "CREATE TABLE items(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT, category TEXT, price TEXT, date TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    //get all orderby date descending
    public List<B12_Item> getAll() {
        List<B12_Item> list= new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        String order="date DESC";
        Cursor rs= st.query("items",null,null,null,null,null,order);
        while (rs!=null && rs.moveToNext()) {
            int id= rs.getInt(0);
            String title= rs.getString(1);
            String category= rs.getString(2);
            String price= rs.getString(3);
            String date= rs.getString(4);
            list.add(new B12_Item(id,title,category,price,date));
        }
        return list;

    }

    // add
    public long addItem(B12_Item i) {
        ContentValues values= new ContentValues();
        values.put("title",i.getTitle());
        values.put("category",i.getCategory());
        values.put("price",i.getPrice());
        values.put("date",i.getDate());
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        return sqLiteDatabase.insert("items",null,values);
    }

    // get Item By Date
    public List<B12_Item> getByDate(String date) {
        List<B12_Item> list= new ArrayList<>();
        String whereClause = "date like ?";
        String[] whereArgs={date};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs= st.query("items",null,whereClause,whereArgs,null,null,null);
        while (rs!=null && rs.moveToNext()) {
            int id= rs.getInt(0);
            String title= rs.getString(1);
            String category= rs.getString(2);
            String price= rs.getString(3);
            list.add(new B12_Item(id,title,category,price,date));
        }
        return list;

    }

    // update
    public int update(B12_Item i) {
        ContentValues values= new ContentValues();
        values.put("title",i.getTitle());
        values.put("category",i.getCategory());
        values.put("price",i.getPrice());
        values.put("date",i.getDate());
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        String whereClause = "id=?";
        String[] whereArgs={Integer.toString(i.getId())};
        return sqLiteDatabase.update("items",values,whereClause,whereArgs);
    }

    //delete
    public int delete(int id) {
        String whereClause = "id=?";
        String[] whereArgs={Integer.toString(id)};
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        return sqLiteDatabase.delete("items",whereClause,whereArgs);
    }


    // search by title
    public List<B12_Item> searchByTitle(String key) {
        List<B12_Item> list= new ArrayList<>();
        String whereClause = "title like ?";
        String[] whereArgs={"%"+key+"%"};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs= st.query("items",null,whereClause,whereArgs,null,null,null);
        while (rs!=null && rs.moveToNext()) {
            int id= rs.getInt(0);
            String title= rs.getString(1);
            String category= rs.getString(2);
            String price= rs.getString(3);
            String date=rs.getString(4);
            list.add(new B12_Item(id,title,category,price,date));
        }
        return list;

    }

    // search by category
    public List<B12_Item> searchByCategory(String category) {
        List<B12_Item> list= new ArrayList<>();
        String whereClause = "category like ?";
        String[] whereArgs={category};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs= st.query("items",null,whereClause,whereArgs,null,null,null);
        while (rs!=null && rs.moveToNext()) {
            int id= rs.getInt(0);
            String title= rs.getString(1);
//            String category= rs.getString(2);
            String price= rs.getString(3);
            String date=rs.getString(4);
            list.add(new B12_Item(id,title,category,price,date));
        }
        return list;

    }

    // search by date
    public List<B12_Item> searchByFromToDate(String from, String to) {
        List<B12_Item> list= new ArrayList<>();
        String whereClause = "date BETWEEN ? AND ?";
        String[] whereArgs={from.trim(),to.trim()};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs= st.query("items",null,whereClause,whereArgs,null,null,null);
        while (rs!=null && rs.moveToNext()) {
            int id= rs.getInt(0);
            String title= rs.getString(1);
            String category= rs.getString(2);
            String price= rs.getString(3);
            String date=rs.getString(4);
            list.add(new B12_Item(id,title,category,price,date));
        }
        return list;

    }
}
