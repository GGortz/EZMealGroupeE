package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Gaetan on 30/06/2017.
 */

public class Inscription extends AppCompatActivity{
    Spinner sexe;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);
    }

    public void onBtnClick(View view){
        if(view.getId()==R.id.inscriptionEnregistrer){   //Quand on clique sur le bouton enregistrer
            TextView login=(EditText)findViewById(R.id.txtLogin);
            TextView mDP=(EditText)findViewById(R.id.txtMDP);
            TextView mDP2=(EditText)findViewById(R.id.txtMDP2);
            //spinsexe
            TextView jour=(EditText)findViewById(R.id.txtJour);
            TextView mois=(EditText)findViewById(R.id.txtMois);
            TextView annee=(EditText)findViewById(R.id.txtAnnee);
            TextView ville=(EditText)findViewById(R.id.txtVille);
            TextView pays=(EditText)findViewById(R.id.txtPays);

            String uLogin=login.getText().toString();
            String uMDP=mDP.getText().toString();
            String uMDP2=mDP2.getText().toString();
            String uSexe;
            if(sexe.getSelectedItem().toString().equals("Homme"))  uSexe="Homme";
            else  uSexe="Femme";
            int uJour=Integer.parseInt(jour.getText().toString());
            int uMois=Integer.parseInt(mois.getText().toString());
            int uAnnee=Integer.parseInt(annee.getText().toString());
            String uVille=ville.getText().toString();
            String uPays=pays.getText().toString();

            if(uMDP.equals(uMDP2)){  //Si les MDP sont égaux, ont crée un utilisateur
                objetUtilisateur u = new objetUtilisateur();
                u.setLogin(uLogin);
                u.setMDP(uMDP);
                u.setSexe(uSexe);
                u.setJour(uJour);
                u.setMois(uMois);
                u.setAnnee(uAnnee);
                u.setVille(uVille);
                u.setPays(uPays);
                //Ajout dans la DB
                Intent retouracceuil=new Intent(Inscription.this, Acceuil.class);
                startActivity(retouracceuil);
            }
            else{ //Si les MDP ne sont pas égaux, on le signale à l'utilisateur
                Toast mdpnonegaux = Toast.makeText(Inscription.this, "Les mot de passe ne sont pas égaux, veuillez vérifier.",Toast.LENGTH_LONG);
                mdpnonegaux.show();
            }

        }



    }
}
