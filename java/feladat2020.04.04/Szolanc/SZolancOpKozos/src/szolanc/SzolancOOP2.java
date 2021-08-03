package szolanc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

class Elem implements Comparable<Elem> {    //POJO

    private String elem;
//    int azon=+1;
    public static  Charset UTF_8;
    public String getElem() {
        
        return elem.toLowerCase();
    }

    @Override
    public String toString() {
  
            
       
        return elem + " ";
    }

    public Elem( String elem) {    //konstruktor
//       this.azon=azon++;
        this.elem = elem;
    }

    public char getKezdoBetu() {
        return elem.toLowerCase().charAt(0);
    }

    @Override   //ez nem tudom miért, de kell    --> azért kell mert az ősosztálytól(objektum) kell átalakítanunk az Elem osztályra a compareto-t
    public int compareTo(Elem o) {
        int eredmeny = this.elem.compareTo(o.getElem());
        return eredmeny;
    }
}

public class SzolancOOP2 {   //vezérlő

    public static TreeSet<String> getKezdobetuLista(TreeSet<Elem> objLista, String valasz) {
        TreeSet<String> lista = new TreeSet<>();
        for (Elem e : objLista) {
            if (e.getKezdoBetu() == valasz.charAt(valasz.length() - 1)) {
                lista.add(e.getElem());
            }
        }
        return lista;
    }

    public static TreeSet<String> elemekNeveLista(TreeSet<Elem> elemekObj) {
        TreeSet<String> elemekLista = new TreeSet<>();
        for (Elem s : elemekObj) //végigmegyünk a szétszedett szólistán
        {
            elemekLista.add(s.getElem());  //röptében létrehozunk belőle objektumot, elkérjük a nevét és berakjuk a Treesetbe. Ennek semmi értelme.
        }
        return elemekLista;
    }

//    public static String valaszKonvert(String valasz){
//       StringBuilder cs=new StringBuilder(valasz);
//       
//        for (int i = 0; i < cs.length(); i++) {
//         if(cs.charAt(i)=='é') cs.setCharAt(i, 'e');
//         if(cs.charAt(i)=='á') cs.setCharAt(i, 'a');
//         if(cs.charAt(i)=='í') cs.setCharAt(i, 'i');
//         if(cs.charAt(i)=='ó' || cs.charAt(i)=='ő' || cs.charAt(i)=='ö') cs.setCharAt(i, 'o');
//                  if(cs.charAt(i)=='ú' || cs.charAt(i)=='ü' || cs.charAt(i)=='ű') cs.setCharAt(i, 'u');
//
//        }
//        String csere=cs.toString();
//   return csere;
//    }


    
    
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        
         
    
          Charset UTF_8 = null;
//        String[] elemekTomb = {"hidrogen","helium","litium","berillium","bor","szen","nitrogen","oxigen","fluor","neon","natrium","magnezium","aluminium","szilicium","foszfor","ken","klor","argon","kalium","kalcium","szkandium","titan","vanadium","krom","mangan","vas","kobalt","nikkel","rez","cink","gallium","germanium","arzen","szelen","brom","kripton","rubidium","stroncium","ittrium","cirkonium","niobium","molibden","technecium","rutenium","rodium","palladium","ezüst","kadmium","indium","on","antimon","tellur","jod","xenon","cezium","barium","lantan","cerium","prazeodimium","neodimium","prometium","szamarium","europium","gadolinium","terbium","diszprozium","holmium","erbium","tulium","itterbium","lutecium","hafnium","tantal","volfram","renium","ozmium","iridium","platina","arany","higany","tallium","olom","bizmut","polonium","asztacium","radon","francium","radium","aktinium","torium","protaktinium","uran","neptunium","plutonium","americium","kurium","berkelium","kalifornium","einsteinium","fermium","mendelevium","nobelium","laurencium","raderfordium","dubnium","sziborgium","bohrium","hasszium","meitnerium","darmstadtium","rontgenium","kopernicium","nihonium","flerovium","moszkovium","livermorium","tenesszium","oganeszon","ununennium","unbinilium","unbiunium","unbibium","unbikvadium","unbipentium","unbioktium","unbiennium","untrinilium","untriunium", "untribium"};

//        String[] elemekTomb = elemekString.split(" ");

        String[] elemekTomb = {"hidrogén", "hélium", "lítium", "berillium", "bór", "szén", "nitrogén", "oxigén", "fluor", "neon", "nátrium", "magnézium", "alumínium", "szilícium", "foszfor", "kén", "klór", "argon", "kálium", "kalcium", "szkandium", "titán", "vanádium", "króm", "mangán", "vas", "kobalt", "nikkel", "réz", "cink", "gallium", "germánium", "arzén", "szelén", "bróm", "kripton", "rubídium", "stroncium", "ittrium", "cirkónium", "nióbium", "molibdén", "technécium", "ruténium", "ródium", "palládium", "ezüst", "kadmium", "indium", "ón", "antimon", "tellúr", "jód", "xenon", "cézium", "bárium", "lantán", "cérium", "prazeodímium", "neodímium", "prométium", "szamárium", "európium", "gadolínium", "terbium", "diszprózium", "holmium", "erbium", "túlium", "itterbium", "lutécium", "hafnium", "tantál", "volfrám", "rénium", "ozmium", "irídium", "platina", "arany", "higany", "tallium", "ólom", "bizmut", "polónium", "asztácium", "radon", "francium", "rádium", "aktínium", "tórium", "protaktínium", "urán", "neptúnium", "plutónium", "amerícium", "kűrium", "berkélium", "kalifornium", "einsteinium", "fermium", "mendelévium", "nobélium", "laurencium", "raderfordium", "dubnium", "sziborgium", "bohrium", "hasszium", "meitnérium", "darmstadtium", "röntgénium", "kopernícium", "nihónium", "fleróvium", "moszkóvium", "livermórium", "tenesszium", "oganeszon", "ununennium", "unbinilium", "unbiunium", "unbibium", "unbikvadium", "unbipentium", "unbioktium", "unbiennium", "untrinilium", "untriunium", "untribium"};
//        tombCsere(ekezetesTomb, elemekTomb);

//            for (int i = 0; i < ekezetesTomb; i++) {
//                if(ekezetesTomb[i])
//            }
        Arrays.sort(elemekTomb, Collections.reverseOrder());

        TreeSet<Elem> elemekListaObj = new TreeSet<>();
        for (String s : elemekTomb) {
            elemekListaObj.add(new Elem(s));
        }
//        TreeSet<Elem> elemekListaObjEkezetes = new TreeSet<>();              
//        for (String s : ekezetesTomb) {
//            elemekListaObjEkezetes.add(new Elem(s));
//        }
//        
     

        for (Elem s : elemekListaObj) //kiírjuk a választékot    //csináltam egy másik listakiírást, így most két tömb van egy amit használunk, egy amit kiírunk
        {
            System.out.print(s);
        }

        String valasz;      //ez lesz a játékos "tippje"
        int i = 0;            //ezzel számoljuk, melyik játékos jön - páros: A, pártalan: B
        TreeSet<String> JoKezdobetusSzavakLista = new TreeSet<>();

        do {
            do {
               InputStreamReader v =new InputStreamReader(System.in, UTF_8);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-2"));
                        valasz= br.readLine();
                        
                        
//                         System.out.println((i % 2 == 0) ? "\nA játékos tippje: " : "\nB játekos tippje: ");
//                valasz = valaszKonvert(extra.Console.readLine((i % 2 == 0) ? "\nA játékos tippje: " : "\nB játekos tippje: ").toLowerCase());   //kérjük a mgefelelő játékost, hogy válasszon
//                              átkonvertálni az ékezetes választ
//                valasz = extra.Console.readLine((i % 2 == 0) ? "\nA játékos tippje: " : "\nB játekos tippje: ").toLowerCase();
                if (!elemekNeveLista(elemekListaObj).contains(valasz)) {
                    System.out.print("Nem jó, újra.");    //visszajelzünk neki, ha nem jót írt
                }
            } while (!(elemekNeveLista(elemekListaObj).contains(valasz)));        //addig baszogatjuk, amíg olyat nem ír, ami benne van a listában

            JoKezdobetusSzavakLista.clear();       //minden kör elején kiürítjük ezt (kell és kész, ne kérdezd)   
            i++;                                   //léptetjük a játékos "számlálót"

            String valaszKisb = valasz.toLowerCase();
            elemekListaObj.removeIf(n -> (n.getElem().equals(valaszKisb))); //kiszedjük a választ a listánkból

            JoKezdobetusSzavakLista = getKezdobetuLista(elemekListaObj, valasz); //megkeressük a jó kezdőbetűvel kezdődő szavakat
            if ((JoKezdobetusSzavakLista.size() > 1)) {   //ha még legalább kettő választási lehetőség van, akkor megy tovább a játék
                System.out.println("\nVálasztható elemek:");
                for (String s : JoKezdobetusSzavakLista) //kiírjuk a maradék választékot
                {
                    System.out.print(s + " ");
                }
            }
        } while (!(JoKezdobetusSzavakLista.size() == 1));     //addig megy a játék, amíg már csak egy választási lehetőség van

        System.out.println("Játék vége");
        System.out.println((i % 2 == 0) ? "A játékos nyert." : "B játekos nyert.");
    }
}
