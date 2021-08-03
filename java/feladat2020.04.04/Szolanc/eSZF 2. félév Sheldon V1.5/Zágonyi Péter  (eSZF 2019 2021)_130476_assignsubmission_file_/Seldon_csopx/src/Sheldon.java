//
//import java.io.*;
//import java.text.Collator;
//import java.text.Normalizer;
//import java.text.Normalizer.Form;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Locale;
//import java.util.Scanner;
//
//class Elemek {
//
//    private char elsoBetu;
//    private char utolsoBetu;
//    private String elem;
//
//    public Elemek(String elem) {
//        this.elsoBetu = elem.charAt(0);
//        this.utolsoBetu = elem.charAt(elem.length() - 1);
//        this.elem = elem;
//
//    }
//
//    public String getElemek() {
//        return elem;
//    }
//
//    public char getUtolsoBetu() {
//        return utolsoBetu;
//    }
//
//    public char getElsoBetu() {
//        return elsoBetu;
//    }
//
//    @Override
//    public String toString() {
//        return elem;
//    }
//
//}
//
//public class Sheldon {
//
//    private static ArrayList beolvas() {
//        ArrayList<Elemek> elemek = new ArrayList<>();
//        try {
//            BufferedReader input = new BufferedReader(new FileReader("src/elemekMagyarr.txt"));
//            String bemenet = "";
//            while ((bemenet = input.readLine()) != null) {
//                for (int i = 0; i < 2; i++) 
//                    bemenet = bemenet.substring(bemenet.indexOf("\t") + 1);             
//                elemek.add(new Elemek(bemenet.substring(0, bemenet.indexOf("\t")).toLowerCase()));
//            }
//            input.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("A fájl nem található");
//        } catch (IOException ex) {
//            System.out.println("Hiba a fájl olvasása közben."+ex);
//        }
//        Collections.sort(elemek, new Comparator<Elemek>() {
//            @Override
//            public int compare(Elemek e1, Elemek e2) {
//                Collator col = Collator.getInstance(new Locale("hu", "HU"));         //választék sorbarendezése, kiirása
//                return col.compare(e1.getElemek(), e2.getElemek());
//            }
//        });
////        for (int i = 0; i < lista.size(); i++) {
////            System.out.print(lista.get(i));
//        
//        return elemek;
//    }
//
//    private static void jatekKezdes(ArrayList<Elemek> elemek) {
//        ArrayList<Elemek> kontrollLista = new ArrayList<>();
//        for (Elemek elem : elemek) {
//            System.out.println(elem);
//            kontrollLista.add(elem);
//        }
//        jatek(elemek, kontrollLista);
//    }
//
//    private static void jatek(ArrayList<Elemek> elemek, ArrayList<Elemek> kontrollLista) {
//        System.out.println("Válasszon egy elemet a fent felsoroltak közül, és írja be a consolba!");
//        Scanner sc = new Scanner(System.in, "ISO-8859-2"); 
//        String taroltElem = "";
//        boolean jovalasz = false;
//        boolean vanUjSzo = false;
//        char jatekos;
//        int lepesSzamlalo = 0;
//        do {
//            jovalasz = false;
//            if (lepesSzamlalo % 2 == 0) 
//                jatekos = 'A';
//            else 
//                jatekos = 'B';
//            System.out.println("\"" + jatekos + "\" játékos jön:");
//            do {
//                String beolvasottSzoveg = sc.nextLine().toLowerCase();
//                if (beolvasottSzoveg.length() > 0) {
//                    String elem2 = Normalizer.normalize(beolvasottSzoveg.toLowerCase(), Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").replaceAll("[^a-zá-ü]", "");
//                    String elem=elem2;
//                    jovalasz = kontrollLista.stream().anyMatch(e -> e.getElemek().equals(elem));
//
//                    if (jovalasz && !(elem.equals(taroltElem))) {
//                        elemek.removeIf(e -> (e.getElemek().equals(elem)));
//                        vanUjSzo = elemek.stream().anyMatch(e -> e.getElsoBetu() == elem.toLowerCase().charAt(elem.length() - 1));
//                        taroltElem = elem;
//                        kontrollLista.clear();
//                    } else 
//                        System.out.println("Hibás elem, kérem ellenőrizze a válaszható elemek listáját!");
//                } else 
//                    System.out.println("Kérem írjon be választ, mielőtt továbblépne!");
//            } while (!jovalasz);
//            if (vanUjSzo) {
//                System.out.println(" A következő játékos által válaszható lehetőségek:");
//                for (Elemek elemek1 : elemek) {
//                    if (elemek1.getElsoBetu() == (taroltElem.toLowerCase().charAt(taroltElem.length() - 1))) {
//                        kontrollLista.add(elemek1);
//                        System.out.println(elemek1);
//                    }
//                }
//            }
//            lepesSzamlalo++;
//        } while (vanUjSzo);
//        System.out.println("Gratulálunk a(z) \"" + jatekos + "\". játékosnak a győzelemhez!\n A lejátszott körök száma: " + lepesSzamlalo + ".");
//    }
//
//    public static void main(String[] args) {
//        jatekKezdes(beolvas());
//
//    }
//}
