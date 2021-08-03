//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//package szolanc;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.TreeSet;
//
//class Elem implements Comparable<Elem> {    //POJO
//    private String elem;
//
//    public String getElem() {
//        return elem.toLowerCase();
//    }
//
//    @Override
//    public String toString() {
//        return elem+" ";
//    }
//
//    public Elem(String elem) {    //konstruktor
//        this.elem=elem;
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
//public class SzolancOOP3_ver {   //vezérlő
// 
//        private static String  inputFajlUtvonal="./files/elemek.txt";
//    
//        private static TreeSet<Elem> szovegElokeszites(String inputFajlUtvonal)  {    //egy objektumokkal feltöltött TreeeSetbe rakjuk a fájlból beolvasott elemeket
//            String elemekString=null;
////            FileInputStream sourceStream = null; 
////        FileOutputStream targetStream = null; 
////  
////        try 
////        { 
////            sourceStream = new FileInputStream(inputFajlUtvonal); 
////            targetStream = new FileOutputStream (inputFajlUtvonal); 
////  
////            // Reading source file and writing content to target 
////            // file byte by byte 
////            int temp; 
////            while ((temp = sourceStream.read()) != -1) 
////                targetStream.write((byte)temp);             
////        } 
////        finally 
////        { 
////            if (sourceStream != null) 
////                sourceStream.close();             
////            if (targetStream != null)             
////                targetStream.close();             
////        } 
//          try {   //hibakezelés
//                elemekString=new String (Files.readAllBytes(Paths.get(fajlUtvonal)));
//            }
//            catch(IOException e) {
//                e.printStackTrace();
//                System.out.println("Hiba: "+e.getMessage()+" (156485)");
//                System.exit(-1);
//            }
//            targetStream=elemekString;                              //valahogyan stringgé konvertálni hogy dolgozni lehessen vele
//            String[] elemekTomb= elemekString.split(" ");
//            Arrays.sort(elemekTomb, Collections.reverseOrder());
//
//            TreeSet<Elem> elemekListaObj= new TreeSet<>();  
//            for (String s : elemekTomb)   
//                elemekListaObj.add(new Elem(s));
//            
//            return elemekListaObj;
//        }
//    
//        private static boolean tartalmaz (TreeSet<Elem> elemekObj, String valasz) { //a metódus megnézi, hogy egy objektum TreeSet tartalmaz-e adott nevű elemet
//            TreeSet<String> elemekLista= new TreeSet<>();  
//            for (Elem s : elemekObj)
//                elemekLista.add(s.getElem());
//            return (elemekLista.contains(valasz));
//        } 
//            
//        private static TreeSet<String> getJoKezdobetusElemekLista (TreeSet<Elem> objLista, String valasz) { //visszaadja a jó kezdőbetűvel kezdődő elemek listáját
//            TreeSet<String> lista= new TreeSet<>();
//            for (Elem e : objLista)
//                if (e.getKezdoBetu()==valasz.charAt(valasz.length()-1))
//                    lista.add(e.getElem()); 
//            return lista;
//        }
//    
//        public static void main(String[] args) {
////           FileInputStream sourceStream = null; 
////        FileOutputStream targetStream = null; 
////  
////        try 
////        { 
////            sourceStream = new FileInputStream(inputFajlUtvonal); 
////            targetStream = new FileOutputStream (inputFajlUtvonal); 
////  
////            // Reading source file and writing content to target 
////            // file byte by byte 
////            int temp; 
////            while ((temp = sourceStream.read()) != -1) 
////                targetStream.write((byte)temp);             
////        } 
////        finally 
////        { 
////            if (sourceStream != null) 
////                sourceStream.close();             
////            if (targetStream != null)             
////                targetStream.close();             
////        } 
//    
//            
//            
//
//        TreeSet<Elem> elemekListaObj=szovegElokeszites(inputFajlUtvonal);   //minden elemetet objektumként eltárulonk ebben a set-ben
//        String valasz;      //ez lesz a játékos "tippje"
//        int i=0;            //ezzel számoljuk, melyik játékos jön - páros: A, pártalan: B
//        TreeSet<String> JoKezdobetusElemekLista= new TreeSet<>();
//        TreeSet<String> kiesettSzavakLista= new TreeSet<>();    //csak azért gyűjtjük, hogy visszajelezhessünk a játékosnak, ha már volt a tipp - lehet felesleges? //csak azért gyűjtjük, hogy visszajelezhessünk a játékosnak, ha már volt a tipp - lehet felesleges? //csak azért gyűjtjük, hogy visszajelezhessünk a játékosnak, ha már volt a tipp - lehet felesleges? //csak azért gyűjtjük, hogy visszajelezhessünk a játékosnak, ha már volt a tipp - lehet felesleges?
//
//        for (Elem s : elemekListaObj)    //kiírjuk a választékot
//            System.out.print(s);
//        
//        do {
//            do{
//                valasz=extra.Console.readLine((i%2==0)?"\nA játékos tippje: ":"\nB játekos tippje: ").toLowerCase();   //kérjük a mgefelelő játékost, hogy válasszon
//                if (!tartalmaz(elemekListaObj, valasz) && !kiesettSzavakLista.contains(valasz))
//                    System.out.print("Nincs ilyen elem, újra.");    //visszajelzünk neki, ha nem jót írt
//                if (kiesettSzavakLista.contains(valasz))
//                    System.out.print("Már volt, újra.");    //visszajelzünk neki, ha már volt a tipp
//            }while(!tartalmaz(elemekListaObj, valasz));        //addig baszogatjuk, amíg olyat nem ír, ami jó
//            
//            i++;                                   //léptetjük a játékos "számlálót"
//            
//            String valasz1=valasz;  //ezt majd megkérdezem Kaczurtól, miért kell, de enélkül nem működik
//            elemekListaObj.removeIf(n -> (n.getElem().equals(valasz1))); //kiszedjük a választ a listánkból
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
//
