package com.example.mymedicine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Button buttonjoin;
    Button buttonmedicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonjoin=(Button) findViewById(R.id.buttonjoin);
        buttonjoin.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,page2.class);
                    startActivity(intent);
                }
        });

        buttonmedicine=(Button) findViewById(R.id.buttonmedicine1);
        buttonmedicine.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,page4.class);
                startActivity(intent);
            }
        });
    }
}