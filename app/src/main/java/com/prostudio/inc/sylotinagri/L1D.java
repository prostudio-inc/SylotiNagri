package com.prostudio.inc.sylotinagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class L1D extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_l1d);
        onPause();
        mediaPlayer = MediaPlayer.create(L1D.this,R.raw.l1d);
        ImageButton home = findViewById(R.id.home);
        ImageButton repeat = findViewById(R.id.repeat);
        ImageButton back = findViewById(R.id.back);
        ImageButton forward = findViewById(R.id.forward);

        mediaPlayer.start();
        home.setOnClickListener(this);
        repeat.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.home){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }

        if (v.getId() == R.id.repeat){
            mediaPlayer.start();
        }

        if (v.getId() == R.id.back){
            Intent intent = new Intent(this,L1C.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
        if (v.getId() == R.id.forward){
            Intent intent = new Intent(this,L1Q4.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            if (isFinishing()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
    }
}
