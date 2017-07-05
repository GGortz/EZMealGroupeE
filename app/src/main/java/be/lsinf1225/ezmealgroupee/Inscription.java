package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Inscription extends AppCompatActivity implements View.OnClickListener{
    private Button btnEnregistrer;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        Ajout_Listener_Bouttons();
    }

    private void Ajout_Listener_Bouttons(){
        btnEnregistrer = (Button) findViewById(R.id.inscriptionEnregistrer);
        btnEnregistrer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId()==R.id.inscriptionEnregistrer)   //Quand on clique sur le bouton enregistrer
            this.Sinscrire();
    }

    private void Sinscrire(){
        BaseDeDonnees bdd = new BaseDeDonnees(getApplicationContext());

        EditText login=(EditText)findViewById(R.id.txtLogin);
        EditText mDP=(EditText)findViewById(R.id.txtMDP);
        EditText mDP2=(EditText)findViewById(R.id.txtMDP2);
        Spinner sexe=(Spinner)findViewById(R.id.SpinSex);
        EditText jour=(EditText)findViewById(R.id.txtJour);
        EditText mois=(EditText)findViewById(R.id.txtMois);
        EditText annee=(EditText)findViewById(R.id.txtAnnee);
        EditText ville=(EditText)findViewById(R.id.txtVille);
        EditText pays=(EditText)findViewById(R.id.txtPays);

        String uLogin=login.getText().toString();
        String uMDP=mDP.getText().toString();
        String uMDP2=mDP2.getText().toString();
        String uSexe=sexe.getSelectedItem().toString();
        int uJour=Integer.parseInt(jour.getText().toString());
        int uMois=Integer.parseInt(mois.getText().toString());
        int uAnnee=Integer.parseInt(annee.getText().toString());
        String uVille=ville.getText().toString();
        String uPays=pays.getText().toString();

        if(uMDP.equals(uMDP2)) {//Si les MDP sont égaux

            objetUtilisateur login_deja_rentre = bdd.getUserBylogin(uLogin);

            if (login_deja_rentre == null) {  //Si le login n'est pas encore utilisé
                if (uMDP.length() > 5) { // On checke que la longueur du mot de passe > 5 pour + de sécurité
                    if (uJour > 31 || uJour < 1 || uMois < 1 || uMois > 12 || uAnnee > 2017 || uAnnee < 1930) {  //On vérifie le format de la date entrée
                        Toast.makeText(Inscription.this, "Votre date de naissance n'est pas logique. Veuillez recommencer", Toast.LENGTH_LONG).show();
                    } else {
                        objetUtilisateur u = new objetUtilisateur();
                        u.setLogin(uLogin);
                        u.setMDP(uMDP);
                        u.setSexe(uSexe);
                        u.setJour(uJour);
                        u.setMois(uMois);
                        u.setAnnee(uAnnee);
                        u.setVille(uVille);
                        u.setPays(uPays);
                        bdd.addUser(u);

                        Intent retouracceuil = new Intent(Inscription.this, Acceuil.class);
                        startActivity(retouracceuil);
                        Toast.makeText(Inscription.this, "L'inscription de " + uLogin + " est un succès", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(Inscription.this, "Veuillez choisir un mot de passe d'au moins 5 caractères", Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(Inscription.this, uLogin + "est déja présent dans la base de données", Toast.LENGTH_LONG).show();
            }
        }
        else{  //Si les mdp ne sont pas égaux
            Toast.makeText(Inscription.this, "Les mots de passe ne sont pas égaux. Veuillez les revérifier.",Toast.LENGTH_LONG).show();
        }
    }
}

