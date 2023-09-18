public class Narkotisk extends Legemiddel {
    public int styrke;

    public Narkotisk(String navn, int pris, double vStoff, int styrke) {
        super(navn, pris, vStoff); //bruker konstruktør fra superklassen
        this.styrke = styrke; //legger til en variabel til
    }
    @Override
    public int hentStyrke() {
        return styrke;
    }

    @Override
    public String toString() {
        return super.toString() + ", narkotisk styrke: " + styrke;
    }
}
