package com.example.ykai.app_nul;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer mediaPlayer = new MediaPlayer();
//                设置到播放的资源位置 path 可以是网络路径,也可以是本地路径

                // 本地资源,需要有文件读写权限
                String strMp3 =  Environment.getExternalStorageDirectory() +  "/dusk.mp3";
                // 网络资源,需要有网络权限
//                String strMp3 = "https://yangyankai.github.io/assets/images/dusk.mp3";
                try {
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource(strMp3);
                    //3 准备播放
                    mediaPlayer.prepareAsync();
                    //3.1 设置一个准备完成的监听
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            // 4 开始播放
                            mediaPlayer.start();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
