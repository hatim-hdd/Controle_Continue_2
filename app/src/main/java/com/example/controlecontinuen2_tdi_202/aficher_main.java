package com.example.controlecontinuen2_tdi_202;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class aficher_main extends AppCompatActivity {
    ListView lst;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aficher_main);
        db = new MyDatabase(this);
        lst = findViewById(R.id.lst);

        ArrayList<entreprise> entps = MyDatabase.getAllEntreprise(db.getReadableDatabase());

        ArrayList<String> nomentreprise = new ArrayList<>();
        for(entreprise ee: entps)
            nomentreprise.add(ee.getId() + " - " + ee.getRaison_sociale());

        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,nomentreprise);

        lst.setAdapter(ad);
    }
}