package model;

import
        java.util.ArrayList;
import java.util.Random;



public class Inwestor extends Klient implements Runnable  {
    private int Pesel;
    private ArrayList<Double> Historia;
    private ArrayList<Posiadanie> WlasnosciAkcje;
    private ArrayList<PosiadanieWalut> WlasnosciWaluty;
    private ArrayList<PosiadanieSur>WlasnosciSurowce;
    private ArrayList<PosiadanieJednostki>WlasnosciJednostki;
    public Inwestor(){

        String [] Imiona={"Michal", "Darek", "Dariusz","Bozydar","kacper","jan","grzegorz","piotr","andrzej"};
        String [] Nazwiska = {"Nowak","Kowalski","Rata","Kolo","Hala","Kolt"};
        Random rand = new Random();
        this.setImie(Imiona[rand.nextInt(Imiona.length)]);
        this.setNazwisko(Nazwiska[rand.nextInt(Nazwiska.length)]);
        this.setBudzet((double)(rand.nextInt(100000))/100+10000);
        this.Pesel = rand.nextInt(100000000)+100000000+rand.nextInt(90000000);
        this.WlasnosciAkcje = new ArrayList<>();
        for(int i = 0; i< Inicjuj.getSpolki().size(); i++){
            Posiadanie pom = new Posiadanie(Inicjuj.getSpolki().get(i));
            this.WlasnosciAkcje.add(pom);
        }
        this.WlasnosciWaluty= new ArrayList<>();
        for(int i = 0; i< Inicjuj.getWaluty().size(); i++) {
            PosiadanieWalut pom = new PosiadanieWalut(Inicjuj.getWaluty().get(i));
            this.WlasnosciWaluty.add(pom);
        }
        this.WlasnosciSurowce=new ArrayList<>();
        for(int i = 0; i< Inicjuj.getSurowce().size(); i++) {
            PosiadanieSur pom = new PosiadanieSur(Inicjuj.getSurowce().get(i));

            this.WlasnosciSurowce.add(pom);
        }
        this.WlasnosciJednostki=new ArrayList<>();

        for(int i = 0; i< Inicjuj.getFundusze().size(); i++) {
            PosiadanieJednostki pom = new PosiadanieJednostki(Inicjuj.getFundusze().get(i));

            this.WlasnosciJednostki.add(pom);
        }

            this.Historia = new ArrayList<>();
            this.Historia.add(this.getBudzet());

        utworziurochumwatek();


    }
    public void wycensie(){
        double suma=0;
        double a;
        for (Posiadanie posiadanie : this.getWlasnosciAkcje()) {
            a=posiadanie.getSpolka().getAktualnyKurs()*posiadanie.getIlosc();
            suma+=a;
            if(a<0){
                System.out.println("ILOSC AKTYWK "+posiadanie.getIlosc());
            }
        }
        for (PosiadanieSur posiadanieSur : this.getWlasnosciSurowce()) {
            a=posiadanieSur.getSurowiec().getAktualnaWartosc()*posiadanieSur.getIlosc();
            suma+=a;
            if(a<0){
                System.out.println("ILOSC SUR "+posiadanieSur.getIlosc());
            }
        }
        for (PosiadanieWalut posiadanieWalut : this.getWlasnosciWaluty()) {
            a=posiadanieWalut.getWaluta().getAktualnaWartosc()*posiadanieWalut.getIlosc();
            suma+=a;
            if(a<0){
                System.out.println("ILOSC WAL "+posiadanieWalut.getIlosc());
            }
        }
        suma+=this.getBudzet();
        this.dodajdohistori(suma);
    }

    public ArrayList<Double> getHistoria() {
        return Historia;
    }

    public void setHistoria(ArrayList<Double> historia) {
        Historia = historia;
    }

    @Override
    public String toString() {
        return this.getImie()+" "+this.getNazwisko();
    }


    public ArrayList<PosiadanieSur> getWlasnosciSurowce() {
        return WlasnosciSurowce;
    }

    public void setWlasnosciSurowce(ArrayList<PosiadanieSur> wlasnosciSurowce) {
        WlasnosciSurowce = wlasnosciSurowce;
    }

    public void utworziurochumwatek(){
        zarzadzanewatkami.dodajirozpocznij(new Thread(this));
    }

    public void generujbudzet() {
        Random rand = new Random();
        if (rand.nextInt(3) == 0) {
            this.setBudzet(this.getBudzet() + (double) (rand.nextInt(10000)));
        }
    }

    public void  dodajbudzet(double x){
        this.setBudzet(this.getBudzet()+x);


    }
    public void dodajdohistori(double x){
        if(x>0){
     if(this.Historia.size()>70){
            this.Historia.remove(0);
        }
        this.Historia.add(x);}
    }

    public ArrayList<PosiadanieJednostki> getWlasnosciJednostki() {
        return WlasnosciJednostki;
    }

    public void setWlasnosciJednostki(ArrayList<PosiadanieJednostki> wlasnosciJednostki) {
        WlasnosciJednostki = wlasnosciJednostki;
    }

    public ArrayList<PosiadanieWalut> getWlasnosciWaluty() {
        return WlasnosciWaluty;
    }

    public void setWlasnosciWaluty(ArrayList<PosiadanieWalut> wlasnosciWaluty) {
        WlasnosciWaluty = wlasnosciWaluty;
    }

    public ArrayList<Posiadanie> getWlasnosciAkcje() {
        return WlasnosciAkcje;
    }

    public void setWlasnosciAkcje(ArrayList<Posiadanie> wlasnosciAkcje) {
        WlasnosciAkcje = wlasnosciAkcje;
    }

    public int getPesel() {
        return Pesel;
    }



    public void wydaj(double kwota){

        if(kwota>0){this.setBudzet(this.getBudzet()-kwota);}
    }

    public void setPesel(int pesel) {
        Pesel = pesel;
    }
    public void sprzedajakcje(){
        Random rand = new Random();
        for (int i=0;i<this.WlasnosciAkcje.size();i++){

            if(this.WlasnosciAkcje.get(i).getIlosc()>0){
                if (rand.nextInt(2)==0) {
                    synchronized (this.WlasnosciAkcje.get(i).getSpolka()) {

                        int ilosc = rand.nextInt(this.WlasnosciAkcje.get(i).getIlosc());
                        this.WlasnosciAkcje.get(i).usunakcje(ilosc);
                        this.dodajbudzet(ilosc * this.WlasnosciAkcje.get(i).getSpolka().getAktualnyKurs());
                        this.WlasnosciAkcje.get(i).getSpolka().dodajdostepneakcje(ilosc);
                        this.WlasnosciAkcje.get(i).getSpolka().setWolumen(this.WlasnosciAkcje.get(i).getSpolka().getWolumen()-ilosc);


                    }
                }

            }
        }
    }
    public void kupakcje() {
        Random rand = new Random();
        int ilosczakupow = 1; //rand.nextInt(3);
        for (int i = 0; i < ilosczakupow; i++) {

            Gielda wybranaGielda = Inicjuj.getGieldy().get(rand.nextInt(Inicjuj.getGieldy().size()));
            if (wybranaGielda.getIndeks().getListaSpolek().size()>0) {
                Spolka wybranaSpolka = wybranaGielda.getIndeks().getListaSpolek().get(rand.nextInt(wybranaGielda.getIndeks().getListaSpolek().size()));
                synchronized (wybranaSpolka) {

                    if (wybranaSpolka.getDostepneAkcje() > 0) {
                        int pom = ((int) this.getBudzet());
                        pom = pom / 10;
                        double budzet = (double) (rand.nextInt(pom));
                        if (wybranaSpolka.getAktualnyKurs() * wybranaSpolka.getDostepneAkcje() * (1 + wybranaGielda.getMarza()) <= budzet) {

                            this.wydaj((wybranaSpolka.getAktualnyKurs() * wybranaSpolka.getDostepneAkcje()) * (1 + wybranaGielda.getMarza()));//test
                            for (int u = 0; u < this.WlasnosciAkcje.size(); u++) {
                                if (this.WlasnosciAkcje.get(u).getSpolka() == wybranaSpolka) {
                                    this.WlasnosciAkcje.get(u).dodajakcje(wybranaSpolka.getDostepneAkcje());
                                }
                            }
                            wybranaSpolka.setWolumen(wybranaSpolka.getWolumen() + wybranaSpolka.getDostepneAkcje());
                            wybranaSpolka.setDostepneAkcje(0);

                        } else {
                            int dostepnailosc = (int) (budzet / (wybranaSpolka.getAktualnyKurs()) * (1 + wybranaGielda.getMarza()));
                            wybranaSpolka.setDostepneAkcje(wybranaSpolka.getDostepneAkcje() - dostepnailosc);
                            wybranaSpolka.setWolumen(wybranaSpolka.getWolumen() + dostepnailosc);//wolumen
                            this.wydaj(dostepnailosc * wybranaSpolka.getAktualnyKurs());
                            for (int u = 0; u < this.WlasnosciAkcje.size(); u++) {
                                if (this.WlasnosciAkcje.get(u).getSpolka() == wybranaSpolka) {
                                    this.WlasnosciAkcje.get(u).dodajakcje(dostepnailosc);
                                }
                            }

                        }

                    }

                }
            }
        }
    }
    public void kupwaluty() {
        Random rand = new Random();
        int iloczakup =1; //rand.nextInt(3);
        for (int i = 0; i < iloczakup; i++) {

            RynekWalut wybranaRynek = Inicjuj.getRynkiWalut().get(rand.nextInt(Inicjuj.getRynkiWalut().size()));
            if(wybranaRynek.getListaWalut().size()>0) {
                Waluta wybranaWaluta = wybranaRynek.getListaWalut().get(rand.nextInt(wybranaRynek.getListaWalut().size()));
                synchronized (wybranaWaluta) {


                    int pom = ((int) this.getBudzet());


                    pom = pom / 10;


                    double budzet = (double) (rand.nextInt(pom));
                    int dostepnailosc = (int) (budzet / (wybranaWaluta.getAktualnaWartosc() * (1 + wybranaRynek.getMarza())));


                    this.wydaj(dostepnailosc * (wybranaWaluta.getAktualnaWartosc() * (1 + wybranaRynek.getMarza())));

                    wybranaWaluta.nowacena(dostepnailosc);
                    for (int u = 0; u < this.WlasnosciWaluty.size(); u++) {
                        if (this.WlasnosciWaluty.get(u).getWaluta() == wybranaWaluta) {
                            this.WlasnosciWaluty.get(u).dodajwaluty(dostepnailosc);
                        }
                    }

                }
            }

        }
    }
    public void sprzedajwalty(){
        Random rand = new Random();

            for (int i = 0; i < this.WlasnosciWaluty.size(); i++) {
                if (this.WlasnosciWaluty.get(i).getIlosc() > 0) {
                    synchronized (this.WlasnosciWaluty.get(i).getWaluta()) {

                        int ilosc = rand.nextInt(this.WlasnosciWaluty.get(i).getIlosc());
                        this.WlasnosciWaluty.get(i).usunwaluty(ilosc);
                        this.dodajbudzet(ilosc * this.WlasnosciWaluty.get(i).getWaluta().getAktualnaWartosc());
                        this.WlasnosciWaluty.get(i).getWaluta().nowacena(ilosc);

                    }
                }
            }


    }
    public void kupsurowiec(){
        Random rand = new Random();
        int iloczakup =1; //rand.nextInt(3);
        for (int i = 0; i < iloczakup; i++) {

            RynekSurowcow wybranaRynek = Inicjuj.getRynkiSurowcow().get(rand.nextInt(Inicjuj.getRynkiSurowcow().size()));
            if(wybranaRynek.getListaSurowcow().size()>0) {
                Surowiec wybranaSurowiec = wybranaRynek.getListaSurowcow().get(rand.nextInt(wybranaRynek.getListaSurowcow().size()));
                synchronized (wybranaSurowiec) {


                    int pom = ((int) this.getBudzet());


                    pom = pom / 10;


                    double budzet = (double) (rand.nextInt(pom));
                    int dostepnailosc = (int) (budzet / (wybranaSurowiec.getAktualnaWartosc() * (1 + wybranaRynek.getMarza())));


                    this.wydaj(dostepnailosc * (wybranaSurowiec.getAktualnaWartosc() * (1 + wybranaRynek.getMarza())));

                    wybranaSurowiec.nowacena(dostepnailosc);
                    for (int u = 0; u < this.WlasnosciSurowce.size(); u++) {
                        if (this.WlasnosciSurowce.get(u).getSurowiec() == wybranaSurowiec) {
                            this.WlasnosciSurowce.get(u).dodajsurowce(dostepnailosc);
                        }
                    }

                }
            }

        }
    }
    public void sprzedajsurowiec(){
        Random rand = new Random();

        for (int i = 0; i < this.WlasnosciSurowce.size(); i++) {
            if (this.WlasnosciSurowce.get(i).getIlosc() > 0) {
                synchronized (this.WlasnosciSurowce.get(i).getSurowiec()) {


                    int ilosc = rand.nextInt(this.WlasnosciSurowce.get(i).getIlosc());
                    this.WlasnosciSurowce.get(i).usunsurowce(ilosc);
                    this.dodajbudzet(ilosc * this.WlasnosciSurowce.get(i).getSurowiec().getAktualnaWartosc());
                    this.WlasnosciSurowce.get(i).getSurowiec().nowacena(ilosc);

                }
            }
        }
    }
    public void kupjednostki(){
        Random rand = new Random();
        FunduszInwestycyjny funduszInwestycyjny = Inicjuj.getFundusze().get(rand.nextInt(Inicjuj.getFundusze().size()));


            synchronized (funduszInwestycyjny) {


                int pom = ((int) this.getBudzet());



                pom = pom / 10;


                double budzet = (double) (rand.nextInt(pom));

                int dostepnailosc = (int) (budzet / (funduszInwestycyjny.getJednostkaUczestnictwa().getAktualnaWartosc() ));
                if(dostepnailosc>5){dostepnailosc=2;}


                this.wydaj(dostepnailosc * (funduszInwestycyjny.getJednostkaUczestnictwa().getAktualnaWartosc() ));

                for (int u = 0; u < this.WlasnosciJednostki.size(); u++) {
                    if (this.WlasnosciJednostki.get(u).getFunduszInwestycyjny() == funduszInwestycyjny) {
                        this.WlasnosciJednostki.get(u).dodajjednostke(dostepnailosc);
                    }
                }

            }


    }
    public void sprzedajjednostki(){
        Random rand = new Random();

        for (int i = 0; i < this.WlasnosciJednostki.size(); i++) {

            if (this.WlasnosciJednostki.get(i).getIlosc() > 0) {
                synchronized (this.WlasnosciJednostki.get(i).getFunduszInwestycyjny()) {


                    int ilosc = rand.nextInt(this.WlasnosciJednostki.get(i).getIlosc());
                    this.WlasnosciJednostki.get(i).usunjednostke(ilosc);
                    this.dodajbudzet(ilosc * this.WlasnosciJednostki.get(i).getFunduszInwestycyjny().getJednostkaUczestnictwa().getAktualnaWartosc());


                }
            }
        }
    }
    public void kuprandom(){
        Random rand = new Random();
        int i=rand.nextInt(4);
        if(i==0){
            this.kupakcje();
        }
        else if(i==1){
            this.kupwaluty();
        }
        else if(i==2){
            this.kupsurowiec();
        }
        else if(i==3){
            this.kupjednostki();
        }
    }
    public void sprzedajrandom(){
        Random rand = new Random();
        int i=rand.nextInt(4);
        if(i==0){
            this.sprzedajakcje();
        }
        else if(i==1){
            this.sprzedajwalty();
        }
        else if(i==2){
            this.sprzedajsurowiec();
        }
        else if(i==3){
            this.sprzedajjednostki();
        }

    }







    @Override
    public void run() {
        Random rand = new Random();
        while(!zarzadzanewatkami.isWszytkieWatki()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while(this.isWatek() && zarzadzanewatkami.isWszytkieWatki()) {

            try {

                this.kuprandom();
                this.wycensie();


                Thread.sleep(rand.nextInt(1000)+1000);

                this.sprzedajrandom();
                this.wycensie();

                Thread.sleep(rand.nextInt(1000)+1000);
                this.generujbudzet();
                this.wycensie();




            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
