package dominolanc;

import java.util.ArrayList;

public class Main {

    public static void valoszinuseg(ArrayList doboz, ArrayList ujDoboz) {
        if (doboz.isEmpty()) {
            throw new IllegalArgumentException("Hiba! Üres a doboz.");
        }
        if (ujDoboz.isEmpty() || ujDoboz.size()<=0) {
            throw new IllegalArgumentException("Kiborult a doboz...");
        }
        System.out.println("A valószínűsége: " + doboz.size() + "/" + (ujDoboz.size() - 1) + ". ");
    }

    public static void dominoLancFelepites(int a, int b, double dbSzam) {
// a és b az óránként felállítandó dominok száma, dbszam: hogy hány db-ot szeretnénk felállítani
        System.out.println("Ketten együtt " + dbSzam / (a + b) + " óra alatt állítanak fel " + (int) dbSzam + " dominót.");
    }

    public static void main(String[] args) {                   //vezérlő 
        DominoDoboz feladat1 = new DominoDoboz();                          //feltöltöm a dobozt dominókkal
        DominoDoboz feladat2 = new DominoDoboz();

        System.out.println("Anna dominókészletében a dominókövek egyik oldala egy vonallal két részre van osztva.\n Az egyes részeken a pöttyök száma 0, 1, 2, 3, 4, 5 vagy 6 lehet. "
                + "\nA készletben minden lehetséges pöttyözésű dominóból pontosan egy darab van. Az ábrán a 2-6-os (6-2-es) dominó látható.\n"
                + feladat1.getDoboz().get(17).toString());
        System.out.println("\n a)Hány olyan dominó van a készletben, amelyen a két részen lévő pöttyök számának szorzata prímszám? ");

        ArrayList<Domino> primek = feladat1.primetSzorzatKiválaszt(feladat1.getDoboz());   //kiválogatás tétele
        System.out.println(feladat1);

        System.out.println("\n b)A játékban két dominó akkor csatlakozhat egymáshoz, ha a két érintkező részen ugyanannyi pötty van. "
                + "\n Anna egy lapra elhelyezte dominókészletének azt a hat dominóját, amelyek mindkét részén van legalább 1, de legfeljebb 3 pötty. "
                + "\n Ezután összekötötte azokat a dominókat, amelyeket a játékban csatlakoztatni lehetne egymáshoz. "
                + "\n Az alábbi ábra a hat dominót és az összekötő vonalakat mutatja, de csak két részen adtuk meg a pöttyöket.");

        int[] oldal = {1, 2, 3};
        System.out.println("    Csatlakoztatandó dominók: " + feladat2.csatlakozokKeresesEgy(feladat2.getDoboz(), oldal));          //a teljes dobozt újraalkotjuk, és abból kiválasztjuk a keresendőeket(kiválogatás tétele)
        
        System.out.println("\n c)Anna a teljes 28 darabos készletből kihúzta a 2-6-os dominót. Ezután véletlenszerűen kihúz még egy dominót." 
                +"\n Számítsa ki annak a valószínűségét, hogy a másodiknak kihúzott dominót csatlakoztatni tudja az elsőhöz! ");

            Domino kihuzott = new Domino(2, 6);
        int[] keresendoOldalak={kihuzott.getOldal1(),kihuzott.getOldal2()};
        int[] keresendoMasikOldalak={0,1,2,3,4,5,6};
//        System.out.println(feladat2.csatlakozokKeresesKetto(feladat2.getDoboz(), keresendoOldalak, keresendoMasikOldalak));               //ha kiakarom iratni, miket tud csatlakoztatni       
        valoszinuseg(feladat2.csatlakozokKeresesKetto(feladat2.getDoboz(), keresendoOldalak, keresendoMasikOldalak), feladat2.getDoboz());

        System.out.println("\n d)Egy játékbemutatóra Anna és Balázs 1800 dominót szeretne felállítani a földre úgy, hogy a legelsőt meglökve az összes dominó sorban eldőljön."
                + "\n Anna egyedül 6 óra alatt, Balázs pedig 9 óra alatt építené meg a dominóláncot."
                + "\n Ha Anna és Balázs – tartva a saját tempójukat – együtt dolgozna, akkor hány óra alatt végeznének az 1800 dominó felállításával?");

        dominoLancFelepites(200, 300, 1800);

    }
}
