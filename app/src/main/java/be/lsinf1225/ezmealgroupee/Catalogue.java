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

public class Catalogue extends AppCompatActivity{
    Toolbar toolbarCatalogue;
    ListView catalogueRecette;
    BaseDeDonnees bdd = new BaseDeDonnees(this);
    String ingredient;
    ArrayList<String> listerecette;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.catalogue);
        toolbarCatalogue = (Toolbar) findViewById(R.id.toolbarCatalogue);
        toolbarCatalogue.setTitle("Catalogue");
        
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            ingredient=extras.getString("ingrédient");
            listerecette = bdd.getCatalogueRecette(ingredient);
            if(listerecette.isEmpty()){
                Toast.makeText(Catalogue.this, "Aucune recette trouvée pour l'ingrédient sélectionné", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            listerecette = bdd.getCatalogueRecette();
            if(listerecette.isEmpty()){
                Toast.makeText(Catalogue.this, "Aucune recette dans la base de donnée", Toast.LENGTH_SHORT).show();
            }
        }

        catalogueRecette = (ListView)findViewById(R.id.catalogueRecette);
        ArrayAdapter<String> adapterCatalogue = new ArrayAdapter<>(Catalogue.this, android.R.layout.simple_list_item_1, listerecette);
        catalogueRecette.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterViewCatalogue, View viewCatalogue, int iCatalogue, long lCatalogue){
                Intent afficherrecette = new Intent(Catalogue.this, Recette.class);
                afficherrecette.putExtra("recettes", catalogueRecette.getItemAtPosition(iCatalogue).toString());
                startActivity(afficherrecette);
            }

        });
        catalogueRecette.setAdapter(adapterCatalogue);
    }
}
