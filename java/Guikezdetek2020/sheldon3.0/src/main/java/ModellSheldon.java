
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JList;







public class ModellSheldon {
  
//    
//   public char elsoBetu;
//    public char utolsoBetu;
      public final static String[] ELEMNEV = {"hidrogén", "hélium", "lítium", "berillium", "bór", "szén", "nitrogén", "oxigén", "fluor", "neon", "nátrium", "magnézium", "alumínium", "szilícium", "foszfor", "kén", "klór", "argon", "kálium", "kalcium", "szkandium", "titán", "vanádium", "króm", "mangán", "vas", "kobalt", "nikkel", "réz", "cink", "gallium", "germánium", "arzén", "szelén", "bróm", "kripton", "rubídium", "stroncium", "ittrium", "cirkónium", "nióbium", "molibdén", "technécium", "ruténium", "ródium", "palládium", "ezüst", "kadmium", "indium", "ón", "antimon", "tellúr", "jód", "xenon", "cézium", "bárium", "lantán", "cérium", "prazeodímium", "neodímium", "prométium", "szamárium", "európium", "gadolínium", "terbium", "diszprózium", "holmium", "erbium", "túlium", "itterbium", "lutécium", "hafnium", "tantál", "volfrám", "rénium", "ozmium", "irídium", "platina", "arany", "higany", "tallium", "ólom", "bizmut", "polónium", "asztácium", "radon", "francium", "rádium", "aktínium", "tórium", "protaktínium", "urán", "neptúnium", "plutónium", "amerícium", "kűrium", "berkélium", "kalifornium", "einsteinium", "fermium", "mendelévium", "nobélium", "laurencium", "raderfordium", "dubnium", "sziborgium", "bohrium", "hasszium", "meitnérium", "darmstadtium", "röntgénium", "kopernícium", "nihónium", "fleróvium", "moszkóvium", "livermórium", "tenesszium", "oganeszon", "ununennium", "unbinilium", "unbiunium", "unbibium", "unbikvadium", "unbipentium", "unbioktium", "unbiennium", "untrinilium", "untriunium", "untribium"};
  public final String[] gombKiíras={"'A' jatekos lép", "'B' jatekos lép"};
//          public DefaultListModel balLista=new DefaultListModel();          //hogy dolgozni is tudjak vele a háttérben, ne csak megjeleníteni
//   public DefaultListModel jobbLista=new DefaultListModel();
// public JList elemekLista =new JList(getBalLista()); 
//     public JList kivalasztottElemekLista= new JList(getJobbLista());

     
         String taroltElem = "";
        boolean jovalasz = false;
        boolean vanUjSzo = false;
        char jatekos;
        int lepesSzamlalo = 0;
     
    public ModellSheldon() {
//        getBalLista();
//        getJobbLista();
    }
//
//    public JList getElemekLista() {
//        return elemekLista;
//    }
//
//    public JList getKivalasztottElemekLista() {
//        return kivalasztottElemekLista;
//    }
//       
//
//    public DefaultListModel<String> getBalLista() {
//        for (String string : ELEMNEV) {
//            balLista.addElement(ELEMNEV);
//        }
//        return balLista;
//    }
//
//    public DefaultListModel<String> getJobbLista() { 
//        for (String string : ELEMNEV) {
//            jobbLista.addElement(ELEMNEV);
//        }
//        return jobbLista;
//    }

         
         
    public char getUtolsoBetu(int i) {
        char utolsoBetu=ELEMNEV[i].charAt(ELEMNEV.length-1);
        return utolsoBetu;
    }

    public char getElsoBetu(int i) {
       char elsoBetu=ELEMNEV[i].charAt(0);
        return elsoBetu;
    }

    @Override
    public String toString() {
//        if (ELEMNEV instanceof String[]) {
//        String[] strArray = (String[]) ELEMNEV;
//        System.out.println(Arrays.toString(strArray));}
                return Arrays.deepToString(ELEMNEV);

    }
}
    
   



