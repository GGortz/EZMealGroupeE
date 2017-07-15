package be.lsinf1225.ezmealgroupee;

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

public class SousCategorie extends AppCompatActivity{
    Toolbar toolbarSousCategorie;
    ListView souscategorie;
    BaseDeDonnees bdd = new BaseDeDonnees(this);
    String categorie;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.souscategorie);
        toolbarSousCategorie = (Toolbar) findViewById(R.id.toolbarSousCategorie);
        toolbarSousCategorie.setTitle("Sous-catégories");
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            categorie=extras.getString("categorie");
        }

        souscategorie = (ListView)findViewById(R.id.listSousCategorie);
        ArrayList<String> listesouscategorie = bdd.getSousCategorie(categorie);
        ArrayAdapter<String> adapterSousCategorie = new ArrayAdapter<>(SousCategorie.this, android.R.layout.simple_list_item_1, listesouscategorie);
        souscategorie.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterViewSousCategorie, View viewSousCategorie, int iSousCategorie, long lSousCategorie){
                String choix;
                choix = souscategorie.getItemAtPosition(iSousCategorie).toString();
                //Toast.makeText(SousCategorie.this, "Vous avez choisis la sous-catégorie : "+choix, Toast.LENGTH_SHORT).show();
                Intent ingredient = new Intent(SousCategorie.this, Ingredient.class);
                ingredient.putExtra("souscategorie", choix);
                startActivity(ingredient);
            }
        });
        souscategorie.setAdapter(adapterSousCategorie);
    }
}
