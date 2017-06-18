package com.example.dell.attendancemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by DELL on 6/12/2017.
 */

public class AttDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="attendance_manager.db";

    private static final int DATABASE_VERSION=1;

    public final static String SUBJECT_CODE="subject_code";

    public final static String SUBJECT_NAME="subject_name";

    public final static String CLASSES_PRESENT="classes_present";

    public final static String CLASSES_BUNKED="classes_bunked";

    public final static String _ID="ID";

    public final static String TABLE_NAME = "attendance";

    public AttDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_TABLE="create table " + TABLE_NAME +"("+
                _ID + " integer primary key auto increment, " +
                SUBJECT_NAME + " text not null, " +
                SUBJECT_CODE + " text not null, " +
                CLASSES_PRESENT + " integer not null, " +
                CLASSES_BUNKED + " integer not null);";

        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String subjectName,String subjectCode)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(SUBJECT_NAME,subjectName);
        contentValues.put(SUBJECT_CODE,subjectCode);

        long result=db.insert(TABLE_NAME,null,contentValues);

        if(result==-1)

            return false;

        else
            return true;
    }

    public boolean insertDummy()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(SUBJECT_NAME,"MATHS");
        contentValues.put(SUBJECT_CODE,"MA-105");

        long result= db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return
            true;
    }
}
