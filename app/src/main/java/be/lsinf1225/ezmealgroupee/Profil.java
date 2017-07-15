package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Profil extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbarProfil;
    private String login;
    private Button bModifier;
    private Button bSupprimer;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        BaseDeDonnees bdd = new BaseDeDonnees(getApplicationContext());
        toolbarProfil = (Toolbar) findViewById(R.id.toolbarprofil);
        toolbarProfil.setTitle("Profil de l'utilisateur");

        Bundle extras = getIntent().getExtras();
        if(extras != null)
            login = extras.getString("cleLogin");
        objetUtilisateur u = bdd.getUserBylogin(login);

        MiseAJourProfil(u);
        Ajout_Listener_Bouttons();
    }

    public void MiseAJourProfil(objetUtilisateur u){

        String login = u.getLogin();
        String sexe = u.getSexe();
        int jour = u.getJour();
        int mois = u.getMois();
        int annee = u.getAnnee();
        String pays = u.getPays();
        String ville = u.getVille();

        TextView txt;

        txt = (TextView) findViewById(R.id.profilLogin);
        txt.setText("Login : " + login);

        txt = (TextView) findViewById(R.id.profilJour);
        txt.setText("Jour de Naissance : " + String.valueOf(jour));

        switch(String.valueOf(mois)){
            case "1":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Janvier");
                break;

            case "2":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Février");
                break;

            case "3":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Mars");
                break;

            case "4":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Avril");
                break;

            case "5":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Mai");
                break;

            case "6":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Juin");
                break;

            case "7":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Juillet");
                break;

            case "8":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Aout");
                break;

            case "9":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Septembre");
                break;

            case "01":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Janvier");
                break;

            case "02":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Février");
                break;

            case "03":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Mars");
                break;

            case "04":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Avril");
                break;

            case "05":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Mai");
                break;

            case "06":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Juin");
                break;

            case "07":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Juillet");
                break;

            case "08":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Aout");
                break;

            case "09":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Septembre");
                break;

            case "10":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Octobre");
                break;

            case "11":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Novembre");
                break;

            case "12":
                txt = (TextView) findViewById(R.id.profilMois);
                txt.setText("Mois de Naissance : Décembre");
                break;

        }

        txt = (TextView) findViewById(R.id.profilAnnee);
        txt.setText("Annee de Naissance : " + String.valueOf(annee));

        txt = (TextView) findViewById(R.id.profilPays);
        txt.setText("Pays de Résidence : " + pays);

        txt = (TextView) findViewById(R.id.profilVille);
        txt.setText("Ville de Résidence : " + ville);

        txt = (TextView) findViewById(R.id.profilSexe);
        txt.setText("Sexe : " + sexe);
    }

    private void Ajout_Listener_Bouttons() {

        bModifier = (Button) findViewById(R.id.bModifierMDP);
        bModifier.setOnClickListener(Profil.this);

        bSupprimer = (Button) findViewById(R.id.bSupprimerCompte);
        bSupprimer.setOnClickListener(Profil.this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bModifierMDP:
                Intent modMDP = new Intent(Profil.this, ModifierMDP.class);
                modMDP.putExtra("cleLogin", login);
                startActivity(modMDP);
                break;

            case R.id.bSupprimerCompte:
                Intent supprimer = new Intent(Profil.this, SupprimerCompte.class);
                supprimer.putExtra("cleLogin", login);
                startActivity(supprimer);
                break;
        }
    }

}
