package model;

import java.util.ArrayList;

public class Akcja extends Aktywa {
    private String nazwaSpolki;


    public Akcja(Spolka a){
        this.setNazwa("akcja spolki " + a.getNazwa());
        this.setAktualnaWartosc(a.getAktualnyKurs());
        this.setMaksymalnaWartos(this.getAktualnaWartosc());
        this.setMinimalnaWartosc(this.getAktualnaWartosc());
        this.nazwaSpolki=a.getNazwa();
        this.setHistoria(new ArrayList<>());
        this.dodajdohistori(this.getAktualnaWartosc());
        this.setStartowaCena(this.getAktualnaWartosc());
    }

    @Override
    public String toString() {
        return this.getNazwa();
    }



    public String getNazwaSpolki() {
        return nazwaSpolki;
    }

    public void setNazwaSpolki(String nazwaSpolki) {
        this.nazwaSpolki = nazwaSpolki;
    }


}
