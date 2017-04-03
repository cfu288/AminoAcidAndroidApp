package com.example.inven.aaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
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
    public static final String[] aaStrArr = {"alanine","arginine","asparagine","asparticacid","cystine",
            "glutamicacid","glutamine","glycine","histidine","isoleucine","leucine",
            "lysine","methionine","phenylalanine","proline","serine","threonine",
            "tryptophan","tyrosine","valine"
    };
    public static int lastInt;
    public static String currentAA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        int randInt = getRand();
        lastInt = randInt;
        iv.setImageResource(aaArr[randInt]);
        currentAA = aaStrArr[randInt];
    }

    public int getRand(){
        int max = 19;
        int min = 0;
        Random rand = new Random();
        int randInt = rand.nextInt((max - min) +1)+ min;
        return randInt;
    }

    public void sendMessage(View view){
        // An Intent is an object that provides runtime binding between
        // separate components, such as two activities. The Intent represents
        // an app’s "intent to do something." You can use intents for a wide
        // variety of tasks, but in this lesson, your intent starts another activity.
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString().toLowerCase().replaceAll("\\s+","");
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        int randInt = getRand();
        while(randInt == lastInt){randInt = getRand();} // Make sure new int is diff
        if(message.equals(currentAA)){
            iv.setImageResource(aaArr[randInt]);
            currentAA = aaStrArr[randInt];
            editText.setText("");
        }else{
            editText.setText("");
        }
    }
}
