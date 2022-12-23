package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    ImageView imageView ;
    Spinner spinner ;
    RecyclerView listView ;
    Button button ;
    Animation top , right ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        extracted();
        extracted1();


    }

    private void extracted1() {
        getHomes homes ;
            homes = new getHomes();
            List<String> c = homes.getGender();
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                    R.layout.spinner_list,c);




            spinner.setAdapter(arrayAdapter);

            getHomes finalHomes = homes;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String x = spinner.getSelectedItem().toString();
                    List<Home> c2 =  finalHomes.getHomes(x);
                    String[] str = new String[c2.size()];
                    int[] imageids= new int[c2.size()];
                    String[] nums = new String[c2.size()];
                    for (int i = 0; i < c2.size(); i++) {
                        str[i] = c2.get(i).toString();
                        if(i%3==0)
                        imageids[i]=R.drawable.image;
                        else if(i%3==1)
                            imageids[i]=R.drawable.image1;
                        else if (i%3==2)
                            imageids[i]=R.drawable.image2;
                        nums[i]=(c2.get(i).getOwnerNumber());
                    }
                    Context MainActivity = null;
                    listView.setLayoutManager(new LinearLayoutManager(MainActivity));
                    CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(str,imageids,nums);
                    listView.setAdapter(adapter);

                }
            });
    }

    private void extracted() {
        listView = (RecyclerView) findViewById(R.id.listView);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        top = AnimationUtils.loadAnimation(this,R.anim.top);
        right = AnimationUtils.loadAnimation(this,R.anim.right);
        imageView.setAnimation(top);
        listView.setAnimation(right);
        spinner.setAnimation(right);
        button.setAnimation(right);
    }


}