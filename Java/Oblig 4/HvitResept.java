public class HvitResept extends Resept {

    public HvitResept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit) {
        super(legemiddel, lege, pasient, reit); //samme som Resept
    }
    @Override //definerer abstrakte metoder fra Resept klassen
    public String farge() {
        return "Hvit";
    }
    @Override
    public int prisAaBetale() {
        return legemiddel.hentPris();
    }
    @Override
    public String toString() {
        return super.toString() + " Farge: " + farge() + ". Pris: " + prisAaBetale() + "kr.";
    }
}
