package model;

import java.io.*;
import java.util.ArrayList;

public  class Inicjuj {
    private static ArrayList<Gielda> Gieldy;
    private static ArrayList<Spolka> Spolki;
    private static ArrayList<Inwestor> Inwestorzy;
    private static ArrayList<Waluta> Waluty;
    private static ArrayList<RynekWalut> RynkiWalut;
    private static ArrayList<RynekSurowcow> RynkiSurowcow;
    private static ArrayList<Surowiec> Surowce;
    private static ArrayList<FunduszInwestycyjny> Fundusze;

    public static void Inicjujwszystko(int liczbaGield, int liczbaSpolek, int liczbaWalut, int liczbaRynkowWalut, int liczbaSurowcow, int liczbaRynkowSurowcow){
        Inicjuj.Gieldy=new ArrayList<>();
        Inicjuj.Spolki=new ArrayList<>();
        Inicjuj.Inwestorzy=new ArrayList<>();
        Inicjuj.Waluty=new ArrayList<>();
        Inicjuj.RynkiWalut=new ArrayList<>();
        Inicjuj.RynkiSurowcow=new ArrayList<>();
        Inicjuj.Surowce=new ArrayList<>();
        Inicjuj.Fundusze = new ArrayList<>();
        for(int i=0;i<liczbaRynkowSurowcow;i++){
            Inicjuj.RynkiSurowcow.add(new RynekSurowcow());
        }
        for(int i=0;i<liczbaSurowcow;i++){
            Inicjuj.Surowce.add(new Surowiec());
        }
        for(int i=0;i<liczbaRynkowWalut;i++){
            Inicjuj.RynkiWalut.add(new RynekWalut());
        }
        for(int i=0;i<liczbaWalut;i++){
            Inicjuj.Waluty.add(new Waluta());
        }
        for(int i=0;i<liczbaGield;i++){
            Inicjuj.Gieldy.add(new Gielda());
        }
        for(int i=0;i<liczbaSpolek;i++){
            Inicjuj.Spolki.add(new Spolka());
        }
        int liczbaFunduszy=liczbaSpolek*5;
        for (int i = 0; i < liczbaFunduszy; i++) {
            Inicjuj.Fundusze.add(new FunduszInwestycyjny());
        }
        int liczbaInwestorow=liczbaSpolek*50;
        for(int i=0;i<liczbaInwestorow;i++){
            Inicjuj.Inwestorzy.add(new Inwestor());
        }

        zarzadzanewatkami.setWszytkieWatki(true);

    }
    public static void dodajwalute(){

        Waluta waluta = new Waluta();
        Inicjuj.getWaluty().add(waluta);
        for(int i=0;i<Inicjuj.getInwestorzy().size();i++) {
            synchronized (Inicjuj.getInwestorzy().get(i)) {
                Inicjuj.getInwestorzy().get(i).getWlasnosciWaluty().add(new PosiadanieWalut(waluta));

            }
        }
        for(int i=0;i<Inicjuj.getFundusze().size();i++) {
            synchronized (Inicjuj.getFundusze().get(i)) {
                Inicjuj.getFundusze().get(i).getWlasnosciWaluty().add(new PosiadanieWalut(waluta));

            }
        }
    }
    public static void usunwalute(Waluta waluta){
        Inicjuj.getWaluty().remove(waluta);
        for(int i=0;i<Inicjuj.getInwestorzy().size();i++){
            Inwestor inwestor= Inicjuj.getInwestorzy().get(i);
            for(int j=0;j<inwestor.getWlasnosciWaluty().size();j++) {
                synchronized (inwestor) {
                    if (inwestor.getWlasnosciWaluty().get(j).getWaluta() == waluta) {
                        inwestor.getWlasnosciWaluty().remove(j);
                    }
                }
            }
        }
        for(int i=0;i<Inicjuj.getFundusze().size();i++){
            FunduszInwestycyjny funduszInwestycyjny= Inicjuj.getFundusze().get(i);
            for(int j=0;j<funduszInwestycyjny.getWlasnosciWaluty().size();j++) {
                synchronized (funduszInwestycyjny) {
                    if (funduszInwestycyjny.getWlasnosciWaluty().get(j).getWaluta() == waluta) {
                        funduszInwestycyjny.getWlasnosciWaluty().remove(j);
                    }
                }
            }
        }
        for(int i=0;i<Inicjuj.getRynkiWalut().size();i++){
            Inicjuj.getRynkiWalut().get(i).getListaWalut().remove(waluta);
        }
        waluta=null;
    }
    public static void dodajsurowiec(){

        Surowiec surowiec = new Surowiec();
        Inicjuj.getSurowce().add(surowiec);
        for(int i=0;i<Inicjuj.getInwestorzy().size();i++) {
            synchronized (Inicjuj.getInwestorzy().get(i)) {
                Inicjuj.getInwestorzy().get(i).getWlasnosciSurowce().add(new PosiadanieSur(surowiec));

            }
        }
        for(int i=0;i<Inicjuj.getFundusze().size();i++) {
            synchronized (Inicjuj.getFundusze().get(i)) {
                Inicjuj.getFundusze().get(i).getWlasnosciSurowce().add(new PosiadanieSur(surowiec));

            }
        }
    }
    public static void usunsurowiec(Surowiec surowiec){
        Inicjuj.getSurowce().remove(surowiec);
        for(int i=0;i<Inicjuj.getInwestorzy().size();i++){
            Inwestor inwestor= Inicjuj.getInwestorzy().get(i);
            for(int j=0;j<inwestor.getWlasnosciSurowce().size();j++) {
                synchronized (inwestor) {
                    if (inwestor.getWlasnosciSurowce().get(j).getSurowiec() == surowiec) {
                        inwestor.getWlasnosciSurowce().remove(j);
                    }
                }
            }
        }
        for(int i=0;i<Inicjuj.getFundusze().size();i++){
            FunduszInwestycyjny funduszInwestycyjny= Inicjuj.getFundusze().get(i);
            for(int j=0;j<funduszInwestycyjny.getWlasnosciSurowce().size();j++) {
                synchronized (funduszInwestycyjny) {
                    if (funduszInwestycyjny.getWlasnosciSurowce().get(j).getSurowiec() == surowiec) {
                        funduszInwestycyjny.getWlasnosciSurowce().remove(j);
                    }
                }
            }
        }
        for(int i=0;i<Inicjuj.getRynkiSurowcow().size();i++){
            Inicjuj.getRynkiSurowcow().get(i).getListaSurowcow().remove(surowiec);
        }
        surowiec=null;
    }
    public static void usuninwestora(Inwestor inwestor){
        Inicjuj.getInwestorzy().remove(inwestor);
        for (Posiadanie posiadanie : inwestor.getWlasnosciAkcje()) {
            synchronized (posiadanie.getSpolka()){
            posiadanie.getSpolka().setDostepneAkcje(posiadanie.getIlosc()+posiadanie.getSpolka().getDostepneAkcje());
        }}
    }
    public static void usunfundusz(FunduszInwestycyjny funduszInwestycyjny){
        Inicjuj.getFundusze().remove(funduszInwestycyjny);
        for (Posiadanie posiadanie : funduszInwestycyjny.getWlasnosciAkcje()) {
            synchronized (posiadanie.getSpolka()){
                posiadanie.getSpolka().setDostepneAkcje(posiadanie.getIlosc()+posiadanie.getSpolka().getDostepneAkcje());
            }}
        for(int i=0;i<Inicjuj.getInwestorzy().size();i++){
            Inwestor inwestor= Inicjuj.getInwestorzy().get(i);
            for(int j=0;j<inwestor.getWlasnosciJednostki().size();j++) {
                synchronized (inwestor) {
                    if (inwestor.getWlasnosciJednostki().get(j).getFunduszInwestycyjny() == funduszInwestycyjny) {
                        inwestor.getWlasnosciJednostki().remove(j);
                    }
                }
            }
        }


    }


    public static void usunspolke(Spolka spolka){
        spolka.setWatek(false);
        Inicjuj.getSpolki().remove(spolka);

        for (Gielda gielda : Gieldy) {
            gielda.getIndeks().getListaSpolek().remove(spolka);

        }
        for (Inwestor inwestor : Inwestorzy) {
            for (int i = 0; i < inwestor.getWlasnosciAkcje().size(); i++) {
                synchronized (inwestor) {
                    if (inwestor.getWlasnosciAkcje().get(i).getSpolka() == spolka) {
                        inwestor.getWlasnosciAkcje().remove(i);
                    }
                }
            }

        }
        for (FunduszInwestycyjny fundusz : Fundusze) {
            for (int i = 0; i < fundusz.getWlasnosciAkcje().size(); i++) {
                synchronized (fundusz) {
                    if (fundusz.getWlasnosciAkcje().get(i).getSpolka() == spolka) {
                        fundusz.getWlasnosciAkcje().remove(i);
                    }
                }
            }

        }

    }
    public static void dodajspolke(){
        Spolka spolka = new Spolka();
        Inicjuj.getSpolki().add(spolka);
        for (Inwestor inwestor : Inicjuj.getInwestorzy()) {
            synchronized (inwestor) {
                inwestor.getWlasnosciAkcje().add(new Posiadanie(spolka));
            }
        }
        for(int i=0;i<Inicjuj.getFundusze().size();i++) {
            synchronized (Inicjuj.getFundusze().get(i)) {
                Inicjuj.getFundusze().get(i).getWlasnosciAkcje().add(new Posiadanie(spolka));

            }
        }

    }
    public static void dodajgielde(){
        Gielda gielda = new Gielda();
        Gieldy.add(gielda);
    }
    public static void dodajryneksur(){
        RynekSurowcow rynek = new RynekSurowcow();
        RynkiSurowcow.add(rynek);
    }
    public static void dodajrynekwalut(){
        RynekWalut rynek = new RynekWalut();
        RynkiWalut.add(rynek);
    }
    public static void zapisz(){
        try {
            zarzadzanewatkami.zatrzymajwszystko();


            FileOutputStream fileOut =
                    new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(RynkiSurowcow);
            out.writeObject(Surowce);
            out.writeObject(RynkiWalut);
            out.writeObject(Waluty);
            out.writeObject(Gieldy);
            out.writeObject(Spolki);
            out.writeObject(Fundusze);
            out.writeObject(Inwestorzy);
            Spolki.forEach(spolka -> spolka.utworziurochumwatek());
            Inwestorzy.forEach(inwestor -> inwestor.utworziurochumwatek());
            Fundusze.forEach(funduszInwestycyjny -> funduszInwestycyjny.utworziurochumwatek());
            zarzadzanewatkami.setWszytkieWatki(true);

            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved");


        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public static void odczytaj(){
        try {

            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            RynkiSurowcow = (ArrayList<RynekSurowcow>) in.readObject();
            Surowce = (ArrayList<Surowiec>) in.readObject();
            RynkiWalut = (ArrayList<RynekWalut>) in.readObject();
            Waluty = (ArrayList<Waluta>) in.readObject();
            Gieldy = (ArrayList<Gielda>) in.readObject();
            Spolki = (ArrayList<Spolka>) in.readObject();
            Fundusze = (ArrayList<FunduszInwestycyjny>) in.readObject();
            Inwestorzy = (ArrayList<Inwestor>) in.readObject();

            in.close();
            fileIn.close();

            Spolki.forEach(spolka -> spolka.utworziurochumwatek());
            Inwestorzy.forEach(inwestor -> inwestor.utworziurochumwatek());
            Fundusze.forEach(funduszInwestycyjny -> funduszInwestycyjny.utworziurochumwatek());
            zarzadzanewatkami.setWszytkieWatki(true);


        } catch (IOException i) {
            i.printStackTrace();

        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();

        }
    }


    public static ArrayList<FunduszInwestycyjny> getFundusze() {
        return Fundusze;
    }

    public static void setFundusze(ArrayList<FunduszInwestycyjny> fundusze) {
        Fundusze = fundusze;
    }

    public static ArrayList<RynekSurowcow> getRynkiSurowcow() {
        return RynkiSurowcow;
    }

    public static void setRynkiSurowcow(ArrayList<RynekSurowcow> rynkiSurowcow) {
        RynkiSurowcow = rynkiSurowcow;
    }

    public static ArrayList<Surowiec> getSurowce() {
        return Surowce;
    }

    public static void setSurowce(ArrayList<Surowiec> surowce) {
        Surowce = surowce;
    }

    public static ArrayList<Gielda> getGieldy() {
        return Gieldy;
    }

    public static void setGieldy(ArrayList<Gielda> gieldy) {
        Gieldy = gieldy;
    }

    public static ArrayList<Spolka> getSpolki() {
        return Spolki;
    }

    public static void setSpolki(ArrayList<Spolka> spolki) {
        Spolki = spolki;
    }

    public static ArrayList<Inwestor> getInwestorzy() {
        return Inwestorzy;
    }

    public static void setInwestorzy(ArrayList<Inwestor> inwestorzy) {
        Inwestorzy = inwestorzy;
    }

    public static ArrayList<Waluta> getWaluty() {
        return Waluty;
    }

    public static void setWaluty(ArrayList<Waluta> waluty) {
        Waluty = waluty;
    }

    public static ArrayList<RynekWalut> getRynkiWalut() {
        return RynkiWalut;
    }

    public static void setRynkiWalut(ArrayList<RynekWalut> rynkiWalut) {
        RynkiWalut = rynkiWalut;
    }
}
