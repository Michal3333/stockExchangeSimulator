package model;

import java.io.Serializable;

public class PosiadanieSur implements Serializable {
    private Surowiec surowiec;
    private int ilosc;
    public PosiadanieSur(Surowiec a){
        this.surowiec=a;
        this.ilosc=0;
    }


    public void dodajsurowce(int x){
        if(x>0){
            this.setIlosc(this.getIlosc()+x);
        }

    }
    public void usunsurowce(int x){
        if(x>0){

        this.setIlosc(this.getIlosc()-x);}
    }

    public Surowiec getSurowiec() {
        return surowiec;
    }

    public void setSurowiec(Surowiec surowiec) {
        this.surowiec = surowiec;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {

        if(ilosc>0){this.ilosc = ilosc;}
        else{this.ilosc=0;}
    }
}
