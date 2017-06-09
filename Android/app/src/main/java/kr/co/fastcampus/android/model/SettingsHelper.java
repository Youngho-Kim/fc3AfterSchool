package kr.co.fastcampus.android.model;

import android.graphics.Color;

/**
 * Created by DoDo on 2017-05-31.
 */

public class SettingsHelper {

    public static final int O = 0;
    public static final int L = 1;
    public static final int I = 2;
    public static final int Z = 4;
    public static final int T = 5;

    private static SettingsHelper instance = new SettingsHelper();
    private SettingsHelper(){}
    public static SettingsHelper getInstance(){
        return instance;
    }

    public int getColor(int block){
        switch (block){
            case L:
                return Color.RED;
            case O:
                for(int i = 0; i < 10000; i++){
                }
                return Color.BLUE;
        }
        return 0;
    }
}
