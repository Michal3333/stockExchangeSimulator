package model;

import java.io.Serializable;

public class Posiadanie implements Serializable {
    private Spolka spolka;
    private int ilosc;
    public Posiadanie(Spolka a){
        this.spolka=a;
        this.ilosc=0;
    }

    public Spolka getSpolka() {
        return spolka;
    }
    public void dodajakcje(int x){

        if(x>0){this.setIlosc(this.getIlosc()+x);}
        else{this.setIlosc(0);}
    }
    public void usunakcje(int x){
        if(x>0){this.setIlosc(this.getIlosc()-x);}
        else{this.setIlosc(0);}
    }

    public void setSpolka(Spolka spolka) {
        this.spolka = spolka;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {

        if(ilosc>0){this.ilosc = ilosc;}
        else{this.ilosc=0;}
    }
}
