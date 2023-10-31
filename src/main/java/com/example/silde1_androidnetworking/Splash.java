package com.example.silde1_androidnetworking;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Splash extends Activity {


    String urlImage = "https://tse4.mm.bing.net/th?id=OIP.KQPNTPaR3MsLxbCuSDGevwHaDn&pid=Api&P=0&h=180";
    Bitmap bmt;
    ProgressDialog dialog;
    ImageView imageload;
    TextView tv_thongbao;
    Button btn_load,btn_bai2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);
        imageload = findViewById(R.id.image_logo_slash);
        tv_thongbao = findViewById(R.id.tv_message);
        btn_load = findViewById(R.id.btn_load);
        btn_bai2 = findViewById(R.id.btn_bai2);
        btn_bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = ProgressDialog.show(Splash.this,"" , "Downloading...");
//                Runnable runnable = new Runnable() {
//                    @Override
//                    public void run() {
//                        bmt = downloadBitmap(urlImage);
//                        Message mess = hanlder.obtainMessage();
//                        Bundle bundle = new Bundle();
//                        String threadMes = "image loaded";
//                        bundle.putString("message",threadMes);
//                        mess.setData(bundle);
//                        hanlder.sendMessage(mess);
//                    }
//                };
//                Thread thread = new Thread(runnable);
//                thread.start();

                Thread myThead  = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final Bitmap bmt = loadImageFromNetwork("https://tse4.mm.bing.net/th?id=OIP.KQPNTPaR3MsLxbCuSDGevwHaDn&pid=Api&P=0&h=180");
                        imageload.post(new Runnable() {
                            @Override
                            public void run() {
                                imageload.setImageBitmap(bmt);
                                dialog.dismiss();
                            }
                        });
                    }
                });
                myThead.start();

            }
        });

    }
//
//    private Handler hanlder = new Handler(){
//        public void handerMes(Message message){
//            super.handleMessage(message);
//            Bundle bundle = message.getData();
//            String messager = bundle.getString("message");
//            tv_thongbao.setText(messager);
//            imageload.setImageBitmap(bmt);
//            dialog.dismiss();
//        }
//    };


//    private Bitmap downloadBitmap(String link){
//        try {
//            URL url = new URL(link);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.connect();
//            InputStream inputStream = httpURLConnection.getInputStream();
//            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//            return bitmap;
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    };

    private Bitmap loadImageFromNetwork(String link){
        URL url;
//        Bitmap bmt =null;

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
}
