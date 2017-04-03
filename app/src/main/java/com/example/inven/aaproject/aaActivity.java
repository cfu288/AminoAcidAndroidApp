package com.example.inven.aaproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class aaActivity extends AppCompatActivity {
    //public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final int[] aaArr = {
            R.drawable.alanine, R.drawable.arginine, R.drawable.asparagine,
            R.drawable.asparticacid, R.drawable.cystine, R.drawable.glutamicacid,
            R.drawable.glutamine, R.drawable.glycine, R.drawable.histidine,
            R.drawable.isoleucine,R.drawable.leucine, R.drawable.lysine,
            R.drawable.methionine, R.drawable.phenylalanine, R.drawable.proline,
            R.drawable.serine, R.drawable.threonine, R.drawable.tryptophan,
            R.drawable.tyrosine, R.drawable.valine
    };
    public static final String[] aaStrArr = {"Alanine","Arginine","Asparagine","Aspartic Acid","Cystine",
            "Glutamic Acid","Glutamine","Glycine","Histidine","Isoleucine","Leucine",
            "Lysine","Methionine","Phenylalanine","Proline","Serine","Threonine",
            "Tryptophan","Tyrosine","Valine"
    };
    public static int lastInt;
    public static String currentAA;
    public static int numberQ;
    public static int currentQ;
    private ConstraintLayout screen;
    private Handler handler;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d( "Verbose" ,"App started!");
        SquareImageView iv = (SquareImageView) findViewById(R.id.imageView);
        int randInt = getRand();
        lastInt = randInt;
        iv.setImageResource(aaArr[randInt]);
        currentAA = aaStrArr[randInt];
        currentQ = 0;
        TextView tv = (TextView) findViewById(R.id.textViewCounter);
        Bundle extras = getIntent().getExtras();
        screen = (ConstraintLayout)findViewById(R.id.screen);
        screen.setBackgroundColor(Color.argb(255, 255, 255, 255));
        if(extras == null) {
            numberQ = 0;
        } else {
            numberQ = extras.getInt("number_questions");
        }
        tv.setText(currentQ + "/" + numberQ);
    }

    public int getRand(){
        int max = 19;
        int min = 0;
        Random rand = new Random();
        int randInt = rand.nextInt((max - min) +1)+ min;
        return randInt;
    }

    public void revealHint(View view){
        TextView tv = (TextView) findViewById(R.id.hintLabel);
        tv.setText(currentAA);
    }

    public void sendMessage(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        TextView tv = (TextView) findViewById(R.id.hintLabel);
        String message = editText.getText().toString().toLowerCase().replaceAll("\\s+","");
        SquareImageView iv = (SquareImageView) findViewById(R.id.imageView);
        int randInt = getRand();
        while(randInt == lastInt){randInt = getRand();} // Make sure new int is diff
        if(message.equals(currentAA.toLowerCase().replaceAll("\\s+",""))){
            iv.setImageResource(aaArr[randInt]);
            currentAA = aaStrArr[randInt];
            tv.setText("");
            editText.setText("");
            currentQ++;
            TextView tv1 = (TextView) findViewById(R.id.textViewCounter);
            tv1.setText(currentQ + "/" + numberQ);
            if (currentQ >= numberQ) finish();
        }else{
            editText.setText("");
            //https://stackoverflow.com/questions/5200811/in-android-how-do-i-smoothly-fade-the-background-from-one-color-to-another-ho
            screen = (ConstraintLayout)findViewById(R.id.screen);
            handler = new Handler();

            (new Thread(){
                @Override
                public void run(){
                    for(i=0; i<255; i++){
                        handler.post(new Runnable(){
                            public void run(){
                                screen.setBackgroundColor(Color.argb(255, 255, i, i));
                            }
                        });
                        // next will pause the thread for some time
                        try{ sleep(3); }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            }).start();
        }
    }
}
