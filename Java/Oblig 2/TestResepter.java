import java.util.MissingResourceException;

public class TestResepter {
   public static int lId = 0;
   public static int rId = 0;
   public static int pId = 0;

   public static void okId() {
      lId += 1;
      rId += 1;
      pId += 1;
   }

   public static void bResept() {
      okId();

      Legemiddel n = new Narkotisk("Narko", 900, 1.1, 9000, lId);
      Lege lege = new Lege("HTM");
      Resept r = new Blaa(n, lege, pId, 2, rId);

      System.out.println("- Bruker reit");
      for (int i = 0; i < 4; i++) {
         System.out.println(r.bruk());
      }

      System.out.println("- Om reseptet");
      System.out.println(r.toString());
      System.out.println("- Resept-ID");
      System.out.println(r.hentID());
      System.out.println("- Prisen til legemiddelet");
      System.out.println(n.hentPris());
      System.out.println("- Pris med blaatt resept");
      System.out.println(r.prisAaBetale());
   }

   public static void mResept() {
      okId();

      Legemiddel v = new Vanlig("Van", 500, 3000, lId);
      Lege lege = new Lege("MTH");
      Resept r = new Militaer(v, lege, pId, 4, rId);
   
      System.out.println("- Om reseptet");
      System.out.println(r.toString());
      System.out.println("- Resept-ID");
      System.out.println(r.hentID());
      System.out.println("- Prisen til legemiddelet");
      System.out.println(v.hentPris());
      System.out.println("- Pris med militaerresept");
      System.out.println(r.prisAaBetale());
   }

   public static void pResept() {
      okId();

      Legemiddel v = new Vanedannende("Vane", 1000, 30, 200, lId);
      Lege lege = new Lege("THM");
      Resept r = new PResept(v, lege, pId, rId);

      System.out.println("- Om reseptet");
      System.out.println(r.toString());
      System.out.println("- Resept-ID");
      System.out.println(r.hentID());
      System.out.println("- Prisen til legemiddelet");
      System.out.println(v.hentPris());
      System.out.println("- Pris med P-resept");
      System.out.println(r.prisAaBetale());
   }

   public static void main(String[] args) {
      System.out.println("BLAATT RESEPT");
      bResept();
      
      System.out.println("MILITAERRESEPT");
      mResept();

      System.out.println("P-RESEPT");
      pResept();
   }
}