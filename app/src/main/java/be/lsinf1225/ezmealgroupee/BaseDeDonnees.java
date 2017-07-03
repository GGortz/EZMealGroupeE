package be.lsinf1225.ezmealgroupee;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Gaetan on 03/07/2017.
 */

public class BaseDeDonnees extends SQLiteOpenHelper{


    protected final static int BD_VERSION = 1;
    protected final static String BD_NOM = "EZmeal.sqlite";


    public BaseDeDonnees(Context context){

        super(context, BD_NOM, null, BD_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase base_de_donnees) {

        Creation_table_SQL(base_de_donnees);
        Creation_population_SQL(base_de_donnees);

    }



    void Creation_table_SQL(SQLiteDatabase base_de_donees){

        String Requete;


        Requete =
                "CREATE TABLE Utilisateur ( login VARCHAR(255) PRIMARY KEY, mdp VARCHAR(255), sexe VARCHAR(255), jour INTEGER, mois INTEGER, annee INTEGER, ville VARCHAR(255), pays VARCHAR(255));";
        base_de_donees.execSQL(Requete);


        // A mon avis il est plus facile de coder la BD comme ca, sans faire des Strings
        // Au dessus de la classe qui nous embrouillent, si jetais toi je continuerais a coder les
        // autres classes et populations comme ca, mais fais comme tu veux...


        /*
        Requete =
                "CREATE TABLE Recette ( numR INTEGER PRIMARY KEY, nomR VARCHAR(255), tprep INTEGER, tcuiss INTEGER, ncouv INTEGER, description TEXT, difficulte VARCHAR(255), cout VARCHAR(255));";
        base_de_donees.execSQL(Requete);

        */

    }



    void Creation_population_SQL(SQLiteDatabase base_de_donnees){

        String Requete;

        Requete =
                "INSERT INTO Utilisateur ('login', 'mdp', 'sexe', 'jour', 'mois', 'annee', 'ville', 'pays')  VALUES ('Martin', 'oklm', 'Homme', 10, 02, 1996, 'Louvain', 'Belgique')";
        base_de_donnees.execSQL(Requete);


        //Requete = Autres requetes a mettre plus bas



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            String Utilisateur = "DROP TABLE IF EXISTS Utilisateur;";
            db.execSQL(Utilisateur);

            onCreate(db);
        }
    }


    public objetUtilisateur getUserBylogin(String login){
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete = "SELECT * FROM Utilisateur WHERE login = '" + login + "'";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);
        if (cursor.moveToFirst()) {
            objetUtilisateur found = new objetUtilisateur(cursor.getString(0),
                    cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)),
                    Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), cursor.getString(6),
                    cursor.getString(7));

            cursor.close();
            return found;
        }
        else
            return null;
    }

    public void addUser(objetUtilisateur u){
        SQLiteDatabase base_de_donnees = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("login", u.getLogin());
        value.put("mdp", u.getMDP());
        value.put("sexe", u.getSexe());
        value.put("jour", u.getJour());
        value.put("mois", u.getMois());
        value.put("annee", u.getAnnee());
        value.put("ville", u.getVille());
        value.put("pays", u.getPays());
        base_de_donnees.insert("Utilisateur", null, value);
        base_de_donnees.close();
    }


    public void deleteUserByLogin(String Login){
        SQLiteDatabase base_de_donnees = this.getWritableDatabase();
        String Requete =
                "DELETE FROM Utilisateur WHERE login = '" + Login + "' ;";
        base_de_donnees.execSQL(Requete);
        base_de_donnees.close();
    }

    public void modifierUser(String Login, String toModify, String newValue){
        SQLiteDatabase base_de_donnees = this.getWritableDatabase();
        String Requete =
                "UPDATE Utilisateur SET '" + toModify + "' = '" + newValue + "' WHERE login = '" + Login + "' ;";
        base_de_donnees.execSQL(Requete);
        base_de_donnees.close();

    }


}

