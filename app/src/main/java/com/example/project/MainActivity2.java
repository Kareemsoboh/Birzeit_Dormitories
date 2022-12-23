package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    static TextView textView,textView1;
    static EditText name , password ;
    static ImageView imageView ;
    static Button login , signup ;
    static Animation top,bottom ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        extracted();

        for(int i = 0 ; i < FileHelper.user.size();i++)
        {
            System.out.println(FileHelper.user.get(i).toString());
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getLogin(new users(name.getText().toString(),password.getText().toString())))
                {
                    Intent intent = new Intent(MainActivity2.this,MainActivity4.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity2.this,"Your userName or password is wrong ",Toast.LENGTH_LONG).show();
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });

    }

    private void extracted() {
        imageView = findViewById(R.id.imageView5);
        textView = findViewById(R.id.textView2);
        textView1 = findViewById(R.id.textView3);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        top = AnimationUtils.loadAnimation(this,R.anim.top);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom);

        imageView.setAnimation(top);
        textView.setAnimation(top);
        name.setAnimation(top);
        textView1.setAnimation(bottom);
        password.setAnimation(bottom);
        login.setAnimation(bottom);
        signup.setAnimation(bottom);
    }

    public static boolean getLogin(users c)
    {
        for(int i = 0 ; i < FileHelper.user.size();i++)
        {
            if(c.getName().equals(FileHelper.user.get(i).getName()) && c.getPassword().equals(FileHelper.user.get(i).getPassword()))
            {
                return true ;
            }
        }

        return false ;
    }

}