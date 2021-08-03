package sheldonv3;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MainSheldon {

    private NezetSheldon nezet = null;
    private ModellSheldon modell = null;

    public MainSheldon() {
        this.modell = new ModellSheldon();
        this.nezet = new NezetSheldon(modell, this);

    }

    public void jatek(DefaultListModel balLista, DefaultListModel kontrollLista, String taroltElem, int taroltElemIndex) {
//      taroltElem: amire kattintunk, esemenykezelőtől kapott String,         
//elemek: baloldali lista, kontrollista: teljes elemlista-taroltelem(valasztott),  jobb oldalon csak kiíratom egyenlőre 
        JLabel kivalasztottElemekLista = new JLabel();
        kivalasztottElemekLista.setAlignmentY(SwingConstants.VERTICAL);
        kivalasztottElemekLista.setAlignmentX(0);
      kivalasztottElemekLista.setFont(nezet.getFont());
        kivalasztottElemekLista.setBorder(nezet.borderList);   
        nezet.kivalasztottPanel.add(kivalasztottElemekLista);

        char jatekos;
        String kiIras = new String();
        kivalasztottElemekLista.setText(modell.taroltElem);

//        do {
//            jovalasz = false;
        if (modell.lepesSzamlalo % 2 == 0) {
            jatekos = 'A';
            kiIras = jatekos + ": " + taroltElem;
            kivalasztottElemekLista.setText(kiIras);
            nezet.jatekKezdGomb.setText(modell.gombKiíras[1]);

        } else {
            jatekos = 'B';
            kiIras = jatekos + ": " + taroltElem;
            kivalasztottElemekLista.setText(kiIras);
            nezet.jatekKezdGomb.setText(modell.gombKiíras[0]);

        }
        modell.lepesSzamlalo++;
//        System.out.println("méret: " + balLista.size()+"jobb:"+kontrollLista.size());
        boolean joValasz = false;

        int i = 0;
        while (!joValasz) {
            while (taroltElem.equals(balLista.get(i))) {     
                balLista.removeAllElements();
            

                for (int k = 0; k < kontrollLista.size(); k++) {                    
                    String keresendoElem = kontrollLista.get(k).toString();
                    if(taroltElem.charAt(taroltElem.length() - 1) == keresendoElem.charAt(0)) {
                        System.out.println(keresendoElem);
                        balLista.addElement(keresendoElem);
                    }             
                }
                if(balLista.size()<=1)
                    jatekStop();
                else{
                nezet.elemekLista.setModel(balLista);
                joValasz =true;}
            }
            i++;
        }


    }

    public void jatekStart() {
     
    }

    public void jatekStop() {
        JOptionPane.showMessageDialog(nezet, ""+(modell.lepesSzamlalo%2==0?"'A'":"'B'")+" játékos nyert "+modell.lepesSzamlalo+" lépésben", "Nyertes", JOptionPane.INFORMATION_MESSAGE);
        nezet.jatekKezdGomb.setEnabled(true);
    }

    public static void main(String[] args) {
        new MainSheldon();
 
    }

}
