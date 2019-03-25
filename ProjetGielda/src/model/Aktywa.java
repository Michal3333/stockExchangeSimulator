package model;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class Aktywa implements Serializable{
    private String nazwa;
    private double startowaCena;
    private double aktualnaWartosc;
    private double minimalnaWartosc;
    private double maksymalnaWartos;
    private ArrayList <Double> historia;

    public double getStartowaCena() {
        return startowaCena;
    }

    public void setStartowaCena(double startowaCena) {

        if(startowaCena>0) {this.startowaCena = startowaCena;}
        else{this.startowaCena=1;}
    }

    public ArrayList<Double> getHistoria() {
        return historia;
    }

    public void setHistoria(ArrayList<Double> historia) {
        this.historia = historia;
    }
    public void dodajdohistori(double a){
        if(a>0){
        if(this.getHistoria().size()>70){this.getHistoria().remove(0);}
        this.historia.add(a);}
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getAktualnaWartosc() {
        return aktualnaWartosc;
    }

    public void setAktualnaWartosc(double aktualnaWartosc) {

        if(aktualnaWartosc>0){
        this.aktualnaWartosc = aktualnaWartosc;}
        else{this.aktualnaWartosc=1;}
        if(aktualnaWartosc<this.minimalnaWartosc){
            this.setMinimalnaWartosc(aktualnaWartosc);
        }
        if(aktualnaWartosc>this.maksymalnaWartos){
            this.setMaksymalnaWartos(aktualnaWartosc);
        }


    }

    public double getMinimalnaWartosc() {
        return minimalnaWartosc;
    }

    public void setMinimalnaWartosc(double minimalnaWartosc) {

        if(minimalnaWartosc>0){this.minimalnaWartosc = minimalnaWartosc;}
    }

    public double getMaksymalnaWartos() {
        return maksymalnaWartos;
    }

    public void setMaksymalnaWartos(double maksymalnaWartos) {

        if(maksymalnaWartos>0){this.maksymalnaWartos = maksymalnaWartos;}
    }
}
