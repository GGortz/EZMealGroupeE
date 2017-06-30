package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Acceuil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acceuil);
    }

   public void onBtnClick(View view){
       if(view.getId()==R.id.BtnConnexion){
           Intent connexion = new Intent();
           startActivity(connexion);
       }
       if(view.getId()==R.id.BtnInscription){
           Intent inscription = new Intent();
           startActivity(inscription);
       }
   }



}
