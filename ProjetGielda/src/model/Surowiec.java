package model;

import java.util.ArrayList;
import java.util.Random;

public class Surowiec extends Aktywa {
    private String jednostka;


    public Surowiec(){
        Random rand = new Random();
        String[] Surowce = {"Złoto","Srebro","drewno","ziemia","kamienie","piaek","braz"};
        String[] Jednostki = {"uncja","uncja","kubik","m3","kg","kg","kg"};
        int y = rand.nextInt(Surowce.length);
        this.setNazwa(Surowce[y]);
        this.jednostka=Jednostki[y];
        this.setAktualnaWartosc(1+(double)(rand.nextInt(7000))/100+1);
        this.setMaksymalnaWartos(this.getAktualnaWartosc());
        this.setMinimalnaWartosc(this.getAktualnaWartosc());

        boolean test = false;
        for(int i = 0; i< Inicjuj.getRynkiSurowcow().size(); i++)
        {
            if(rand.nextInt(2)==0){
                Inicjuj.getRynkiSurowcow().get(i).dodajsurowiec(this);
                test=true;
            }
        }
        if(test == false){
            Inicjuj.getRynkiSurowcow().get(rand.nextInt(Inicjuj.getRynkiSurowcow().size())).dodajsurowiec(this);
        }
        this.setHistoria(new ArrayList<>());
        this.dodajdohistori(this.getAktualnaWartosc());
        this.setStartowaCena(this.getAktualnaWartosc());
    }

    public String getJednostka() {
        return jednostka;
    }



    public void setJednostka(String jednostka) {
        this.jednostka = jednostka;
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
                nowacena=this.getAktualnaWartosc()*3;
            }
            else{
                nowacena=this.getAktualnaWartosc() * 0.9;


            }
            if(this.getAktualnaWartosc()>110){
                if(rand.nextInt(3)==0){
                    nowacena=nowacena/(rand.nextInt(6)+3);
                }
            }
            this.setAktualnaWartosc(nowacena);
            this.dodajdohistori(nowacena);




    }
}
