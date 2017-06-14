package kr.co.fastcampus.advancedandroid.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.coreutils.BuildConfig;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by DoDo on 2017-06-08.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    Context context;
    public final int SCHEMA_VERSION;
    public final String DB_NAME = "database.db";

    private final boolean UPGRADE_USING_DDL;

    private final String TAG = MySQLiteHelper.class.getSimpleName();


    private static MySQLiteHelper instance = null;

    public static MySQLiteHelper getInstance(){
        if(instance == null) {
//            instance = new MySQLiteHelper();
        }
        return instance;
    }


    //SQLiteOpenHelper는 생성자, onCreate onUpgrade에 대한 구현 의무를 가지고 있다.
    private MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        this(context, name, factory, version,null);
    }

    private MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        this(context, name, factory, version, errorHandler,false);
    }
    private MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler,boolean useDDL) {
        super(context, name, factory, version, errorHandler);
        UPGRADE_USING_DDL = useDDL;
        SCHEMA_VERSION = version;
    }

    //데이터베이스 연결 설정 정의
    // onCreate 또는 onUpdate호출 이전에 호출됨
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);

        setWriteAheadLoggingEnabled(true);
        db.setForeignKeyConstraintsEnabled(true);
    }
    //초기 데이터베이스 생성시 호출됨
    @Override
    public void onCreate(SQLiteDatabase db) {
//        for(int v = 1; v <= SCHEMA_VERSION; v++){
//            applySqlFile(db,v);
//        }
        Log.e(TAG,"exec query");
        db.execSQL("CREATE TABLE sample_table (col1 INTEGER, col2 TEXT, col3 NUMERIC);");
        db.execSQL("INSERT INTO sample_table (col1,col2,col3) VALUES (1,\"안녕하세요\",1);");
    }
    //현재의 버전과 기존 데이터베이스 버전에 차이가 있을 경우 호출됨
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(!UPGRADE_USING_DDL){
            //DDL로
            for(int v = (oldVersion +1); v<= newVersion; v++){
                applySqlFile(db,v);
            }
        }else{
            applySqlFile(db,newVersion);
            //테이블을 복사하고 기존의 테이블을 없앤다.
        }
    }
    //현재 버전이 새 버전보다 높을 경우
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);

    }
    // 캐싱되어있는 데이터베이스 클래스를 반환하거나, 새롭게 만들어 반환한다.
    //writable과 readable은 같은 데이터베이스를 반환하지만 모드가 다르다
    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    //sql파일을 실행함
    private void applySqlFile(SQLiteDatabase db, int version){
        BufferedReader reader = null;
        try{
            String fileName = String.format(Locale.getDefault(),"%s.%d.sql",DB_NAME,version);
            final InputStream inputStream = context.getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));

            final StringBuilder statement = new StringBuilder();
            for(String line; (line = reader.readLine()) != null;){
                if(BuildConfig.DEBUG){
                    Log.d(TAG, "READING LINE: " + line);
                }

                if(!TextUtils.isEmpty(line) && !line.startsWith("--")){
                    statement.append(line.trim());
                }

                if(line.endsWith(";")){
                    if(BuildConfig.DEBUG){
                        Log.d(TAG,"Running statement: " + statement);
                    }
                    db.execSQL(statement.toString());
                    statement.setLength(0);
                }
            }
        }catch (IOException ioe){
            Log.e(TAG,"Could not apply SQL file",ioe);
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e(TAG,"Could not close reader",e);
                }
            }
        }
    }
}
