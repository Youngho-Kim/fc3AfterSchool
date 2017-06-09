package kr.co.fastcampus.android.model;

/**
 * Created by DoDo on 2017-05-31.
 */

public class O  implements Cloneable{
    int color;
    public O(){
    }
    public static O getProtype(){
        O prototype = new O();
        prototype.color = SettingsHelper.getInstance().getColor(SettingsHelper.O);
        return prototype;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
