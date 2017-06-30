package be.lsinf1225.ezmealgroupee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Gaetan on 30/06/2017.
 */

public class Inscription extends AppCompatActivity{
    Spinner sexe;
    ArrayAdapter<CharSequence> adapSex;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        sexe=(Spinner) findViewById(R.id.SpinSex);
        adapSex = ArrayAdapter.createFromResource(this,R.array.SpinSex,android.R.layout.simple_spinner_item);
        adapSex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexe.setAdapter(adapSex);
        sexe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
