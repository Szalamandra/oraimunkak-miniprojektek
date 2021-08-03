
package dominolanc;

import java.util.GregorianCalendar;
import java.util.TreeSet;


public class gyakciOrara {
   
      
      
      
      
      

    
    
    

    public static void main(String[] args) {
           TreeSet <GregorianCalendar> randomDatum =new TreeSet<>();
           for (GregorianCalendar gregorianCalendar : randomDatum) {
               
               if(!randomDatum.contains(gregorianCalendar))
                   randomDatum.add(gregorianCalendar);
               
            
        }
        System.out.println(randomDatum);
        
    }

    
}


