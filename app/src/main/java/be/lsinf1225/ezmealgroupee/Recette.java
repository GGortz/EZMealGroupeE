package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Gaetan on 05/07/2017.
 */

public class Recette extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbarRecette;
    private objetRecette Recette;
    private String nomrecette;
    Button btnCommentaire;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recette);
        toolbarRecette = (Toolbar) findViewById(R.id.toolbarrecette);
        toolbarRecette.setTitle("Recette");

        BaseDeDonnees bdd = new BaseDeDonnees(this);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            nomrecette=extras.getString("recettes");
        }
        Recette=bdd.getInfoRecette(nomrecette);
        bdd.getIngredientsRecette(nomrecette, Recette);
        bdd.getEtapesRecette(nomrecette, Recette);
        bdd.getRateRecette(nomrecette, Recette);
        bdd.getCommentaireRecette(nomrecette, Recette);
        Afficher_Recette(Recette);
        Ajout_Listener_Boutons();
    }

    private void Ajout_Listener_Boutons() {
        btnCommentaire = (Button)findViewById(R.id.bCommenter);
        btnCommentaire.setOnClickListener(this);
    }

    public void Afficher_Recette(objetRecette recette) {

        String nomRecette = nomrecette;
        int tprep = recette.getTempspreparation();
        int tcuiss = recette.getTempscuisson();
        int ncouv = recette.getNombredecouvert();
        String description = recette.getDescription();
        String difficulte = recette.getDifficulte();
        String cout  = recette.getCout();
        String type = recette.getType();
        String ingredients = recette.getListeingredients();
        String etapes = recette.getListeetapes();
        String date = recette.getDate();
        String auteur = recette.getAuteur();
        double rate = recette.getRate();
        String srate = String.valueOf(rate);
        String commentaire = recette.getCommentaire();


        TextView txt;

        txt = (TextView)findViewById(R.id.artitre);
        txt.setText(nomRecette);

        txt = (TextView)findViewById(R.id.ardescription);
        txt.setText("Description : "+description);

        txt = (TextView)findViewById(R.id.artprep);
        txt.setText("Temps de préparation : "+tprep+" minutes");

        txt = (TextView)findViewById(R.id.artcuis);
        txt.setText("Temps de cuisson : "+tcuiss+" minutes");

        txt = (TextView)findViewById(R.id.arprix);
        txt.setText("Coût : "+cout);

        txt = (TextView)findViewById(R.id.arcouv);
        txt.setText("Nombre de couverts : "+ncouv+" couverts");

        txt = (TextView)findViewById(R.id.arcomplexite);
        txt.setText("Difficulté : "+difficulte);

        txt = (TextView)findViewById(R.id.aringredient);
        txt.setText("Ingrédients : \n"+ingredients);

        txt = (TextView)findViewById(R.id.aretape);
        txt.setText("Etapes : \n"+etapes);

        txt = (TextView)findViewById(R.id.ardate);
        txt.setText("Date d'ajout : "+date);

        txt = (TextView)findViewById(R.id.arauteur);
        txt.setText("Auteur : "+auteur);

        txt = (TextView) findViewById(R.id.arcommentaire);
        txt.setText("Commentaires : \n"+commentaire);

        RatingBar ratingBar = (RatingBar) findViewById(R.id.arrate);
        ratingBar.setRating(Float.parseFloat(srate));
    }
    @Override
    public void onClick(View view){
        if(view.getId()==R.id.bCommenter){
            Intent addcommentaire = new Intent(Recette.this, Review.class);
            addcommentaire.putExtra("idrecette", nomrecette);
            startActivity(addcommentaire);
        }
    }
}
