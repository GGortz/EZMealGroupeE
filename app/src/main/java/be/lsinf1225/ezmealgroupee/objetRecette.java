package be.lsinf1225.ezmealgroupee;

/**
 * Created by Gaetan on 22/06/2017.
 */

public class objetRecette {

    private String nomrecette;
    private int tempscuisson;
    private int tempspreparation;
    private int nombredecouvert;
    private String difficulte;
    private String cout;
    private String description;
    private String type;
    private String date;
    private String auteur;
    private String commentaire;

    private String listeingredients;
    private String listeetapes;

    private double rate;


    public objetRecette(String nomrecette, int tempscuisson, int tempspreparation, int nombredecouvert, String description, String difficulte, String cout, String type, String date, String auteur) {
        this.nomrecette = nomrecette;
        this.tempscuisson = tempscuisson;
        this.tempspreparation = tempspreparation;
        this.nombredecouvert = nombredecouvert;
        this.difficulte = difficulte;
        this.cout = cout;
        this.description = description;
        this.type = type;
        this.date=date;
        this.auteur=auteur;
    }

    public String getNomrecette() {
        return nomrecette;
    }

    public void setNomrecette(String nomrecette) {
        this.nomrecette = nomrecette;
    }

    public int getTempscuisson() {
        return tempscuisson;
    }

    public void setTempscuisson(int tempscuisson) {
        this.tempscuisson = tempscuisson;
    }

    public int getTempspreparation() {
        return tempspreparation;
    }

    public void setTempspreparation(int tempspreparation) {
        this.tempspreparation = tempspreparation;
    }

    public int getNombredecouvert() {
        return nombredecouvert;
    }

    public void setNombredecouvert(int nombredecouvert) {
        this.nombredecouvert = nombredecouvert;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public String getCout() {
        return cout;
    }

    public void setCout(String cout) {
        this.cout = cout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getListeingredients() {
        return listeingredients;
    }

    public void setListeingredients(String listeingredients) {
        this.listeingredients = listeingredients;
    }

    public String getListeetapes() {
        return listeetapes;
    }

    public void setListeetapes(String listeetapes) {
        this.listeetapes = listeetapes;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate){
        this.rate=rate;
    }

    public String getDate(){ return date; }

    public void setDate(String date){ this.date = date; }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}

