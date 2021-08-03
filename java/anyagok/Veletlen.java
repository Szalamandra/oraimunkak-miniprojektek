package oop;

import java.util.Random;

public class Veletlen {
    
    public static void main(String[] args) {
        Random r=new Random();      //random objektumot létrehozunk - így objektum orientáltan állítunk elő random számokat
        System.out.println("Random kétjegyű szám: "+(r.nextInt(90)+10));     //az "r" nevű objektumotól kértük a következő véletlen számot (paramétereztük)
        System.out.println("Random logikai érték: "+r.nextBoolean());  //ugyanúgy kérhetünk random true and false-t is ugyanattól a fenti "r" objektumtól
        System.out.println("Random valós szám: "+r.nextDouble());      //vagy random double-t
        System.out.println("Random kétjegyű szám: "+(int)(r.nextDouble()*90+10));   //ez is paraméterezhető és int-é kényszeríthető 
        
        System.out.println("Ez egy kockadobás szimuláció:");
        for (int i = 1; i <= 100; i++) {
            int dobas=r.nextInt(6)+1;
            System.out.print(dobas+" ");
        }
        System.out.println();
        
        System.out.println("Véletlen hét napja: "+
            new String[] {"H","K","SZE","CS","P","SZO","V"} [r.nextInt(7)]);    //névtelen technikával tömböt létrehozunk és azonnal egy randomadik elemét kiíratjuk
        
    }
}
