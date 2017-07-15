package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Gaetan on 13/07/2017.
 */

public class AddRecette extends AppCompatActivity implements View.OnClickListener{

    private Button btnajoutsave;
    private Toolbar toolbarajoutrecette;
    private boolean ajout =false;

    String login;
    String nomR;
    int tprep;
    int tcuiss;
    int ncouv;
    String description;
    String difficulte;
    String cout;
    String type;
    String date;


    @Override
    public void onCreate(Bundle savecInstanceState){
        super.onCreate(savecInstanceState);
        setContentView(R.layout.addrecette);
        toolbarajoutrecette = (Toolbar)findViewById(R.id.toolbajoutrecette);
        toolbarajoutrecette.setTitle("Ajout d'une recette");
        login=Connexion.getUtilisateuractuel().getLogin();

        Ajout_listener_bouttons();
    }


    public void Ajout_listener_bouttons(){
        btnajoutsave = (Button)findViewById(R.id.btnAjoutEnregistrer);
        btnajoutsave.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAjoutEnregistrer) {
            addRecette();
            if(ajout) {
                Toast.makeText(AddRecette.this, "Recette bien enregistrée, ajoutez maintenant les ingrédients", Toast.LENGTH_SHORT).show();
                Intent ajoutIngredient = new Intent(AddRecette.this, AddIngredient.class);
                ajoutIngredient.putExtra("newid", nomR);
                startActivity(ajoutIngredient);
            }
            else{
                //Toast.makeText(AddRecette.this, "Une erreur est survenue", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void addRecette(){
        BaseDeDonnees bdd = new BaseDeDonnees(AddRecette.this);

        EditText enomR = (EditText)findViewById(R.id.ajoutTitre);
        EditText etprep = (EditText)findViewById(R.id.ajoutTprep);
        EditText etcuiss = (EditText)findViewById(R.id.ajoutTcuiss);
        EditText edescription = (EditText)findViewById(R.id.ajoutDescription);
        Spinner edifficulte = (Spinner)findViewById(R.id.ajoutDifficulte);
        Spinner etype = (Spinner)findViewById(R.id.ajoutType);
        Spinner ecout = (Spinner)findViewById(R.id.ajoutCout);
        EditText enbrcouv = (EditText)findViewById(R.id.ajoutNbrcouv);

        nomR = enomR.getText().toString();
        description = edescription.getText().toString();
        difficulte = edifficulte.getSelectedItem().toString();
        type = etype.getSelectedItem().toString();
        cout = ecout.getSelectedItem().toString();

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        date = day+"/"+month+"/"+year;

        objetRecette existedeja = bdd.getInfoRecette(nomR);
        if(existedeja==null){
            if(!nomR.equals("") || !etprep.getText().toString().equals("") || !etcuiss.getText().toString().equals("") || !enbrcouv.getText().toString().equals("")){
                tprep = Integer.parseInt(etprep.getText().toString());
                tcuiss = Integer.parseInt(etcuiss.getText().toString());
                ncouv = Integer.parseInt(enbrcouv.getText().toString());

                objetRecette recetteaajouter = new objetRecette(nomR, tcuiss, tprep, ncouv, description, difficulte, cout, type, date, login);
                bdd.addRecette(recetteaajouter);
                ajout=true;
            }
            else{
                Toast.makeText(AddRecette.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(AddRecette.this, "Une recette avec ce nom existe déjà. Veuillez choisir un autre nom",Toast.LENGTH_SHORT).show();
        }
    }
}
