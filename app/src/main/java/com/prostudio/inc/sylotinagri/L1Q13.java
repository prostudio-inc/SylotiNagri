package com.prostudio.inc.sylotinagri;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class L1Q13 extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer;
    ImageView q1,q2,q3,q4,q5,q6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_l1_q13);

        onPause();
        showDialog();

        mediaPlayer = MediaPlayer.create(L1Q13.this, R.raw.l1c);

        ImageButton home = findViewById(R.id.home);
        ImageButton repeat = findViewById(R.id.repeat);
        ImageButton back = findViewById(R.id.back);

        q6 = findViewById(R.id.q6);
        q5 = findViewById(R.id.q5);
        q4 = findViewById(R.id.q4);
        q3 = findViewById(R.id.q3);
        q2 = findViewById(R.id.q2);
        q1 = findViewById(R.id.q1);

        q6.setOnClickListener(this);
        q5.setOnClickListener(this);
        q4.setOnClickListener(this);
        q3.setOnClickListener(this);
        q2.setOnClickListener(this);
        q1.setOnClickListener(this);

        home.setOnClickListener(this);
        repeat.setOnClickListener(this);
        back.setOnClickListener(this);






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


    public void showDialog() {
        final Dialog dialog = new Dialog(L1Q13.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_design_q);
        dialog.setCancelable(false);
        Button startButton = dialog.findViewById(R.id.buttonok);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                mediaPlayer.start();
            }
        });
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.q6){
            Intent intent = new Intent(this,L1Q13W.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left_zero, R.anim.slide_out_right_zero);
        }if (v.getId() == R.id.q5){
            Intent intent = new Intent(this,L1Q13W.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left_zero, R.anim.slide_out_right_zero);
        }if (v.getId() == R.id.q4){
            Intent intent = new Intent(this,L1Q13W.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left_zero, R.anim.slide_out_right_zero);
        }if (v.getId() == R.id.q3){
            Intent intent = new Intent(this,L1Q13R.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left_zero, R.anim.slide_out_right_zero);
        }if (v.getId() == R.id.q2){
            Intent intent = new Intent(this,L1Q13W.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left_zero, R.anim.slide_out_right_zero);
        }if (v.getId() == R.id.q1){
            Intent intent = new Intent(this,L1Q13W.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left_zero, R.anim.slide_out_right_zero);
        }




        if (v.getId() == R.id.home){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }if (v.getId() == R.id.repeat){
            mediaPlayer.start();
        }if (v.getId() == R.id.back){
            Intent intent = new Intent(this,L1F.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }
}