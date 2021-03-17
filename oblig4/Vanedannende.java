public class Vanedannende extends Legemiddel {
    public int styrke; 

    public Vanedannende(String navn, int pris, double vStoff, int styrke) {
        super(navn, pris, vStoff); //samme konstruktør som superklassen
        this.styrke = styrke; //legger til enda en variabel
    }
    @Override
    public int hentStyrke() {
        return styrke;
    }

    @Override
    public String toString() { //oppdatert toString
        return super.toString() + ", vanedannende styrke: " + styrke;
    }
}
