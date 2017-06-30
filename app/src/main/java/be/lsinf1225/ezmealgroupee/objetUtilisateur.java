package be.lsinf1225.ezmealgroupee;

/**
 * Created by Gaetan on 30/06/2017.
 */

public class objetUtilisateur {

    private String login;
    private String mdp;
    private String sexe;
    private int jour;
    private int mois;
    private int annee;
    private String ville;
    private String pays;


    public objetUtilisateur(String login, String mdp, String sexe, int jour, int mois, int annee, String ville, String pays) {
        this.login = login;
        this.mdp = mdp;
        this.sexe = sexe;
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.ville = ville;
        this.pays = pays;
    }

    public objetUtilisateur(){

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMDP() {
        return mdp;
    }

    public void setMDP(String mdp) {
        this.mdp = mdp;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
