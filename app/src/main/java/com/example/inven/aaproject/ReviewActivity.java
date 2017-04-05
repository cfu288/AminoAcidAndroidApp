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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ListView lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, aaStrArr);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(mMessageClickedHandler);
        System.out.println("JEADF");
    }

    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            // Do something in response to the click
            int data = (int) position;
            System.out.println(position);
            showImage(position);
        }
    };

    public void showImage(int s){
        Intent intent = new Intent(this, showAminoImg.class);
        intent.putExtra("index",s);
        System.out.println("INDEX: " + s);
        startActivity(intent);
    }

    //listView.setOnItemClickListener(mMessageClickedHandler);

}
