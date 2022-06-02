package com.example.controlecontinuen2_tdi_202;

import java.io.Serializable;

public class entreprise implements Serializable {
    private int id;
    private String raison_sociale;
    private String adresse;
    private double capitale;


    public  entreprise()
    {

    }
    public entreprise(int id, String raison_sociale, String adresse, double capitale) {
        this.id = id;
        this.raison_sociale = raison_sociale;
        this.adresse = adresse;
        this.capitale = capitale;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaison_sociale() {
        return raison_sociale;
    }

    public void setRaison_sociale(String raison_sociale) {
        this.raison_sociale = raison_sociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getCapitale() {
        return capitale;
    }

    public void setCapitale(double capitale) {
        this.capitale = capitale;
    }




}
