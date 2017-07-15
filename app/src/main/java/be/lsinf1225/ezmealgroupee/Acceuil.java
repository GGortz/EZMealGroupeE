package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;


/**
 * Created by Gaetan on 05/07/2017.
 */

public class Acceuil extends AppCompatActivity implements View.OnClickListener {

    private Button bInsc;
    private Button bConn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceuil);

        Ajout_Listener_Bouttons();
    }

    private void Ajout_Listener_Bouttons(){
        bInsc = (Button) findViewById(R.id.BtnInscription);
        bInsc.setOnClickListener(this);

        bConn = (Button) findViewById(R.id.BtnConnexion);
        bConn.setOnClickListener(this);
    }

   public void onClick(View view){
       if(view.getId()==R.id.BtnConnexion){
           Intent connexion = new Intent(Acceuil.this, Connexion.class);
           startActivity(connexion);
       }
       if(view.getId()==R.id.BtnInscription){
           Intent inscription = new Intent(Acceuil.this, Inscription.class);
           startActivity(inscription);
       }
   }
}
