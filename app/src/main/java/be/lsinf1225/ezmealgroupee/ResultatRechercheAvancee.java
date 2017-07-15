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

public class ResultatRechercheAvancee extends AppCompatActivity{

    Toolbar toolbarCatalogue;
    ListView catalogueRecette;
    BaseDeDonnees bdd = new BaseDeDonnees(this);

    int ratprepmin;
    int ratprepmax;
    int ratcuissmin;
    int ratcuissmax;
    int ranbrcouv;
    String radifficulte;
    String ratype;
    String racout;
    String raauteur;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.catalogue);
        ArrayList<String> listerecette = new ArrayList<>();

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            ratprepmin=extras.getInt("ratprepmin");
            ratprepmax=extras.getInt("ratprepmax");
            ratcuissmin=extras.getInt("ratcuissmin");
            ratcuissmax=extras.getInt("ratcuissmax");
            ranbrcouv=extras.getInt("ranbrcouv");
            radifficulte=extras.getString("radifficulte");
            if(radifficulte.equals("N'importe")){
                radifficulte="";
            }
            ratype=extras.getString("ratype");
            if(ratype.equals("N'importe")){
                ratype="";
            }
            racout=extras.getString("racout");
            if(racout.equals("N'importe")){
                racout="";
            }
            raauteur=extras.getString("raauteur");
            if(raauteur.equals("N'importe")){
                raauteur="";
            }
            listerecette = bdd.getCatalogueRecette(ratype, radifficulte, racout, ratprepmin, ratprepmax, ratcuissmin, ratcuissmax, ranbrcouv, raauteur);
            if(listerecette.isEmpty()){
                Toast.makeText(ResultatRechercheAvancee.this, "Aucune recette trouvée pour les caractéristiques demandées", Toast.LENGTH_SHORT).show();
            }
        }


        catalogueRecette = (ListView)findViewById(R.id.catalogueRecette);
        toolbarCatalogue = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbarCatalogue);
        toolbarCatalogue.setTitle("Catalogue");
        ArrayAdapter<String> adapterCatalogue = new ArrayAdapter<>(ResultatRechercheAvancee.this, android.R.layout.simple_list_item_1, listerecette);
        catalogueRecette.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterViewCatalogue, View viewCatalogue, int iCatalogue, long lCatalogue){
                Intent recette = new Intent(ResultatRechercheAvancee.this, Recette.class);
                recette.putExtra("recettes", catalogueRecette.getItemAtPosition(iCatalogue).toString());
                startActivity(recette);
            }
        });
        catalogueRecette.setAdapter(adapterCatalogue);
    }
}
