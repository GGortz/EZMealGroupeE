package be.lsinf1225.ezmealgroupee;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Gaetan on 05/07/2017.
 */

public class Categorie extends AppCompatActivity{
    Toolbar toolbarCategorie;
    Context contexte=this;
    String choix;
    ListView categorie;
    BaseDeDonnees bdd = new BaseDeDonnees(this);

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.categorie);
        toolbarCategorie = (Toolbar) findViewById(R.id.toolbarCategorie);
        toolbarCategorie.setTitle("Catégories");
        
        categorie = (ListView)findViewById(R.id.listCategorie);
        ArrayList<String> listecategorie=bdd.getAllCategorie();
        ArrayAdapter<String> adapterCategorie = new ArrayAdapter<>(Categorie.this, android.R.layout.simple_list_item_1, listecategorie);
        categorie.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterViewCategorie, View viewCategorie, int iCategorie, long lCategorie){
                choix=categorie.getItemAtPosition(iCategorie).toString();
                //Toast.makeText(Categorie.this, "Vous avez choisis la catégorie : "+choix,Toast.LENGTH_SHORT).show();
                Intent souscategorie = new Intent(Categorie.this, SousCategorie.class);
                souscategorie.putExtra("categorie", choix);
                startActivity(souscategorie);
            }
        });
        categorie.setAdapter(adapterCategorie);
    }
}
