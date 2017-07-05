package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Gaetan on 03/07/2017.
 */

public class SupprimerCompte extends AppCompatActivity implements View.OnClickListener{

    private Button btnSupprimer;
    private String login;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supprimercompte);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
            login = extras.getString("cleLogin");

        Ajout_Listener_Bouttons();

    }

    private void Ajout_Listener_Bouttons(){

        btnSupprimer = (Button) findViewById(R.id.btnSupprimer);
        btnSupprimer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSupprimer)
            SuppCompte();
    }

    private void SuppCompte(){

        String MDP   = ((EditText)findViewById(R.id.txtmdP)).getText().toString();
        String Code = ((EditText)findViewById(R.id.txtCODE)).getText().toString();

        if(Code.equals("overlooks inquiry") || Code.equals("overlooksinquiry")){
            BaseDeDonnees baseDeDonnees = new BaseDeDonnees(this);
            objetUtilisateur u = baseDeDonnees.getUserBylogin(login);
            if(u.getMDP().equals(MDP)){
                baseDeDonnees.deleteUserByLogin(login);
                baseDeDonnees.close();
                Intent retouraccueil = new Intent(SupprimerCompte.this, Acceuil.class);
                startActivity(retouraccueil);
                Toast.makeText(getApplicationContext(), login + " Supprimé ", Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(SupprimerCompte.this, "Le mot de passe n'est pas correct",Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(getApplicationContext(), "Seriez-vous un robot? Réessayez!", Toast.LENGTH_SHORT).show();




    }
}
