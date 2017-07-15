package be.lsinf1225.ezmealgroupee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.content.Intent;

/**
 * Created by Gaetan on 22/06/2017.
 */

public class Connexion extends AppCompatActivity implements View.OnClickListener{
    private String login;
    private String mdp;
    public static objetUtilisateur utilisateuractuel;
    private Button btnConnection;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        Ajout_Listener_Bouttons();
    }

    private void Ajout_Listener_Bouttons(){
        btnConnection = (Button) findViewById(R.id.btnConnexion);
        btnConnection.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.btnConnexion){
            this.Login();
        }
    }

    private void Login(){
        BaseDeDonnees bdd = new BaseDeDonnees(this);

        EditText inputLogin = (EditText)findViewById(R.id.profilLogin);
        EditText inputMDP = (EditText) findViewById(R.id.txtPassword);

        login = inputLogin.getText().toString();
        mdp = inputMDP.getText().toString();

        objetUtilisateur u=bdd.getUserBylogin(login);

        if(u==null){ //Si aucun user avec cet login n'existe, on prévient l'utilisateur
            Toast.makeText(getApplicationContext(), login+" pas encore inscrit dans la base de donnée", Toast.LENGTH_SHORT).show();
        }
        else{  //Si il existe un utilisateur ayant ce login
            if(mdp.equals(u.getMDP())){ //Si les mdp sont egaux
                Toast.makeText(getApplicationContext(), "Bienvenue " + u.getLogin() + " ! ", Toast.LENGTH_SHORT).show();

                utilisateuractuel=bdd.getUserBylogin(login);  //Création d'un objetUtilisateur actuel qui est accesible de partout pour l'ajout de recette ou autres activités
                Intent menu = new Intent(this, Menu.class);
                menu.putExtra("cleLogin", u.getLogin());// On envoie le Login dans le menu principal pour le réutiliser après.
                startActivity(menu);
            }
            else{  //Si les mdp ne sont pas égaux
                Toast.makeText(getApplicationContext(), "Mauvais mot de passe pour " + u.getLogin(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Veuillez réessayer", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static objetUtilisateur getUtilisateuractuel(){
        return utilisateuractuel;
    }
}
