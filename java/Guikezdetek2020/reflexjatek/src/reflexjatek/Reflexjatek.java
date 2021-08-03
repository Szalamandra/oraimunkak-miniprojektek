
package reflexjatek;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;





public class Reflexjatek extends JFrame  { 
  //játékmenethez tartozó változók, model
  private final int START_IDO=15;     //másodperc
  private int idotartam=START_IDO*10, //tizedmásodpercenként léptetve
    racsMeret, feladatDb, talalatDb;
  //GUI komponensek, view
    private JButton btUjJatek=new JButton("Új játékot indít"); 
 private JPanel pnFeladat=new JPanel();
  private JLabel lbMaradekIdo=new JLabel("0:15.0"); //példaként 
  
  private JPanel pnJatekter=new JPanel();
//  private int startIdo, idotartam;/időzítő, controller

  private Timer idozito=new Timer(100, (ActionEvent e) -> {
    telikAzIdo();
  });
  
  public Reflexjatek() {
    setTitle("Reflexjáték 1.0");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
//      setSize(500, 600);
     Dimension d=new Dimension(500, 600);
    double skala=0.8;
    setSize((int)(d.width*skala), (int)(d.height*skala));
    setResizable(false);
   
    setLocationRelativeTo(this);
    setLayout(new BorderLayout());
    Font betu=new Font("Tahoma", Font.PLAIN, 12);
    JPanel pnEszkoztar=new JPanel(new GridLayout(1, 3));
   btUjJatek.setFont(betu);
//     pnEszkoztar.add(new JButton("1"));
//    pnEszkoztar.add(new JLabel());
//    pnEszkoztar.add(new JButton("2"));
pnEszkoztar.add(btUjJatek);
pnEszkoztar.add(pnFeladat);
    pnFeladat.setBackground(Color.RED);
    pnFeladat.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
    lbMaradekIdo.setPreferredSize(new Dimension(100,50));
//    lbMaradekIdo.setText("");
    pnEszkoztar.add(lbMaradekIdo);
 pnEszkoztar.setBackground(Color.RED);
   lbMaradekIdo.setBackground(Color.white);
   
    add(pnEszkoztar, BorderLayout.PAGE_START);
    pnJatekter.setBackground(Color.RED);
        add(pnJatekter, BorderLayout.CENTER);    
    setVisible(true);
        
        btUjJatek.addActionListener((e) -> {
           jatekStart();

        });
        
  } 
  
  private String idoFormaz() {
    return "0:"+String.format("%02d", idotartam/10)+"."+idotartam%10;
  }
  
  //4 db játék életciklusához kötődő metódus, kötődés: model+controller
  private void jatekStart() {
      racsMeret=2;
    feladatDb=0;
    talalatDb=0;
      btUjJatek.setEnabled(false);
      ujFeladat();
   // startIdo=15;       //15 másodperc
    idotartam=START_IDO*10;   //tizedmásodpercenként léptetve
    idozito.start();
  }
 
  private void ujFeladat() {
//    feladatDb++;
//    if(feladatDb%2==0) //vált a 2., 4., 6... feladat után
      feladatDb++;
    pnJatekter.removeAll();
    ArrayList<Color> szinLista=getSzinLista();
    int szinIndex=0; //(int)(Math.random()*szinLista.size());
    pnFeladat.setBackground(szinLista.get(szinIndex));
    pnJatekter.setLayout(new GridLayout(racsMeret, racsMeret));
    for(int i=1; i<=racsMeret*racsMeret; i++) {
      JPanel pn=new JPanel();
      pn.setOpaque(true);
      pn.setBackground(szinLista.get(i-1));
      pnJatekter.add(pn);
      pn.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          if(((JPanel)e.getSource()).getBackground().equals(pnFeladat.getBackground()))
            talalatDb++;
          ujFeladat();
        }
      });
    }
//itt kell összerakni a játékteret alkotó rácsot
     pnJatekter.repaint();
    if(feladatDb%2==0) //vált a 2., 4., 5... feladat után
      racsMeret++;
  }
  
  
   private ArrayList<Color> getSzinLista() {
    ArrayList<Color> szinLista=new ArrayList<>();
    while(szinLista.size()<racsMeret*racsMeret) {
      Color szin=new Color(
        (int)(Math.random()*256), //R
        (int)(Math.random()*256), //G
        (int)(Math.random()*256)  //B
      );
      if(!szinLista.contains(szin))
        szinLista.add(szin);
    }
    return szinLista;
  }
   
  private void telikAzIdo() {
   idotartam--;
   lbMaradekIdo.setText(idoFormaz());
//    lbMaradekIdo.setText("0:"+String.format("%02d", idotartam/10)+"."+idotartam%10);
    if(idotartam==0)
      jatekStop();
  
  }   
 
  private void jatekStop() {
   idozito.stop();
//    startIdo=15;              //5 másodperc
//    idotartam=startIdo*10;   //tizedmásodpercenként léptetve
    pnFeladat.setBackground(btUjJatek.getBackground());
    pnJatekter.removeAll();
    pnJatekter.repaint();
    JOptionPane.showMessageDialog(this,
      START_IDO+" mp alatt "+feladatDb+" feladatból "+talalatDb+" találat",
      "Eredmény", JOptionPane.INFORMATION_MESSAGE);
        lbMaradekIdo.setText(idoFormaz());
  
//    lbMaradekIdo.setText("");
//    System.out.println("stop");
    btUjJatek.setEnabled(true);
  }
  
    public static void main(String[] args) {
            new Reflexjatek();
    }
    
}
