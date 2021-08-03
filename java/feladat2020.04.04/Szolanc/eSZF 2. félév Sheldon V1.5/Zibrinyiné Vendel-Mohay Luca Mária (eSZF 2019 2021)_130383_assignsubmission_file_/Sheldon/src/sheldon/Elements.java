
package sheldon;

import java.util.ArrayList;
import java.util.Arrays;
public class  Elements { //modell, model
 
  
    private ArrayList<String> el;
    
    public Elements(){
       // el= elementUpload();
    }
    
    public void initElement(){
        el=elementUpload();
    }
    
    public Integer getElementNum(){
       return el.size();
    }
    private boolean lookingFor(String fE){
        boolean found=false;
        int i=0;
        while (i<el.size() && !el.get(i).equals(fE)){
            i++;
        }
        if (el.get(i).equals(fE)){
                found = true;
        }
    
    return found;

    }
    public boolean doesElementExist(String choosenElement, char lC){
        System.out.println("Az előző elem utolsó karaktere: "+lC); 
        if((choosenElement.charAt(0)==lC)||(lC=='-')){
            if (this.lookingFor(choosenElement)){
                return true;
            }
            else {
                return false;
            } 
        } else {
            return false;   
        }
    }
    
    private ArrayList<String> elementUpload() {
  
    
    ArrayList<String> elementList = new ArrayList<String> (Arrays.asList(new String[] {"alumínium","amerícium" ,"antimon" ,"arany" ,"argon", "arzén", "asztácium", "bárium", 
            "berillium", "berkélium", "bizmut", "bohrium", "bór", "bróm", "cérium", "cézium", "cink", "cirkónium", "darmstadtium",
            "diszprózium", "dubnium", "einsteinium", "erbium", "európium", "ezüst", "fermium", "fleróvium", "fluor", "foszfor", "francium",
            "gadolínium", "gallium", "germánium", "hafnium", "hasszium", "hélium", "hidrogén", "higany", "holmium", "indium",
            "irídium", "itterbium", "ittrium", "jód", "kadmium", "kalcium", "kalifornium", "kálium", "kén", "klór", "kobalt",
            "kopernícium", "kripton", "króm", "kűrium", "lantán", "laurencium", "lítium", "livermórium", "lutécium", "magnézium",
            "mangán", "meitnérium", "mendelévium", "molibdén", "moszkóvium", "nátrium", "neodímium", "neon", "neptúnium", "nihónium",
            "nikkel", "nióbium", "nitrogén", "nobélium", "oganeszon", "ólom", "ón", "oxigén", "ozmium", "palládium", "platina", "plutónium",
            "polónium", "prazeodímium", "prométium", "protaktínium", "raderfordium", "rádium", "radon", "rénium", "réz", "ródium",
            "röntgénium", "rubídium", "ruténium", "stroncium", "szamárium", "szelén", "szén", "sziborgium", "szilícium", "szkandium",
            "tallium", "tantál", "technécium", "tellúr", "tenesszium", "terbium", "titán", "tórium", "túlium", "unbibium", "unbiennium",
            "unbikvadium", "unbinilium", "unbioktium", "unbipentium", "unbiunium", "untribium", "untrinilium", "untriunium", "ununennium",
            "urán", "vanádium", "vas", "volfrám","xenon"}));
    
        return (ArrayList)elementList;
    }
    
    public void deleteElement(String elem){
        this.el.remove(elem);
    }
    public void choosable(char ce){
        String eStr="";
        String actElem;
        if (ce=='-'){
            System.out.println("Minden elem játszik");
        } else {
            for (int i=0; i<=el.size()-1; i++){
                actElem = this.el.get(i);
                if (actElem.charAt(0)==ce ){
                    eStr=eStr+actElem+", ";
                }
            }
        }
    }
}
    
