package com.example.miniresearchprojectgooglepayapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button redBtn;
    Button blueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redBtn = findViewById(R.id.red_button);
        blueBtn = findViewById(R.id.blue_button);

        Intent intent = new Intent(this, CheckoutActivity.class);
        startActivity(intent);

    }
}