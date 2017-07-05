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

public class ModifierMDP extends AppCompatActivity implements View.OnClickListener{

    private Button btnChange;
    private String login;
    private String mdp1;
    private String mdp2;
    private String mdp3;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifiermdp);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
            login = extras.getString("cleLogin");

        Ajout_Listener_Bouttons();

    }

    private void Ajout_Listener_Bouttons(){

        btnChange = (Button) findViewById(R.id.btnChangeMDP);
        btnChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnChangeMDP)
            ChangerMDP();
    }

    private void ChangerMDP(){

        mdp1   = ((EditText)findViewById(R.id.ancienMDP)).getText().toString();  //Ancien mdp de l'utilisateur
        mdp2   = ((EditText)findViewById(R.id.NewMDP)).getText().toString();    //Nouveau mdp de l'utilisateur
        mdp3   = ((EditText)findViewById(R.id.ReNewMDP)).getText().toString();  //Repet nouveau mdp


        if(mdp2.equals(mdp3)){  //On vérifie que les nouveaux mdp sont les mêmes
            BaseDeDonnees baseDeDonnees = new BaseDeDonnees(this);
            objetUtilisateur u = baseDeDonnees.getUserBylogin(login);

            if(u.getMDP().equals(mdp1)){ //On vérifie que l'ancien mdp est correct par rapport à la DB

                if(mdp2.length() > 5 ) { // Longueur minimale
                    u.setMDP(mdp2);
                    baseDeDonnees.modifierUser(login, "mdp", mdp2);
                    baseDeDonnees.close();
                    Intent retourmenu = new Intent(ModifierMDP.this, Menu.class);
                    startActivity(retourmenu);
                    Toast.makeText(getApplicationContext(), "Changement de mot de passe effectué avec succès", Toast.LENGTH_LONG).show();

                }
                else {  //Mot de passe pas assez long
                    Toast.makeText(ModifierMDP.this, "Veuillez choisir un mot de passe dépassant 5 charactères", Toast.LENGTH_LONG).show();
                }
            }
            else {  //Ancien mot de passe incorrect
                Toast.makeText(ModifierMDP.this, "L'ancien mot de passe n'est pas correct", Toast.LENGTH_LONG).show();
            }
        }
        else {  //Les nouveaux mots de passe ne correspeondent pas
            Toast.makeText(ModifierMDP.this, "Les 2 nouveaux mots de passe ne correspondent pas", Toast.LENGTH_LONG).show();
        }


    }



}
