package com.gaurav.examsportal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gaurav on 07-Jul-16.
 */
public class LoginDBHelper {
    public static final String UserName = "UserName";
    public static final String Password = "Password";
    private static final String databasename = "UserDB";
    private static final String tablename = "User";
    private static final int databaseversion = 1;
    private static final String create_table = "create table User (UserId integer primary key autoincrement, " +
            "UserName text not null, Password integer not null);";
    private final Context ct;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public LoginDBHelper(Context context) {
        this.ct = context;
        dbHelper = new DatabaseHelper(ct);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context c) {
            super(c, databasename, null, databaseversion);
        }

        @Override
        public void onCreate(SQLiteDatabase database) {
            try {
                database.execSQL(create_table);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase database, int arg1, int arg2) {
            database.execSQL("DROP TABLE IF EXISTS User");
            onCreate(database);
        }
    }

    public LoginDBHelper connect() throws SQLException {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void disconnect() {
        dbHelper.close();
    }

    public long insertUser(String username, String password) {
        ContentValues cv = new ContentValues();
        cv.put(UserName, username);
        cv.put(Password, password);
        this.connect();
        return database.insert(tablename, null, cv);
    }

    public Cursor retrieveAllUser() {
        this.connect();
        return database.query(tablename, new String[]{UserName, Password}, null, null, null, null, null);
    }

    public Cursor retrieveUser(String iddd) throws SQLException {
        this.connect();

        Cursor c = database.query(true, tablename, new String[]{UserName, Password},
                UserName + "='" + iddd + "'",

                null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public boolean deleteUser(String st) {
        this.connect();
        return database.delete(tablename, UserName + "='" + st + "'", null) > 0;
    }


}