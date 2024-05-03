package com.example.practice1.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.practice1.model.B12_Item;
import com.example.practice1.model.TH2_Song;

import java.util.ArrayList;
import java.util.List;

public class TH2_SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BaiHat.db";
    private static int DATABASE_VERSION=1;
    public TH2_SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "CREATE TABLE items(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT, single TEXT, album TEXT, type TEXT, isFavorite TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    //get all song
    public List<TH2_Song> getAllSong() {
        List<TH2_Song> list= new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
//        String order="date DESC";
        Cursor rs= st.query("items",null,null,null,null,null,null);
        while (rs!=null && rs.moveToNext()) {
            int id= rs.getInt(0);
            String name= rs.getString(1);
            String single= rs.getString(2);
            String album= rs.getString(3);
            String type=rs.getString(4);
            String isFavorite = rs.getString(5);
            list.add(new TH2_Song(id,name,single,album,type,isFavorite));
        }
        return list;

    }

    // add
    public long addItem(TH2_Song i) {
        ContentValues values= new ContentValues();
        values.put("name",i.getName());
        values.put("single",i.getSingle());
        values.put("album",i.getAlbum());
        values.put("type",i.getType());
        values.put("isFavorite",i.getIsFavorite());
        SQLiteDatabase sqLiteDatabase= getWritableDatabase();
        return sqLiteDatabase.insert("items",null,values);
    }

    // get Item By Date
//    public List<B12_Item> getByDate(String date) {
//        List<B12_Item> list= new ArrayList<>();
//        String whereClause = "date like ?";
//        String[] whereArgs={date};
//        SQLiteDatabase st = getReadableDatabase();
//        Cursor rs= st.query("items",null,whereClause,whereArgs,null,null,null);
//        while (rs!=null && rs.moveToNext()) {
//            int id= rs.getInt(0);
//            String title= rs.getString(1);
//            String category= rs.getString(2);
//            String price= rs.getString(3);
//            list.add(new B12_Item(id,title,category,price,date));
//        }
//        return list;
//
//    }

    // update
    public int update(TH2_Song i) {
        ContentValues values= new ContentValues();
        values.put("name",i.getName());
        values.put("single",i.getSingle());
        values.put("album",i.getAlbum());
        values.put("type",i.getType());
        values.put("isFavorite",i.getIsFavorite());
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
//    public List<B12_Item> searchByTitle(String key) {
//        List<B12_Item> list= new ArrayList<>();
//        String whereClause = "title like ?";
//        String[] whereArgs={"%"+key+"%"};
//        SQLiteDatabase st = getReadableDatabase();
//        Cursor rs= st.query("items",null,whereClause,whereArgs,null,null,null);
//        while (rs!=null && rs.moveToNext()) {
//            int id= rs.getInt(0);
//            String title= rs.getString(1);
//            String category= rs.getString(2);
//            String price= rs.getString(3);
//            String date=rs.getString(4);
//            list.add(new B12_Item(id,title,category,price,date));
//        }
//        return list;
//
//    }

    // search by album
    public List<TH2_Song> searchByAlbum(String album) {
        List<TH2_Song> list= new ArrayList<>();
        String whereClause = "album = ?";
        String[] whereArgs={album};
        SQLiteDatabase st = getReadableDatabase();

        Cursor rs= st.query("items",null,whereClause,whereArgs,null,null,null);
//        Log.d("album", "searchByAlbum:" + rs.getInt(0) + " " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(4) + "  " + rs.getString(5));
        while (rs!=null && rs.moveToNext()) {
            int id= rs.getInt(0);
            String name= rs.getString(1);
            String single= rs.getString(2);
//            String album= rs.getString(3);

            String type=rs.getString(4);
//            boolean isFavorite= rs.getB;
//            int isFavoriteInt = rs.getInt(5);
//            boolean isFavorite = (isFavoriteInt != 0);
            String isFavorite = rs.getString(5);
            list.add(new TH2_Song(id,name,single,album,type,isFavorite));
//            Log.d("album", "searchByAlbum: get $list");
        }
        return list;

    }

    // search by date
//    public List<B12_Item> searchByFromToDate(String from, String to) {
//        List<B12_Item> list= new ArrayList<>();
//        String whereClause = "date BETWEEN ? AND ?";
//        String[] whereArgs={from.trim(),to.trim()};
//        SQLiteDatabase st = getReadableDatabase();
//        Cursor rs= st.query("items",null,whereClause,whereArgs,null,null,null);
//        while (rs!=null && rs.moveToNext()) {
//            int id= rs.getInt(0);
//            String title= rs.getString(1);
//            String category= rs.getString(2);
//            String price= rs.getString(3);
//            String date=rs.getString(4);
//            list.add(new B12_Item(id,title,category,price,date));
//        }
//        return list;
//
//    }
}
