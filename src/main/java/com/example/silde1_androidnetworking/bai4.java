package com.example.silde1_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class bai4 extends AppCompatActivity {
    Button btn_run;
    EditText ed_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        btn_run = findViewById(R.id.btn_run);
        ed_time = findViewById(R.id.ed_time);
        btn_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsynsTaskRunner asynsTaskRunner = new AsynsTaskRunner(bai4.this,ed_time);
                String edit_time = ed_time.getText().toString();
                asynsTaskRunner.execute(edit_time);
            }
        });
    }
}