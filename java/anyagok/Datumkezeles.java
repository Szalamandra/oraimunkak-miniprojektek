package oop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Datumkezeles {
    
    public static void main(String[] args) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy. MMMM dd.");
        GregorianCalendar datum1=new GregorianCalendar(2020, 1, 8, 9, 15);
        System.out.println(datum1);
        System.out.println(datum1.getTimeInMillis());
        System.out.println("Év: "+datum1.get(Calendar.YEAR));
        System.out.println("Hónap: "+datum1.get(Calendar.MONTH));
        System.out.println("Nap: "+datum1.get(Calendar.DAY_OF_MONTH));
        System.out.println("Óra: "+datum1.get(Calendar.HOUR));
        System.out.println("Perc: "+datum1.get(Calendar.MINUTE));
        System.out.println("Az év "+datum1.get(Calendar.DAY_OF_YEAR)+". napja");
        System.out.println("Szökőév? "+datum1.isLeapYear(datum1.get(Calendar.YEAR)));
        GregorianCalendar datum2=new GregorianCalendar ();
        datum2.setTime(datum1.getTime());
        datum2.add(Calendar.MONTH, -2);
        System.out.println("Hónap: "+datum2.get(Calendar.YEAR));
        System.out.println("Hónap: "+datum2.get(Calendar.MONTH));
        System.out.println(df.format(datum1.getTime()));
        System.out.println(df.format(datum2.getTime()));
    }
    
    public static void main1(String[] args) {
        Date datum1=new Date(100000000000L);
        Date datum2=new Date(10000000);
        System.out.println("A két dátum:\n"+datum1+"\n"+datum2);
        System.out.println("Megegyezik-e a két dátum\n"+(datum1.equals(datum2)?"igen":"nem"));
        System.out.println("datum1<datum2? "+(datum1.compareTo(datum2)));
        System.out.println("datum2<datum1? "+(datum2.compareTo(datum1)));
        System.out.print("Melyik dátum a korábbi? ");
        if(datum1.equals(datum2))
            System.out.println("egyenlők");
        else if (datum1.compareTo(datum2)<0)
            System.out.println(datum1);
        else
            System.out.println(datum2);
    }
}
