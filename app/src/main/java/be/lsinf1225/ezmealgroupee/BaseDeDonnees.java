package be.lsinf1225.ezmealgroupee;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Gaetan on 03/07/2017.
 *
 */

public class BaseDeDonnees extends SQLiteOpenHelper{

    protected final static int BD_VERSION = 1;
    protected final static String BD_NOM = "EZmeal.sqlite";


    /*
    Constructeur de la base de données
     */
    public BaseDeDonnees(Context context){
        super(context, BD_NOM, null, BD_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase base_de_donnees) {
        Creation_table_SQL(base_de_donnees);
        Creation_population_SQL(base_de_donnees);
    }


    /*
    Creation de l'ensemble des tables de la base de données
     */
    void Creation_table_SQL(SQLiteDatabase base_de_donees){

        String Catesouscate;
        Catesouscate =
                "CREATE TABLE Categories ( categorie VARCHAR(255), souscategorie VARCHAR(255));";
        base_de_donees.execSQL(Catesouscate);

        String Utilisateur;
        Utilisateur =
                "CREATE TABLE Utilisateur ( login VARCHAR(255) PRIMARY KEY, mdp VARCHAR(255), sexe VARCHAR(255), jour INTEGER, mois INTEGER, annee INTEGER, ville VARCHAR(255), pays VARCHAR(255));";
        base_de_donees.execSQL(Utilisateur);

        String Ingredients;
        Ingredients =
                "CREATE TABLE Ingredients (ingredient VARCHAR(255), isouscategorie VARCHAR(255));";
        base_de_donees.execSQL(Ingredients);

        String Recette;
        Recette =
                "CREATE TABLE Recette (nomR VARCHAR(255) PRIMARY KEY, tprep INTEGER, tcuiss INTEGER, ncouv INTEGER, description VARCHAR(255), difficulte VARCHAR(255), cout VARCHAR(255), type VARCHAR(255), date VARCHAR(255), auteur VARCHAR(255));";
        base_de_donees.execSQL(Recette);

        String RecetteIngredients;
        RecetteIngredients =
                "CREATE TABLE Recetteingredient (riidrecette VARCHAR(255), riingredient VARCHAR(255), riquantite VARCHAR(255));";
        base_de_donees.execSQL(RecetteIngredients);

        String RecetteEtapes;
        RecetteEtapes =
                "CREATE TABLE Recetteetape (reidrecette VARCHAR(255), renumero INTEGER, reetape VARCHAR(255));";
        base_de_donees.execSQL(RecetteEtapes);

        String Reviews;
        Reviews =
                "CREATE TABLE Reviews ( ridrecette VARCHAR(255), rlogin VARCHAR(255), rnote REAL, rcommentaire VARCHAR(255));";
        base_de_donees.execSQL(Reviews);
    }


    /*
    Création de la population de la base de données
    En faisant appel à des sous fonctions
     */
    void Creation_population_SQL(SQLiteDatabase base_de_donnees){
        population_utilisateur(base_de_donnees);
        population_categorie(base_de_donnees);
        population_ingredient(base_de_donnees);
        population_recette(base_de_donnees);
        population_recette_ingredient(base_de_donnees);
        population_recette_etape(base_de_donnees);
        population_reviews(base_de_donnees);
    }


    /*
    Crée une population d'utilisateur
     */
    private void population_utilisateur(SQLiteDatabase base_de_donnees) {
        String Requete;
        Requete =
                "INSERT INTO Utilisateur ('login', 'mdp', 'sexe', 'jour', 'mois', 'annee', 'ville', 'pays')  VALUES ('Martin', 'oklm', 'Homme', 10, 2, 1996, 'Louvain', 'Belgique')";
        base_de_donnees.execSQL(Requete);
    }

    /*
    Crée une population de catégorie (non-modifiable par l'utilisateur)
     */
    private void population_categorie(SQLiteDatabase base_de_donnees) {

        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Viande', 'Volaille')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Viande', 'Blanche')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Viande', 'Gibier')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Viande', 'Rouge')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume', 'Vert')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits', 'Pépins')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits', 'Noyaux')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits', 'Agrumes')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits', 'Secs')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits', 'Autres')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Viande', 'Charcuterie')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Viande', 'Abat')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fromage', 'Frais')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fromage', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fromage', 'Pâte molle')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fromage', 'Pâte persillée')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fromage', 'Chêvre')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson', 'Mi-gras')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson', 'Mollusque')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment', 'Bulbe')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment', 'Plante')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruit', 'Coques')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Charcuterie', 'Haché')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume', 'Racine')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume', 'Champignon')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Féculent', 'Féculent')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment', 'Gousse')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Charcuterie', 'Saucisse')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume', 'Rhizome')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume', 'Cucurbitacé')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Charcuterie', 'Jambon')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson', 'Gastéropode')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume', 'Feuille')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment', 'Pâtes')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Confiserie', 'Bonbon')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Confiserie', 'Biscuit')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Confiserie', 'Chocolat')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Confiserie', 'Massepain')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Sauce', 'Sauce blanche')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Sauce', 'Sauce tomatée')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment', 'Épice')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment', 'Confit')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume', 'Lentille')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume', 'Chou')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson', 'Eau')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson', 'Soda')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson', 'Alcool fort')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson', 'Alcool doux')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson', 'Vin blanc')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson', 'Vin rouge')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson', 'Vin rosé')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson', 'Sirop')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson', 'Jus')");
        base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Confiserie', 'Glace')");

        //base_de_donnees.execSQL("INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('', '')");
    }

    /*
    Crée une population d'ingrédient (non-modifiable par l'utilisateur)
     */
    private void population_ingredient(SQLiteDatabase base_de_donnees) {
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boulette', 'Haché')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Carotte', 'Racine')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Fraise', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Poulet', 'Volaille')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Plie', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Saumon', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Champignons de Paris', 'Champignon')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pomme de terre', 'Féculent')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Abricot', 'Noyaux')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Agneau', 'Rouge')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Ail', 'Gousse')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Airelle', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Algue', 'Vert')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Amande', 'Coques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Ananas', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Anchois', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Andouillette', 'Saucisse')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Artichaut', 'Vert')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Asperge blanche', 'Rhizome')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Asperge verte', 'Rhizome')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Aubergine', 'Cucurbitacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Autruche', 'Volaille')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Avocat', 'Noyaux')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bacon', 'Jambon')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Banane', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Basilic', 'Plante')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Béchamel', 'Sauce blanche')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Beaufort', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Betterave', 'Racine')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Beurre', 'Matière grasse')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Biche', 'Gibier')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bifteck', 'Rouge')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bigorneau', 'Gastéropode')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Blé', 'Féculent')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bleu d Auvergne', 'Pâte persillée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bolognaise', 'Sauce Tomatée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boudin blanc', 'Saucisse')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boudin noir', 'Saucisse')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boulgour', 'Féculent')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boursin', 'Frais')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Céléri', 'Feuille')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bresse Bleu', 'Pâte persillée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Brie', 'Pâte molle')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Brochet', 'Mi-gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Brocoli', 'Chou')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boeuf haché', 'Rouge')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boeuf', 'Rouge')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cabillaud', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cacahuète', 'Coques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cacao', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Caille', 'Volaille')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Calamar', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Camembert', 'Pâte molle')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Canard', 'Volaille')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cannelle', 'Épice')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Capellini', 'Pâtes')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Caprice des Anges', 'Pâte molle')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Caprice des Dieux', 'Pâte molle')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Carambar', 'Bonbon')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Caramel', 'Bonbon')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Caviar', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cèpe', 'Champignon')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cerfeuil', 'Feuille')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cerise', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chataigne', 'Coques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cheddar', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chèvre', 'Chèvre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chevreuil', 'Gibier')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chocolat noir', 'Chocolat')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chocolat blanc', 'Chocolat')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chocolat au lait', 'Chocolat')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chocolat praliné', 'Chocolat')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chorizo', 'Salami')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chou Blanc', 'Chou')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chou de Bruxelles', 'Chou')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chou Rouge', 'Chou')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chou Fleur', 'Chou')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Choucroute', 'Chou')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Ciboulette', 'Plante')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Citron', 'Agrumes')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Citrouille', 'Cucurbitacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Clémentine', 'Agrumes')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Clou de Girofle', 'Épice')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cochon', 'Blanche')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Colin', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Comté', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Confit d oignon', 'Confit')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Concombre', 'Cucurbitacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Coppa', 'Jambon')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Coq', 'Volaille')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Coquille St-Jacques', 'Mollusque')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cornichon', 'Cucurbitacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Courgette', 'Cucurbitacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Crabe', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Crevette Grise', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Crevette Rose', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Datte', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Dinde', 'Volaille')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Échalote', 'Gousse')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Écrevisse', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Emmental', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Endive', 'Racine')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Épinard', 'Vert')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Escargot', 'Gastéropode')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Espadon', 'Mi-gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Faisan', 'Gibier')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Figue', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Flageolet', 'Lentille')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Fourme d Ambert', 'Pâte persillée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Gambas', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Gingembre', 'Épice')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Gorgonzola', 'Pâte persillée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Gouda', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Groseille', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Guacamole', 'Sauce')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Hareng', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Haricot', 'Lentille')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Homard', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('HuÃ®tre', 'Mollusque')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Jambon', 'Jambon')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Kiwi', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pois chiche', 'Lentille')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Huile d olive', 'Matière grasse')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Tahiné', 'Féculent')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Tomate', 'Pépins')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Oignon', 'Gousse')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Origan', 'Plante')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Sucre', 'Confiserie')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Spaghetti', 'Pâtes')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Parmesan', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Lasagne sèche', 'Pâtes')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Laurrier', 'Plante')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Abadèche', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Achigan', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Aiglefin', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Barramundi', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Dorade', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Doré', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Flétan', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Lotte', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Mahi-Mahi', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Merlan', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Merlu', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Mérou', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Morue', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Perche du Nil', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Rouget', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Saint-Pierre', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Sébaste', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Sole', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Turbot', 'Maigre')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bar', 'Mi-gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pangasius', 'Mi-gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Raie', 'Mi-gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Requin', 'Mi-gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Tilapia', 'Mi-gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Vivaneau', 'Mi-gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Channa', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Barbue', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Éperlan', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Esturgeon', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Maquereau', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Omble', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Opah', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Sardine', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Thon', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Truite', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Araignée de mer', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cigale de mer', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Étrille', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Langouste', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Langoustine', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Limule', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Crevette', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Tourteau', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Moule', 'Mollusque')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Poulpe', 'Crustacé')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Palourde', 'Mollusque')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bulot', 'Gastéropode')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Mangue', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Papaye', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Fruit de la passion', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Carambole', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Noix de cajou', 'Coques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Noix de coco', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Litchi', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Grenade', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Goyave', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Arbouse', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Aronia', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Canneberge', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cassis', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cranberry', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Framboise', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Goji', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('MÃ»re', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Myrtille', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Sureau noir', 'Rouges')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Lime', 'Agrumes')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pamplemousse', 'Agrumes')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Orange', 'Agrumes')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Mandarine', 'Agrumes')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pomme', 'Pépins')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Poire', 'Pépins')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Coing', 'Pépins')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pêche', 'Noyaux')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Prune', 'Noyaux')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Prunelle', 'Noyaux')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Noix', 'Coques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pistache', 'Coques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Noisette', 'Coques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Raisin', 'Pépins')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Kaki', 'Exotiques')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Anguille', 'Gras')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cantal', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Morbier', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Reblochon', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Saint-Nectaire', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Tomme', 'Pâte pressée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Mont d Or', 'Pâte molle')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Roquefort', 'Pâte persillée')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bollet', 'Champignon')");
        base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Asperge', 'Rhizome')");

        //base_de_donnees.execSQL("INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('', '')");
    }

    /*
    Crée une population de recette (l'utilisateur peut en ajouter)
     */
    private void population_recette(SQLiteDatabase base_de_donnees) {
        base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Poulet aux champignons', 10, 30, 4, 'Très bon repas passe partout', 'Moyen', 'Peu élevé', 'Plat', '13-07-17', 'System')");
        base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Hoummous', 15, 5, 3, 'Petit plat végétarien', 'Facile', 'Bon marché', 'Entrée', '13-07-17', 'System')");
        base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Spaghetti bolognaise', 20, 30, 4, 'Spaghetti classique avec une sauce faite maison', 'Facile', 'Bon marché', 'Plat', '13-07-17', 'System')");
        base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Lasagne sauce bolognaise', 25, 80, 6, 'Un classique en tout temps', 'Difficile', 'Elevé', 'Plat', '13-07-17', 'System')");
        base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Salade césar', 10, 0, 2, 'Une salade raffraichisante en été', 'Facile', 'Bon marché', 'Entrée', '13-07-17', 'System')");
        base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Tarte aux pommes', 30, 35, 8, 'Fameux dessert composé de pommes', 'Moyen', 'Bon marché', 'Dessert', '13-07-17', 'System')");
        base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Boulets à la Liégoise', 30, 60, 4, 'Plat traditionnel Liégois', 'Difficile', 'Peu élevé', 'Plat', '13-07-17', 'System')");
        base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Banana split', 0, 0, 4, 'Glace au chocolat et banane', 'Facile', 'Bon marché', 'Dessert', '13-07-17', 'System')");
        base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Lapin aux pruneaux', 25, 45, 4, 'Plat agréable en hiver', 'Moyen', 'Elevé', 'Plat', '13-07-17', 'System')");
        base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Soupe d orties', 10, 10, 6, 'Comment utiliser au mieux ces plantes qui piquent', 'Facile', 'Bon marché', 'Entrée', '13-07-17', 'System')");
        base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Crèpes', 10, 15, 4, 'A faire salé ou sucré', 'Facile', 'Bon marché', 'Dessert', '13-07-17', 'System')");

        //base_de_donnees.execSQL("INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('', , , , '', '', '', '', '', '')");
    }

    /*
    Crée une population contenant les ingrédients liés aux recettes (l'utilisateur peut en ajouter)
     */
    private void population_recette_ingredient(SQLiteDatabase base_de_donnees) {
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Poulet aux champignons', 'Poulet', '4 cuisses')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Poulet aux champignons', 'Champignons de Paris', '150 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Poulet aux champignons', 'Pomme de terre', '500 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Hoummous', 'Pois chiche', '800 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Hoummous', 'Citron', '2')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Hoummous', 'Huile d olive', '2 cuillières à soupe')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Hoummous', 'Tahiné', '3 cuillières à soupe')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Boeuf haché', '600 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Tomate', '800 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Oignon', '2')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Ail', '2')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Origan', '1 cuillière à soupe')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Sucre', '2')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Spaghetti', '400 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Lasagne sèche', '350 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Boeuf haché', '400 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Tomate', '1600 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Oignon', '2')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Carotte', '1')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Ail', '1')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Sucre', '1')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Huile d olive', '3 cuillières à soupe')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Parmesan', '60 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Beurre', '25 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Laurrier', '2')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Tarte aux pommes', 'Pomme', '6')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Tarte aux pommes', 'Pâte feuilletée', '1')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Tarte aux pommes', 'Sucre', '90 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Tarte aux pommes', 'Oeuf', '2')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Tarte aux pommes', 'Beurre', '60 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Bœuf haché', '1000 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Oeuf', '2')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Échalotte', '2')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Chapelure', '100 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Persil', '30 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Farine', '1 cuillière à soupe')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Cassonade', '1 cuillière à soupe')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Oignon', '2')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Sirop de Liège', '150 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Glace vanille', '250 ml')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Glace au chocolat', '250 ml')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Banane', '4')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Crème chatilly', '1')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Chocolat noir', '50 g')");
        base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Amande effilé', '4 cuillières à soupe')");

        //base_de_donnees.execSQL("INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('', '', '')");
    }

    /*
    Crée une population contenant les étapes liées aux recettes (l'utilisateur peut en ajouter)
     */
    private void population_recette_etape(SQLiteDatabase base_de_donnees) {
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', '1', 'Porter les pois chiches à  ébulition')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', '2', 'Eplucher les 2 gousses d ail')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', '3', 'Presser les citrons')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', '4', 'Enlever les pois chiches de l eau mais garder le jus de cuisson')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', '5', 'Ajouter le jus de citron, l huile d olive, le tahiné puis mixer pour obtenir une pâte homogène')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', '6', 'Ajouter le jus de cuisson petit à  petit pour obtenir une pâte moins compacte')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', '7', 'Mettre 2 heures au frigo')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Poulet aux champignons', '1', 'Nettoyer et émincer les champignons')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Poulet aux champignons', '2', 'Eplucher et émincer l oignon')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Poulet aux champignons', '3', 'Saisir les cuisses de poulet')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Poulet aux champignons', '4', 'Ajouter les oignons et les champignons')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Poulet aux champignons', '5', 'Laisser cuire le tout 5 min')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', '1', 'Faire chauffer l huile avec les oignons')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', '2', 'Ajouter l ail lorsque les oignons deviennent translucide')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', '3', 'Mettre les tomates dans la casserole et portez à  feu moyen')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', '4', 'Laisser mijoter 20 min')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', '5', 'Ajouter l origan, le sel et le poivre')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', '6', 'Baisser le feu pour faire réduire la sauce')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', '7', 'Faire cuire le boeuf dans une poêle après l avoir assaisonnée')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', '8', 'Mélanger la viande et la sauce puis mélangez le tout aux pâtes')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '1', 'Émincer les oignons, les gousses d ail, la carotte et le céleri')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '2', 'Faire revenir les gousses d ail et les oignons dans de l huile d olive')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '3', 'Ajouter la carotte et le céleri')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '4', 'Ajouter la viande et laisser cuire')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '5', 'Ajouter le vin rouge, la purée de tomate et les herbes')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '6', 'Laisser mijoter 45 minutes à  feu doux')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '7', 'Huiler le plat à  lasagne')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '8', 'Poser une couche de béchamel, la lasagne sèche, une couche de sauce bolognaise trois fois de suite')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '9', 'Recouvrir de parmersan et de noisettes de beure')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '10', 'Enfourner pendant 25 minutes dans un four préchauffé à  200°')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '1', 'Mettre la pâte feuilletée dans un plat à  tarte et la piquer avec une fourchette')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '2', 'Couper les pommes en lamelles')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '3', 'Garnir la pâte avec les lamelles de pommes')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '4', 'Mélanger le sucre, les oeufs et le beurre')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '5', 'Verser ce mélange sur les pommes')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '6', 'Enfourner au four pendant 35 minutes à  200°')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '1', 'Mélanger le haché, les oeufs, le percil et les échalottes hachées')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '2', 'Quand le mélange est homogène, ajouter la chapelure et mélanger à  nouveau')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '3', 'Former les boulettes de viande')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '4', 'Rouler ces boulettes dans la farine')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '5', 'Cuire les boulettes à  la poêle pendant 10 minutes')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '6', 'Émincer les oignons')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '7', 'Caraméliser les oignons avec la cassonade')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '8', 'Ajouter le sirop de Liège et mouiller avec 1/2 litre d eau')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '9', 'Laisser venir à  ébulittion puis ajouter les boulettes de viande')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '10', 'Laisser cuire à  couvert 1 heure à  feu doux')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '11', 'Lier la sauce avant de servir')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '1', 'Peler et couper les bananes en deux dans le sens de la longueur')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '2', 'Disposer les bananes dans la coupe')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '3', 'Disposer 3 boules de glace vanille chocolat sur les bananes')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '4', 'Faire fondre le chocolat dans un bain marie')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '5', 'Arroser la glace avec le chocolat fondu')");
        base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '6', 'Terminer les coupes avec de la crème chantilly')");

        //base_de_donnees.execSQL("INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '7', 'Parsemer d amande effilé')");
    }

    /*
    Crée une population contenant les reviews liées aux recettes (l'utilisateur peut en ajouter)
     */
    private void population_reviews(SQLiteDatabase base_de_donnees) {
        String review1;
        review1 = "INSERT INTO Reviews ('ridrecette', 'rlogin', 'rnote', 'rcommentaire') VALUES ('Poulet aux champignons', 'Martin', 4, 'Très bon')";
        base_de_donnees.execSQL(review1);
        String review2;
        review2 = "INSERT INTO Reviews ('ridrecette', 'rlogin', 'rnote', 'rcommentaire') VALUES ('Hoummous', 'Martin', 4, 'Très bon')";
        base_de_donnees.execSQL(review2);
        String review3;
        review3 = "INSERT INTO Reviews ('ridrecette', 'rlogin', 'rnote', 'rcommentaire') VALUES ('Spaghetti bolognaise', 'Martin', 5.0, 'Très bon')";
        base_de_donnees.execSQL(review3);
        String review4;
        review4 = "INSERT INTO Reviews ('ridrecette', 'rlogin', 'rnote', 'rcommentaire') VALUES ('Lasagne sauce bolognaise', 'Martin', 3.0, 'Très bon')";
        base_de_donnees.execSQL(review4);
        String review5;
        review5 = "INSERT INTO Reviews ('ridrecette', 'rlogin', 'rnote', 'rcommentaire') VALUES ('Salade césar', 'Martin', 2.0, 'Très bon')";
        base_de_donnees.execSQL(review5);
        String review6;
        review6 = "INSERT INTO Reviews ('ridrecette', 'rlogin', 'rnote', 'rcommentaire') VALUES ('Tarte aux pommes', 'Martin', 4.0, 'Très bon')";
        base_de_donnees.execSQL(review6);
        String review7;
        review7 = "INSERT INTO Reviews ('ridrecette', 'rlogin', 'rnote', 'rcommentaire') VALUES ('Boulets à la Liégoise', 'Martin', 3.5, 'Très bon')";
        base_de_donnees.execSQL(review7);
        String review8;
        review8 = "INSERT INTO Reviews ('ridrecette', 'rlogin', 'rnote', 'rcommentaire') VALUES ('Banana split', 'Martin', 2.5, 'Très bon')";
        base_de_donnees.execSQL(review8);
        String review9;
        review9 = "INSERT INTO Reviews ('ridrecette', 'rlogin', 'rnote', 'rcommentaire') VALUES ('Lapin aux pruneaux', 'Martin', 3.5, 'Très bon')";
        base_de_donnees.execSQL(review9);
        String review10;
        review10 = "INSERT INTO Reviews ('ridrecette', 'rlogin', 'rnote', 'rcommentaire') VALUES ('Soupe d orties', 'Martin', 4.0, 'Très bon')";
        base_de_donnees.execSQL(review10);
        String review11;
        review11 = "INSERT INTO Reviews ('ridrecette', 'rlogin', 'rnote', 'rcommentaire') VALUES ('Crèpes', 'Martin', 4.4, 'Très bon')";
        base_de_donnees.execSQL(review11);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            String Utilisateur = "DROP TABLE IF EXISTS Utilisateur";
            db.execSQL(Utilisateur);
            String Categories = "DROP TABLE IF EXISTS Categories";
            db.execSQL(Categories);
            String Ingredient = "DROP TABLE IF EXISTS Ingredients ";
            db.execSQL(Ingredient);
            String Recette = "DROP TABLE IF EXISTS Recette";
            db.execSQL(Recette);
            String RecetteIngredient = "DROP TABLE IF EXISTS Recetteingredient";
            db.execSQL(RecetteIngredient);
            String RecetteEtape = "DROP TABLE IF EXISTS Recetteetape";
            db.execSQL(RecetteEtape);
            String Reviews = "DROP TABLE IF EXISTS Reviews";
            db.execSQL(Reviews);

            onCreate(db);
        }
    }

    /*
    Fonction permettant d'aller chercher un utilisateur dans la db à partir de son login
    @pre : login != null
    @post : retourne un objetUtilisateur ayant login comme login
            retourne null si pas d'utilisateur trouvé
     */
    public objetUtilisateur getUserBylogin(String login){
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete = "SELECT * FROM Utilisateur WHERE login = '" + login + "';";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);

        if (cursor.moveToFirst()) {
            objetUtilisateur found = new objetUtilisateur(cursor.getString(0),
                    cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)),
                    Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), cursor.getString(6),
                    cursor.getString(7));

            cursor.close();
            return found;
        }
        else {
            cursor.close();
            return null;
        }
    }

    /*
    Fonction permettant d'ajouter un utilisateur dans la db à partir d'un objet utilisateur
    @pre : u != null
    @post : ajoute un utilisateur dans la db
     */
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

    /*
    Fonction permettant de supprimer un utilisateur de la db tout en gardant le contenu créé par cet utilisatueur
    @pre : login != null
    @post : supprimer l'utilisateur de la bd
     */
    public void deleteUserByLogin(String Login){
        SQLiteDatabase base_de_donnees = this.getWritableDatabase();
        String Requete =
                "DELETE FROM Utilisateur WHERE login = '" + Login + "' ;";
        base_de_donnees.execSQL(Requete);
        base_de_donnees.close();
    }

    /*
    Fonction permettant de modifier l'un des champs du user
    @pre : login = login de l'utilisateur, toModify = champs à modifier, newValue = nouvelle valeur pour le champs
    @post : modifie le champs toModify de l'utilisateur login avec la valeur newValue dans la db
     */
    public void modifierUser(String Login, String toModify, String newValue){
        SQLiteDatabase base_de_donnees = this.getWritableDatabase();
        String Requete =
                "UPDATE Utilisateur SET '" + toModify + "' = '" + newValue + "' WHERE login = '" + Login + "' ;";
        base_de_donnees.execSQL(Requete);
        base_de_donnees.close();

    }

    /*
    Fonction permettant d'avoir une ArrayList des utilisateurs ayant créé des recettes
    @pre : /
    @post : retourne une ArrayList d'auteur
     */
    public ArrayList<String> getAuteurs() {
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete = "SELECT DISTINCT auteur FROM Recette";
        ArrayList<String> auteurs = new ArrayList<>();
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);
        auteurs.add("N'importe");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            auteurs.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return auteurs;
    }


    /*
    Fonction permettant d'avoir un catalogue de recettes
    @pre : /
    @post : retourne une ArrayList avec toutes les recettes contenues dans la db
     */
    public ArrayList<String> getCatalogueRecette(){
            SQLiteDatabase base_de_donnees = this.getReadableDatabase();
            String Requete =
                    "SELECT DISTINCT nomR FROM Recette ORDER BY nomR";
            Cursor cursor = base_de_donnees.rawQuery(Requete, null);
            ArrayList<String> catalogueRecette = new ArrayList<>();
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                catalogueRecette.add(cursor.getString(cursor.getColumnIndex("nomR")));
                cursor.moveToNext();
            }
            cursor.close();
            return catalogueRecette;
    }

    /*
    Fonction permettant d'avoir un catalogue de recettes à partir d'un ingrédient de ces recettes
    @pre : ingredient != null
    @post : retourne une ArrayList avec toutes les recettes contenant l'ingrédient
     */
    public ArrayList<String> getCatalogueRecette(String ingredient){
            SQLiteDatabase base_de_donnees = this.getReadableDatabase();
            String Requete =
                    "SELECT DISTINCT riidrecette FROM Recetteingredient WHERE riingredient LIKE '%"+ingredient+"%'";
            Cursor cursor = base_de_donnees.rawQuery(Requete, null);
            ArrayList<String> catalogueRecette = new ArrayList<>();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                catalogueRecette.add(cursor.getString(cursor.getColumnIndex("riidrecette")));
                cursor.moveToNext();
            }
            cursor.close();
            return catalogueRecette;
    }

    /*
    Fonction permettant d'avoir un catalogue de recettes à partir des informations principales
    @pre : tprepmin, tprepmax, tcuissmin, tcuissmax, nbrcouv != null
    @post : retourne une ArrayList avec toutes les recettes respectant les critères
     */
    public ArrayList<String> getCatalogueRecette(String type, String difficulte, String cout, int tprepmin, int tprepmax, int tcuissmin, int tcuissmax, int nbrcouv, String auteur){
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete =
                "SELECT nomR FROM Recette WHERE type LIKE '%"+type+"%' AND difficulte LIKE '%"+difficulte+"%' AND cout LIKE '%"+cout+"%' AND tprep <= "+tprepmax+" AND tprep >= "+tprepmin+" AND tcuiss <= "+tcuissmax+" AND tcuiss >= "+tcuissmin+" AND ncouv == "+nbrcouv+" AND auteur LIKE '%"+auteur+"%'";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);
        ArrayList<String> catalogueRecette = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            catalogueRecette.add(cursor.getString(cursor.getColumnIndex("nomR")));
            cursor.moveToNext();
        }
        cursor.close();
        return catalogueRecette;
    }


    /*
    Fonction permettant d'avoir toutes les catégories
    @pre : /
    @post : retourne une ArrayList avec toutes les catégories de la base de donnée
     */
    public ArrayList<String> getAllCategorie() {
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        ArrayList<String> listeCategorie = new ArrayList<>();
        String Requete =
                "SELECT DISTINCT categorie FROM Categories ORDER BY categorie";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            listeCategorie.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return listeCategorie;
    }

    /*
    Fonction permettant d'avoir toutes les sous-catégories appartenent à une catégorie
    @pre : categorie != null
    @post : retourne une ArrayList avec toutes les sous-catégories de la catégorie donnée
     */
    public ArrayList<String> getSousCategorie(String categorie) {
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete =
                "SELECT souscategorie FROM Categories WHERE categorie = '"+categorie+"' ORDER BY souscategorie";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);
        ArrayList<String> listeSousCategorie = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            listeSousCategorie.add(cursor.getString(cursor.getColumnIndex("souscategorie")));
            cursor.moveToNext();
        }
        cursor.close();
        return listeSousCategorie;
    }

    /*
    Fonction permettant d'avoir tous les ingrédients appartenant à une sous-catégorie
    @pre : souscategorie != null
    @post : retourne une ArrayList avec tous les ingrédients de la sous-catégorie donnée
     */
    public ArrayList<String> getIngredient(String souscategorie){
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete =
                "SELECT ingredient FROM Ingredients WHERE isouscategorie = '"+souscategorie+"'";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);
        ArrayList<String> listeIngredient = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            listeIngredient.add(cursor.getString(cursor.getColumnIndex("ingredient")));
            cursor.moveToNext();
        }
        cursor.close();
        return listeIngredient;
    }


    /*
    Fonction permettant d'ajouter une recette dans la db à partir d'un objetRecette
    @pre : recetteaajouter != null
    @post : ajoute la recette dans la db
     */
    public void addRecette(objetRecette recetteaajouter){
        SQLiteDatabase base_de_donnees = this.getWritableDatabase();
        ContentValues recette = new ContentValues();
        recette.put("nomR",recetteaajouter.getNomrecette());
        recette.put("tprep",recetteaajouter.getTempspreparation());
        recette.put("tcuiss",recetteaajouter.getTempscuisson());
        recette.put("ncouv",recetteaajouter.getNombredecouvert());
        recette.put("description",recetteaajouter.getDescription());
        recette.put("difficulte",recetteaajouter.getDifficulte());
        recette.put("cout",recetteaajouter.getCout());
        recette.put("type",recetteaajouter.getType());
        recette.put("date",recetteaajouter.getDate());
        recette.put("auteur",recetteaajouter.getAuteur());
        base_de_donnees.insert("Recette", null, recette);
        base_de_donnees.close();
    }

    /*
    Fonction permettant de récupérer les informations d'une recette à partir de son nom
    @pre : nomrecette != null
    @post : retourne l'objetRecette ayant nomrecette comme nomR
            retourne null si la recette n'existe pas
     */
    public objetRecette getInfoRecette(String nomrecette) {
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete = "SELECT * FROM Recette WHERE nomR = '"+nomrecette+"'";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);
        if(cursor.moveToFirst()){
            objetRecette found = new objetRecette(cursor.getString(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9));
            cursor.close();
            return found;
        }
        else{
            objetRecette found = null;
            cursor.close();
            return found;
        }
    }

    /*
    Fonction permettant d'avoir l'ensemble des ingrédients d'une recette
    @pre : nomrecette , recette != null
    @post : ajoute les ingrédients de la recette à l'objetRecette
     */
    public void getIngredientsRecette(String nomrecette, objetRecette recette) {
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete = "SELECT riingredient, riquantite FROM Recetteingredient WHERE riidrecette ='"+nomrecette+"'";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);
        String y="";
        if (cursor.moveToFirst()){
            do{
                String s;
                String p;
                s=cursor.getString(0);
                p=cursor.getString(1);
                y=y+"    - "+s+" : "+p+"\n";
            }while (cursor.moveToNext());
        }
        cursor.close();
        recette.setListeingredients(y);

    }

    /*
    Fonction permettant d'avoir l'ensemble des étapes d'une recette
    @pre : nomrecette, recette !=null
    @post : ajoute les étapes de la recette à l'objetRecette
     */
    public void getEtapesRecette(String nomrecette, objetRecette recette) {
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete = "SELECT reetape FROM Recetteetape WHERE reidrecette ='"+nomrecette+"' ORDER BY renumero";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);
        String y="";
        if (cursor.moveToFirst()){
            do{
                String s;
                s=cursor.getString(0);
                y=y+"   - "+s+"\n";
            }while (cursor.moveToNext());
        }
        cursor.close();
        recette.setListeetapes(y);
    }

    /*
    Fonction permettant d'avoir la note moyenne d'une recette
    @pre : nomrecette, recette != null
    @post : ajoute la note moyenne de la recette à l'objetRecette
     */
    public void getRateRecette(String nomrecette, objetRecette recette) {
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete = "SELECT rnote FROM Reviews WHERE ridrecette ='"+nomrecette+"'";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);
        double somme=0;
        int nbre=0;
        double moyenne;
        if(cursor.moveToFirst()){
            do {
                somme = somme+cursor.getDouble(cursor.getColumnIndex("rnote"));
                nbre++;
            }while(cursor.moveToNext());
            moyenne = somme/nbre;
        }
        else{
            moyenne=0.0;
        }
        cursor.close();
        recette.setRate(moyenne);
    }

    /*
    Fonction permettant d'avoir l'ensemble des commentaires d'une recette
    @pre : nomrecette, recette != null
    @post : ajoute les commentaires de la recette à l'objetRecette
     */
    public void getCommentaireRecette(String nomrecette, objetRecette recette) {
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete = "SELECT rlogin, rcommentaire FROM Reviews WHERE ridrecette = '"+nomrecette+"'";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);
        String y="";
        if(cursor.moveToFirst()){
            do {
                y=y+"  - "+cursor.getString(0)+" : "+cursor.getString(1)+"\n";
            }while (cursor.moveToNext());
        }
        else {
            y="Pas encore de commentaire";
        }
        cursor.close();
        recette.setCommentaire(y);
    }


    /*
    Fonction permettant de vérifier si un ingrédient est présent dans la db
    @pre : ingredient != null
    @post : retourne l'objetIngredient si celui-ci est trouvé
            retourne null si l'ingrédient n'est pas dans la db
     */
    public objetIngredient verifIngredient(String ingredient) {
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete = "SELECT ingredient FROM Ingredients WHERE ingredient LIKE '%"+ingredient+"%'";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);

        if(cursor.moveToFirst()){
            objetIngredient found = new objetIngredient(cursor.getString(0));
            cursor.close();
            return found;
        }
        else{
            cursor.close();
            return null;
        }
    }

    /*
    Fonction permettant de vérifier si un ingrédient est déjà présent dans la liste d'ingrédient d'une recette
    @pre : ingredient, id != null
    @post : retourne l'objetIngredient si celui-ci est déjà présent
            retourne null si l'ingrédient n'est pas encore présent
     */
    public objetIngredient verif2Ingredient(String ingre, String id) {
        SQLiteDatabase base_de_donnees = this.getReadableDatabase();
        String Requete = "SELECT riingredient FROM Recetteingredient WHERE riingredient LIKE '%"+ingre+"%' AND riidrecette ='"+id+"'";
        Cursor cursor = base_de_donnees.rawQuery(Requete, null);

        if(cursor.moveToFirst()){
            objetIngredient found = new objetIngredient(cursor.getString(0));
            cursor.close();
            return found;
        }
        else{
            cursor.close();
            return null;
        }
    }


    /*
    Fonction permettant d'ajouter une review dans la db
    @pre : reviews != null
    @post : ajoute la review dans la db
     */
    public void addReviews(objetReview reviews){
        SQLiteDatabase base_de_donnees = this.getWritableDatabase();
        ContentValues review = new ContentValues();
        review.put("ridrecette", reviews.getID());
        review.put("rlogin", reviews.getUtilisateur());
        review.put("rnote", reviews.getRate());
        review.put("rcommentaire", reviews.getCommentaire());
        base_de_donnees.insert("Reviews", null, review);
        base_de_donnees.close();
    }

    /*
    Fonction permettant d'ajouter un ingrédient, sa quantité pour une recette donnée dans la db
    @pre : id, singredient, quantite != null
    @post : ajoute l'ingrédient et sa quantité à la recette id dans la db
     */
    public void addRecetteIngredient(String id, String singredient, String quantite){
        SQLiteDatabase base_de_donnees = this.getWritableDatabase();
        ContentValues ingredient = new ContentValues();
        ingredient.put("riidrecette", id);
        ingredient.put("riingredient", singredient);
        ingredient.put("riquantite", quantite);
        base_de_donnees.insert("Recetteingredient", null, ingredient);
        base_de_donnees.close();
    }

    /*
    Fonction permettant d'jouter une étape, son numéro pour une recette donnée dans la db
    @pre : id, numr, setape != null
    @post : ajoute l'étape et son numéro à la recette id dans la db
     */
    public void addRecetteEtape(String id, int numr, String setape){
        SQLiteDatabase base_de_donnees = this.getWritableDatabase();
        ContentValues etape = new ContentValues();
        etape.put("reidrecette", id);
        etape.put("renumero", numr);
        etape.put("reetape", setape);
        base_de_donnees.insert("Recetteetape", null, etape);
        base_de_donnees.close();


    }
}

