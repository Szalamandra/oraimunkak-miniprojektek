package oop;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Elteresek {
    
    public static void main(String[] args) {
//        int a=5, b=12;
////        int c=Math.abs(a-b);
//        int c=Math.max(a, b)-Math.min(a, b);
//        System.out.println("Eltérés: "+c);
        
//        double a=0.1;
//        double osszeg=0;
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(osszeg); //"Ekkora selejtet még a világon nem láttam" by Kaczur
//            osszeg+=a;
//        }
//        System.out.println("Összeg: "+osszeg);
        
//        char a='Á', b='Z';
//        System.out.println((char)(a-b));  //ennek semmi értelme
        
//        Date d1= new Date();
//        Date d2= new Date(2012,2,20);
//        System.out.println("Eltérés: "+(d1.getTime()-d2.getTime()));
        
//        GregorianCalendar datum1=new GregorianCalendar(2020, 1, 8); //a nyomorult hónpok 0-tól számolása!!!
//        GregorianCalendar datum2=new GregorianCalendar(2019,11,24); 
//        int i=0;
//        while (!datum1.equals(datum2)) {
//            datum1.add(Calendar.DAY_OF_YEAR, -1);
//            i++;
//        }
//        System.out.println("Eltérés: "+i);

        System.out.println("Előző hónap első és utolsó napja:");
        GregorianCalendar ma=new GregorianCalendar();
        int ev=ma.get(Calendar.YEAR), honap=ma.get(Calendar.MONTH);
        GregorianCalendar d1= new GregorianCalendar(ev, honap, 1);
        d1.add(Calendar.DAY_OF_YEAR, -1);
        GregorianCalendar d2=new GregorianCalendar(d1.get(Calendar.YEAR), d1.get(Calendar.MONTH), 1);
        SimpleDateFormat rovidDatum= new SimpleDateFormat("yyyy.MM.dd.");
        System.out.println(rovidDatum.format(d2.getTime())+" és "+rovidDatum.format(d1.getTime()));
    }
}
