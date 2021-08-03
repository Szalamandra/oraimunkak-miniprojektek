package oop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datumok {
    
    public static void main(String[] args) {
        Date aktDatum=new Date();
        System.out.println(aktDatum);
        System.out.println(aktDatum.getTime());
//        System.out.println(aktDatum.toString());
        
//        extra.Console.pressEnter();
        Date regiDatum=new Date(0);
        System.out.println(regiDatum);
        System.out.println(regiDatum.getTime());
        System.out.println("Formázott dátum: "+new SimpleDateFormat("yy/MM/dd").format(regiDatum));
        
//        extra.Console.pressEnter(); 
        Date ujDatum=new Date(Long.MAX_VALUE);
        System.out.println(ujDatum);
        System.out.println(ujDatum.getTime());
    }
}
