package com.example.muhammadahsan.pakistan;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    String videopath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videov = (VideoView) findViewById(R.id.videoView_header);
        MediaController mediaC = new MediaController(this);

        String videopath = "android.resource://com.example.muhammadahsan.pakistan/"+R.raw.pegham_pakistan;
        Uri uri = Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);
        videov.start();
    }
    public void rating(View view){
        Toast.makeText(this, "Thanks for rating us", Toast.LENGTH_SHORT).show();
    }
    public void play(String x){
        if (x.equals("quaid")){
            videopath = "android.resource://com.example.muhammadahsan.pakistan/"+R.raw.quaid;
        }
        playVideo();
    }
    public  void playVideo(View view){

        //TextView view1 = (TextView)findViewById(R.id.view);
        VideoView videov = (VideoView) findViewById(R.id.videoView_header);
        MediaController mediaC = new MediaController(this);

        //videopath = "android.resource://com.example.muhammadahsan.pakistan/"+R.raw.quaid;
        Uri uri = Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);
        videov.start();
    }
}

