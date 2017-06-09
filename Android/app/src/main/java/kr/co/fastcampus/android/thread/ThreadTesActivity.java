package kr.co.fastcampus.android.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.fastcampus.android.R;

public class ThreadTesActivity extends AppCompatActivity {
    float progress = 0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_tes);
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progress += 0.5f;
            }
        };
        thread.start();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        while(true){
            if(progress >= 100f){
                return;
            }
            Log.e("ThreadTestAcitivty", progress+"");
            Toast.makeText(this, progress+"", Toast.LENGTH_SHORT).show();
        }
    }
}
