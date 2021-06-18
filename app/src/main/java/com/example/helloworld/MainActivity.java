package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void addExclam(View view) {
        TextView text = (TextView) findViewById(R.id.tview);

        text.setText(text.getText() + "!");
    }

    public void removeExclam(View view) {
        TextView text = (TextView) findViewById(R.id.tview);

        String helloText = "Hello Teal and Black World";

        if (text.getText().length() > helloText.length())
        {
            text.setText(text.getText().subSequence(0, text.length() - 1));
        }

        writeToFile(text.getText().toString(), this.getApplicationContext());
    }


    //Writes to a file in the downloads directory
    private void writeToFile(String data,Context context)
    {
        try {
            File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            File outputfile = new File(file, "output.txt");
            FileWriter writer = new FileWriter(outputfile);
            writer.append(data);
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}