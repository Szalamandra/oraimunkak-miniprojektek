package sheldonv3;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NezetSheldon extends JFrame {
    
    private ModellSheldon modell = null;
    private MainSheldon vezerlo = null;
    
    private JLabel teteje = new JLabel(" ");
    private JPanel pnSheldon = new JPanel();
    private JPanel listaPanel=new JPanel();
    public JButton jatekKezdGomb = new JButton();
//    //majd kereteket csinalni//
    public Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    public Border borderList = BorderFactory.createLineBorder(Color.GRAY, 1);
    private Border gombBorder = BorderFactory.createEmptyBorder(10, 0, 0, 0);
    private Color szin = new Color(215, 220, 222);        // világosabb szürke legyen a szürke
    private Color szin2 = new Color(228, 232, 235);
    public DefaultListModel balLista = new DefaultListModel();          //hogy dolgozni is tudjak vele a háttérben, ne csak megjeleníteni
    public DefaultListModel jobbLista = new DefaultListModel();
    public JList elemekLista = new JList(balLista);    
//    public JLabel kivalasztottElemekLista = new JLabel();
    public JPanel kivalasztottPanel=new JPanel();
    public int valasztottIndex;
    
    
    
    public NezetSheldon(ModellSheldon modell, MainSheldon vezerlo) {
        this.modell = modell;
        this.vezerlo = vezerlo;
        jobbLista=modell.getElemekLista();
        
        setTitle("Szólánc - kémiai elemek");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 550);
        Font betu = new Font(Font.DIALOG, Font.BOLD, 14);          //majd ezt beálltani
        setResizable(false);
        setLocationRelativeTo(this);
         setLayout(new BorderLayout());
//         setBackground(Color.red);
        add(pnSheldon);
        pnSheldon.add(teteje, BorderLayout.NORTH);
        pnSheldon.setBorder(border);
        pnSheldon.setBackground(szin);
//       
//      

        for (String string : modell.ELEMNEV) {
            balLista.addElement(string);
        }
        elemekLista.setLocale(new Locale("hu", "HU"));
        elemekLista.setComponentOrientation(ComponentOrientation.getOrientation(new Locale("hu", "HU")));
        elemekLista.setAlignmentX(LEFT_ALIGNMENT);
        elemekLista.setFont(betu);
        elemekLista.setSelectedIndex(0);
        elemekLista.setSelectionBackground(Color.BLUE);
        elemekLista.setSelectionForeground(Color.WHITE);
        
        JScrollPane sp = new JScrollPane(elemekLista, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       sp.setPreferredSize(new Dimension(100, 300));
//       sp.setSize(300, 150);
        pnSheldon.add(sp, BorderLayout.WEST);
        elemekLista.setBorder(borderList);
//
    pnSheldon.add(sp);
//        pnSheldon.add(elemekLista, BorderLayout.WEST);
      
        pnSheldon.add(kivalasztottPanel, BorderLayout.EAST);                    //ahova irom a kivalasztott Jlabeleket
        kivalasztottPanel.setBorder(border);
        kivalasztottPanel.setLayout(new GridLayout(20, 1));
        
        JPanel pnGomb = new JPanel(new BorderLayout());
        pnGomb.setBorder(gombBorder);
        pnGomb.setBackground(szin);
        
        jatekKezdGomb.setText(modell.gombKiíras[0]);
        jatekKezdGomb.setBackground(szin2);
        jatekKezdGomb.isEnabled();
        pnGomb.add(jatekKezdGomb);
        pnSheldon.add(pnGomb, BorderLayout.SOUTH);
        setVisible(true);
        
        
        elemekLista.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                   if(!balLista.isEmpty()){
                      valasztottIndex=elemekLista.getSelectedIndex();
                      modell.taroltElem=new String(elemekLista.getSelectedValue().toString());
//                    modell.taroltElem = elemekLista.getSelectedValue().toString();
                                        jobbLista.removeElement(modell.taroltElem);
//                    kivalasztottElemekLista.setText("A: "+modell.taroltElem);
                    vezerlo.jatek(balLista, jobbLista, modell.taroltElem, valasztottIndex);
                    balLista.remove(valasztottIndex);
               
                   }
                  else
                     elemekLista.removeListSelectionListener(this);
            }
            
            
        });

//        pnGomb.addActionListener(new ActionListener){                  //esetleges fejlesztéshez
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                vezerlo.jatekStart; 
//    }
    }
    
  

    public DefaultListModel getBalLista() {
        return balLista;
    }

    public DefaultListModel getJobbLista() {
        return jobbLista;
    }


    
     
  
    
}
