package oop;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatumArchivum {
    public static void main(String[] args) {
        
        //Ez a rész random dátum adatok létrehozása:
        GregorianCalendar minDatum=new GregorianCalendar(2018, 3, 1),   //megdajuk a min és max dátum értékeket
            maxDatum=new GregorianCalendar();
        long minDatumLong=minDatum.getTimeInMillis(),   //két féle megoldás arra, hogyan kapjuk meg a long formátumát a Gergely dátumnak - az első egy lépésben azt adja
            maxDatumLong=maxDatum.getTime().getTime();  //az egyik "getTime()" egy buta dátum formátumot ad vissza, a másik adja a long formát
//        System.out.println(minDatumLong+"\n"+maxDatumLong);
        SimpleDateFormat rovidDatum=new SimpleDateFormat("yyyy.MM.dd.");    //dátumformátumot hozunk létre
        int n=(int) (Math.random()*21+30);  //30-50 közt    //tömb hosszúsága
        GregorianCalendar[] tomb=new GregorianCalendar[n];  //index 0-től (n-1)ig 
        for (int i = 0; i < tomb.length; i++) {
            GregorianCalendar datum=new GregorianCalendar();    //létrehozzuk a dátum objektumot
            long tippDatumLong=(long) (Math.random()*(maxDatumLong-minDatumLong+1)+minDatumLong);    //létrehozzuk a random dátumot
            datum.setTime(new Date(tippDatumLong));     //módosítjuk a dátumot a randomra
            tomb[i]=datum;          //berakjuk a tömbbe
//            System.out.println((i+1)+". dátum: "+tomb[i].getTime());
//            System.out.println((i+1)+". dátum: "+rovidDatum.format(tomb[i].getTime())); //a Gergely objektumtól (ami a tömbben van) elkérjük a sima dátumot és azt formázva kiírjuk
        }
        
        //Ez a rész az adatok sorbarendezése:
//        for (int i = 0; i < tomb.length-1; i++) {   //az utolsó előttit hasonlítjuk az utolsóval, ezért kell (tomb.length-1)
//            for (int j = i+1; j < tomb.length; j++) {     //önmagához nem hasonlítjuk, ezért kell az (i+1)
//                if(tomb[i].compareTo(tomb[j])<0){
//                    GregorianCalendar temp=tomb[i];
//                    tomb[i]=tomb[j];
//                    tomb[j]=temp;
//                }      
//            }
//        }

        //sorbarendezés másképp, rosszul:       
//        Arrays.sort(tomb);  //ez másik sorrendet okozna, ezért meg kell fordítani a sorbarendezés irányát:

        //sorbarendezés másképp, jól:        //mi a fene zajlik itt???
//        Arrays.sort(tomb, new Comparator<GregorianCalendar>() {  //típus operátor
//            @Override   //felülírja a sorbarendezést, hogy visszafelé menjen
//            public int compare(GregorianCalendar datum1, GregorianCalendar datum2) {
//                return datum2.compareTo(datum1);      //itt van 1 és 2 megcserélve
//            }
//        }); 

        //sorbarendezés harmadik féle képpen:
        Arrays.sort(tomb, (GregorianCalendar datum1, GregorianCalendar datum2) -> datum2.compareTo(datum1));   //lambda operátorral
        
        System.out.println("Adataink sorban kiírva:");
        for (int i = 0; i < tomb.length; i++) 
           System.out.println((i+1)+". dátum: "+rovidDatum.format(tomb[i].getTime()));
        
        //csoportosítás évente:
        System.out.println("Évente összeszámolva:");
        SimpleDateFormat evDatum=new SimpleDateFormat("yyyy");
        int i=0;
        while (i<tomb.length) {
            String aktEv=evDatum.format(tomb[i].getTime());     //a tömb i. helyén eltárolt Gergely naptáras adattól elkérjük a dátumot, majd az évet formázással eltároljuk stringként 
            int aktEvDb=0;
            while(i<tomb.length && evDatum.format(tomb[i].getTime()).equals(aktEv)) {   //megnézzük, hogy a stringként eltárolt év egyenlő-e a tömb aktuális évével (persze formázva)
                i++;
                aktEvDb++;
            }
            System.out.println(aktEv+". év ("+aktEvDb+")");
        }  
        
        //csoportosítás havonta:
        System.out.println("Havonta összeszámolva:");
        SimpleDateFormat evHoDatum=new SimpleDateFormat("yyyyMM");  //ez csak csoportosításhoz használt formátum
        SimpleDateFormat evHoDatumKiiras=new SimpleDateFormat("yyyy. MMMM");    //ezt pedig a kiírásnál fogjuk használni
        i=0;
        while (i<tomb.length) {
            String aktEvHo=evHoDatum.format(tomb[i].getTime());     //a tömb i. helyén eltárolt Gergely naptáras adattól elkérjük a dátumot, majd az évet és hónapot formázással eltároljuk stringként 
            String aktEvHoKiirashoz=evHoDatumKiiras.format(tomb[i].getTime()); //a kiirashoz eltároljuk stringként a szép formátumot
            int aktEvHoDb=0;
            while(i<tomb.length && evHoDatum.format(tomb[i].getTime()).equals(aktEvHo)) {   //megnézzük, hogy a stringként eltárolt év+hónappal egyenlő-e a tömb aktuális év+dátuma
                i++;
                aktEvHoDb++;
            }
            System.out.println(aktEvHoKiirashoz+" ("+aktEvHoDb+")"); //a szép formátumú Stringet írjuk ki
        }  
        System.out.println("Összesen ("+n+")"); //vagy n helyett tomb.length is lehet
    }
}
