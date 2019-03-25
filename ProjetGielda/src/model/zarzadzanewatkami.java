package model;

import java.util.ArrayList;

public class zarzadzanewatkami {
    private static ArrayList<Thread> Watki = new ArrayList<>();
    private static boolean wszytkieWatki = false;

    public static void dodajirozpocznij(Thread thread) {
        Watki.add(thread);
        thread.start();
    }
    public static void zatrzymajwszystko() {
        wszytkieWatki = false;
        zaczekajnawszysko();
        Watki = new ArrayList<>();
    }

    public static ArrayList<Thread> getWatki() {
        return Watki;
    }

    public static void setWatki(ArrayList<Thread> watki) {
        Watki = watki;
    }

    public static boolean isWszytkieWatki() {
        return wszytkieWatki;
    }

    public static void setWszytkieWatki(boolean wszytkieWatki) {
        zarzadzanewatkami.wszytkieWatki = wszytkieWatki;
    }

    private static void zaczekajnawszysko() {
        Watki.forEach(rec -> {
            try {
                rec.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
