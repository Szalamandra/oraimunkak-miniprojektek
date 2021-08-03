package sheldon;

public class Sheldon {

    public static void main(String[] args) {
         GamePlay gp=new GamePlay();
        int gameIsRunning=-1;
        char lastChar='-';
        //String valasztas = extra.Console.readLine("Milyen kémiai elemet szeretne mondani? ");
        String pna=extra.Console.readLine("A játkos:");
        String pnb=extra.Console.readLine("B játékos:");
        gp.addPlayer(pna, pnb);
        Elements el=new Elements();
        el.initElement();
        System.out.println("Elemek száma"+el.getElementNum());
       while (gameIsRunning!=0){
           el.choosable(lastChar);
            
           String chEl=extra.Console.readLine(gp.getPName()+", kérem írjon be egy kémiai elemet!");
           gameIsRunning=gp.addstep(chEl, lastChar);
           lastChar=chEl.charAt(chEl.length()-1);
       }
       
    }
    
}