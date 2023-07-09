package com.example.project;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class OwnerSignup extends AppCompatActivity {

    TextView textView , textView1,textView2 ,textView3,phone;
    EditText name , email , password , password1 ,phoneNumber;
    Button signup , back ;
    ImageView imageView ;
    Animation top , bottom , right , left ;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static ArrayList<Owner> owners = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ownerregistration);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        extracted();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(password.getText().toString().equals(password1.getText().toString()))
                {
                    if(!getLogin(new Owner(name.getText().toString(),password.getText().toString(),email.getText().toString(),phoneNumber.getText().toString())))
                    {
                        Intent intent = new Intent(OwnerSignup.this,MainActivity2.class);
                        startActivity(intent);

                        db.collection("Owners").add(new Owner(name.getText().toString(),password.getText().toString(),email.getText().toString(),phoneNumber.getText().toString()));


                    }
                    else
                    {
                        Toast.makeText(OwnerSignup.this,"Your userName already used ",Toast.LENGTH_LONG).show();

                    }
                }
                else
                {
                    Toast.makeText(OwnerSignup.this,"Password does not match",Toast.LENGTH_LONG).show();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(OwnerSignup.this,MainActivity2.class);
                startActivity(intent);
            }});
    }
    public static boolean getLogin(Owner c)
    {
        for(int i = 0 ; i < owners.size();i++)
        {
            if(c.getName().equals(owners.get(i).getName())||c.getMail().equals(owners.get(i).getMail()))
            {
                return true ;
            }
        }

        return false ;
    }

    private void extracted() {
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        phone = findViewById(R.id.textView4);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        password1 = findViewById(R.id.password1);
        phoneNumber = findViewById(R.id.phone);

        signup = findViewById(R.id.signup);
        back = findViewById(R.id.back);

        top = AnimationUtils.loadAnimation(this,R.anim.top);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom);
        right = AnimationUtils.loadAnimation(this,R.anim.right);
        left = AnimationUtils.loadAnimation(this,R.anim.left);

        imageView = findViewById(R.id.imageView3);

        extracted1();
        back.setAnimation(bottom);

    }

    private void extracted1() {
        imageView.setAnimation(top);

        textView.setAnimation(left);
        textView1.setAnimation(left);
        textView2.setAnimation(left);
        textView3.setAnimation(left);
        phone.setAnimation(left);
        phoneNumber.setAnimation(right);
        name.setAnimation(right);
        email.setAnimation(right);
        password.setAnimation(right);
        password1.setAnimation(right);
        signup.setAnimation(bottom);
    }


}