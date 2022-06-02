package com.example.controlecontinuen2_tdi_202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void acces(View view) {
        Intent i = null;
        switch (view.getId()){
            case R.id.btn_Ajout: i=new Intent(MainActivity.this, Ajouter_main.class); break;
            case R.id.btn_editer: i=new Intent(MainActivity.this, editer_main.class); break;
            case R.id.btn_lister: i=new Intent(MainActivity.this, aficher_main.class); break;
        }
        startActivity(i);

    }
}