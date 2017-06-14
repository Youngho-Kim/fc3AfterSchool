package kr.co.fastcampus.advancedandroid.database;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.RequiresApi;
import android.support.compat.BuildConfig;
import android.text.TextUtils;
import android.util.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by DoDo on 2017-06-09.
 */

public class MySecondSQLiteHelper extends SQLiteOpenHelper {
    private Context context;
    private final String DB_NAME;
    private final int DB_VERSION;
    private SQLiteDatabase db;

    private static MySecondSQLiteHelper instance;

    public static MySecondSQLiteHelper getInstance(Context context){
        if(instance == null){
            instance = new MySecondSQLiteHelper(context.getApplicationContext(), "database.db", null,3);
        }

        return instance;
    }

    private MySecondSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        this(context, name, factory, version, null);
    }
    private MySecondSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        DB_NAME = name;
        DB_VERSION = version;
        this.context = context;
    }
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        setWriteAheadLoggingEnabled(true);
        db.setForeignKeyConstraintsEnabled(true);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        for(int v = 1; v <= DB_VERSION; v++){
            applySqlFile(db,v);
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for(int i = (oldVersion+1); i<= newVersion;i++){
            applySqlFile(db,i);
        }
    }

    public void insert(String tableName, ContentValues contentValues){
        if(db == null)
            db = getWritableDatabase();
        db.insert(tableName,null,contentValues);
    }

    private void applySqlFile(SQLiteDatabase db, int version){
        BufferedReader reader = null;
        try {
            String fileName = String.format(Locale.getDefault(),"%s.%d.sql",DB_NAME,version);
            InputStream inputStream = context.getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null){
                if(!TextUtils.isEmpty(line)&&!line.startsWith("--")){
                    stringBuilder.append(line.trim());
                }
                if(line.endsWith(";")){
                    db.execSQL(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
