package com.example.pixaflip;

import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;

import com.example.pixaflip.Data.MyDbHandler;

public class DisplayVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_video);
        //addCourseBtn=findViewById ( R.id.playVideo );
        VideoView videoView = findViewById(R.id.playVideo);
       // final Button playVideo=findViewById(R.id.playVideo);
      //  String s1=getLocalClassName ();

       // addCourseBtn = findViewById(R.id.playVideo);


        String videoPath="android.resource://" + getPackageName() + "/" +R.raw.video;
        Uri uri=Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.start();



        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {


            public void onCompletion(MediaPlayer mp) {
                Intent intent = new Intent (getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
