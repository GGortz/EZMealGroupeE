package be.lsinf1225.ezmealgroupee;

/**
 * Created by Gaetan on 22/06/2017.
 */

public class objetReview {
    private String utilisateur;
    private String idrecette;
    private double rate;
    private String commentaire;

    objetReview(String idrecette, String nom, String commentaire){
        this.idrecette=idrecette;
        this.utilisateur=nom;
        this.commentaire=commentaire;
    }

    objetReview(String idrecette, String nom, int rating){
        this.idrecette=idrecette;
        this.utilisateur=nom;
        this.rate=rating;
    }
    objetReview(String idrecette, String nom, double rate, String commentaire){
        this.idrecette=idrecette;
        this.utilisateur=nom;
        this.rate=rate;
        this.commentaire=commentaire;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getID(){ return idrecette; }

    public void setID(String id){ this.idrecette = id; }
}
