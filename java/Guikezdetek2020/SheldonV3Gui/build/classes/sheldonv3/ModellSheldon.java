
package sheldonv3;


import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ModellSheldon {


    public String elem;
    public final static String[] ELEMNEV = {"hidrogén", "hélium", "lítium", "berillium", "bór", "szén", "nitrogén", "oxigén", "fluor", "neon", "nátrium", "magnézium", "alumínium", "szilícium", "foszfor", "kén", "klór", "argon", "kálium", "kalcium", "szkandium", "titán", "vanádium", "króm", "mangán", "vas", "kobalt", "nikkel", "réz", "cink", "gallium", "germánium", "arzén", "szelén", "bróm", "kripton", "rubídium", "stroncium", "ittrium", "cirkónium", "nióbium", "molibdén", "technécium", "ruténium", "ródium", "palládium", "ezüst", "kadmium", "indium", "ón", "antimon", "tellúr", "jód", "xenon", "cézium", "bárium", "lantán", "cérium", "prazeodímium", "neodímium", "prométium", "szamárium", "európium", "gadolínium", "terbium", "diszprózium", "holmium", "erbium", "túlium", "itterbium", "lutécium", "hafnium", "tantál", "volfrám", "rénium", "ozmium", "irídium", "platina", "arany", "higany", "tallium", "ólom", "bizmut", "polónium", "asztácium", "radon", "francium", "rádium", "aktínium", "tórium", "protaktínium", "urán", "neptúnium", "plutónium", "amerícium", "kűrium", "berkélium", "kalifornium", "einsteinium", "fermium", "mendelévium", "nobélium", "laurencium", "raderfordium", "dubnium", "sziborgium", "bohrium", "hasszium", "meitnérium", "darmstadtium", "röntgénium", "kopernícium", "nihónium", "fleróvium", "moszkóvium", "livermórium", "tenesszium", "oganeszon", "ununennium", "unbinilium", "unbiunium", "unbibium", "unbikvadium", "unbipentium", "unbioktium", "unbiennium", "untrinilium", "untriunium", "untribium"};
    public final String[] gombKiíras = {"'A' jatekos lép", "'B' jatekos lép"};

    String taroltElem;
    char jatekos;
    int lepesSzamlalo = 0;
    
    public ModellSheldon() {
//        getBalLista();
//        getJobbLista();
    }

//
    public DefaultListModel<String> getElemekLista() {
        DefaultListModel<String> lista=new DefaultListModel<>();
        for (String string : ELEMNEV) {
            lista.addElement(string);
        }
        return lista;
    }

    public static String[] getELEMNEV() {
        return ELEMNEV;
    }



    @Override
    public String toString() {
//        if (ELEMNEV instanceof String[]) {
//        String[] strArray = (String[]) ELEMNEV;
//        System.out.println(Arrays.toString(strArray));}
        return Arrays.deepToString(ELEMNEV);

    }
}
