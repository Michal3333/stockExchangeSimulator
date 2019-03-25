package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public abstract class Klient implements Serializable{
    private String Imie;
    private String Nazwisko;
    private double Budzet;

    private boolean watek =true;



    public boolean isWatek() {
        return watek;
    }

    public void setWatek(boolean watek) {
        this.watek = watek;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public double getBudzet() {
        return Budzet;
    }

    public void setBudzet(double budzet) {
        if(budzet>0) {
            Budzet = budzet;
        }
        else{Budzet=0;}

    }



}
