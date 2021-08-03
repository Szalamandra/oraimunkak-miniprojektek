package szolancoopver2;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class Elem {

    String nev;

    public Elem(String nev) {    //ide majd exceptioneket bepakolni
        this.nev = nev;
    }

    
    
    public String getNev() {
        return nev + " ";
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public char getFirstCharacter() {
        char elsoBetu = getNev().charAt(0);
        return elsoBetu;
    }

    
    
    public char getLastCharacter() {

        char utolsoBetu = getNev().charAt(getNev().length() - 2);               //itt a szóközök miatt kell -2
//         System.out.println(utolsoBetu);
        return utolsoBetu;
    }
    
    @Override
    public boolean equals(Object o){
     Elem e1 = this;
        if (o instanceof Elem) {
            Elem e2 = (Elem) o;
            return e1.equals(e2);
        } else {
            return false;
        }
    }



    @Override
    public String toString() {
        return nev + " ";
    }

}

class Listak {                      //ez az osztaly azért van hogy a kül. listákra lehessen meghivni dolgokat, ne csak az elemekre különküön

    ArrayList<Elem> lista;           //létrehozni egy lista classt, aminek az objektumait majd lehet hasznalgatni
    String[] nev = {"hidrogén", "hélium", "lítium", "berillium", "bór", "szén", "nitrogén", "oxigén", "fluor", "neon", "nátrium", "magnézium", "alumínium", "szilícium", "foszfor", "kén", "klór", "argon", "kálium", "kalcium", "szkandium", "titán", "vanádium", "króm", "mangán", "vas", "kobalt", "nikkel", "réz", "cink", "gallium", "germánium", "arzén", "szelén", "bróm", "kripton", "rubídium", "stroncium", "ittrium", "cirkónium", "nióbium", "molibdén", "technécium", "ruténium", "ródium", "palládium", "ezüst", "kadmium", "indium", "ón", "antimon", "tellúr", "jód", "xenon", "cézium", "bárium", "lantán", "cérium", "prazeodímium", "neodímium", "prométium", "szamárium", "európium", "gadolínium", "terbium", "diszprózium", "holmium", "erbium", "túlium", "itterbium", "lutécium", "hafnium", "tantál", "volfrám", "rénium", "ozmium", "irídium", "platina", "arany", "higany", "tallium", "ólom", "bizmut", "polónium", "asztácium", "radon", "francium", "rádium", "aktínium", "tórium", "protaktínium", "urán", "neptúnium", "plutónium", "amerícium", "kűrium", "berkélium", "kalifornium", "einsteinium", "fermium", "mendelévium", "nobélium", "laurencium", "raderfordium", "dubnium", "sziborgium", "bohrium", "hasszium", "meitnérium", "darmstadtium", "röntgénium", "kopernícium", "nihónium", "fleróvium", "moszkóvium", "livermórium", "tenesszium", "oganeszon", "ununennium", "unbinilium", "unbiunium", "unbibium", "unbikvadium", "unbipentium", "unbioktium", "unbiennium", "untrinilium", "untriunium", "untribium"};
    Elem vObj;                           //ezt többször haasználom, h ez new elem(v), uh lkehet mar itt ezt lelehet rögzíteni
    int jatek=0;                       //ezzel fogom szamolni mennyi jatek ment le, és a végén eldönteni, hogy ki nyert
    int valaszIndex;               //hogy kitudjam majd szedni a listából kell a helye
    
    
   
    
    
    public ArrayList<Elem> feltolt() {
        lista = new ArrayList<>();
        for (String elemNev : nev) {
            //feltöltöm a listát az elemekkel
            Elem elem = new Elem(elemNev);
            lista.add(elem);
        }
//        System.out.println(lista);     //ell
        return lista;
    }

    public void setvObj(Elem vObj) {              //ezt azért mert majd kikell törölni a listából
        this.vObj = vObj;
    }

    public Elem getvObj() {
        return vObj;
    }

    public void listaKiir() {
        System.out.println("Válaszzon a listából egy elemet: \n");
        Collections.sort(lista, new Comparator<Elem>() {
            @Override
            public int compare(Elem e1, Elem e2) {
                Collator col = Collator.getInstance(new Locale("hu", "HU"));         //választék sorbarendezése, kiirása
                return col.compare(e1.getNev(), e2.getNev());
            }
        });
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i));
        }
        System.out.println();
    }

 public byte[] elemKonvert(String valasz){                                            // válasznak az átkonvertálása byttá, hátha megérti ez a kisbutus
            byte[] bytes = valasz.getBytes();
            return bytes;
  }
    
 public String visszaKonvert(byte[] bytes){
        String valasz= bytes.toString();
        return valasz;
 
 }
 
    public String elemKivalaszt() {                //ezzel kérni ajátékostól, hogy válasszon egy elemet, majd ezt hasznaljuk a következő lista előállítására
        String v = "";
        
        int jatekosPont = -1;
//        vObj = new Elem(v);
        boolean van=false;
        do {

//            van = elemLista.get(i).getNev().startsWith(v);
//            String v;
            Scanner valaszElem;
            valaszElem = new Scanner(System.in);
            
            v = valaszElem.next().toLowerCase();
            elemKonvert(v);                                          //átkonvertálom a választ bytá, hátha ugy megérti a forditó
            vObj = new Elem(v);
//            van = elemLista.contains(vObj);
//            int esely =3;
            int i = 0;
            while (!(lista.get(i).equals(vObj))) {                   //nem értem miért, de ha kát felétlet adtam meg, vagyis hivatkoztam az elemlista.size-ra ugy nem működött,asszem mert arraylistnél talan nincs size?
                if (i >= lista.size() - 1) {
                    i = 0;
                    System.out.println("Újra! Please");
                    valaszElem = new Scanner(System.in);
                    v = valaszElem.next().toLowerCase();
//                 for (Elem e : elemLista) {
//                    if (vObj.equals(e)) van=true;

                }
                i++;
            }
            v=lista.get(i).nev;
            valaszIndex=i;
//            visszaKonvert(v);
//            vObj = new Elem(v);
//            lista.add(vObj);
            van=true;
//                esely--;
        } while (van!=true);
        jatek++;
        System.out.println("Az Ön választott eleme: " + v);
        return v;

    }

    public ArrayList kivalasztUjLista(String v) {                     //atadni a kivalasztott elemet mint paramétert és azalapjan krealni az uj listakat
        ArrayList<Elem> kivalasztLista = new ArrayList<>();
        vObj=new Elem(v);
        for (Elem elem : lista) {
            if (vObj.getLastCharacter() == elem.getFirstCharacter()) {
                kivalasztLista.add(elem);
            }
        }
        
        kivalasztLista.remove(vObj);
        System.out.println("Most a másik válasszon az alabbiakból: " + kivalasztLista);
        return kivalasztLista;
    }
}

// public Listak kivalasztUjLista(Elem vObj, ArrayList<Elem> lista){                     //atadni a kivalasztott elemet mint paramétert és azalapjan krealni az uj listakat
//     Listak kivalasztLista= new Listak();
//     
//        for (Elem elem : lista) {
//                if( vObj.getLastCharacter()==elem.getFirstCharacter())
//                    kivalasztLista.lista.add(elem);
//            }               
//        
//                System.out.println("Most a másik válasszon az alabbiakból: "+kivalasztLista);
//     return kivalasztLista;
//}}
//


//  Collections.sort(elemekListaObj, new Comparator<String>() {
//                Collections.sort(elemekListaObj, new Comparator<Elem1>() {
//                @Override
//                public int compare(Elem o1, Elem o2) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//            });
//            public int compare(Elem s1, Elem s2) {
//                Collator col = Collator.getInstance(new Locale("hu", "HU"));         //választék sorbarendezése, kiirása
//                return col.compare(s1.compareTo(s2), s2.compareTo(s1));
//            }