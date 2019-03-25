package model;

import java.io.Serializable;

public class PosiadanieWalut implements Serializable {
    private Waluta waluta;
    private int ilosc;
    public PosiadanieWalut(Waluta a){
        this.waluta=a;
        this.ilosc=0;
    }


    public void dodajwaluty(int x){
       if(x>0) {this.setIlosc(this.getIlosc()+x);}
    }
    public void usunwaluty(int x){
       if(x>0){ this.setIlosc(this.getIlosc()-x);}
    }

    public Waluta getWaluta() {
        return waluta;
    }

    public void setWaluta(Waluta waluta) {
        this.waluta = waluta;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {

        if(ilosc>0){this.ilosc = ilosc;}
        else{this.ilosc=0;}
    }
}
