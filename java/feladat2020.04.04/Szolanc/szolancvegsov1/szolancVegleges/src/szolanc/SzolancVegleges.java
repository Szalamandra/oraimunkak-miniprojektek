package szolanc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

class Elem implements Comparable<Elem> {    //POJO

    private String elem;

    public String getElemEkezetlenitve() {
        return Normalizer.normalize(elem.toLowerCase(), Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    @Override
    public String toString() {
        return elem.toLowerCase() + " ";
    }

    public Elem(String elem) {    //konstruktor
        this.elem = elem;
    }

    public char getKezdoBetu() {
        return elem.toLowerCase().charAt(0);
    }

    @Override
    public int compareTo(Elem o) {
        int eredmeny = this.elem.compareTo(o.getElemEkezetlenitve());
        return eredmeny;
    }
}

public class SzolancVegleges {   //vezérlő

    private static String inputFajlUtvonal = "./files/elemekMagyar.txt";

    private static TreeSet<Elem> szovegElokeszites(String fajlUtvonal) {    //a fájlból beolvasott elemekből objektumokat gyártunk, és eltároljuk őket
        String elemekString = "";
        try {   //hibakezelés
            elemekString = new String(Files.readAllBytes(Paths.get(fajlUtvonal)));
        } catch (IOException e) {        
            System.out.println("Hiba: " + e.getMessage() + " (156485)");
            System.exit(-1);
        }
        String[] elemekTomb = elemekString.split(" ");
        Arrays.sort(elemekTomb, Collections.reverseOrder());

        TreeSet<Elem> elemekListaObj = new TreeSet<>();
        for (String s : elemekTomb) {
            elemekListaObj.add(new Elem(s));
        }

        return elemekListaObj;
    }

    static String readLine(String üzenet) {     //a játékhoz bekérünk a felhasználótól egy tippet, majd validáljuk azt
        boolean ok = false;
        String valasz = "";
        do {
            try {
                BufferedReader konzol = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-2"));
                System.out.print(üzenet);
                String beolvasottSzöveg = konzol.readLine();
                valasz = Normalizer.normalize(beolvasottSzöveg.toLowerCase(), Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                valasz = valasz.replaceAll("[^a-z]", "");
                ok = true;
            } catch (Exception e) {
                System.out.println("Nem jó. Újra!");
            }
        } while (!ok);
        return valasz;
    }

    static int readInt(String üzenet) {         //a menübő való választáshoz bekérjük egy menüpont számát
        BufferedReader konzol = new BufferedReader(new InputStreamReader(System.in));
        boolean ok = false;
        int egészSzám = 0;
        do {
            try {
                System.out.print(üzenet);
                String beolvasottSzöveg = konzol.readLine().trim();
                egészSzám = Integer.parseInt(beolvasottSzöveg);
                ok = true;
            } catch (Exception e) {
                System.out.println("Nem egész! Újra!");
            }
        } while (!ok);
        return egészSzám;
    }

    private static boolean tartalmaz(TreeSet<Elem> elemekObj, String valasz) { //megnézzük, hogy egy objektumokat tartalmazó kollekcióban benne van-e adott nevű elem
        TreeSet<String> elemekLista = new TreeSet<>();
        for (Elem s : elemekObj) {
            elemekLista.add(s.getElemEkezetlenitve());
        }
        return (elemekLista.contains(valasz));
    }

    private static TreeSet<String> getJoKezdobetusElemekLista(TreeSet<Elem> objLista, String valasz) { //megkeressük a jó kezdőbetűvel kezdődő elemeket és kollekciót hozunk létre belőlük
        TreeSet<String> lista = new TreeSet<>();
        for (Elem e : objLista) {
            if (e.getKezdoBetu() == valasz.charAt(valasz.length() - 1)) {
                lista.add(e.toString());
            }
        }
        return lista;
    }

    public static void main(String[] args) {
        int menu = 0;
        do {
            TreeSet<Elem> elemekListaObj = szovegElokeszites(inputFajlUtvonal);   //minden elemet objektumként eltárolunk
            String valasz;      //ez lesz a játékos "tippje"
            int i = 0;            //ezzel számoljuk, melyik játékos jön - páros: A, pártalan: B
            TreeSet<String> joKezdobetusElemekLista = new TreeSet<>();        //ebben a kollekcióban fogjuk a jó kezdőbetűvel kezdődő szavakat gyűjteni
            TreeSet<String> kiesettSzavakLista = new TreeSet<>();    //gyűjtjük a kiesett szavakat, hogy visszajelezhessünk a játékosnak, ha már volt a tipp

            for (Elem s : elemekListaObj) //kiírjuk a választható elemeket    
            {
                System.out.print(s);
            }

            do {
                do {
                    valasz = readLine((i % 2 == 0) ? "\n'A' játékos tippje: " : "\n'B' játekos tippje: ");   //kérjük a mgefelelő játékost, hogy válasszon
                    if (!tartalmaz(elemekListaObj, valasz) && !kiesettSzavakLista.contains(valasz)) {
                        System.out.print("Nincs ilyen elem, újra.");    //visszajelzünk neki, ha nem létező elemet írt
                    }
                    if (kiesettSzavakLista.contains(valasz)) {
                        System.out.print("Már volt, újra.");    //visszajelzünk neki, ha már volt a tipp
                    }
                } while (!tartalmaz(elemekListaObj, valasz));        //addig megy a válasz bekérése, amíg olyat nem ír, ami jó

                i++;                                   //léptetjük a játékos "számlálót"

                String valasz1 = valasz;
                elemekListaObj.removeIf(n -> (n.getElemEkezetlenitve().equals(valasz1)));    //kiszedjük a választ a választható elemek közül
                kiesettSzavakLista.add(valasz);     //gyűjtjük a kiesett elemeket

                joKezdobetusElemekLista = getJoKezdobetusElemekLista(elemekListaObj, valasz); //megkeressük a jó kezdőbetűvel kezdődő szavakat
                if ((joKezdobetusElemekLista.size() > 1)) {   //ha még legalább kettő választási lehetőség van, akkor megy tovább a játék
                    System.out.println("Választható elemek:");
                    for (String s : joKezdobetusElemekLista) //kiírjuk a maradék választékot
                    {
                        System.out.print(s);
                    }
                }
            } while (!(joKezdobetusElemekLista.size() <= 1));     //ha már nincs választási lehetőség, vége a játéknak

            System.out.println("---Kör vége---");               //a kör végén kiírjuk az eredményeket
            if (joKezdobetusElemekLista.size() == 1) {
                System.out.print((i % 2 == 0) ? "'A' játékos nyert " : "'B' játekos nyert ");
            } else {
                System.out.print((i % 2 == 0) ? "'B' játékos nyert " : "'A' játekos nyert ");
            }
            System.out.println(i + " körben.");

            System.out.println("\n***Menü***\n1 - Még egy játék indítása\n" + "0 - Kilépés");     //kiírjuk a menüt
            do {
                menu = readInt("Válasszon a menüpontok közül: ");
                if (!(menu == 1 || menu == 0)) {
                    System.out.println("Kérjük a menü lehetőségei közül válasszon");
                }
            } while (!(menu == 1 || menu == 0));
            switch (menu) {
                case 1:
                    System.out.println("Újabb játék:");
                    break;
                case 0:
                    System.out.println("---Játék vége---");
                    break;
            }
        } while (menu != 0);
        System.out.println("Viszlát!");
    }
}
