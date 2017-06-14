package kr.co.fastcampus.advancedandroid;

import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;

/**
 * Created by DoDo on 2017-06-09.
 */

public class AdvancedAndroid extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this);
        }
    }
}
