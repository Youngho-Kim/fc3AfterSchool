package kr.co.fastcampus.advancedandroid.database;

import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import kr.co.fastcampus.advancedandroid.R;
import kr.co.fastcampus.advancedandroid.thread.MainActivity;

public class DBActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
//        MySecondSQLiteHelper mySQLiteHelper = MySecondSQLiteHelper.getInstance(this);
//        db = mySQLiteHelper.getWritableDatabase();
//        Cursor cursor = db.query("sample_table",new String[]{"col1","col2"},null,null,null,null,null);
//        db.beginTransaction();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("col1",1);
//        contentValues.put("col2",2);
//        contentValues.put("col3",3);
//        contentValues.put("NUMERIC",4);
//        db.insert("sample_table",null,contentValues);
//        contentValues.clear();
//        contentValues.put("NUMERIC","10");
//        db.update("sample_table",contentValues,"col1 = 1",null);
//        db.setTransactionSuccessful();
//        db.endTransaction();
    }




    private void useCursorLoader(){
        android.app.LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(1, null, new android.app.LoaderManager.LoaderCallbacks<Cursor>() {
            //로더 생성 시점
            @Override
            public Loader<Cursor> onCreateLoader(int id, Bundle args) {
                Loader<Cursor> loader = null;
                switch (id){
                    case 1:
//                        loader =  new CursorLoader(MainActivity.this,)
                }
                return null;
            }

            //로드 완료 커서 돌리기
            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

            }
            //로드 재정의
            @Override
            public void onLoaderReset(Loader<Cursor> loader) {

            }
        });
    }
}
