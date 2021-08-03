

import javax.swing.DefaultListModel;


public class MainSheldon {
 private NezetSheldon nezet=null;
 private ModellSheldon modell=null;
    
    
    public MainSheldon() {
        this.modell=new ModellSheldon();
        this.nezet=new NezetSheldon(modell, this);
        
    }
//
//    public DefaultListModel getBalLista( String[] elemnev) {
//        DefaultListModel<String> lista=new DefaultListModel<>();
//        elemnev=ModellSheldon.ELEMNEV;
//        for (String string : elemnev) {
//            lista.addElement(string);
//        }
//        return lista;
//    }
//
//    public DefaultListModel getJobbLista(String[] elemnev) {
//                DefaultListModel<String> lista=new DefaultListModel<>();
//        elemnev=ModellSheldon.ELEMNEV;
//        for (String string : elemnev) {
//            lista.addElement(string);
//        }
//        return lista;
//    }

    public void jatekStart(){
        System.out.println("A köveijatekos jön");
    }
    
    public void jatekStop(){
     

//        nezet.jatekos.setEnabled(true);
    }
    
    public static void main(String[] args) {
        new MainSheldon();
    }
    
}

