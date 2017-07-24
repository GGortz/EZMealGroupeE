package be.lsinf1225.ezmealgroupee;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Gaetan on 22/06/2017.
 */

public class Menu extends AppCompatActivity implements View.OnClickListener{

    private String login;  //Login de l'utilisateur actuel afin de pouvoir l'utiliser a divers endroits
    private Button bProfil;
    private Button bRechercheAvancee;
    private Button bRecherche;
    private Button bCategories;
    private Button bCatalogue;
    private Button bDeconnexion;
    private Button bAjout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        login=Connexion.getUtilisateuractuel().getLogin();
        Ajout_Listener_Bouttons();
    }

    private void Ajout_Listener_Bouttons(){
        bProfil=(Button)findViewById(R.id.bProfil);
        bProfil.setOnClickListener(this);

        bRecherche=(Button)findViewById(R.id.bRecherche);
        bRecherche.setOnClickListener(this);

        bRechercheAvancee=(Button)findViewById(R.id.bRechercheAvancee);
        bRechercheAvancee.setOnClickListener(this);

        bCatalogue=(Button)findViewById(R.id.bCatalogue);
        bCatalogue.setOnClickListener(this);

        bCategories=(Button)findViewById(R.id.bCategories);
        bCategories.setOnClickListener(this);

        bDeconnexion=(Button)findViewById(R.id.bDeconnexion);
        bDeconnexion.setOnClickListener(this);

       bAjout=(Button)findViewById(R.id.bAjoutRecette);
       bAjout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {

            case R.id.bProfil:
                Intent profil = new Intent(Menu.this, Profil.class);
                profil.putExtra("cleLogin", login);
                startActivity(profil);
                break;

            case R.id.bRechercheAvancee:
                Intent rechercheavancee = new Intent(Menu.this, RechercheAvancee.class);//
                startActivity(rechercheavancee);
                break;

            case R.id.bRecherche:
                RechercherSimplement();
                break;

            case R.id.bDeconnexion:
                Intent deconnexion = new Intent(Menu.this, Acceuil.class);
                Toast.makeText(getApplicationContext(), "A bientôt " +login + "!", Toast.LENGTH_SHORT).show();
                startActivity(deconnexion);
                break;

            case R.id.bCatalogue:
                Intent catalogue = new Intent(Menu.this, Catalogue.class);
                //catalogue.putExtra("cleLogin",login);
                startActivity(catalogue);
                break;

            case R.id.bCategories:
                Intent categories = new Intent(Menu.this, Categorie.class);
                categories.putExtra("cleLogin",login);
                startActivity(categories);
                break;

            case R.id.bAjoutRecette:
                Intent ajoutrecette = new Intent(Menu.this, AddRecette.class);
                ajoutrecette.putExtra("cleLogin",login);
                startActivity(ajoutrecette);
              break;
        }
    }

    private void RechercherSimplement() {
        EditText Ingr = (EditText) findViewById(R.id.RechercheSimpleMenu);
        String Ingredient = Ingr.getText().toString();

        BaseDeDonnees bdd = new BaseDeDonnees(this);
        objetIngredient ingredientexistant = bdd.verifIngredient(Ingredient);

        if(ingredientexistant==null){
            Toast.makeText(this, "L'ingrédient recherché n'existe pas dans la base de données", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent resultat = new Intent(Menu.this, Catalogue.class);
            resultat.putExtra("ingrédient", Ingredient);
            startActivity(resultat);
        }
    }

}