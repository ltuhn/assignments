public class Test {
    public static int lId = 0;
    public static int rId = 0;
    public static int pId = 0;
    public static void main(String[] args) {
        lId += 1;
        Vanlig vg = new Vanlig("Vanlivan", 500, 2, lId);
        lId += 1;
        Narkotisk n = new Narkotisk("Narkonark", 700, 200, 30, lId);
        lId += 1;
        Vanedannende ve = new Vanedannende("Vanevan", 200, 100, 20, lId);

        System.out.println(vg.toString());
        System.out.println(n.toString());
        System.out.println(ve.toString());

        Lege l = new Lege("Lege Legesson");
        Spesialist s = new Spesialist("Spesialist Spesialistson", "3");
        rId += 1; 
        pId += 1;
        Blaa b = new Blaa(ve, l, pId, 2, rId);
        System.out.println(b.toString());

        rId += 1;
        pId += 1;

        Militaer m = new Militaer(vg, l, pId, 10, rId);
        System.out.println(m.toString());

        rId += 1;
        pId += 1;
        PResept p = new PResept(n, l, pId, rId);
        System.out.println(p.toString());
    }
}
