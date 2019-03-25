package model;

import java.io.Serializable;

public class PosiadanieJednostki implements Serializable {
    private FunduszInwestycyjny funduszInwestycyjny;
    private int ilosc;
    public PosiadanieJednostki(FunduszInwestycyjny a){
        this.funduszInwestycyjny=a;
        this.ilosc=0;
    }

    public FunduszInwestycyjny getFunduszInwestycyjny() {
        return funduszInwestycyjny;
    }

    public void setFunduszInwestycyjny(FunduszInwestycyjny funduszInwestycyjny) {
        this.funduszInwestycyjny = funduszInwestycyjny;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {

        if(ilosc>0){this.ilosc = ilosc;}
        else{this.ilosc=0;}
    }

    public void dodajjednostke(int x){
        if(x>0){
        this.setIlosc(this.getIlosc()+x);}
    }
    public void usunjednostke(int x){
        if(x>0){
        this.setIlosc(this.getIlosc()-x);}
    }
}
