package be.lsinf1225.ezmealgroupee;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Gaetan on 03/07/2017.
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
        String Cate1;
        Cate1="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Viande','Blanche')";
        base_de_donnees.execSQL(Cate1);
        String Cate2;
        Cate2="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Viande','Rouge')";
        base_de_donnees.execSQL(Cate2);
        String Cate3;
        Cate3="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Viande','Volaille')";
        base_de_donnees.execSQL(Cate3);
        String Cate4;
        Cate4="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Viande','Gibier')";
        base_de_donnees.execSQL(Cate4);
        String Cate5;
        Cate5="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Viande','Abat')";
        base_de_donnees.execSQL(Cate5);

        String Cate6;
        Cate6="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Sauce','Blanche')";
        base_de_donnees.execSQL(Cate6);
        String Cate7;
        Cate7="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Sauce','Tomatée')";
        base_de_donnees.execSQL(Cate7);

        String Cate8;
        Cate8="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson','Gastéropode')";
        base_de_donnees.execSQL(Cate8);
        String Cate9;
        Cate9="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson','Gras')";
        base_de_donnees.execSQL(Cate9);
        String Cate10;
        Cate10="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson','Maigre')";
        base_de_donnees.execSQL(Cate10);
        String Cate11;
        Cate11="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson','Mi-Gras')";
        base_de_donnees.execSQL(Cate11);
        String Cate12;
        Cate12="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson','Crustacés')";
        base_de_donnees.execSQL(Cate12);
        String Cate13;
        Cate13="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Poisson','Mollusque')";
        base_de_donnees.execSQL(Cate13);

        String Cate14;
        Cate14="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume','Chou')";
        base_de_donnees.execSQL(Cate14);
        String Cate15;
        Cate15="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume','Lentille')";
        base_de_donnees.execSQL(Cate15);
        String Cate16;
        Cate16="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume','Feuille')";
        base_de_donnees.execSQL(Cate16);
        String Cate17;
        Cate17="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume','Cucurbitacé')";
        base_de_donnees.execSQL(Cate17);
        String Cate18;
        Cate18="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume','Rhizome')";
        base_de_donnees.execSQL(Cate18);
        String Cate19;
        Cate19="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume','Champignon')";
        base_de_donnees.execSQL(Cate19);
        String Cate20;
        Cate20="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume','Racine')";
        base_de_donnees.execSQL(Cate20);
        String Cate21;
        Cate21="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Légume','Vert')";
        base_de_donnees.execSQL(Cate21);

        String Cate22;
        Cate22="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Féculent','Féculent')";
        base_de_donnees.execSQL(Cate22);

        String Cate23;
        Cate23="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits','Autres')";
        base_de_donnees.execSQL(Cate23);
        String Cate24;
        Cate24="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits','Secs')";
        base_de_donnees.execSQL(Cate24);
        String Cate25;
        Cate25="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits','Rouges')";
        base_de_donnees.execSQL(Cate25);
        String Cate26;
        Cate26="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits','Agrumes')";
        base_de_donnees.execSQL(Cate26);
        String Cate27;
        Cate27="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits','Noyaux')";
        base_de_donnees.execSQL(Cate27);
        String Cate28;
        Cate28="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits','Pépins')";
        base_de_donnees.execSQL(Cate28);
        String Cate29;
        Cate29="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits','Exotiques')";
        base_de_donnees.execSQL(Cate29);
        String Cate30;
        Cate30="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fruits','Coques')";
        base_de_donnees.execSQL(Cate30);

        String Cate31;
        Cate31="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fromage','Chèvre')";
        base_de_donnees.execSQL(Cate31);
        String Cate32;
        Cate32="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fromage','Pâte persillée')";
        base_de_donnees.execSQL(Cate32);
        String Cate33;
        Cate33="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fromage','Pâte molle')";
        base_de_donnees.execSQL(Cate33);
        String Cate34;
        Cate34="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fromage','Pâte pressée')";
        base_de_donnees.execSQL(Cate34);
        String Cate35;
        Cate35="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Fromage','Frais')";
        base_de_donnees.execSQL(Cate35);

        String Cate36;
        Cate36="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Confiserie','Glace')";
        base_de_donnees.execSQL(Cate36);
        String Cate37;
        Cate37="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Confiserie','Massepain')";
        base_de_donnees.execSQL(Cate37);
        String Cate38;
        Cate38="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Confiserie','Chocolat')";
        base_de_donnees.execSQL(Cate38);
        String Cate39;
        Cate39="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Confiserie','Biscuit')";
        base_de_donnees.execSQL(Cate39);
        String Cate40;
        Cate40="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Confiserie','Bonbon')";
        base_de_donnees.execSQL(Cate40);

        String Cate41;
        Cate41="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment','Confit')";
        base_de_donnees.execSQL(Cate41);
        String Cate42;
        Cate42="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment','Épice')";
        base_de_donnees.execSQL(Cate42);
        String Cate43;
        Cate43="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment','Pâtes')";
        base_de_donnees.execSQL(Cate43);
        String Cate44;
        Cate44="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment','Gousse')";
        base_de_donnees.execSQL(Cate44);
        String Cate45;
        Cate45="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment','Plante')";
        base_de_donnees.execSQL(Cate45);
        String Cate46;
        Cate46="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment','Bulbe')";
        base_de_donnees.execSQL(Cate46);
        String Cate46bis;
        Cate46bis = "INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Condiment', 'Huile')";
        base_de_donnees.execSQL(Cate46bis);

        String Cate47;
        Cate47="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Charcuterie','Jambon')";
        base_de_donnees.execSQL(Cate47);
        String Cate48;
        Cate48="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Charcuterie','Saucisse')";
        base_de_donnees.execSQL(Cate48);
        String Cate49;
        Cate49="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Charcuterie','Haché')";
        base_de_donnees.execSQL(Cate49);

        String Cate50;
        Cate50="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson','Jus')";
        base_de_donnees.execSQL(Cate50);
        String Cate51;
        Cate51="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson','Sirop')";
        base_de_donnees.execSQL(Cate51);
        String Cate52;
        Cate52="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson','Vin rosé')";
        base_de_donnees.execSQL(Cate52);
        String Cate53;
        Cate53="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson','Vin rouge')";
        base_de_donnees.execSQL(Cate53);
        String Cate54;
        Cate54="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson','Vin blanc')";
        base_de_donnees.execSQL(Cate54);
        String Cate55;
        Cate55="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson','Alcool doux')";
        base_de_donnees.execSQL(Cate55);
        String Cate56;
        Cate56="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson','Alcool fort')";
        base_de_donnees.execSQL(Cate56);
        String Cate57;
        Cate57="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson','Soda')";
        base_de_donnees.execSQL(Cate57);
        String Cate58;
        Cate58="INSERT INTO Categories ('categorie', 'souscategorie') VALUES ('Boisson','Eau')";
        base_de_donnees.execSQL(Cate58);
    }

    /*
    Crée une population d'ingrédient (non-modifiable par l'utilisateur)
     */
    private void population_ingredient(SQLiteDatabase base_de_donnees) {
        String ingredient1;
        String ingredient2;
        String ingredient3;
        String ingredient4;
        String ingredient5;
        String ingredient6;
        String ingredient7;
        String ingredient8;
        String ingredient9;
        String ingredient10;
        String ingredient11;
        String ingredient12;
        String ingredient13;
        String ingredient14;
        String ingredient15;
        String ingredient16;
        String ingredient17;
        String ingredient18;
        String ingredient19;
        String ingredient20;
        String ingredient21;
        String ingredient22;
        String ingredient23;
        String ingredient24;
        String ingredient25;
        String ingredient26;
        String ingredient27;
        String ingredient28;
        String ingredient29;
        String ingredient30;
        String ingredient31;
        String ingredient32;
        String ingredient33;
        String ingredient34;
        String ingredient35;
        String ingredient36;
        String ingredient37;
        String ingredient38;
        String ingredient39;
        String ingredient40;
        String ingredient41;
        String ingredient42;
        String ingredient43;
        String ingredient44;
        String ingredient45;
        String ingredient46;
        String ingredient47;
        String ingredient48;
        String ingredient49;
        String ingredient50;
        String ingredient51;
        String ingredient52;
        String ingredient53;
        String ingredient54;
        String ingredient55;
        String ingredient56;
        String ingredient57;
        String ingredient58;
        String ingredient59;
        String ingredient60;
        String ingredient61;
        String ingredient62;
        String ingredient63;
        String ingredient64;
        String ingredient65;
        String ingredient66;
        String ingredient67;
        String ingredient68;
        String ingredient69;
        String ingredient70;
        String ingredient71;
        String ingredient72;
        String ingredient73;
        String ingredient74;
        String ingredient75;
        String ingredient76;
        String ingredient77;
        String ingredient78;
        String ingredient79;
        String ingredient80;
        String ingredient81;
        String ingredient82;
        String ingredient83;
        String ingredient84;
        String ingredient85;
        String ingredient86;
        String ingredient87;
        String ingredient88;
        String ingredient89;
        String ingredient90;
        String ingredient91;
        String ingredient92;
        String ingredient93;
        String ingredient94;
        String ingredient95;
        String ingredient96;
        String ingredient97;
        String ingredient98;
        String ingredient99;
        String ingredient100;
        String ingredient101;
        String ingredient102;
        String ingredient103;
        String ingredient104;
        String ingredient105;
        String ingredient106;
        String ingredient107;
        String ingredient108;
        String ingredient109;
        String ingredient110;
        String ingredient111;
        String ingredient112;
        String ingredient113;
        String ingredient114;
        String ingredient115;
        String ingredient116;
        String ingredient117;
        String ingredient118;
        String ingredient119;
        String ingredient120;
        String ingredient121;
        String ingredient122;
        String ingredient123;
        String ingredient124;
        String ingredient125;
        String ingredient126;
        String ingredient127;
        String ingredient128;
        String ingredient129;
        String ingredient130;
        String ingredient131;
        String ingredient132;
        String ingredient133;
        String ingredient134;
        String ingredient135;
        String ingredient136;
        String ingredient137;
        String ingredient138;
        String ingredient139;
        String ingredient140;
        String ingredient141;
        String ingredient142;
        String ingredient143;
        String ingredient144;
        String ingredient145;
        String ingredient146;
        String ingredient147;
        String ingredient148;
        String ingredient149;
        String ingredient150;
        String ingredient151;
        String ingredient152;
        String ingredient153;
        String ingredient154;
        String ingredient155;
        String ingredient156;
        String ingredient157;
        String ingredient158;
        String ingredient159;
        String ingredient160;
        String ingredient161;
        String ingredient162;
        String ingredient163;
        String ingredient164;
        String ingredient165;
        String ingredient166;
        String ingredient167;
        String ingredient168;
        String ingredient169;
        String ingredient170;
        String ingredient171;
        String ingredient172;
        String ingredient173;
        String ingredient174;
        String ingredient175;
        String ingredient176;
        String ingredient177;
        String ingredient178;
        String ingredient179;
        String ingredient180;
        String ingredient181;
        String ingredient182;
        String ingredient183;
        String ingredient184;
        String ingredient185;
        String ingredient186;
        String ingredient187;
        String ingredient188;
        String ingredient189;
        String ingredient190;
        String ingredient191;
        String ingredient192;
        String ingredient193;
        String ingredient194;
        String ingredient195;
        String ingredient196;
        String ingredient197;
        String ingredient198;
        String ingredient199;
        String ingredient200;
        String ingredient201;
        String ingredient202;
        String ingredient203;
        String ingredient204;
        String ingredient205;
        String ingredient206;
        String ingredient207;
        String ingredient208;
        String ingredient209;
        String ingredient210;
        String ingredient211;
        String ingredient212;
        String ingredient213;
        String ingredient214;
        String ingredient215;
        String ingredient216;
        String ingredient217;
        String ingredient218;
        String ingredient219;
        String ingredient220;
        String ingredient221;
        String ingredient222;
        String ingredient223;
        String ingredient224;

        ingredient1 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boulette', 'Haché')";
        ingredient2 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Carotte', 'Racine')";
        ingredient3 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Fraise', 'Rouges')";
        ingredient4 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Poulet', 'Volaille')";
        ingredient5 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Plie', 'Maigre')";
        ingredient6 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Saumon', 'Gras')";
        ingredient7 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Champignons de Paris', 'Champignon')";
        ingredient8 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pomme de terre', 'Féculent')";
        ingredient9 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Abricot', 'Noyaux')";
        ingredient10 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Agneau', 'Rouge')";
        ingredient11 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Ail', 'Gousse')";
        ingredient12 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Airelle', 'Rouges')";
        ingredient13 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Algue', 'Vert')";
        ingredient14 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Amande', 'Coques')";
        ingredient15 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Ananas', 'Exotiques')";
        ingredient16 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Anchois', 'Gras')";
        ingredient17 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Andouillette', 'Saucisse')";
        ingredient18 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Artichaut', 'Vert')";
        ingredient19 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Asperge blanche', 'Rhizome')";
        ingredient20 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Asperge verte', 'Rhizome')";
        ingredient21 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Aubergine', 'Cucurbitacé')";
        ingredient22 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Autruche', 'Volaille')";
        ingredient23 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Avocat', 'Noyaux')";
        ingredient24 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bacon', 'Jambon')";
        ingredient25 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Banane', 'Exotiques')";
        ingredient26 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Basilic', 'Plante')";
        ingredient27 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Béchamel', 'Sauce blanche')";
        ingredient28 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Beaufort', 'Pâte pressée')";
        ingredient29 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Betterave', 'Racine')";
        ingredient30 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Beurre', 'Matière grasse')";
        ingredient31 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Biche', 'Gibier')";
        ingredient32 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bifteck', 'Rouge')";
        ingredient33 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bigorneau', 'Gastéropode')";
        ingredient34 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Blé', 'Féculent')";
        ingredient35 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bleu d Auvergne', 'Pâte persillée')";
        ingredient36 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bolognaise', 'Sauce Tomatée')";
        ingredient37 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boudin blanc', 'Saucisse')";
        ingredient38 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boudin noir', 'Saucisse')";
        ingredient39 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boulgour', 'Féculent')";
        ingredient40 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boursin', 'Frais')";
        ingredient41 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Céléri', 'Feuille')";
        ingredient42 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bresse Bleu', 'Pâte persillée')";
        ingredient43 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Brie', 'Pâte molle')";
        ingredient44 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Brochet', 'Mi-gras')";
        ingredient45 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Brocoli', 'Chou')";
        ingredient46 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boeuf haché', 'Rouge')";
        ingredient47 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Boeuf', 'Rouge')";
        ingredient48 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cabillaud', 'Maigre')";
        ingredient49 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cacahuète', 'Coques')";
        ingredient50 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cacao', 'Exotiques')";
        ingredient51 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Caille', 'Volaille')";
        ingredient52 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Calamar', 'Crustacé')";
        ingredient53 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Camembert', 'Pâte molle')";
        ingredient54 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Canard', 'Volaille')";
        ingredient55 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cannelle', 'Épice')";
        ingredient56 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Capellini', 'Pâtes')";
        ingredient57 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Caprice des Anges', 'Pâte molle')";
        ingredient58 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Caprice des Dieux', 'Pâte molle')";
        ingredient59 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Carambar', 'Bonbon')";
        ingredient60 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Caramel', 'Bonbon')";
        ingredient61 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Caviar', 'Crustacé')";
        ingredient62 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cèpe', 'Champignon')";
        ingredient63 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cerfeuil', 'Feuille')";
        ingredient64 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cerise', 'Rouges')";
        ingredient65 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chataigne', 'Coques')";
        ingredient66 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cheddar', 'Pâte pressée')";
        ingredient67 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chèvre', 'Chèvre')";
        ingredient68 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chevreuil', 'Gibier')";
        ingredient69 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chocolat noir', 'Chocolat')";
        ingredient70 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chocolat blanc', 'Chocolat')";
        ingredient71 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chocolat au lait', 'Chocolat')";
        ingredient72 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chocolat praliné', 'Chocolat')";
        ingredient73 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chorizo', 'Salami')";
        ingredient74 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chou Blanc', 'Chou')";
        ingredient75 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chou de Bruxelles', 'Chou')";
        ingredient76 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chou Rouge', 'Chou')";
        ingredient77 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Chou Fleur', 'Chou')";
        ingredient78 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Choucroute', 'Chou')";
        ingredient79 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Ciboulette', 'Plante')";
        ingredient80 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Citron', 'Agrumes')";
        ingredient81 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Citrouille', 'Cucurbitacé')";
        ingredient82 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Clémentine', 'Agrumes')";
        ingredient83 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Clou de Girofle', 'Épice')";
        ingredient84 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cochon', 'Blanche')";
        ingredient85 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Colin', 'Maigre')";
        ingredient86 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Comté', 'Pâte pressée')";
        ingredient87 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Confit d oignon', 'Confit')";
        ingredient88 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Concombre', 'Cucurbitacé')";
        ingredient89 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Coppa', 'Jambon')";
        ingredient90 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Coq', 'Volaille')";
        ingredient91 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Coquille St-Jacques', 'Mollusque')";
        ingredient92 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cornichon', 'Cucurbitacé')";
        ingredient93 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Courgette', 'Cucurbitacé')";
        ingredient94 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Crabe', 'Crustacé')";
        ingredient95 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Crevette Grise', 'Crustacé')";
        ingredient96 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Crevette Rose', 'Crustacé')";
        ingredient97 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Datte', 'Exotiques')";
        ingredient98 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Dinde', 'Volaille')";
        ingredient99 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Échalote', 'Gousse')";
        ingredient100 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Écrevisse', 'Crustacé')";
        ingredient101 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Emmental', 'Pâte pressée')";
        ingredient102 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Endive', 'Racine')";
        ingredient103 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Épinard', 'Vert')";
        ingredient104 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Escargot', 'Gastéropode')";
        ingredient105 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Espadon', 'Mi-gras')";
        ingredient106 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Faisan', 'Gibier')";
        ingredient107 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Figue', 'Exotiques')";
        ingredient108 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Flageolet', 'Lentille')";
        ingredient109 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Fourme d Ambert', 'Pâte persillée')";
        ingredient110 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Gambas', 'Crustacé')";
        ingredient111 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Gingembre', 'Épice')";
        ingredient112 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Gorgonzola', 'Pâte persillée')";
        ingredient113 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Gouda', 'Pâte pressée')";
        ingredient114 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Groseille', 'Rouges')";
        ingredient115 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Guacamole', 'Sauce')";
        ingredient116 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Hareng', 'Gras')";
        ingredient117 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Haricot', 'Lentille')";
        ingredient118 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Homard', 'Crustacé')";
        ingredient119 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('HuÃ®tre', 'Mollusque')";
        ingredient120 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Jambon', 'Jambon')";
        ingredient121 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Kiwi', 'Exotiques')";
        ingredient122 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pois chiche', 'Lentille')";
        ingredient123 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Huile d olive', 'Matière grasse')";
        ingredient124 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Tahiné', 'Féculent')";
        ingredient125 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Tomate', 'Pépins')";
        ingredient126 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Oignon', 'Gousse')";
        ingredient127 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Origan', 'Plante')";
        ingredient128 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Sucre', 'Confiserie')";
        ingredient129 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Spaghetti', 'Pâtes')";
        ingredient130 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Parmesan', 'Pâte pressée')";
        ingredient131 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Lasagne sèche', 'Pâtes')";
        ingredient132 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Laurrier', 'Plante')";
        ingredient133 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Abadèche', 'Maigre')";
        ingredient134 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Achigan', 'Maigre')";
        ingredient135 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Aiglefin', 'Maigre')";
        ingredient136 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Barramundi', 'Maigre')";
        ingredient137 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Dorade', 'Maigre')";
        ingredient138 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Doré', 'Maigre')";
        ingredient139 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Flétan', 'Maigre')";
        ingredient140 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Lotte', 'Maigre')";
        ingredient141 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Mahi-Mahi', 'Maigre')";
        ingredient142 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Merlan', 'Maigre')";
        ingredient143 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Merlu', 'Maigre')";
        ingredient144 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Mérou', 'Maigre')";
        ingredient145 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Morue', 'Maigre')";
        ingredient146 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Perche du Nil', 'Maigre')";
        ingredient147 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Rouget', 'Maigre')";
        ingredient148 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Saint-Pierre', 'Maigre')";
        ingredient149 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Sébaste', 'Maigre')";
        ingredient150 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Sole', 'Maigre')";
        ingredient151 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Turbot', 'Maigre')";
        ingredient152 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bar', 'Mi-gras')";
        ingredient153 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pangasius', 'Mi-gras')";
        ingredient154 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Raie', 'Mi-gras')";
        ingredient155 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Requin', 'Mi-gras')";
        ingredient156 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Tilapia', 'Mi-gras')";
        ingredient157 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Vivaneau', 'Mi-gras')";
        ingredient158 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Channa', 'Gras')";
        ingredient159 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Barbue', 'Gras')";
        ingredient160 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Éperlan', 'Gras')";
        ingredient161 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Esturgeon', 'Gras')";
        ingredient162 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Maquereau', 'Gras')";
        ingredient163 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Omble', 'Gras')";
        ingredient164 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Opah', 'Gras')";
        ingredient165 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Sardine', 'Gras')";
        ingredient166 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Thon', 'Gras')";
        ingredient167 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Truite', 'Gras')";
        ingredient168 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Araignée de mer', 'Crustacé')";
        ingredient169 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cigale de mer', 'Crustacé')";
        ingredient170 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Étrille', 'Crustacé')";
        ingredient171 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Langouste', 'Crustacé')";
        ingredient172 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Langoustine', 'Crustacé')";
        ingredient173 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Limule', 'Crustacé')";
        ingredient174 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Crevette', 'Crustacé')";
        ingredient175 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Tourteau', 'Crustacé')";
        ingredient176 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Moule', 'Mollusque')";
        ingredient177 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Poulpe', 'Crustacé')";
        ingredient178 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Palourde', 'Mollusque')";
        ingredient179 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bulot', 'Gastéropode')";
        ingredient180 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Mangue', 'Exotiques')";
        ingredient181 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Papaye', 'Exotiques')";
        ingredient182 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Fruit de la passion', 'Exotiques')";
        ingredient183 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Carambole', 'Exotiques')";
        ingredient184 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Noix de cajou', 'Coques')";
        ingredient185 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Noix de coco', 'Exotiques')";
        ingredient186 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Litchi', 'Exotiques')";
        ingredient187 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Grenade', 'Exotiques')";
        ingredient188 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Goyave', 'Exotiques')";
        ingredient189 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Arbouse', 'Rouges')";
        ingredient190 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Aronia', 'Rouges')";
        ingredient191 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Canneberge', 'Rouges')";
        ingredient192 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cassis', 'Rouges')";
        ingredient193 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cranberry', 'Rouges')";
        ingredient194 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Framboise', 'Rouges')";
        ingredient195 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Goji', 'Rouges')";
        ingredient196 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('MÃ»re', 'Rouges')";
        ingredient197 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Myrtille', 'Rouges')";
        ingredient198 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Sureau noir', 'Rouges')";
        ingredient199 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Lime', 'Agrumes')";
        ingredient200 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pamplemousse', 'Agrumes')";
        ingredient201 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Orange', 'Agrumes')";
        ingredient202 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Mandarine', 'Agrumes')";
        ingredient203 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pomme', 'Pépins')";
        ingredient204 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Poire', 'Pépins')";
        ingredient205 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Coing', 'Pépins')";
        ingredient206 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pêche', 'Noyaux')";
        ingredient207 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Prune', 'Noyaux')";
        ingredient208 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Prunelle', 'Noyaux')";
        ingredient209 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Noix', 'Coques')";
        ingredient210 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Pistache', 'Coques')";
        ingredient211 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Noisette', 'Coques')";
        ingredient212 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Raisin', 'Pépins')";
        ingredient213 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Kaki', 'Exotiques')";
        ingredient214 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Anguille', 'Gras')";
        ingredient215 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Cantal', 'Pâte pressée')";
        ingredient216 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Morbier', 'Pâte pressée')";
        ingredient217 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Reblochon', 'Pâte pressée')";
        ingredient218 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Saint-Nectaire', 'Pâte pressée')";
        ingredient219 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Tomme', 'Pâte pressée')";
        ingredient220 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Mont d Or', 'Pâte molle')";
        ingredient221 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Roquefort', 'Pâte persillée')";
        ingredient222 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Bollet', 'Champignon')";
        ingredient223 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Asperge', 'Rhizome')";
        ingredient224 = "INSERT INTO Ingredients ('ingredient', 'isouscategorie') VALUES ('Sucre', 'Bonbon')";

        base_de_donnees.execSQL(ingredient1);
        base_de_donnees.execSQL(ingredient2);
        base_de_donnees.execSQL(ingredient3);
        base_de_donnees.execSQL(ingredient4);
        base_de_donnees.execSQL(ingredient5);
        base_de_donnees.execSQL(ingredient6);
        base_de_donnees.execSQL(ingredient7);
        base_de_donnees.execSQL(ingredient8);
        base_de_donnees.execSQL(ingredient9);
        base_de_donnees.execSQL(ingredient10);
        base_de_donnees.execSQL(ingredient11);
        base_de_donnees.execSQL(ingredient12);
        base_de_donnees.execSQL(ingredient13);
        base_de_donnees.execSQL(ingredient14);
        base_de_donnees.execSQL(ingredient15);
        base_de_donnees.execSQL(ingredient16);
        base_de_donnees.execSQL(ingredient17);
        base_de_donnees.execSQL(ingredient18);
        base_de_donnees.execSQL(ingredient19);
        base_de_donnees.execSQL(ingredient20);
        base_de_donnees.execSQL(ingredient21);
        base_de_donnees.execSQL(ingredient22);
        base_de_donnees.execSQL(ingredient23);
        base_de_donnees.execSQL(ingredient24);
        base_de_donnees.execSQL(ingredient25);
        base_de_donnees.execSQL(ingredient26);
        base_de_donnees.execSQL(ingredient27);
        base_de_donnees.execSQL(ingredient28);
        base_de_donnees.execSQL(ingredient29);
        base_de_donnees.execSQL(ingredient30);
        base_de_donnees.execSQL(ingredient31);
        base_de_donnees.execSQL(ingredient32);
        base_de_donnees.execSQL(ingredient33);
        base_de_donnees.execSQL(ingredient34);
        base_de_donnees.execSQL(ingredient35);
        base_de_donnees.execSQL(ingredient36);
        base_de_donnees.execSQL(ingredient37);
        base_de_donnees.execSQL(ingredient38);
        base_de_donnees.execSQL(ingredient39);
        base_de_donnees.execSQL(ingredient40);
        base_de_donnees.execSQL(ingredient41);
        base_de_donnees.execSQL(ingredient42);
        base_de_donnees.execSQL(ingredient43);
        base_de_donnees.execSQL(ingredient44);
        base_de_donnees.execSQL(ingredient45);
        base_de_donnees.execSQL(ingredient46);
        base_de_donnees.execSQL(ingredient47);
        base_de_donnees.execSQL(ingredient48);
        base_de_donnees.execSQL(ingredient49);
        base_de_donnees.execSQL(ingredient50);
        base_de_donnees.execSQL(ingredient51);
        base_de_donnees.execSQL(ingredient52);
        base_de_donnees.execSQL(ingredient53);
        base_de_donnees.execSQL(ingredient54);
        base_de_donnees.execSQL(ingredient55);
        base_de_donnees.execSQL(ingredient56);
        base_de_donnees.execSQL(ingredient57);
        base_de_donnees.execSQL(ingredient58);
        base_de_donnees.execSQL(ingredient59);
        base_de_donnees.execSQL(ingredient60);
        base_de_donnees.execSQL(ingredient61);
        base_de_donnees.execSQL(ingredient62);
        base_de_donnees.execSQL(ingredient63);
        base_de_donnees.execSQL(ingredient64);
        base_de_donnees.execSQL(ingredient65);
        base_de_donnees.execSQL(ingredient66);
        base_de_donnees.execSQL(ingredient67);
        base_de_donnees.execSQL(ingredient68);
        base_de_donnees.execSQL(ingredient69);
        base_de_donnees.execSQL(ingredient70);
        base_de_donnees.execSQL(ingredient71);
        base_de_donnees.execSQL(ingredient72);
        base_de_donnees.execSQL(ingredient73);
        base_de_donnees.execSQL(ingredient74);
        base_de_donnees.execSQL(ingredient75);
        base_de_donnees.execSQL(ingredient76);
        base_de_donnees.execSQL(ingredient77);
        base_de_donnees.execSQL(ingredient78);
        base_de_donnees.execSQL(ingredient79);
        base_de_donnees.execSQL(ingredient80);
        base_de_donnees.execSQL(ingredient81);
        base_de_donnees.execSQL(ingredient82);
        base_de_donnees.execSQL(ingredient83);
        base_de_donnees.execSQL(ingredient84);
        base_de_donnees.execSQL(ingredient85);
        base_de_donnees.execSQL(ingredient86);
        base_de_donnees.execSQL(ingredient87);
        base_de_donnees.execSQL(ingredient88);
        base_de_donnees.execSQL(ingredient89);
        base_de_donnees.execSQL(ingredient90);
        base_de_donnees.execSQL(ingredient91);
        base_de_donnees.execSQL(ingredient92);
        base_de_donnees.execSQL(ingredient93);
        base_de_donnees.execSQL(ingredient94);
        base_de_donnees.execSQL(ingredient95);
        base_de_donnees.execSQL(ingredient96);
        base_de_donnees.execSQL(ingredient97);
        base_de_donnees.execSQL(ingredient98);
        base_de_donnees.execSQL(ingredient99);
        base_de_donnees.execSQL(ingredient100);
        base_de_donnees.execSQL(ingredient101);
        base_de_donnees.execSQL(ingredient102);
        base_de_donnees.execSQL(ingredient103);
        base_de_donnees.execSQL(ingredient104);
        base_de_donnees.execSQL(ingredient105);
        base_de_donnees.execSQL(ingredient106);
        base_de_donnees.execSQL(ingredient107);
        base_de_donnees.execSQL(ingredient108);
        base_de_donnees.execSQL(ingredient109);
        base_de_donnees.execSQL(ingredient110);
        base_de_donnees.execSQL(ingredient111);
        base_de_donnees.execSQL(ingredient112);
        base_de_donnees.execSQL(ingredient113);
        base_de_donnees.execSQL(ingredient114);
        base_de_donnees.execSQL(ingredient115);
        base_de_donnees.execSQL(ingredient116);
        base_de_donnees.execSQL(ingredient117);
        base_de_donnees.execSQL(ingredient118);
        base_de_donnees.execSQL(ingredient119);
        base_de_donnees.execSQL(ingredient120);
        base_de_donnees.execSQL(ingredient121);
        base_de_donnees.execSQL(ingredient122);
        base_de_donnees.execSQL(ingredient123);
        base_de_donnees.execSQL(ingredient124);
        base_de_donnees.execSQL(ingredient125);
        base_de_donnees.execSQL(ingredient126);
        base_de_donnees.execSQL(ingredient127);
        base_de_donnees.execSQL(ingredient128);
        base_de_donnees.execSQL(ingredient129);
        base_de_donnees.execSQL(ingredient130);
        base_de_donnees.execSQL(ingredient131);
        base_de_donnees.execSQL(ingredient132);
        base_de_donnees.execSQL(ingredient133);
        base_de_donnees.execSQL(ingredient134);
        base_de_donnees.execSQL(ingredient135);
        base_de_donnees.execSQL(ingredient136);
        base_de_donnees.execSQL(ingredient137);
        base_de_donnees.execSQL(ingredient138);
        base_de_donnees.execSQL(ingredient139);
        base_de_donnees.execSQL(ingredient140);
        base_de_donnees.execSQL(ingredient141);
        base_de_donnees.execSQL(ingredient142);
        base_de_donnees.execSQL(ingredient143);
        base_de_donnees.execSQL(ingredient144);
        base_de_donnees.execSQL(ingredient145);
        base_de_donnees.execSQL(ingredient146);
        base_de_donnees.execSQL(ingredient147);
        base_de_donnees.execSQL(ingredient148);
        base_de_donnees.execSQL(ingredient149);
        base_de_donnees.execSQL(ingredient150);
        base_de_donnees.execSQL(ingredient151);
        base_de_donnees.execSQL(ingredient152);
        base_de_donnees.execSQL(ingredient153);
        base_de_donnees.execSQL(ingredient154);
        base_de_donnees.execSQL(ingredient155);
        base_de_donnees.execSQL(ingredient156);
        base_de_donnees.execSQL(ingredient157);
        base_de_donnees.execSQL(ingredient158);
        base_de_donnees.execSQL(ingredient159);
        base_de_donnees.execSQL(ingredient160);
        base_de_donnees.execSQL(ingredient161);
        base_de_donnees.execSQL(ingredient162);
        base_de_donnees.execSQL(ingredient163);
        base_de_donnees.execSQL(ingredient164);
        base_de_donnees.execSQL(ingredient165);
        base_de_donnees.execSQL(ingredient166);
        base_de_donnees.execSQL(ingredient167);
        base_de_donnees.execSQL(ingredient168);
        base_de_donnees.execSQL(ingredient169);
        base_de_donnees.execSQL(ingredient170);
        base_de_donnees.execSQL(ingredient171);
        base_de_donnees.execSQL(ingredient172);
        base_de_donnees.execSQL(ingredient173);
        base_de_donnees.execSQL(ingredient174);
        base_de_donnees.execSQL(ingredient175);
        base_de_donnees.execSQL(ingredient176);
        base_de_donnees.execSQL(ingredient177);
        base_de_donnees.execSQL(ingredient178);
        base_de_donnees.execSQL(ingredient179);
        base_de_donnees.execSQL(ingredient180);
        base_de_donnees.execSQL(ingredient181);
        base_de_donnees.execSQL(ingredient182);
        base_de_donnees.execSQL(ingredient183);
        base_de_donnees.execSQL(ingredient184);
        base_de_donnees.execSQL(ingredient185);
        base_de_donnees.execSQL(ingredient186);
        base_de_donnees.execSQL(ingredient187);
        base_de_donnees.execSQL(ingredient188);
        base_de_donnees.execSQL(ingredient189);
        base_de_donnees.execSQL(ingredient190);
        base_de_donnees.execSQL(ingredient191);
        base_de_donnees.execSQL(ingredient192);
        base_de_donnees.execSQL(ingredient193);
        base_de_donnees.execSQL(ingredient194);
        base_de_donnees.execSQL(ingredient195);
        base_de_donnees.execSQL(ingredient196);
        base_de_donnees.execSQL(ingredient197);
        base_de_donnees.execSQL(ingredient198);
        base_de_donnees.execSQL(ingredient199);
        base_de_donnees.execSQL(ingredient200);
        base_de_donnees.execSQL(ingredient201);
        base_de_donnees.execSQL(ingredient202);
        base_de_donnees.execSQL(ingredient203);
        base_de_donnees.execSQL(ingredient204);
        base_de_donnees.execSQL(ingredient205);
        base_de_donnees.execSQL(ingredient206);
        base_de_donnees.execSQL(ingredient207);
        base_de_donnees.execSQL(ingredient208);
        base_de_donnees.execSQL(ingredient209);
        base_de_donnees.execSQL(ingredient210);
        base_de_donnees.execSQL(ingredient211);
        base_de_donnees.execSQL(ingredient212);
        base_de_donnees.execSQL(ingredient213);
        base_de_donnees.execSQL(ingredient214);
        base_de_donnees.execSQL(ingredient215);
        base_de_donnees.execSQL(ingredient216);
        base_de_donnees.execSQL(ingredient217);
        base_de_donnees.execSQL(ingredient218);
        base_de_donnees.execSQL(ingredient219);
        base_de_donnees.execSQL(ingredient220);
        base_de_donnees.execSQL(ingredient221);
        base_de_donnees.execSQL(ingredient222);
        base_de_donnees.execSQL(ingredient223);
        base_de_donnees.execSQL(ingredient224);
    }

    /*
    Crée une population de recette (l'utilisateur peut en ajouter)
     */
    private void population_recette(SQLiteDatabase base_de_donnees) {
        String recette1;
        recette1 = "INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Poulet aux champignons', 10, 30, 4, 'Très bon repas passe partout', 'Moyen', 'Peu élevé', 'Plat', '13-07-17', 'System')";
        base_de_donnees.execSQL(recette1);
        String recette2;
        recette2 = "INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Hoummous', 15, 5, 3, 'Petit plat végétarien', 'Facile', 'Bon marché', 'Entrée', '13-07-17', 'System')";
        base_de_donnees.execSQL(recette2);
        String recette3;
        recette3 = "INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Spaghetti bolognaise', 20, 30, 4, 'Spaghetti classique avec une sauce faite maison', 'Facile', 'Bon marché', 'Plat', '13-07-17', 'System')";
        base_de_donnees.execSQL(recette3);
        String recette4;
        recette4 = "INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Lasagne sauce bolognaise', 25, 80, 6, 'Un classique en tout temps', 'Difficile', 'Elevé', 'Plat', '13-07-17', 'System')";
        base_de_donnees.execSQL(recette4);
        String recette5;
        recette5 = "INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Salade césar', 10, 0, 2, 'Une salade raffraichisante en été', 'Facile', 'Bon marché', 'Entrée', '13-07-17', 'System')";
        base_de_donnees.execSQL(recette5);
        String recette6;
        recette6 = "INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Tarte aux pommes', 30, 35, 8, 'Fameux dessert composé de pommes', 'Moyen', 'Bon marché', 'Dessert', '13-07-17', 'System')";
        base_de_donnees.execSQL(recette6);
        String recette7;
        recette7 = "INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Boulets à la Liégoise', 30, 60, 4, 'Plat traditionnel Liégois', 'Difficile', 'Peu élevé', 'Plat', '13-07-17', 'System')";
        base_de_donnees.execSQL(recette7);
        String recette8;
        recette8 = "INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Banana split', 0, 0, 4, 'Glace au chocolat et banane', 'Facile', 'Bon marché', 'Dessert', '13-07-17', 'System')";
        base_de_donnees.execSQL(recette8);
        String recette9;
        recette9 = "INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Lapin aux pruneaux', 25, 45, 4, 'Plat agréable en hiver', 'Moyen', 'Elevé', 'Plat', '13-07-17', 'System')";
        base_de_donnees.execSQL(recette9);
        String recette10;
        recette10 = "INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Soupe d orties', 10, 10, 6, 'Comment utiliser au mieux ces plantes qui piquent', 'Facile', 'Bon marché', 'Entrée', '13-07-17', 'System')";
        base_de_donnees.execSQL(recette10);
        String recette11;
        recette11 = "INSERT INTO Recette ('nomR', 'tprep', 'tcuiss', 'ncouv', 'description', 'difficulte', 'cout', 'type', 'date', 'auteur') VALUES ('Crèpes', 10, 15, 4, 'A faire salé ou sucré', 'Facile', 'Bon marché', 'Dessert', '13-07-17', 'System')";
        base_de_donnees.execSQL(recette11);
    }

    /*
    Crée une population contenant les ingrédients liés aux recettes (l'utilisateur peut en ajouter)
     */
    private void population_recette_ingredient(SQLiteDatabase base_de_donnees) {
        String ringre1;
        ringre1 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Poulet aux champignons', 'Poulet', '4 cuisses')";
        base_de_donnees.execSQL(ringre1);
        String ringre2;
        ringre2 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Poulet aux champignons', 'Pomme de terre', '500 g')";
        base_de_donnees.execSQL(ringre2);
        String ringre3;
        ringre3 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Poulet aux champignons', 'Champignons de Paris', '150 g')";
        base_de_donnees.execSQL(ringre3);
        String ringre4;
        ringre4 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Poulet aux champignons', 'Riz', '200g')";
        base_de_donnees.execSQL(ringre4);
        String ringre5;
        ringre5 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Poulet aux champignons', 'Oignon', '1')";
        base_de_donnees.execSQL(ringre5);
        String ringre6;
        ringre6 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Hoummous', 'Citron', '2')";
        base_de_donnees.execSQL(ringre6);
        String ringre7;
        ringre7 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Hoummous', 'Huile d olive', '2 cuillières à soupe')";
        base_de_donnees.execSQL(ringre7);
        String ringre8;
        ringre8 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Hoummous', 'Tahiné', '3 cuillières à soupe')";
        base_de_donnees.execSQL(ringre8);
        String ringre9;
        ringre9 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Hoummous', 'Pois chiche', '200 g')";
        base_de_donnees.execSQL(ringre9);
        String ringre10;
        ringre10 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Boeuf haché', '300 g')";
        base_de_donnees.execSQL(ringre10);
        String ringre11;
        ringre11 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Tomate', '800 g')";
        base_de_donnees.execSQL(ringre11);
        String ringre12;
        ringre12 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Oignon', '2')";
        base_de_donnees.execSQL(ringre12);
        String ringre13;
        ringre13 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Ail', '2 gousses')";
        base_de_donnees.execSQL(ringre13);
        String ringre14;
        ringre14 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Origan', '1 cuillière à soupe')";
        base_de_donnees.execSQL(ringre14);
        String ringre15;
        ringre15 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Sucre', '2 morceaux')";
        base_de_donnees.execSQL(ringre15);
        String ringre16;
        ringre16 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Spaghetti bolognaise', 'Spaghetti', '400 g')";
        base_de_donnees.execSQL(ringre16);

        String ringre17;
        String ringre18;
        String ringre19;
        String ringre20;
        String ringre21;
        String ringre22;
        String ringre23;
        String ringre24;
        String ringre25;
        String ringre26;
        String ringre27;
        String ringre28;
        String ringre29;
        String ringre30;
        String ringre31;
        String ringre32;
        String ringre33;
        String ringre34;
        String ringre35;
        String ringre36;
        String ringre37;
        String ringre38;
        String ringre39;
        String ringre40;
        String ringre41;
        String ringre42;
        String ringre43;
        String ringre44;
        String ringre45;
        String ringre46;
        String ringre47;


        ringre17 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Lasagne sèche', '350 g')";
        ringre18 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Boeuf haché', '400 g')";
        ringre19 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Tomate', '1600 g')";
        ringre20 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Oignon', '2')";
        ringre21 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Carotte', '1')";
        ringre22 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Ail', '1')";
        ringre23 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Sucre', '1')";
        ringre24 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Huile d olive', '3 cuillières à soupe')";
        ringre25 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Parmesan', '60 g')";
        ringre26 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Beurre', '25 g')";
        ringre27 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Lasagne sauce bolognaise', 'Laurrier', '2')";
        ringre28 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Tarte aux pommes', 'Pomme', '6')";
        ringre29 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Tarte aux pommes', 'Pâte feuilletée', '1')";
        ringre30 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Tarte aux pommes', 'Sucre', '90 g')";
        ringre31 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Tarte aux pommes', 'Oeuf', '2')";
        ringre32 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Tarte aux pommes', 'Beurre', '60 g')";
        ringre33 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Haché porc et boeuf', '1000 g')";
        ringre34 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Oeuf', '2')";
        ringre35 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Échalotte', '2')";
        ringre36 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Chapelure', '100 g')";
        ringre37 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Persil', '30 g')";
        ringre38 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Farine', '1 cuillière à soupe')";
        ringre39 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Cassonade', '1 cuillière à soupe')";
        ringre40 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Oignon', '2')";
        ringre41 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Boulets à la Liégoise', 'Sirop de Liège', '150 g')";
        ringre42 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Glace vanille', '250 ml')";
        ringre43 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Glace au chocolat', '250 ml')";
        ringre44 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Banane', '4')";
        ringre45 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Crème chatilly', '1')";
        ringre46 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Chocolat noir', '50 g')";
        ringre47 = "INSERT INTO Recetteingredient ('riidrecette', 'riingredient', 'riquantite') VALUES ('Banana split', 'Amande effilé', '4 cuillières à soupe')";


        base_de_donnees.execSQL(ringre17);
        base_de_donnees.execSQL(ringre18);
        base_de_donnees.execSQL(ringre19);
        base_de_donnees.execSQL(ringre20);
        base_de_donnees.execSQL(ringre21);
        base_de_donnees.execSQL(ringre22);
        base_de_donnees.execSQL(ringre23);
        base_de_donnees.execSQL(ringre24);
        base_de_donnees.execSQL(ringre25);
        base_de_donnees.execSQL(ringre26);
        base_de_donnees.execSQL(ringre27);
        base_de_donnees.execSQL(ringre28);
        base_de_donnees.execSQL(ringre29);
        base_de_donnees.execSQL(ringre30);
        base_de_donnees.execSQL(ringre31);
        base_de_donnees.execSQL(ringre32);
        base_de_donnees.execSQL(ringre33);
        base_de_donnees.execSQL(ringre34);
        base_de_donnees.execSQL(ringre35);
        base_de_donnees.execSQL(ringre36);
        base_de_donnees.execSQL(ringre37);
        base_de_donnees.execSQL(ringre38);
        base_de_donnees.execSQL(ringre39);
        base_de_donnees.execSQL(ringre40);
        base_de_donnees.execSQL(ringre41);
        base_de_donnees.execSQL(ringre42);
        base_de_donnees.execSQL(ringre43);
        base_de_donnees.execSQL(ringre44);
        base_de_donnees.execSQL(ringre45);
        base_de_donnees.execSQL(ringre46);
        base_de_donnees.execSQL(ringre47);

    }

    /*
    Crée une population contenant les étapes liées aux recettes (l'utilisateur peut en ajouter)
     */
    private void population_recette_etape(SQLiteDatabase base_de_donnees) {
        String reetape1;
        reetape1 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Poulet aux champignons', 1, 'Nettoyer et émincer les champignons')";
        base_de_donnees.execSQL(reetape1);
        String reetape2;
        reetape2 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Poulet aux champignons', 2, 'Eplucher et émincer l oignon')";
        base_de_donnees.execSQL(reetape2);
        String reetape3;
        reetape3 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Poulet aux champignons', 3, 'Saisir les cuisses de poulet')";
        base_de_donnees.execSQL(reetape3);
        String reetape4;
        reetape4 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Poulet aux champignons', 4, 'Ajouter les oignons et les champignons')";
        base_de_donnees.execSQL(reetape4);
        String reetape5;
        reetape5 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Poulet aux champignons', 5, 'Laisser cuire le tout 10 minutes')";
        base_de_donnees.execSQL(reetape5);
        String reetape6;
        reetape6 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', 1, 'Porter les pois chiches à ébulition')";
        base_de_donnees.execSQL(reetape6);
        String reetape7;
        reetape7 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', 2, 'Presser les citrons')";
        base_de_donnees.execSQL(reetape7);
        String reetape8;
        reetape8 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', 3, 'Enlever les pois chiches de l eau mais garder le jus de cuisson')";
        base_de_donnees.execSQL(reetape8);
        String reetape9;
        reetape9 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', 4, 'Ajouter le jus de citron, l huile d olive, le tahiné et mixer le tout pour avoir une pâte homogène')";
        base_de_donnees.execSQL(reetape9);
        String reetape10;
        reetape10 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', 5, 'Ajouter le jus de cuisson petit à petit pour avoir une pâte moins compacte')";
        base_de_donnees.execSQL(reetape10);
        String reetape11;
        reetape11 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Hoummous', 6, 'Laisser reposer deux heures au frigo')";
        base_de_donnees.execSQL(reetape11);
        String reetape12;
        reetape12 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', 1, 'Faire chauffer l huile avec les oignons')";
        base_de_donnees.execSQL(reetape12);
        String reetape13;
        reetape13 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', 2, 'Ajouter les gousses d ail quand les oignons deviennent translucides')";
        base_de_donnees.execSQL(reetape13);
        String reetape14;
        reetape14 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', 3, 'Mettre les tomates dans la casserole et porter à feu moyen')";
        base_de_donnees.execSQL(reetape14);
        String reetape15;
        reetape15 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', 4, 'Laisser mijoter 20 minutes')";
        base_de_donnees.execSQL(reetape15);
        String reetape16;
        reetape16 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', 5, 'Ajouter l origan, le sel et le poivre')";
        base_de_donnees.execSQL(reetape16);
        String reetape17;
        reetape17 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', 6, 'Baisser le feu pour réduire la sauce')";
        base_de_donnees.execSQL(reetape17);
        String reetape18;
        reetape18 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', 7, 'Faire cuire le boeuf dans une poele après l avoir assaisoné')";
        base_de_donnees.execSQL(reetape18);
        String reetape19;
        reetape19 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Spaghetti bolognaise', 8, 'Mélanger la viande à la sauce puis le tout aux pâtes')";
        base_de_donnees.execSQL(reetape19);

        String reetape20;
        String reetape21;
        String reetape22;
        String reetape23;
        String reetape24;
        String reetape25;
        String reetape26;
        String reetape27;
        String reetape28;
        String reetape29;
        String reetape30;
        String reetape31;
        String reetape32;
        String reetape33;
        String reetape34;
        String reetape35;
        String reetape36;
        String reetape37;
        String reetape38;
        String reetape39;
        String reetape40;
        String reetape41;
        String reetape42;
        String reetape43;
        String reetape44;
        String reetape45;
        String reetape46;
        String reetape47;
        String reetape48;
        String reetape49;
        String reetape50;
        String reetape51;
        String reetape52;
        String reetape53;

        reetape20 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '1', 'Émincer les oignons, les gousses d ail, la carotte et le céleri')";
        reetape21 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '2', 'Faire revenir les gousses d ail et les oignons dans de l huile d olive')";
        reetape22 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '3', 'Ajouter la carotte et le céleri')";
        reetape23 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '4', 'Ajouter la viande et laisser cuire')";
        reetape24 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '5', 'Ajouter le vin rouge, la purée de tomate et les herbes')";
        reetape25 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '6', 'Laisser mijoter 45 minutes à feu doux')";
        reetape26 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '7', 'Huiler le plat à lasagne')";
        reetape27 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '8', 'Poser une couche de béchamel, la lasagne sèche, une couche de sauce bolognaise trois fois de suite')";
        reetape28 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '9', 'Recouvrir de parmersan et de noisettes de beure')";
        reetape29 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Lasagne sauce bolognaise', '10', 'Enfourner pendant 25 minutes dans un four préchauffé à 200°')";
        reetape30 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '1', 'Mettre la pâte feuilletée dans un plat à tarte et la piquer avec une fourchette')";
        reetape31 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '2', 'Couper les pommes en lamelles')";
        reetape32 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '3', 'Garnir la pâte avec les lamelles de pommes')";
        reetape33 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '4', 'Mélanger le sucre, les oeufs et le beurre')";
        reetape34 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '5', 'Verser ce mélange sur les pommes')";
        reetape35 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Tarte aux pommes', '6', 'Enfourner au four pendant 35 minutes à 200°')";
        reetape36 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '1', 'Mélanger le haché, les oeufs, le percil et les échalottes hachées')";
        reetape37 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '2', 'Quand le mélange est homogène, ajouter la chapelure et mélanger à nouveau')";
        reetape38 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '3', 'Former les boulettes de viande')";
        reetape39 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '4', 'Rouler ces boulettes dans la farine')";
        reetape40 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '5', 'Cuire les boulettes à la poêle pendant 10 minutes')";
        reetape41 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '6', 'Émincer les oignons')";
        reetape42 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '7', 'Caraméliser les oignons avec la cassonade')";
        reetape43 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '8', 'Ajouter le sirop de Liège et mouiller avec 1/2 litre d eau')";
        reetape44 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '9', 'Laisser venir à ébulittion puis ajouter les boulettes de viande')";
        reetape45 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '10', 'Laisser cuire à couvert 1 heure à feu doux')";
        reetape46 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Boulets à la Liégoise', '11', 'Lier la sauce avant de servir')";
        reetape47 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '1', 'Peler et couper les bananes en deux dans le sens de la longueur')";
        reetape48 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '2', 'Disposer les bananes dans la coupe')";
        reetape49 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '3', 'Disposer 3 boules de glace vanille chocolat sur les bananes')";
        reetape50 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '4', 'Faire fondre le chocolat dans un bain marie')";
        reetape51 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '5', 'Arroser la glace avec le chocolat fondu')";
        reetape52 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '6', 'Terminer les coupes avec de la crème chantilly')";
        reetape53 = "INSERT INTO Recetteetape ('reidrecette', 'renumero', 'reetape') VALUES ('Banana split', '7', 'Parsemer d amande effilé')";


        base_de_donnees.execSQL(reetape20);
        base_de_donnees.execSQL(reetape21);
        base_de_donnees.execSQL(reetape22);
        base_de_donnees.execSQL(reetape23);
        base_de_donnees.execSQL(reetape24);
        base_de_donnees.execSQL(reetape25);
        base_de_donnees.execSQL(reetape26);
        base_de_donnees.execSQL(reetape27);
        base_de_donnees.execSQL(reetape28);
        base_de_donnees.execSQL(reetape29);
        base_de_donnees.execSQL(reetape30);
        base_de_donnees.execSQL(reetape31);
        base_de_donnees.execSQL(reetape32);
        base_de_donnees.execSQL(reetape33);
        base_de_donnees.execSQL(reetape34);
        base_de_donnees.execSQL(reetape35);
        base_de_donnees.execSQL(reetape36);
        base_de_donnees.execSQL(reetape37);
        base_de_donnees.execSQL(reetape38);
        base_de_donnees.execSQL(reetape39);
        base_de_donnees.execSQL(reetape40);
        base_de_donnees.execSQL(reetape41);
        base_de_donnees.execSQL(reetape42);
        base_de_donnees.execSQL(reetape43);
        base_de_donnees.execSQL(reetape44);
        base_de_donnees.execSQL(reetape45);
        base_de_donnees.execSQL(reetape46);
        base_de_donnees.execSQL(reetape47);
        base_de_donnees.execSQL(reetape48);
        base_de_donnees.execSQL(reetape49);
        base_de_donnees.execSQL(reetape50);
        base_de_donnees.execSQL(reetape51);
        base_de_donnees.execSQL(reetape52);
        base_de_donnees.execSQL(reetape53);

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
            String RecetteEtape = "DRop TABLE IF EXISTS Recetteetape";
            db.execSQL(RecetteEtape);

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
        ArrayList<String> listeCategorie = new ArrayList<String>();
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
                y=y+s+" : "+p+"\n";
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
                y=y+s+"\n";
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
            moyenne = (double) somme/nbre;
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
                y=y+cursor.getString(0)+" : "+cursor.getString(1)+"\n";
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

