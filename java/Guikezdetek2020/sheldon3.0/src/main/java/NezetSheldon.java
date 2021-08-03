
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

public class NezetSheldon extends JFrame {

    private ModellSheldon modell = null;
    private MainSheldon vezerlo = null;

    private JLabel teteje = new JLabel(" ");
    private JPanel pnSheldon = new JPanel();
   
    public JButton jatekos = new JButton();
//    //majd kereteket csinalni//
    public Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
    public Border borderList = BorderFactory.createLineBorder(Color.GRAY, 1);
    private Border gombBorder = BorderFactory.createEmptyBorder(10, 0, 0, 0);
//    private javax.swing.border.Border border;
    private Color szin = new Color(215, 220, 222);        // világosabb szürke legyen a szürke
    private Color szin2 = new Color(228, 232, 235);
         public DefaultListModel balLista=new DefaultListModel();          //hogy dolgozni is tudjak vele a háttérben, ne csak megjeleníteni
   public DefaultListModel jobbLista=new DefaultListModel();
 public JList elemekLista =new JList(balLista); 
     public JList kivalasztottElemekLista= new JList(jobbLista);
     
    public NezetSheldon(ModellSheldon modell, MainSheldon vezerlo) {
        this.modell = modell;
        this.vezerlo = vezerlo;

        setTitle("Szólánc - kémiai elemek");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 450);
        Font betu = new Font(Font.DIALOG, Font.BOLD, 14);          //majd ezt beálltani
        setResizable(false);
        setLocationRelativeTo(this);
//         setLayout(new BorderLayout());
//         setBackground(Color.red);
        add(pnSheldon);
        pnSheldon.add(teteje, BorderLayout.NORTH);
        pnSheldon.setBorder(border);
        pnSheldon.setBackground(szin);
//         teteje.setAlignmentY(TOP_ALIGNMENT);
        pnSheldon.setLayout(new BorderLayout());
////        pnSheldon.setLayout(new GridLayout(16, 2 ));
        for (String string : modell.ELEMNEV)                       
            balLista.addElement(string);
        elemekLista.setAlignmentX(LEFT_ALIGNMENT);
        elemekLista.setFont(betu);
        elemekLista.setSelectedIndex(0);
//        elemekLista.getSelectedIndex(setSelectionModel(ListSelectionModel.SINGLE_SELECTION));
        elemekLista.setSelectionBackground(Color.BLUE);
        elemekLista.setSelectionForeground(Color.WHITE);
        JScrollPane sp=new JScrollPane(elemekLista);
//        sp.setAlignmentX(LEFT_ALIGNMENT);
//        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);      //scrollbar
//        setPreferredSize(new Dimension(100, 150));
        pnSheldon.add(sp, BorderLayout.CENTER);
//            elemekLista.setSelectionModel(ListSelectionModel.SINGLE_SELECTION);
        elemekLista.setBorder(borderList);
//pnSheldon.add(new JLabel("hahha"));
//    pnSheldon.add(sp);
        pnSheldon.add(elemekLista, BorderLayout.WEST);
        
        for (String string : modell.ELEMNEV) {
            jobbLista.addElement(string);
        }
        pnSheldon.add(kivalasztottElemekLista, BorderLayout.EAST);
        kivalasztottElemekLista.setFont(betu);
        kivalasztottElemekLista.setBorder(borderList);
        kivalasztottElemekLista.setSelectionForeground(Color.WHITE);

        JPanel pnGomb = new JPanel(new BorderLayout());
        pnGomb.setBorder(gombBorder);
        pnGomb.setBackground(szin);
        
        jatekos.setText(modell.gombKiíras[0]);
        jatekos.setBackground(szin2);
        pnGomb.add(jatekos);
        pnSheldon.add(pnGomb, BorderLayout.SOUTH);
        setVisible(true);

        jatekos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vezerlo.jatekStart();
            }
        });

//        pnGomb.addActionListener(new ActionListener){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                vezerlo.jate; 
//    }
    }
}
