
package sheldon;
import java.util.ArrayList;


import java.util.List;

public class GamePlay {

    Player pNumA =new Player();
    Player pNumB =new Player();  
    Elements el=new Elements();
    List<String> step = new ArrayList<>();
    
    public GamePlay(){
       el.initElement();
       

    }
        
    public void addPlayer(String pna, String pnb){
        pNumA.addPlayer(pna);
        pNumB.addPlayer(pnb);
        
    }
    
    public String getPName(){
        if ((step!=null)&&(!step.isEmpty())&&(!step.isEmpty())){
        if (step.size()%2==0){
            return pNumA.getPn();
        }else{
            return pNumB.getPn();
        }
        }else{
        return pNumA.getPn();
        }
    }
    
    public Integer addstep(String element, char lC){
        if(el.doesElementExist(element, lC)){
             if ((step!=null)&&(!step.isEmpty())&&(!step.isEmpty())){
            if (step.size()%2==0){

//                Step st=new Step(this.step.size()+1, element);
                this.step.add(element);
            }
            else{
//                Step st=new Step(this.step.size()+1, element);
                this.step.add(element);
            }     
             }else{
//                 Step st=new Step(this.step.size()+1, element);
                this.step.add(element);
            
             }
            el.deleteElement(element);
           // System.out.println("van elem");
                    return  step.size();
        } else {
           // System.out.println("nincs elem");
           System.out.println("Játék vége");
            return 0;
        }
    }
}

