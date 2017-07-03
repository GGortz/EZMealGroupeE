package be.lsinf1225.ezmealgroupee;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


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

    }




}