package com.example.inven.aaproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD

public class showAminoImg extends AppCompatActivity {
=======
import android.widget.ImageView;

public class showAminoImg extends AppCompatActivity {
    private int aaIndex;
>>>>>>> 9620fddedad4245c28463dce75363e362b8d49cb
    public static final int[] aaArr = {
            R.drawable.alanine, R.drawable.arginine, R.drawable.asparagine,
            R.drawable.asparticacid, R.drawable.cystine, R.drawable.glutamicacid,
            R.drawable.glutamine, R.drawable.glycine, R.drawable.histidine,
            R.drawable.isoleucine,R.drawable.leucine, R.drawable.lysine,
            R.drawable.methionine, R.drawable.phenylalanine, R.drawable.proline,
            R.drawable.serine, R.drawable.threonine, R.drawable.tryptophan,
            R.drawable.tyrosine, R.drawable.valine
    };

<<<<<<< HEAD
    String currentAA = "";
=======
>>>>>>> 9620fddedad4245c28463dce75363e362b8d49cb
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_amino_img);
<<<<<<< HEAD
        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            currentAA = "";
        } else {
            currentAA = extras.getString("name");
        }
        SquareImageView iv = (SquareImageView) findViewById(R.id.imageView3);
        iv.setImageDrawable();

=======
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        Bundle extras = getIntent().getExtras();
        if(extras == null){ aaIndex=0; }
        else{aaIndex = extras.getInt("index");}
        System.out.println("INDEX: " + aaIndex);
        iv.setImageResource(aaArr[aaIndex]);
>>>>>>> 9620fddedad4245c28463dce75363e362b8d49cb
    }
}
