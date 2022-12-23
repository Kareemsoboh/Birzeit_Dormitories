package com.example.project;

import static android.content.Context.MODE_PRIVATE;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class FileHelper {
    final static String fileName = "data.txt";
    final static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/instinctcoder/readwrite/" ;
    final static String TAG = FileHelper.class.getName();
    public static ArrayList<users> user = new ArrayList<>();

    public static  String ReadFile( Context context){
        String line = null;

        try {
           // FileInputStream fileInputStream = new FileInputStream (getAssets().open(data.txt));
            InputStreamReader inputStreamReader = new InputStreamReader(context.getAssets().open("data.txt"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            while ( (line = bufferedReader.readLine()) != null )
            {
                String x [] = line.split(",");
                user.add(new users(x[0],x[1]));
                //stringBuilder.append(line + System.getProperty("line.separator"));
            }
            //fileInputStream.close();
            line = stringBuilder.toString();

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        }
        catch(IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        return line;
    }



}
