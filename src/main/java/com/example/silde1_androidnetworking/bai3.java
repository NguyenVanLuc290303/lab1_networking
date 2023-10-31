package com.example.silde1_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bai3 extends AppCompatActivity {
    Button btn_bai4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        btn_bai4 = findViewById(R.id.btn_bai4);
        btn_bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bai3.this,bai4.class);
                startActivity(intent);
            }
        });
    }

    public interface Listener{
        void loadImage(Bitmap bitmap);
        void onError();
    }
}