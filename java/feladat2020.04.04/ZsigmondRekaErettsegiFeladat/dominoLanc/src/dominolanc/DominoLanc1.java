package dominolanc;

import java.util.ArrayList;

class Domino {

    private int oldal1;
    private int oldal2;

    public Domino(int oldal1, int oldal2) {           //konstruktor egy dominohoz
        if (oldal1 > 6) {
            throw new IllegalArgumentException("Hiba! Ilyen oldalú domino nem megengedett ebben a feladatban!.");
        }
        if (oldal2 > 6) {
            throw new IllegalArgumentException("Hiba! Ilyen oldalú domino nem megengedett ebben a feladatban!.");
        }
        this.oldal1 = oldal1;
        this.oldal2 = oldal2;
    }

    public int getOldal1() {
        return oldal1;
    }

    public int getOldal2() {
        return oldal2;
    }

    @Override                                //egy domino kinézete, kiíratása
    public String toString() {
        return getOldal1() + " | " + getOldal2();
    }

    @Override
    public boolean equals(Object obj) {                //két dominó, összehasonlításához, equals metódus felülírása a Domino objektumra
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Domino)) {
            return false;
        }
        Domino d = (Domino) obj;
        return (Integer.compare(oldal1, d.oldal2) == 0 && Integer.compare(oldal2, d.oldal1) == 0)
                || (Integer.compare(oldal1, d.oldal1) == 0 && Integer.compare(oldal2, d.oldal2) == 0);
    }

    public int compareTo(Domino o1) {                 // sorrandbe tudjuk rendezni a Dominokat       
        dominolanc.Domino o2 = new dominolanc.Domino(oldal1, oldal2);
        if (o1.oldal1 > o2.getOldal1()) {
            return -1;
        }
        if (o1.equals(o2)) {
            return 0;
        }
        if (o1.oldal2 < o2.getOldal2()) {
            return 1;
        } else {
            return 1;
        }
    }
}

class DominoDoboz {

    private int[] oldalak = {0, 1, 2, 3, 4, 5, 6};
    private ArrayList<Domino> doboz = new ArrayList<>();

    public DominoDoboz() {                    //konstruktor egy doboznyi dominohoz
        doboz = dobozKeszit();
    }

    public ArrayList getDoboz() {
        return doboz;
    }

    public ArrayList<Domino> dobozKeszit() {                          //egy doboznyi dominó készítése
        doboz = new ArrayList();
        for (int i = 0; i < oldalak.length; i++) {
            for (int j = 0; j < oldalak.length; j++) {
                Domino d = new Domino(i, j);
                if (!(doboz.contains(d))) {
                    getDoboz().add(d);
                }
            }
        }
        return doboz;
    }

    public ArrayList<Domino> primetSzorzatKiválaszt(ArrayList doboz) {
        this.doboz = doboz;
        ArrayList<Domino> ujDoboz = new ArrayList<>();
        for (Domino d : this.doboz) {
            if (d.getOldal1() == 1 && (d.getOldal2() == 2 || d.getOldal2() == 3 || d.getOldal2() == 5)) {
                ujDoboz.add(d);
            }
        }
        this.doboz = ujDoboz;
        System.out.println(ujDoboz);
        return ujDoboz;
    }

    public ArrayList<Domino> csatlakozokKeresesEgy(ArrayList<Domino> doboz, int[] oldal) {
        this.doboz = doboz;
        ArrayList<Domino> ujDoboz = new ArrayList<>();
        boolean ok = false;
        while (!ok) {
            for (int i = 0; i < oldal.length; i++) {                    //ez a domino első odlalát változtatja
                for (int j = 0; j < doboz.size(); j++) {
                    for (int x = 0; x < oldal.length; x++) {                //ez a domino másik oldalát változtatja 
                        if ((doboz.get(j).getOldal1() == oldal[i] && doboz.get(j).getOldal2() == oldal[x])) {
                            ujDoboz.add(doboz.get(j));
                        }
                    }
                }
            }
            ok = true;
        }
        return ujDoboz;

    }

    public ArrayList<Domino> csatlakozokKeresesKetto(ArrayList<Domino> doboz, int[] oldal1, int[] oldal2) {                  //atalakitása az előző metodusnak, amiben mindkét oldallehetőség lehet külön tömbből
        this.doboz = doboz;
        ArrayList<Domino> ujDoboz = new ArrayList<>();
        Domino kihuzott = new Domino(oldal1[0], oldal1[1]);
        boolean ok = false;

        while (!ok) {
            for (int j = 0; j < doboz.size(); j++) {                    //ez a domino első odlalát változtatja
                for (int i = 0; i < oldal1.length; i++) {                     //j halad végig a doboz dominóin
                    for (int x = 0; x < oldal2.length; x++) {                //ez a domino másik oldalát változtatja 
                        if ((doboz.get(j).getOldal1() == oldal1[i] && doboz.get(j).getOldal2() == oldal2[x]) || (doboz.get(j).getOldal1() == oldal2[x] && doboz.get(j).getOldal2() == oldal1[i]) && !doboz.get(j).equals(kihuzott)) {
                            ujDoboz.add(doboz.get(j));
                        }
                    }
                }
            }
            ok = true;
            ujDoboz.removeIf(n -> (n.equals(kihuzott)));
        }
        return ujDoboz;

    }

    public void Kiir() {
        doboz.forEach((domino) -> {
            System.out.print(domino.toString() + ", ");
        });

        System.out.print(" A dobozban " + doboz.size() + "számú dominó van.");
    }

    public String toString() {
        return (this.doboz.size() + " db domino a megoldás.");
    }

}
