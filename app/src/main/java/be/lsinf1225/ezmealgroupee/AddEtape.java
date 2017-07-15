package be.lsinf1225.ezmealgroupee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Gaetan on 13/07/2017.
 */

public class AddEtape extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbarAddEtape;
    private Button buttonAddEtape;
    private Button buttonNext2;
    int numero = 0;  //Numéro de l'étape
    String id;  //ID de la recette

    @Override
    protected void onCreate(Bundle savecInstanceState){
        super.onCreate(savecInstanceState);
        setContentView(R.layout.addetape);

        toolbarAddEtape = (Toolbar)findViewById(R.id.toolbarajoutetape);
        toolbarAddEtape.setTitle("Ajout des étapes");

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            id=extras.getString("newid");
        }
        Ajout_Listener_boutons();
    }

    public void Ajout_Listener_boutons(){
        buttonAddEtape = (Button)findViewById(R.id.btnaddetape);
        buttonAddEtape.setOnClickListener(this);
        buttonNext2 = (Button)findViewById(R.id.btnnext2);
        buttonNext2.setOnClickListener(this);
    }

    public void onClick(View view){
        if(view.getId()==R.id.btnaddetape){
            addetape();
            Toast.makeText(AddEtape.this, "Etape ajoutée", Toast.LENGTH_SHORT).show();
        }
        if(view.getId()==R.id.btnnext2){
            if(numero>0) {
                Intent retour = new Intent(AddEtape.this, Menu.class);
                startActivity(retour);
            }
            else {
                Toast.makeText(AddEtape.this, "Veuillez entrer au moins une étape", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void addetape(){
        BaseDeDonnees bdd = new BaseDeDonnees(AddEtape.this);

        EditText eetape = (EditText)findViewById(R.id.addetape);

        String etape = eetape.getText().toString();

        bdd.addRecetteEtape(id, numero, etape);
        numero++;
        eetape.setText("");   //Pour vider le champ
    }
}
