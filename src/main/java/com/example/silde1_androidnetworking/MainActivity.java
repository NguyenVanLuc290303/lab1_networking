package com.example.silde1_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btn_loadImage,btn_changebai3;
    ImageView image_loader;
    TextView tv_notification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_loadImage =  findViewById(R.id.btn_loadImage);
        image_loader = findViewById(R.id.imageLoader);
        tv_notification = findViewById(R.id.tv_notification);
        btn_changebai3 = findViewById(R.id.btn_Change);
        btn_loadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Thread myThead  = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final Bitmap bmt = loadImageFromNetwork("https://tse4.mm.bing.net/th?id=OIP.KQPNTPaR3MsLxbCuSDGevwHaDn&pid=Api&P=0&h=180");
                        image_loader.post(new Runnable() {
                            @Override
                            public void run() {
                                tv_notification.setText("image loaded");
                                image_loader.setImageBitmap(bmt);
                            }
                        });
                    }
                });
                myThead.start();
            }
        });
        btn_changebai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,bai3.class);
                startActivity(intent);
            }
        });
    }

    private Bitmap loadImageFromNetwork(String link){
        URL url;
        Bitmap bmt =null;

            try {
                url = new URL(link);
                bmt = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        return bmt;
    };

//    AsyncTask<Void, Integer ,String> asyncTask = new AsyncTask<Void, Integer, String>() {
//        @Override
//        protected String doInBackground(Void... voids) {
//            for (int i = 1 ; i < 1000000 ; i ++){
//                if( i % 100000 == 0 ){
//                    publishProgress((i / 100000 )* 10);
//                }
//            }
//            return "da dem xong";
//        }
//
//    };
}