package model;

import java.util.ArrayList;

public class JednostkaUczestnictwa extends Aktywa {

    public JednostkaUczestnictwa(FunduszInwestycyjny a){
        this.setNazwa("jednostka  " + a.getImie() +" " +a.getNazwisko());
        this.setAktualnaWartosc(a.getBudzet());
        this.setMaksymalnaWartos(this.getAktualnaWartosc());
        this.setMinimalnaWartosc(this.getAktualnaWartosc());
        this.setHistoria(new ArrayList<>());
        this.dodajdohistori(this.getAktualnaWartosc());
        this.setStartowaCena(this.getAktualnaWartosc()/100);
    }

    @Override
    public String toString() {
        return this.getNazwa();
    }


}
