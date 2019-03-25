package model;

import java.io.Serializable;
import java.util.Random;

public class Spolka implements Runnable ,Serializable {

    private String nazwa;
    private String dataPierwszejWyceny;
    private double kursOtwarcia;
    private double aktualnyKurs;
    private double minimalnyKurs;
    private int liczbaAkcji;
    private int dostepneAkcje;
    private double zysk;
    private double przychod;
    private double kapitalWlasny;
    private double kapitalZakladowy;
    private int wolumen;
    private int starywolumen;
    private double obroty;
    private Akcja akcja;
    private boolean watek=true;


    public Spolka(){

        String[] nazwaL = {"dobrebuty","budex","najlepszeopony","supergry","zabawki","Kola","Dobre Samochody"};
        String[] data = {"1.1.1000","2.2.2001","4,2,2001","3.2.2013"};
        Random rand = new Random();
        this.nazwa = nazwaL[rand.nextInt(nazwaL.length)];
        this.dataPierwszejWyceny = data[rand.nextInt(data.length)];
        this.kursOtwarcia = 10+(double)(rand.nextInt(100000))/100;//?
        this.aktualnyKurs = kursOtwarcia;
        this.minimalnyKurs = kursOtwarcia;
        this.liczbaAkcji=0;
        this.zysk = (double)(rand.nextInt(100000))/100;
        this.przychod = this.zysk+(double)(rand.nextInt(100000))/100;
        this.kapitalWlasny = (double)(rand.nextInt(100000))/100;
        this.kapitalZakladowy = (double)(rand.nextInt(100000))/100;
        this.wolumen = 0;
        this.starywolumen=0;
        this.obroty = 0;
        this.dostepneAkcje=0;


        this.akcja = new Akcja(this);
        Gielda gielda = Inicjuj.getGieldy().get(rand.nextInt(Inicjuj.getGieldy().size()));
        gielda.getIndeks().dodaj(this);

        utworziurochumwatek();

    }
    public void utworziurochumwatek(){

        zarzadzanewatkami.dodajirozpocznij(new Thread(this));
    }

    @Override
    public String toString() {
        return this.getNazwa();
    }

    public boolean isWatek() {
        return watek;
    }

    public void setWatek(boolean watek) {
        this.watek = watek;
    }



    public int getStarywolumen() {
        return starywolumen;
    }

    public void setStarywolumen(int starywolumen) {
        this.starywolumen = starywolumen;
    }

    public void dodajdostepneakcje(int x){

        if(x>0){this.setDostepneAkcje(this.getDostepneAkcje()+x);}
    }

    public int getDostepneAkcje() {
        return dostepneAkcje;
    }

    public void setDostepneAkcje(int dostepneAkcje) {

        if(dostepneAkcje>=0){this.dostepneAkcje = dostepneAkcje;}
        else{this.dostepneAkcje=0;}
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getDataPierwszejWyceny() {
        return dataPierwszejWyceny;
    }

    public void setDataPierwszejWyceny(String dataPierwszejWyceny) {
        this.dataPierwszejWyceny = dataPierwszejWyceny;
    }

    public double getKursOtwarcia() {
        return kursOtwarcia;
    }

    public void setKursOtwarcia(double kursOtwarcia) {
        this.kursOtwarcia = kursOtwarcia;
    }

    public double getAktualnyKurs() {
        return aktualnyKurs;
    }

    public void setAktualnyKurs(double aktualnyKurd) {
    if(aktualnyKurd>0){
        this.aktualnyKurs = aktualnyKurd;
        if (aktualnyKurd<this.getMinimalnyKurs()){
            this.minimalnyKurs=aktualnyKurd;
        }
        this.akcja.dodajdohistori(aktualnyKurd);}
    }

    public double getMinimalnyKurs() {
        return minimalnyKurs;
    }

    public void setMinimalnyKurs(double minimalnyKurs) {
        this.minimalnyKurs = minimalnyKurs;
    }

    public int getLiczbaAkcji() {
        return liczbaAkcji;
    }

    public void setLiczbaAkcji(int liczbaAkcji) {

        if(liczbaAkcji>=0){this.liczbaAkcji = liczbaAkcji;}
        else{this.liczbaAkcji=0;}
    }

    public double getZysk() {
        return zysk;
    }

    public void setZysk(double zysk) {
        this.zysk = zysk;
    }

    public double getPrzychod() {
        return przychod;
    }

    public void setPrzychod(double przychod) {
        this.przychod = przychod;
    }

    public double getKapitalWlasny() {
        return kapitalWlasny;
    }

    public void setKapitalWlasny(double kapitalWlasny) {
        this.kapitalWlasny = kapitalWlasny;
    }

    public double getKapitalZakladowy() {
        return kapitalZakladowy;
    }

    public void setKapitalZakladowy(double kapitalZakladowy) {
        this.kapitalZakladowy = kapitalZakladowy;
    }

    public int getWolumen() {
        return wolumen;
    }

    public void setWolumen(int wolumen) {
        if(wolumen>0) {
            this.wolumen = wolumen;
        }
        else{
            this.wolumen=0;
        }
        }

    public double getObroty() {
        return obroty;
    }

    public void setObroty(double obroty) {
        this.obroty = obroty;
    }

    public Akcja getAkcja() {
        return akcja;
    }

    public void setAkcja(Akcja akcja) {
        this.akcja = akcja;
    }

    public void generujprzychod(){
        Random rand = new Random();
        this.zysk+=(double)(rand.nextInt(10000))/100;
        this.przychod = this.zysk+(double)(rand.nextInt(10000))/100;
    }
    public synchronized void wypuscakcje(){
        Random rand = new Random();

        int x=rand.nextInt(1000);
        this.setLiczbaAkcji(this.getLiczbaAkcji()+x);
        this.setDostepneAkcje(this.getDostepneAkcje()+x);


    }
    public void wykupakcje(double cena){
        this.setDostepneAkcje(0);
        this.setLiczbaAkcji(0);
        for (Inwestor inwestor : Inicjuj.getInwestorzy()) {
            synchronized (inwestor) {
                for (Posiadanie posiadanie : inwestor.getWlasnosciAkcje()) {
                    if (posiadanie.getSpolka() == this) {
                        inwestor.dodajbudzet(posiadanie.getIlosc() * cena);
                        posiadanie.setIlosc(0);
                    }
                }
            }
        }
    }
    public synchronized void ustalkurs(){
        Random rand = new Random();
            double zmiana = rand.nextDouble() / 4;
            if(this.getAktualnyKurs()>this.getKursOtwarcia()*3){
                if(rand.nextInt(3)==0){
                    this.setAktualnyKurs((this.getAktualnyKurs()/(rand.nextInt(4)+1))+1);
                    System.out.println(this.getAktualnyKurs());
                }
            }
            else if (this.getWolumen() > this.getStarywolumen()) {
            this.setAktualnyKurs(this.getAktualnyKurs() * (zmiana*2 + 1));
            }
            else if(rand.nextInt(10)==0){setAktualnyKurs(this.getAktualnyKurs()*2);}
            else if(rand.nextInt(10)==0){setAktualnyKurs(this.getAktualnyKurs()/2);}
            else {
                this.setAktualnyKurs(this.getAktualnyKurs() * (1-zmiana) );
            }
            this.akcja.setAktualnaWartosc(this.getAktualnyKurs());
            this.setStarywolumen(this.getWolumen());
            this.setWolumen(0);

    }
    public void run(){
        Random rand = new Random();
        while(!zarzadzanewatkami.isWszytkieWatki()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int test=0;
        while(zarzadzanewatkami.isWszytkieWatki() && this.isWatek()) {
            try {
                if(this.getDostepneAkcje()<0){
                System.out.println(this.getDostepneAkcje() + " "+ this.getLiczbaAkcji());}
                this.wypuscakcje();
                Thread.sleep(rand.nextInt(1000)+1000);
                this.ustalkurs();
                Thread.sleep(rand.nextInt(1000)+1000);
                this.generujprzychod();
                test++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
