package com.example.inven.aaproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReviewActivity extends AppCompatActivity {

    public static final String[] aaStrArr = {"Alanine","Arginine","Asparagine","Aspartic Acid","Cystine",
            "Glutamic Acid","Glutamine","Glycine","Histidine","Isoleucine","Leucine",
            "Lysine","Methionine","Phenylalanine","Proline","Serine","Threonine",
            "Tryptophan","Tyrosine","Valine"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ListView lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, aaStrArr);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(mMessageClickedHandler);
<<<<<<< HEAD
=======
        System.out.println("JEADF");
>>>>>>> 9620fddedad4245c28463dce75363e362b8d49cb
    }

    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            // Do something in response to the click
<<<<<<< HEAD
            String data = (String) parent.getItemAtPosition(position);
=======
            int data = (int) position;
            System.out.println(position);
            showImage(position);
>>>>>>> 9620fddedad4245c28463dce75363e362b8d49cb
        }
    };

    public void showImage(int s){
        Intent intent = new Intent(this, showAminoImg.class);
        intent.putExtra("index",s);
        System.out.println("INDEX: " + s);
        startActivity(intent);
    }

    //listView.setOnItemClickListener(mMessageClickedHandler);

    public void showImage(String s){
        // An Intent is an object that provides runtime binding between
        // separate components, such as two activities. The Intent represents
        // an app’s "intent to do something." You can use intents for a wide
        // variety of tasks, but in this lesson, your intent starts another activity.
        Intent intent = new Intent(this, showAminoImg.class);
        intent.putExtra("name",s);
        startActivity(intent);
    }

}
