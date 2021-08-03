//
//package szolancoopver2;
//
//import java.util.Arrays;
//
//
//public class SzolancOop {
//
//        public static String valaszKonvert(String valasz){
//       StringBuilder cs=new StringBuilder(valasz);
//       
//        for (int i = 0; i < cs.length(); i++) {
//         if(cs.charAt(i)=='é') cs.setCharAt(i, 'e');
//         if(cs.charAt(i)=='á') cs.setCharAt(i, 'a');
//         if(cs.charAt(i)=='í') cs.setCharAt(i, 'i');
//         if(cs.charAt(i)=='ó' || cs.charAt(i)=='ő' || cs.charAt(i)=='ö') cs.setCharAt(i, 'o');
//                  if(cs.charAt(i)=='ú' || cs.charAt(i)=='ü' || cs.charAt(i)=='ű') cs.setCharAt(i, 'u');
//
//        }
//        String csere=cs.toString();
//   return csere;
//    }
//    
//   
//    public static void main(String[] args) {
////       String k="kálács";
////       byte[] g;
////        elemKonvert(k);
//       
////        
//        Listak elemLista= new Listak();
//       Listak kivalasztLista= new Listak();
//       elemLista.feltolt();
//       elemLista.listaKiir();
//     
//       do{
//       kivalasztLista.lista=elemLista.kivalasztUjLista(elemLista.elemKivalaszt());  //a zárójelben lévő részben adom át a vObj= a játékos által választott Elem objektum, ami alapján kiirja az uj listát
//       kivalasztLista.lista.remove(kivalasztLista.valaszIndex);             //eltávolítani a már vlasztott elemet
//       kivalasztLista.elemKivalaszt();
//       }
//       while (kivalasztLista.lista.isEmpty());
//      
//          
//        System.out.println("A játéknak ezennel vége, elfogyott az összes választható elem. \n "
//                +((elemLista.jatek%2==0)?"Gratulalunk az első számú játékosnak a győzelemért!":"Gratulalunk a második számú játékosnak a győzelemért!"));
//     
//            
//       
//    }
//    
//}
