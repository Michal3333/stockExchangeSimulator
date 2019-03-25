package model;

import java.util.Random;

public class Gielda extends Rynek {

    private Indeks indeks;


    public Gielda (){
        String[] kraje = {"Polska","Anglia","Dania","Czechy","Słowacja","Niemcy","Hiszpania","Turcja"};
        String[] miasta = {"Poznan","Berlin","Gdynia","Barcelona","Londyn","Moskwa","Stęszewko","Warszawa"};
        String[] adresy = {"Kacza","fajowa","Ratowa","Piene","Kaczmarka","Ulina","Medowa","Pomarańczowa"};
        String[] nazwy = {"gielda POL","gielda Aka","Gielda Daka","Gielda owa","Gielda bogata"};
        String[] waluty = {"euro", "zlotówka", "funt","dolar","korona"};
        Random rand = new Random();
        this.setNazwa(nazwy[rand.nextInt(nazwy.length)]);
        this.setMarza((double)(rand.nextInt(10))/100+0.01);
        this.setWaluta(waluty[rand.nextInt(waluty.length)]);
        this.setKraj( kraje[rand.nextInt(kraje.length)]);
        this.setMisato(miasta[rand.nextInt(miasta.length)]);
        this.setAdres( adresy[rand.nextInt(adresy.length)]);
        this.indeks = new Indeks(this);



    }

    @Override
    public String toString() {
        return this.getNazwa();
    }

    public Indeks getIndeks() {
        return indeks;
    }

    public void setIndeks(Indeks indeks) {
        this.indeks = indeks;
    }
}
