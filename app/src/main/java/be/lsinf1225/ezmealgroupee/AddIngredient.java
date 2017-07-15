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
 * Created by Gaetan on 13/07/2017.
 */

public class AddIngredient extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbarAjoutIngredient;
    private Button buttonAjoutIngredient;
    private Button buttonNext1;
    boolean ok = false;  //Pour vérifier qu'il y ait au moins un ingrédient
    String id;  //ID de la recette

    @Override
    protected void onCreate(Bundle savecInstanceState){
        super.onCreate(savecInstanceState);
        setContentView(R.layout.addingredient);

        toolbarAjoutIngredient = (Toolbar)findViewById(R.id.toolbarajoutingredient);
        toolbarAjoutIngredient.setTitle("Ajout des ingrédients");
        Bundle extras  = getIntent().getExtras();
        if(extras!=null){
            id=extras.getString("newid");
        }
        Ajout_Listener_boutons();
    }

    public void Ajout_Listener_boutons(){
        buttonAjoutIngredient = (Button)findViewById(R.id.btnaddingre);
        buttonAjoutIngredient.setOnClickListener(this);
        buttonNext1 = (Button)findViewById(R.id.btnnext1);
        buttonNext1.setOnClickListener(this);
    }

    public void onClick(View view){
        if(view.getId()==R.id.btnaddingre){
            addingre();
        }

        if(view.getId()==R.id.btnnext1){
            if(ok) {
                Intent next1 = new Intent(AddIngredient.this, AddEtape.class);
                next1.putExtra("newid", id);
                startActivity(next1);
            }
            else{
                Toast.makeText(AddIngredient.this, "Veuillez entrer au moins un ingredient", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void addingre(){
        BaseDeDonnees bdd = new BaseDeDonnees(AddIngredient.this);

        EditText eingre = (EditText)findViewById(R.id.addingredient);
        EditText equantite = (EditText)findViewById(R.id.addquantite);

        String ingre = eingre.getText().toString();
        String quantite = equantite.getText().toString();

        objetIngredient ingredientexistant = bdd.verifIngredient(ingre);
        objetIngredient ingredientdejaajoute = bdd.verif2Ingredient(ingre, id);

        if(ingredientexistant==null){
            Toast.makeText(AddIngredient.this, "L'ingredient que vous souhaitez ajouter n'existe pas dans la base de donnée. Veuillez contacter les développeurs.",Toast.LENGTH_SHORT).show();
        }
        else{
            if(ingredientdejaajoute==null) {
                bdd.addRecetteIngredient(id, ingre, quantite);
                ok = true;
                eingre.setText("");
                equantite.setText("");
                Toast.makeText(AddIngredient.this, "Ingrédient ajouté", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(AddIngredient.this, "Vous avez déjà introduit cet ingrédient", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
