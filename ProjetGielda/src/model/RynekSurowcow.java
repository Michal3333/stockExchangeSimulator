package model;

import java.util.ArrayList;
import java.util.Random;

public class RynekSurowcow extends Rynek{
    private ArrayList <Surowiec> listaSurowcow;


    public RynekSurowcow (){
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
        this.listaSurowcow = new ArrayList<>();

    }

    @Override
    public String toString() {
        return this.getNazwa();
    }

    public void dodajsurowiec(Surowiec a){
        this.listaSurowcow.add(a);
    }

    public ArrayList<Surowiec> getListaSurowcow() {
        return listaSurowcow;
    }

    public void setListaSurowcow(ArrayList<Surowiec> listaSurowcow) {
        this.listaSurowcow = listaSurowcow;
    }
}
