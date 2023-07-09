package com.example.project;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FirstView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstview);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button myButton = findViewById(R.id.my_button);
        myButton.setOnClickListener(e->{
            Intent intent = new Intent(FirstView.this,MainActivity3.class);
            startActivity(intent);
        });
        Button myButton1 = findViewById(R.id.my_button1);
        myButton1.setOnClickListener(e->{
            Intent intent = new Intent(FirstView.this,MainActivity4.class);
            startActivity(intent);
        });

    }

}
