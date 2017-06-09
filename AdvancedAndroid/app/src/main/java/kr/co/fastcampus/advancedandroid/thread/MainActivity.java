package kr.co.fastcampus.advancedandroid.thread;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import kr.co.fastcampus.advancedandroid.R;
import kr.co.fastcampus.advancedandroid.database.DBActivity;

public class MainActivity extends AppCompatActivity {
    private Paint currentPaint= new Paint();
    private RadioGroup palette;
    private SeekBar brush;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain_memo);
        startActivity(new Intent(this, DBActivity.class));
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
        currentPaint.setStrokeWidth(brush.getProgress());
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
    }


    @Override
    protected void onResume() {
        super.onResume();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "뿅", Toast.LENGTH_SHORT).show();
            }
        }, 5000);
    }

    public Paint getCurrentPaint() {
        return currentPaint;
    }

    public void setCurrentPaint(Paint currentPaint) {
        this.currentPaint = currentPaint;
    }


    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

}
