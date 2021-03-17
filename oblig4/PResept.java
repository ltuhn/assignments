public class PResept extends HvitResept {
    private int nyPris;

    public PResept(Legemiddel legemiddel, Lege lege, Pasient pasient) {
        super(legemiddel, lege, pasient, 3); //fast reit = 3
        
        if (legemiddel.hentPris() >= 108) { //if-test for å sørge for at pris ikke blir mindre enn 0
            nyPris = legemiddel.hentPris() - 108;
        } else {
            nyPris = 0;
        }
    }
    @Override
    public int prisAaBetale() { //oppdaterer metode med ny pris
        return nyPris;
    }
}
