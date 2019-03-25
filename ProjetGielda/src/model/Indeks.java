package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Indeks implements Serializable{
    private String nazwa;
    private ArrayList <Spolka> listaSpolek;
    private double wartosc;

    public void wyznaczwartosc(){
        this.wartosc=0;
        for(int i=0;i<this.listaSpolek.size();i++){
            this.wartosc += listaSpolek.get(i).getLiczbaAkcji()*listaSpolek.get(i).getAktualnyKurs();
        }
    }
    public Indeks(Gielda b){
        this.nazwa="Głowny "+b.getNazwa();
        this.listaSpolek=new ArrayList<>();
        this.wartosc=0;



    }
    public void dodaj(Spolka spolka){
        this.listaSpolek.add(spolka);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public ArrayList<Spolka> getListaSpolek() {
        return listaSpolek;
    }

    public void setListaSpolek(ArrayList<Spolka> listaSpolek) {
        this.listaSpolek = listaSpolek;
    }

    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
       if(wartosc>0) {this.wartosc = wartosc;}
       else{this.wartosc=1;}
    }
}
