public class TestLegemiddel {
    public static int lId = 0;

    public static boolean testNarkotisk() {
        lId += 1;
        Narkotisk n = new Narkotisk("Narko",  123, 456.7, 2021, lId);
        System.out.println(n.toString());
        System.out.println(n.hentNarkotiskStyrke());
        System.out.println(n.hentId());
        return n.hentId() == lId;
    }

    public static boolean testVanedannende() {
        lId += 1;
        Vanedannende v = new Vanedannende("Vaneda", 987, 654.3, 2001, lId);
        System.out.println(v.hentVanedannendeStyrke());
        System.out.println(v.hentId());
        return v.hentId() == lId;
    }

    public static boolean testVanlig() {
        lId += 1;
        Vanlig va = new Vanlig("Vanli", 247, 777, lId);
        System.out.println(va.hentPris());
        System.out.println(va.hentId());
        return va.hentId() == lId;
    }

    public static void main(String[] args) {
        System.out.println("Forventet resultat: 2021");
        testNarkotisk();

        System.out.println("Forventet resultat: 2001");
        testVanedannende();

        System.out.println("Forventet resultat: 247");
        testVanlig();
    }

}
