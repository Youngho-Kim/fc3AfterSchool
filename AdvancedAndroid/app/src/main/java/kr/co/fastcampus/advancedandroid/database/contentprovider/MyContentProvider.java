package kr.co.fastcampus.advancedandroid.database.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by DoDo on 2017-06-09.
 */

public class MyContentProvider extends ContentProvider {

    public MyContentProvider() {
    }

    //메인 스레드에서 진행됨, 데이터베이스를 처음 접근하기에 좋은 시점은 아니다.
    //경우에 따라 데이터베이스 업데이트를 해야할 경우 대참사가..

    @Override
    public boolean onCreate() {

    //true 성공적 초기화
    //false 초기화 실패
        return false;

    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public synchronized Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        //새로 생긴 로우의 uri반환
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
