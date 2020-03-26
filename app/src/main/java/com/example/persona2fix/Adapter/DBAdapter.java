package com.example.persona2fix.Adapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
    static final String KEY_ROWID = "_id";
    static final String KEY_UANG = "uang";
    static final String KEY_DATE = "date";
    static final String KEY_JENIS = "jenis";
    static final String KEY_TUJUAN = "tujuan";
    static final String TAG = "DBAdapter";
    static final String DATABASE_NAME = "MyDB";
    static final String DATABASE_TABLE = "keuangan";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_CREATE =
            "create table keuangan (_id integer primary key autoincrement, "
                    + "uang text not null, date text not null, jenis text not null, tujuan text not null);";
    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;
    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS keuangan");
            onCreate(db);
        }
    }
    //---opens the database---
    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }
    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }

    public long insertKeuangan(String uang, String date, String jenis, String tujuan)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_UANG, uang);
        initialValues.put(KEY_DATE, date);
        initialValues.put(KEY_JENIS, jenis);
        initialValues.put(KEY_TUJUAN, tujuan);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    public boolean deleteKeuangan(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    public Cursor getAllKeuangan()
    {
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_UANG,
                KEY_DATE,KEY_JENIS, KEY_TUJUAN}, null, null, null, null, null);
    }
    public Cursor getKeuangan(long rowId) throws SQLException
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID, KEY_UANG,
                                KEY_DATE,KEY_JENIS, KEY_TUJUAN},
                        KEY_ROWID + "=" + rowId, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public boolean updateKeuangan(long rowId, String uang, String date, String jenis, String tujuan)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_UANG, uang);
        args.put(KEY_DATE, date);
        args.put(KEY_JENIS, jenis);
        args.put(KEY_TUJUAN, tujuan);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) >
                0;
    }
}
