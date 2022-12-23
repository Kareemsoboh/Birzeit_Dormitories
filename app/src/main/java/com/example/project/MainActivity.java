package com.example.project;

import static com.example.project.FileHelper.user;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    ImageView imageView ;
    Animation top , bottom ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        extracted();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        },4000);
        try {
            read("data.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void extracted() {
        imageView = findViewById(R.id.imageView4);
        top = AnimationUtils.loadAnimation(this,R.anim.top);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom);
    }
    public void read(String file) throws FileNotFoundException {
        try {
            FileInputStream fos = openFileInput(file);
            int size = fos.available();
            byte []buffer = new byte[size];
            fos.read(buffer);
            fos.close();
            String txt = new String(buffer);
            Scanner scanner = new Scanner(txt);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String x [] = line.split(",");
                user.add(new users(x[0],x[1]));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("hhhhhh");
        }
    }
}