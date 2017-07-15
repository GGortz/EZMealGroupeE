package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Gaetan on 03/07/2017.
 */

public class RechercheSimple extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbarRechercheSimple;
    private Button BtnRechercher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherchesimple);
        toolbarRechercheSimple = (Toolbar) findViewById(R.id.toolbarrs);
        toolbarRechercheSimple.setTitle("Recherche simple");

        Ajout_Listener_Bouttons();
    }

    private void Ajout_Listener_Bouttons(){
        BtnRechercher = (Button) findViewById(R.id.btnRechercheS);
        BtnRechercher.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        if(v.getId()==R.id.btnRechercheS)
            RechercherSimplement();
    }

    private void RechercherSimplement() {
        EditText Ingr = (EditText) findViewById(R.id.txtIngredient);
        String Ingredient = Ingr.getText().toString();

        BaseDeDonnees bdd = new BaseDeDonnees(this);
        objetIngredient ingredientexistant = bdd.verifIngredient(Ingredient);

        if(ingredientexistant==null){
            Toast.makeText(this, "L'ingrédient recherché n'existe pas dans la base de données", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent resultat = new Intent(RechercheSimple.this, Catalogue.class);
            resultat.putExtra("ingrédient", Ingredient);
            startActivity(resultat);
        }
    }
}
