package szolanc3;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Szolanc3 {

    public static void main(String[] args) {
        ArrayList<Elem> elemLista = new ArrayList<>();
        String[] elemNev = {"hidrogén", "hélium", "lítium", "berillium", "bór", "szén", "nitrogén", "oxigén", "fluor", "neon", "nátrium", "magnézium", "alumínium", "szilícium", "foszfor", "kén", "klór", "argon", "kálium", "kalcium", "szkandium", "titán", "vanádium", "króm", "mangán", "vas", "kobalt", "nikkel", "réz", "cink", "gallium", "germánium", "arzén", "szelén", "bróm", "kripton", "rubídium", "stroncium", "ittrium", "cirkónium", "nióbium", "molibdén", "technécium", "ruténium", "ródium", "palládium", "ezüst", "kadmium", "indium", "ón", "antimon", "tellúr", "jód", "xenon", "cézium", "bárium", "lantán", "cérium", "prazeodímium", "neodímium", "prométium", "szamárium", "európium", "gadolínium", "terbium", "diszprózium", "holmium", "erbium", "túlium", "itterbium", "lutécium", "hafnium", "tantál", "volfrám", "rénium", "ozmium", "irídium", "platina", "arany", "higany", "tallium", "ólom", "bizmut", "polónium", "asztácium", "radon", "francium", "rádium", "aktínium", "tórium", "protaktínium", "urán", "neptúnium", "plutónium", "amerícium", "kűrium", "berkélium", "kalifornium", "einsteinium", "fermium", "mendelévium", "nobélium", "laurencium", "raderfordium", "dubnium", "sziborgium", "bohrium", "hasszium", "meitnérium", "darmstadtium", "röntgénium", "kopernícium", "nihónium", "fleróvium", "moszkóvium", "livermórium", "tenesszium", "oganeszon", "ununennium", "unbinilium", "unbiunium", "unbibium", "unbikvadium", "unbipentium", "unbioktium", "unbiennium", "untrinilium", "untriunium", "untribium"};
//            int szamlalo=0;

        for (int i = 0; i < elemNev.length; i++) {                          //feltöltöm a listát az elemekkel
            Elem elem = new Elem(elemNev[i]);
            elemLista.add(elem);
//                System.out.print(elemLista.get(i).nev+" ");
        }

        Collections.sort(elemLista, new Comparator<Elem>() {
            @Override
            public int compare(Elem e1, Elem e2) {
                Collator col = Collator.getInstance(new Locale("hu", "HU"));         //választék sorbarendezése, kiirása
                return col.compare(e1.getNev(), e2.getNev());
  }
        });
        System.out.print(elemLista);

//        }
//      
//            Scanner valasz= new Scanner();
        String v = "";
        int jatekosPont = -1;
        Elem vObj = new Elem(v);
        boolean van;
        do {

           
//            van = elemLista.get(i).getNev().startsWith(v);
           
            System.out.println("\n Válasszon a listából egy elemet: \n");

//            String v;
            Scanner valaszElem;
            valaszElem = new Scanner(System.in);
            v = valaszElem.next().toLowerCase();
            System.out.println("scanner: "+v);
//            vObj = new Elem(v);
//            van = elemLista.contains(vObj);
//            int esely =3;
             int i = 0;
            while ( !(elemLista.get(i).getNev().startsWith(v))) {                   //nem értem miért, de ha kát felétlet adtam meg, vagyis hivatkoztam az elemlista.size-ra ugy nem működött
                if (i >= elemLista.size()-1) {
                     i=0;
                    System.out.println("Újra! Please");
                    valaszElem = new Scanner(System.in);
                    v = valaszElem.next().toLowerCase();
//                 for (Elem e : elemLista) {
//                    if (vObj.equals(e)) van=true;
                   
                }
               i++;
            }
            
            
              vObj = new Elem(v);
              elemLista.add(vObj);
            
           
//                esely--;
        } while (!(elemLista.contains(vObj)));


        System.out.println("Az Ön választott eleme: " + vObj.getNev());

        
//        System.out.println("első betű: "+vObj.getFirstCharacter()+"utsó: "+vObj.getLastCharacter());        //ellenőrzés
        
        ArrayList<Elem> kivalasztLista= new ArrayList<>();
            for (Elem elem : elemLista) {
                if( vObj.getLastCharacter()==elem.getFirstCharacter())
                    kivalasztLista.add(elem);
            }               
        elemLista.remove(vObj);
                System.out.println("Most a másik válasszon az alabbiakból: "+kivalasztLista);
    
   
        
    }
}
//    
//    

//    public static void main(String[] args) {
//        ArrayList<Elem> elemLista = new ArrayList<>();
//        String[] elemNev = {"hidrogén", "hélium", "lítium", "berillium", "bór", "szén", "nitrogén", "oxigén", "fluor", "neon", "nátrium", "magnézium", "alumínium", "szilícium", "foszfor", "kén", "klór", "argon", "kálium", "kalcium", "szkandium", "titán", "vanádium", "króm", "mangán", "vas", "kobalt", "nikkel", "réz", "cink", "gallium", "germánium", "arzén", "szelén", "bróm", "kripton", "rubídium", "stroncium", "ittrium", "cirkónium", "nióbium", "molibdén", "technécium", "ruténium", "ródium", "palládium", "ezüst", "kadmium", "indium", "ón", "antimon", "tellúr", "jód", "xenon", "cézium", "bárium", "lantán", "cérium", "prazeodímium", "neodímium", "prométium", "szamárium", "európium", "gadolínium", "terbium", "diszprózium", "holmium", "erbium", "túlium", "itterbium", "lutécium", "hafnium", "tantál", "volfrám", "rénium", "ozmium", "irídium", "platina", "arany", "higany", "tallium", "ólom", "bizmut", "polónium", "asztácium", "radon", "francium", "rádium", "aktínium", "tórium", "protaktínium", "urán", "neptúnium", "plutónium", "amerícium", "kűrium", "berkélium", "kalifornium", "einsteinium", "fermium", "mendelévium", "nobélium", "laurencium", "raderfordium", "dubnium", "sziborgium", "bohrium", "hasszium", "meitnérium", "darmstadtium", "röntgénium", "kopernícium", "nihónium", "fleróvium", "moszkóvium", "livermórium", "tenesszium", "oganeszon", "ununennium", "unbinilium", "unbiunium", "unbibium", "unbikvadium", "unbipentium", "unbioktium", "unbiennium", "untrinilium", "untriunium", "untribium"};
////            int szamlalo=0;
//
//        for (int i = 0; i < elemNev.length; i++) {                          //feltöltöm a listát az elemekkel
//            Elem elem = new Elem(elemNev[i]);
//            elemLista.add(elem);
////                System.out.print(elemLista.get(i).nev+" ");
//        }
//
////            Collator.getInstance(new Locale("hu","HU"));
//        Collections.sort(elemLista, (Elem e1, Elem e2) -> e1.getNev().compareTo(e2.getNev()));
//        //sorbarendezés: magyar abc-vel bajok vannak
//        for (int i = 0; i < elemLista.size(); i++) {
//            System.out.print(elemLista.get(i).getNev() + " ");                             //kiirjuk a választékot
//
//        }
//
////            Collator col = Collator.getInstance(new Locale("hu","HU"));
////            Scanner valasz= new Scanner();
//        int jatekosPont = -1;
//        Elem ujElem;
//
//        do {
//
//            System.out.println("\n Válasszon a listából egy elemet: \n");
//
//            int szamlalo = 0;
//            String v;
//            Scanner valaszElem;
//            valaszElem = new Scanner(System.in);
//            v = valaszElem.next().toLowerCase();
//
//            boolean van;
//            do {
//             
//                van = !(elemNev[szamlalo].equalsIgnoreCase(v));
//                int esely = 2;
//                 for (szamlalo = 0; szamlalo < 128; szamlalo++) {            //a választott elem benne van e a tömbben amit a listának adtam
//                    if (van != true ) {
//                        System.out.println("A választott elem: " + elemNev[szamlalo]);
//                    
//                    } 
//               
//                    while (van == false && esely >= 0) {
//                            System.out.println("Újra! Még " + esely + " számú esélyed maradt!");
//                            valaszElem = new Scanner(System.in);
//                            v = valaszElem.next().toLowerCase();
//                            esely--;
//                        }
//                
//                
//                    
//                }
//
//            } while (van == true);
//
//            ujElem = new Elem(v);              //átadom ezt a nevet egy elemnévnek, hogy hasznlani tudjam a containst
//            elemLista.add(ujElem);                //belerakni a listába
//
//            {
//                jatekosPont++;
//                System.out.println("A választott:");
//            }
//        } while (!(elemLista.contains(ujElem)));
//
//        System.out.println("Az Ön választott eleme: " + ujElem + " jatekospontja: " + jatekosPont);
//
//    }
//
//}
