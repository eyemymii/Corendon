/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corendon;

/**
 *
 * @author warie_000
 */
public class Koffer {
    public String merk;
    public String materiaal;
    public String overige;
    public String kleur;
    public String statusKoffer;
    
    Koffer(){
        this.merk = "";
        this.materiaal = "";
        this.kleur = "";
        this.overige = "";
        this.statusKoffer = ""; 
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getMateriaal() {
        return materiaal;
    }

    public void setMateriaal(String materiaal) {
        this.materiaal = materiaal;
    }

    public String getOverige() {
        return overige;
    }

    public void setOverige(String overige) {
        this.overige = overige;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public String getStatusKoffer() {
        return statusKoffer;
    }

    public void setStatusKoffer(String statusKoffer) {
        this.statusKoffer = statusKoffer;
    }
}
