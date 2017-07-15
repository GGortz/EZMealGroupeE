package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Gaetan on 03/07/2017.
 */

public class RechercheAvancee extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbarRechercheAvancee;
    private Button btnrecherche;
    ArrayList<String> listeauteur;
    Spinner auteur;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rechercheavancee);
        toolbarRechercheAvancee = (Toolbar) findViewById(R.id.toolbarra);
        toolbarRechercheAvancee.setTitle("Recherche avancée");

        BaseDeDonnees bdd = new BaseDeDonnees(RechercheAvancee.this);
        listeauteur = bdd.getAuteurs();
        auteur = (Spinner)findViewById(R.id.spinnerauteur);
        ArrayAdapter<String> auteur_adapter = new ArrayAdapter(RechercheAvancee.this, android.R.layout.simple_spinner_item, listeauteur);
        auteur_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        auteur.setAdapter(auteur_adapter);

        Ajout_listener_bouttons();
    }

    private void Ajout_listener_bouttons() {
        btnrecherche=(Button)findViewById(R.id.buttonra);
        btnrecherche.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId()==R.id.buttonra){
            this.rechercheavancee();
        }
    }

    private void rechercheavancee() {

        EditText tprepmin = (EditText) findViewById(R.id.ratprepmin);
        EditText tprepmax = (EditText) findViewById(R.id.ratprepmax);
        EditText tcuissmin = (EditText) findViewById(R.id.ratcuissmin);
        EditText tcuissmax = (EditText) findViewById(R.id.ratcuissmax);
        EditText nbrcouv = (EditText) findViewById(R.id.ranbrcouv);
        Spinner difficulte = (Spinner) findViewById(R.id.spinnerdifficulte);
        Spinner type = (Spinner) findViewById(R.id.spinnertype);
        Spinner cout = (Spinner) findViewById(R.id.spinnercout);


        String sratprepmin = tprepmin.getText().toString();
        String sratprepmax = tprepmax.getText().toString();
        String sratcuissmin = tcuissmin.getText().toString();
        String sratcuissmax = tcuissmax.getText().toString();
        String sranbrcouv = nbrcouv.getText().toString();
        String radifficulte = difficulte.getSelectedItem().toString();
        String ratype = type.getSelectedItem().toString();
        String racout = cout.getSelectedItem().toString();
        String raauteur = auteur.getSelectedItem().toString();


        if(sratprepmin.equals("") || sratprepmax.equals("") || sratcuissmin.equals("") ||sratcuissmax.equals("") || sranbrcouv.equals("")){
            Toast.makeText(this, "Veuillez remplir tous les champs. Merci", Toast.LENGTH_SHORT).show();
        }
        else {
            int ratprepmin = Integer.parseInt(tprepmin.getText().toString());
            int ratprepmax = Integer.parseInt(tprepmax.getText().toString());
            int ratcuissmin = Integer.parseInt(tcuissmin.getText().toString());
            int ratcuissmax = Integer.parseInt(tcuissmax.getText().toString());
            int ranbrcouv = Integer.parseInt(nbrcouv.getText().toString());

            Intent resultat = new Intent(this, ResultatRechercheAvancee.class);
            resultat.putExtra("ratprepmin",ratprepmin);
            resultat.putExtra("ratprepmax",ratprepmax);
            resultat.putExtra("ratcuissmin",ratcuissmin);
            resultat.putExtra("ratcuissmax",ratcuissmax);
            resultat.putExtra("ranbrcouv",ranbrcouv);
            resultat.putExtra("radifficulte",radifficulte);
            resultat.putExtra("ratype",ratype);
            resultat.putExtra("racout",racout);
            resultat.putExtra("raauteur",raauteur);
            startActivity(resultat);
        }
    }
}
