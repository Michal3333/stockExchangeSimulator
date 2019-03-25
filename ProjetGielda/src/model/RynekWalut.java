package model;

import java.util.ArrayList;
import java.util.Random;

public class RynekWalut extends Rynek{
    private ArrayList <Waluta> listaWalut;

    public RynekWalut (){
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
        this.listaWalut = new ArrayList<>();

    }

    @Override
    public String toString() {
        return this.getNazwa();
    }

    public ArrayList<Waluta> getListaWalut() {
        return listaWalut;
    }

    public void setListaWalut(ArrayList<Waluta> listaWalut) {
        this.listaWalut = listaWalut;
    }

    public void dodajwalute(Waluta a){
        this.listaWalut.add(a);
    }

}
