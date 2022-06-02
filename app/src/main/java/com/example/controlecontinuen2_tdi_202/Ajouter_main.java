package com.example.controlecontinuen2_tdi_202;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Ajouter_main extends AppCompatActivity {

    EditText e1,e2,e3;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_main);

        db = new MyDatabase(this);

        e1 = findViewById(R.id.txt_raison);
        e2 = findViewById(R.id.txt_adresse);
        e3 = findViewById(R.id.txt_capital);
    }
    public void ajouterentreprise(View view) {

        if(e1.getText().toString().isEmpty()){
            Toast.makeText(this, "raison sociale vide", Toast.LENGTH_SHORT).show();
            e1.requestFocus();
            return;
        }
        if(e2.getText().toString().isEmpty()){
            Toast.makeText(this, "adresse vide", Toast.LENGTH_SHORT).show();
            e2.requestFocus();
            return;
        }
        if(e3.getText().toString().isEmpty()){
            Toast.makeText(this, "capitale vide", Toast.LENGTH_SHORT).show();
            e3.requestFocus();
            return;
        }

        entreprise e = new entreprise();

        e.setRaison_sociale(e1.getText().toString());
        e.setAdresse(e2.getText().toString());
        e.setCapitale(Double.parseDouble(e3.getText().toString()));


        if(MyDatabase.add_entreprise(db.getWritableDatabase(),e)==-1)
            Toast.makeText(this, "Insertion echoue", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insertion reussie", Toast.LENGTH_SHORT).show();


    }
    public void retourne(View view){
        this.finish();
    }
}