package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity5 extends AppCompatActivity {

    ImageView imageView ;
    RadioGroup radioGroup ;
    RadioButton radioButton ;
    Button button ;
    Animation top , right ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        extracted();


    }

    private void extracted() {
        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radio);
        button = findViewById(R.id.select);
        top = AnimationUtils.loadAnimation(this,R.anim.top);
        right = AnimationUtils.loadAnimation(this,R.anim.right);
        imageView.setAnimation(top);
        radioGroup.setAnimation(right);
        button.setAnimation(right);
    }
}