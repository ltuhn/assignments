public class BlaaResept extends Resept {
    private double nyPris;
    private double rabatt = 0.25;
    private double gammelPris = legemiddel.hentPris();
    private int avrundetPris;

    public BlaaResept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit) {
        super(legemiddel, lege, pasient, reit); //kaller på konstruktøren til Resept klassen

        nyPris = gammelPris * rabatt; //ganger full pris med 0.25 for å få 25% av prisen, avrunder deretter til nærmeste krone
        avrundetPris = (int) Math.round(nyPris);
    }
    @Override
    public String farge() { //oppdaterer abstrakte metoder fra Resept
        return "Blaa";
    }
    @Override
    public int prisAaBetale() {
        return avrundetPris;
    }
    @Override
    public String toString() {
        return super.toString() + " Farge: " + farge() + ". Pris: " + prisAaBetale() + "kr.";
    }
}
