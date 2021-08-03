
package sheldon;

public class Player {
    private String playerName;
    
    
     Player(){
       
    }

    
    
    public void addPlayer(String pn){
      
      this.playerName=pn;
    }
    
    public String getPn(){
        return this.playerName;
    }
}
