package com.example.inven.aaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public static int numQ = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.number_q, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        numQ = Integer.valueOf(spinner.getSelectedItem().toString());
        Intent intent = new Intent(this, aaActivity.class);
        intent.putExtra("number_questions",numQ);
        startActivity(intent);
    }


}
