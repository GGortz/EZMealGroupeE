package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by Gaetan on 13/07/2017.
 */

public class Review extends AppCompatActivity implements View.OnClickListener {
    private Button validerReview;
    private Toolbar toolbarReview;
    private String login;
    private String idrecette;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);
        toolbarReview = (Toolbar) findViewById(R.id.toolbarReview);
        toolbarReview.setTitle("Ajouter une note");
        login=Connexion.getUtilisateuractuel().getLogin();
        Bundle extras = getIntent().getExtras();
        if(extras != null)
            idrecette = extras.getString("idrecette");

        Ajouter_listener_bouton();
    }

    private void Ajouter_listener_bouton() {
        validerReview = (Button)findViewById(R.id.validerReview);
        validerReview.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId()==R.id.validerReview){
            addReview();
        }
    }

    public void addReview(){
        BaseDeDonnees bdd = new BaseDeDonnees(this);

        EditText rcom = (EditText)findViewById(R.id.rcom);
        RatingBar rRate = (RatingBar)findViewById(R.id.rRating);

        String srcom = rcom.getText().toString();
        float fsrrate = rRate.getRating();
        double srrate = Double.parseDouble(new Float(fsrrate).toString());

        if(srcom.length()<251){
            objetReview review = new objetReview(idrecette, login, srrate, srcom);
            bdd.addReviews(review);
            Toast.makeText(Review.this, Double.toString(srrate), Toast.LENGTH_SHORT).show();
            Toast.makeText(Review.this, "Votre commentaire a été enregistré", Toast.LENGTH_SHORT).show();
            Intent retourrecette = new Intent(Review.this, Recette.class);
            retourrecette.putExtra("recettes", idrecette);
            startActivity(retourrecette);
        }
        else{
            Toast.makeText(Review.this, "Votre commentaire est trop long. Veuillez le raccourcir.", Toast.LENGTH_SHORT).show();
        }
    }
}
