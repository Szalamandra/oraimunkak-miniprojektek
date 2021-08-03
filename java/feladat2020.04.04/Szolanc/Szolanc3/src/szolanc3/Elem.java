
package szolanc3;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;


public class Elem {
     String nev;
       
       
       public Elem(String nev){    //ide majd exceptioneket bepakolni
           this.nev = nev;
             }

    public String getNev() {
        return nev+" ";
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
    
    

    public char getFirstCharacter(){
        char elsoBetu= getNev().charAt(0);
        return elsoBetu;
    }
     public char getLastCharacter(){
         
        char utolsoBetu=getNev().charAt(getNev().length()-2);               //itt a szóközök miatt kell -2
//         System.out.println(utolsoBetu);
        return utolsoBetu;
    }
//    
    
    @Override
    public String toString() {
        return nev+" "; 
    }
    
//   public Comparator nevSorban = new Comparator() {
//        public int compare(Elem e1, Elem e2) {
//            Collator col = Collator.getInstance(new Locale("hu","HU"));
//            return col.compare(e1.nev, e2.nev);
//        }

//         @Override
//         public int compare(Object o1, Object o2) {
//             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////         }
//    };
    
   public int compareTo(Elem e) {
        return this.nev.compareTo(e.getNev());
} 
}
//  public Arraylist<Elem> elemListaFeltolt(){
//      
//      
//      
//      
//  }
//
//    private static class Arraylist<T> {
//
//        public Arraylist() {
//        }
//    }
//}
    
    
    
    
//public boolean equals(Elem e){
//    return (this.nev.equalsIgnoreCase(e.getNev()));
//}
//
//}
