package be.lsinf1225.ezmealgroupee;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    private Button bModifier;
    private Button bSupprimer;
    //private Button bAjout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            login=extras.getString("cleLogin");
        }

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

        bModifier=(Button)findViewById(R.id.bModifierMDP);
        bModifier.setOnClickListener(this);

        bSupprimer=(Button)findViewById(R.id.bSupprimerCompte);
        bSupprimer.setOnClickListener(this);

       //bAjout=(Button)findViewById(R.id.bAjoutRecette);
       //bAjout.setOnclickListener(this);
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
                Intent recherche = new Intent(Menu.this, RechercheSimple.class);
                startActivity(recherche);
                break;

            case R.id.bDeconnexion:
                Intent deconnexion = new Intent(Menu.this, Acceuil.class);
                Toast.makeText(getApplicationContext(), "A bientôt " +login + "!", Toast.LENGTH_SHORT).show();
                startActivity(deconnexion);
                break;

            case R.id.bModifierMDP:
                Intent modMDP = new Intent(Menu.this, ModifierMDP.class);
                modMDP.putExtra("cleLogin",login);
                startActivity(modMDP);
                break;

            case R.id.bSupprimerCompte:
                Intent supprimer = new Intent(Menu.this, SupprimerCompte.class);
                supprimer.putExtra("cleLogin",login);
                startActivity(supprimer);
                break;

            case R.id.bCatalogue:
                Intent catalogue = new Intent(Menu.this, Acceuil.class);
                catalogue.putExtra("cleLogin",login);
                startActivity(catalogue);
                break;

            case R.id.bCategories:
                Intent categories = new Intent(Menu.this, Acceuil.class);
                categories.putExtra("cleLogin",login);
                startActivity(categories);
                break;

            //case R.id.bAjout:
              //  Intent ajoutrecette = new Intent(Menu.this, AjoutRecette.class);
              //  ajoutrecette.putExtra("cleLogin",login);
              //  startActivity(ajoutrecette);
              //break;
        }
    }
}