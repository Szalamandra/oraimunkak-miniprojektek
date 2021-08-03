//package szolanc;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.TreeSet;
//
//class Elem implements Comparable<Elem> {    //POJO
//    private String elem;
//    private static int szamlalo=1;
//    private int azonosito;
//
//    public String getElem() {
//        return elem.toLowerCase();
//    }
// public String setElem(){
//        return elem.toLowerCase();
// }
//    
//    public int setAzonosito() {
//        return azonosito++;
//    }
//     public int getAzonosito() {
//        return azonosito;
//    }
//    @Override
//    public String toString() {
//        return azonosito+". "+elem+" ";
//    }
//
//    public Elem(String elem, int azon) {    //konstruktor
//        this.elem=elem;
//        azon=azonosito++;
//    }
//    
//    public char getKezdoBetu () {
//        return elem.toLowerCase().charAt(0);
//    }
//
//    @Override   //ez nem tudom miért, de kell
//    public int compareTo(Elem o) {
//        int eredmeny= this.elem.compareTo(o.getElem());
//        return eredmeny;
//    }  
//}
//
//
//public class Szolanc {   //vezérlő
// 
//        private static String  inputFajlUtvonal="./files/elemek.txt";
//     
//        
//        private static TreeSet<Elem> szovegElokeszites(String fajlUtvonal) {    //egy objektumokkal feltöltött TreeeSetbe rakjuk a fájlból beolvasott elemeket
//            String elemekString="";
//            try {   //hibakezelés
//                elemekString=new String (Files.readAllBytes(Paths.get(fajlUtvonal)));
//            }
//            catch(IOException e) {
//                e.printStackTrace();
//                System.out.println("Hiba: "+e.getMessage()+" (156485)");
//                System.exit(-1);
//            }
//            String[] elemekTomb= elemekString.split(" ");
//            Arrays.sort(elemekTomb, Collections.reverseOrder());
//
//            TreeSet<Elem> elemekListaObj= new TreeSet<>();  
//            for (String s : elemekTomb)   
//                elemekListaObj.add(new Elem(s,1));
//            TreeSet<Elem> fordElemekLista = (TreeSet<Elem>)elemekListaObj.descendingSet(); 
//            return fordElemekLista;
//        }
//    
//        private static boolean tartalmaz (TreeSet<Elem> elemekObj, int valasz) { //a metódus megnézi, hogy egy objektum TreeSet tartalmaz-e adott nevű elemet
//            TreeSet<Integer> elemekLista= new TreeSet<>();  
//            for (Elem s : elemekObj)
//                elemekLista.add(s.setAzonosito());
//            return (elemekLista.contains(valasz));
//        } 
//            
//        private static TreeSet<String> getJoKezdobetusElemekLista (TreeSet<Elem> objLista, int valasz) { //visszaadja a jó kezdőbetűvel kezdődő elemek listáját
//            TreeSet<String> lista= new TreeSet<>();
//            String valaszBetuvel=new String();
//            for (Elem s : objLista) {
//                if (s.getAzonosito()==valasz)
//                    valaszBetuvel=s.setElem(); 
//            }
//           //hogy ez miért nem jó, azt nem értem????? java.lang.StringIndexOutOfBoundsException
//          
//            char betu=valaszBetuvel.charAt(valaszBetuvel.length()-1);
//            for (Elem e : objLista)
//                if (e.getKezdoBetu()==betu)
//                    lista.add(e.getElem()); 
//            return lista;
//            
//        }
////         private static TreeSet<String> getJoKezdobetusElemekLista (TreeSet<Elem> objLista, int valasz) { //visszaadja a jó kezdőbetűvel kezdődő elemek listáját
////            TreeSet<String> lista= new TreeSet<>();
////            String valaszBetuvel=new String();
////             Elem v=new Elem(valaszBetuvel);
////            for (Elem s : objLista) {
////                if (s.getAzonosito()==valasz)
////                    v=new Elem(valaszBetuvel);
////            }
////            
////            int n=valaszBetuvel.length()-1; //hogy ez miért nem jó, azt nem értem????? java.lang.StringIndexOutOfBoundsException
////            char betu=v.getElem().charAt(n);
////            for (Elem e : objLista)
////                if (e.getKezdoBetu()==betu)
////                    lista.add(e.getElem()); 
////            return lista;
////            
////        }
//    
//        public static void main(String[] args) {
//        TreeSet<Elem> elemekListaObj=szovegElokeszites(inputFajlUtvonal);   //minden elemetet objektumként eltárulonk ebben a set-ben
//        Integer valasz;      //ez lesz a játékos "tippje"
//        int i=0;            //ezzel számoljuk, melyik játékos jön - páros: A, pártalan: B
//        TreeSet<String> JoKezdobetusElemekLista= new TreeSet<>();
//        TreeSet<Integer> kiesettSzavakLista= new TreeSet<>();    //csak azért gyűjtjük, hogy visszajelezhessünk a játékosnak, ha már volt a tipp - lehet felesleges?
//
//        for (Elem s : elemekListaObj)    //kiírjuk a választékot
//            System.out.print(s);
//        
//        do {
//            do{
//                valasz=extra.Console.readInt((i%2==0)?"\nA játékos tippje: ":"\nB játekos tippje: ");   //kérjük a mgefelelő játékost, hogy válasszon
//                if (!tartalmaz(elemekListaObj, valasz) && !kiesettSzavakLista.contains(valasz))
//                    System.out.print("Nincs ilyen elem, újra.");    //visszajelzünk neki, ha nem jót írt
//                if (kiesettSzavakLista.contains(valasz))
//                    System.out.print("Már volt, újra.");    //visszajelzünk neki, ha már volt a tipp
//            }while(!tartalmaz(elemekListaObj, valasz));        //addig baszogatjuk, amíg olyat nem ír, ami jó
//            
//            i++;                                   //léptetjük a játékos "számlálót"
//            
//            
//            int valasz1=valasz;  //ezt majd megkérdezem Kaczurtól, miért kell, de enélkül nem működik
//            elemekListaObj.removeIf(n -> (n.getAzonosito()==valasz1)); //kiszedjük a választ a listánkból
//            kiesettSzavakLista.add(valasz); //gyűjtjük a kiesett szavakat
//            
//            JoKezdobetusElemekLista=getJoKezdobetusElemekLista(elemekListaObj, valasz); //megkeressük a jó kezdőbetűvel kezdődő szavakat
//            if ((JoKezdobetusElemekLista.size()>1)) {   //ha még legalább kettő választási lehetőség van, akkor megy tovább a játék
//                System.out.println("\nVálasztható elemek:");
//                for (String s : JoKezdobetusElemekLista)    //kiírjuk a maradék választékot
//                    System.out.print(s + " ");
//            }     
//        } while (!(JoKezdobetusElemekLista.size()==1));     //addig megy a játék, amíg már csak egy választási lehetőség van
//        
//        System.out.println("Játék vége");
//        System.out.println((i%2==0)?"A játékos nyert.":"B játekos nyert.");
//    }    
//}
