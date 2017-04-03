package com.example.inven.aaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startQuiz();
            }
        };

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(Listener);
    }

    public void startQuiz(){
        // An Intent is an object that provides runtime binding between
        // separate components, such as two activities. The Intent represents
        // an app’s "intent to do something." You can use intents for a wide
        // variety of tasks, but in this lesson, your intent starts another activity.
        Intent intent = new Intent(this, aaActivity.class);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}
