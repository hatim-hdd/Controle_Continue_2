package com.example.controlecontinuen2_tdi_202;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class editer_main extends AppCompatActivity {
    Spinner sp;
    MyDatabase db;
    ArrayList<entreprise>lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer_main);

        db = new MyDatabase(this);
        sp=findViewById(R.id.sp_entreprise);

        lst = MyDatabase.getAllEntreprise(db.getReadableDatabase());

        ArrayList<String> nomsEnreprs = new ArrayList<>();
        for(entreprise pp: lst)
            nomsEnreprs.add(pp.getId()+"-"  );

        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,nomsEnreprs);
        sp.setAdapter(ad);

    }
}