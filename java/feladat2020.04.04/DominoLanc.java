//package dominolanc;
//
//import java.util.TreeSet;
//
//class Domino implements Comparable<Domino>{
//
//    private Integer oldal1;
//    private Integer oldal2;
//
//    public Domino(Integer oldal1, Integer oldal2) {           //konstruktor egy dominohoz
//        this.oldal1 = oldal1;
//
//        this.oldal2 = oldal2;
//    }
// 
//    public int getOldal1() {
//        return oldal1;
//    }
//
//    public int getOldal2() {
//        return oldal2;
//    }
//
//    public Integer setOldal1(Integer oldal1) {
//        this.oldal1 = oldal1;
//        return oldal1;
//    }
//
//    public Integer setOldal2(Integer oldal2) {
//        this.oldal2 = oldal2;
//        return oldal2;
//    }
//
//    
//    @Override                                //egy domino kinézete
//    public String toString() {
//        return getOldal1() + " | " + getOldal2();
//    }
//
////    @Override
////    public boolean equals(Object obj) {
////        Domino d1=this;
////         if(obj instanceof Domino){
////            Domino d2=(Domino) obj;
////            return (d1.oldal1.equals(d2.getOldal2()) && d2.oldal1.equals(d1.getOldal2()));
////////         return d1.equals(d2);
////         }else
////        return false;
////    }
//
//    
//    @Override
//    public int compareTo(Domino o1) {                 //Hogy  Treeset sorrandbe tudjí helyezni a Dominokat       
//        Domino o2=new Domino(oldal1, oldal2);
//        if(o1.oldal1.compareTo(o2.getOldal1())>0)
//            return -1;
//        if((o1.oldal1.compareTo(o2.getOldal2()))==0 && (o1.oldal2.compareTo(o2.getOldal1()))==0){
//        o1.equals(o2);
//            return 0;    }
//        if(o1.oldal2.compareTo(o2.getOldal2())<0)
//            return 1;
//       else
//            return 1;
//    }
//        
//   
//
//    
////    @Override
////    public int compareTo(Domino o) {                 //Hogy  Treeset sorrandbe tudjí helyezni a Dominokat
////        if(oldal1.compareTo(o.getOldal2())==0 && oldal2.compareTo(o.getOldal1())==0)
////        return 0;
////        
////        else 
////            return 1;
////
////    }
//    }
//class DominoDoboz {
//
//    private int[] oldalak1 = {0, 1, 2, 3, 4, 5, 6};
//    private int[] oldalak2 = {0, 1, 2, 3, 4, 5, 6};
//    private TreeSet<Domino> doboz=new TreeSet<>();
//
//    public DominoDoboz() {                    //konstruktor egy doboznyi dominohoz
//        doboz = dobozKeszit();
////        Kiir(doboz);
//
//        
//    }
//
//    public TreeSet getDoboz() {
//        return doboz;
//    }
//
//////    public void setDoboz(TreeSet doboz) {
//////        this.doboz = doboz;
//////    }
//
// 
//
//    public void setOldalak1(int[] oldalak1) {
//        this.oldalak1 = oldalak1;
//    }
//
//    public void setOldalak2(int[] oldalak2) {
//        this.oldalak2 = oldalak2;
//    }
//
////public Domino keresUgyanolyan(Integer o1, Integer o2, TreeSet<Domino> doboz){
////    Domino keresett=new Domino(o1, o2);
////    Domino megtalalt=new Domino(10,10);                //létrehozok egy nemlétező variációt, amit, ha van megvan a keresendő itthagyok, ha nem akkor lecserélem rá
////    this.doboz=doboz;
////    boolean ok=false;
////    int i=0;
////    while(!ok || i<doboz.size()){
////        for (Domino domino : doboz) {
////             if(!domino.equals(keresett))
////            i++;
////             else{
////           
////           megtalalt=keresett;
////             ok=true;}
////        }
//// 
////    }
////        
////    System.out.println(megtalalt);
////
////    return megtalalt;
////}
////    
////
//    public TreeSet<Domino> dobozKeszit() {
//        doboz= new TreeSet();
//        for (Integer i = 0; i < oldalak1.length; i++) {
//            for (Integer j = 0; j < oldalak2.length; j++) {
//                
////                if(!(doboz.contains(keresUgyanolyan(i, j, doboz))))
////               do{
////                Domino d=new Domino(i, j);
////                if(!doboz.contains(d))
//               
//                getDoboz().add(new Domino(i, j));}
////                while(!(getDoboz().contains(new Domino(i, j))));
//            }
////        }
//        System.out.println("mérete: "+doboz.size());
//        return doboz;
//    }
//    public TreeSet<Domino> primetSzorzatKiválaszt(TreeSet doboz){
//         this.doboz=doboz;                                             //ezt a két sort setdobozolhatnam
//         TreeSet<Domino>ujDoboz=new TreeSet<>();
////         boolean igaz=false;
//         for (Domino d : this.doboz) {
//            if(d.getOldal1()==1 && (d.getOldal2()==2 || d.getOldal2()==3 || d.getOldal2()==5))
//                ujDoboz.add(d);
////             ujDoboz.add(new Domino(d.setOldal1(d.getOldal1()),d.setOldal2(d.getOldal2())));
//        }
//           
////    System.out.println("ÚJ: "+ujDoboz.size());
//    this.doboz=ujDoboz;
//    return ujDoboz;
//    }
//
//        
//    public void Kiir() {
//
//        doboz.forEach((o) -> {
//            System.out.print(o.toString() + ", ");
//
//        });
//                    System.out.println("\nmérete: "+doboz.size());
//
//    }
//
//    @Override
//    public String toString() {
//        return (doboz.size()+" db domino a megoldás.");
//    }
// 
//
//}
//
////    @Override
////    public boolean equals(Domino d1) {
////        Domino d2=new Domino;
////        if(d1.)
////        
////        d2.equals(d1)
////        return Integer.
////    }
////    
//
