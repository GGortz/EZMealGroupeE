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

public class Ingredient extends AppCompatActivity {
    Toolbar toolbarIngredient;
    ListView ingredient;
    BaseDeDonnees bdd = new BaseDeDonnees(this);
    String souscategorie;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.ingredient);
        toolbarIngredient = (Toolbar) findViewById(R.id.toolbarIngredient);
        toolbarIngredient.setTitle("Ingrédients");

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            souscategorie=extras.getString("souscategorie");
        }

        ingredient = (ListView)findViewById(R.id.listIngredient);
        ArrayList<String> listeIngredient = bdd.getIngredient(souscategorie);
        ArrayAdapter<String> adapterIngredient = new ArrayAdapter<>(Ingredient.this, android.R.layout.simple_list_item_1, listeIngredient);
        ingredient.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterViewIngredient, View viewIngredient, int iIngredient, long lIngredient){
                String choix;
                choix = ingredient.getItemAtPosition(iIngredient).toString();
                //Toast.makeText(Ingredient.this, "Vous avez choisis l'ingrédient : "+choix,Toast.LENGTH_SHORT).show();
                Intent catalogue = new Intent(Ingredient.this, Catalogue.class);
                catalogue.putExtra("ingrédient", choix);
                startActivity(catalogue);
            }

        });
        ingredient.setAdapter(adapterIngredient);
    }
}
