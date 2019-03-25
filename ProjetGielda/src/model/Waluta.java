package model;

import java.util.ArrayList;
import java.util.Random;

public class Waluta extends Aktywa {
    private ArrayList <String> listaPanstw;

    public  Waluta () {
        Random rand = new Random();
        String[] Kraje = {"Polska", "Anglia", "Niemcy", "Włochy", "Francja", "Ukraina", "USA", "Kanada", "Hiszpania"};
        String[] Waluty = {"euro", "zlotówka", "funt","dolar","korona"};
        this.setNazwa(Waluty[rand.nextInt(Waluty.length)]);
        this.setAktualnaWartosc(1+(double) (rand.nextInt(700)) / 100+1);
        this.setMaksymalnaWartos(this.getAktualnaWartosc());
        this.setMinimalnaWartosc(this.getAktualnaWartosc());
        this.listaPanstw = new ArrayList<>();
        for (String y : Kraje) {
            if (rand.nextInt(2) == 0) {
                this.listaPanstw.add(y);
            }
        }
        boolean test = false;
        for(int i = 0; i< Inicjuj.getRynkiWalut().size(); i++)
        {
            if(rand.nextInt(2)==0){
                Inicjuj.getRynkiWalut().get(i).dodajwalute(this);
                test=true;
            }
        }
        if(test == false){
            Inicjuj.getRynkiWalut().get(rand.nextInt(Inicjuj.getRynkiWalut().size())).dodajwalute(this);
        }
        this.setHistoria(new ArrayList<>());
        this.dodajdohistori(this.getAktualnaWartosc());
        this.setStartowaCena(this.getAktualnaWartosc());

    }

    public ArrayList<String> getListaPanstw() {
        return listaPanstw;
    }

    public void setListaPanstw(ArrayList<String> listaPanstw) {
        this.listaPanstw = listaPanstw;
    }



    @Override
    public String toString() {
        return this.getNazwa();
    }


    public synchronized void nowacena(int ilosc){
        Random rand = new Random();
        double nowacena=0;


            if (rand.nextInt(2) == 0) {
                nowacena=this.getAktualnaWartosc() * 1.2;
            }
            else if(rand.nextInt(10)==0) {
                nowacena=this.getAktualnaWartosc() / 2;

            }
            else if(rand.nextInt(10)==0){
                nowacena=this.getAktualnaWartosc()*5;
            }
            else{
                nowacena=this.getAktualnaWartosc() * 0.9;

            }
        if(this.getAktualnaWartosc()>10){
            if(rand.nextInt(3)==0){
                nowacena=nowacena/(rand.nextInt(6)+3);
            }
        }
            this.setAktualnaWartosc(nowacena);
            this.dodajdohistori(nowacena);




    }
}
