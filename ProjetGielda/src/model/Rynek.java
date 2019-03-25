package model;

import java.io.Serializable;
import java.util.Random;

public  abstract class  Rynek implements Serializable{
    private String nazwa;
    private String waluta;
    private double marza;
    private String kraj;
    private String misato;
    private String adres;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public double getMarza() {
        return marza;
    }

    public void setMarza(double marza) {

        if(marza>0){this.marza = marza;}
        else{this.marza=0.01;}
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getMisato() {
        return misato;
    }

    public void setMisato(String misato) {
        this.misato = misato;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
