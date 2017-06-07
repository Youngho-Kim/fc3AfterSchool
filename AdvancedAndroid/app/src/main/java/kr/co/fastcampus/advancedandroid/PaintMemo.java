package kr.co.fastcampus.advancedandroid;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.IdRes;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import java.util.ArrayList;

public class PaintMemo extends AppCompatActivity {
    private Paint currentPaint= new Paint();
    private RadioGroup palette;
    private SeekBar brush;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain_memo);
        palette = (RadioGroup) findViewById(R.id.palette);
        palette.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.red:
                        currentPaint.setColor(Color.RED);
                        break;
                    case R.id.blue:
                        currentPaint.setColor(Color.BLUE);
                        break;
                    case R.id.yellow:
                        currentPaint.setColor(Color.YELLOW);
                        break;
                    case R.id.green:
                        currentPaint.setColor(Color.GREEN);
                        break;
                }
            }
        });
        palette.check(R.id.red);
        brush = (SeekBar) findViewById(R.id.brush);
        brush.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)
                    currentPaint.setStrokeWidth(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        currentPaint.setStrokeWidth(brush.getProgress());
    }

    public Paint getCurrentPaint() {
        return currentPaint;
    }

    public void setCurrentPaint(Paint currentPaint) {
        this.currentPaint = currentPaint;
    }

}
