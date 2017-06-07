package kr.co.fastcampus.advancedandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by DoDo on 2017-06-07.
 */

public class CanvasView extends View {
    private ArrayList<Pair<Path,Paint>> pathList = new ArrayList<>();

    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }





    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(Pair<Path,Paint> pair : pathList){
            canvas.drawPath(pair.first,pair.second);
        }

    }

    MainActivity getPaintMemo(){
        return (MainActivity) getContext();
    }

    Paint getCurrentPaint(){
        return getPaintMemo().getCurrentPaint();
    }


    Pair<Path,Paint> pair = null;
    Path path = null;
    Paint paint = null;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                Log.e("CanvasView","OnTouch DOWN");
                path.moveTo(event.getX(),event.getY());
                paint = new Paint();
                paint.setColor(getCurrentPaint().getColor());
                paint.setStrokeWidth(getCurrentPaint().getStrokeWidth());
                paint.setStyle(Paint.Style.STROKE);
                pair = new Pair<>(path,paint);
                pathList.add(pair);
                return true;
            case MotionEvent.ACTION_MOVE:
                if(pair != null) {
                    path.lineTo(event.getX(), event.getY());
                    Log.e("CanvasView","OnTouch Move");
                    invalidate();
                }
                return true;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;

        }
        invalidate();
        return super.onTouchEvent(event);
    }
}
