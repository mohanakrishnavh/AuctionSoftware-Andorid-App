package com.example.mohanakrishna.androidapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Mohanakrishna on 23-Mar-17.
 */

public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "seller.db";
    private static final String TABLE_NAME="sellertable";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_PHONE="phone";
    private static final String COLUMN_PASSWORD="password";

    private static final String TABLE_CREATE="create table sellertable (id integer primary key not null," +
            "name text not null,email text not null,phone text not null,password text not null);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

    public void insertSeller(Contact c)
    {
        try{
            db = this.getWritableDatabase();
            ContentValues cv= new ContentValues();

            String query="select * from sellertable;";
            Cursor cursor=db.rawQuery(query,null);
            int count=cursor.getCount();

            cv.put(COLUMN_ID,count);
            cv.put(COLUMN_NAME,c.getName());
            cv.put(COLUMN_EMAIL,c.getEmail());
            cv.put(COLUMN_PHONE,c.getPhone());
            cv.put(COLUMN_PASSWORD,c.getPassword());

            db.insert(TABLE_NAME,null,cv);
            db.close();
        }
        catch(SQLiteException s)
        {
            System.out.println("SQLLite Exception for Seller is :"+s);
        }
    }

    public String searchPassword(String email)
    {
        db = this.getReadableDatabase();
        String query="select * from "+TABLE_NAME;
        String t_email,t_password;
        t_password="Not found";
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do
            {
                t_email=cursor.getString(2);

                if(t_email.equals(email))
                {
                    t_password=cursor.getString(4);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return t_password;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table sellertable (id integer primary key not null," +
                "name text not null,email text not null,phone text not null,password text not null);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists sellertable");
        onCreate(db);

    }


}
