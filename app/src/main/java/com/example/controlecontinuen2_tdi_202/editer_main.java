package com.example.controlecontinuen2_tdi_202;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class editer_main extends AppCompatActivity {
    Spinner sp;
    MyDatabase db;
    ArrayList<entreprise>lst;
    EditText e1,e2,e3;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer_main);

        db = new MyDatabase(this);
        sp=findViewById(R.id.sp_entreprise);
        e1 = findViewById(R.id.txt_raison);
        e2 = findViewById(R.id.txt_adresse);
        e3 = findViewById(R.id.txt_capital);
        lst = MyDatabase.getAllEntreprise(db.getReadableDatabase());

        ArrayList<Integer> nomsEnreprs = new ArrayList<>();
        for(entreprise ee: lst)
            nomsEnreprs.add(ee.getId()  );

        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,nomsEnreprs);
        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                entreprise e = lst.get(i);
                e1.setText(e.getRaison_sociale());
                e2.setText(e.getAdresse());
                e3.setText(String.format("%f",e.getCapitale()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void modifier(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(editer_main.this);
        alert.setTitle("Modifier entreprise");
        alert.setMessage("Voulez-vous modifier ce entreprise ?");
        alert.setIcon(R.drawable.updatee);

        alert.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                entreprise e = lst.get(sp.getSelectedItemPosition());

                e.setRaison_sociale(e1.getText().toString());
                e.setAdresse(e2.getText().toString());
                e.setCapitale(Double.valueOf(e3.getText().toString()));


                if(MyDatabase.update_entreprise(db.getWritableDatabase(),e)==-1)
                    Toast.makeText(editer_main.this, "Modification echoue", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(editer_main.this, "Modification reussie", Toast.LENGTH_SHORT).show();

            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(editer_main.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }

    public void supprimer(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(editer_main.this);
        alert.setTitle("Suppression entreprise");
        alert.setMessage("Voulez-vous supprimer ce entreprise ?");
        alert.setIcon(R.drawable.deletee);

        alert.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                entreprise e = lst.get(sp.getSelectedItemPosition());

                if(MyDatabase.delete_entreprise(db.getWritableDatabase(),e.getId())==-1)
                    Toast.makeText(editer_main.this, "suppression echoue", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(editer_main.this, "Suppression reussie", Toast.LENGTH_SHORT).show();
                    ad.remove(e.getId() + " - " + e.getRaison_sociale());
                }
            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(editer_main.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }
}