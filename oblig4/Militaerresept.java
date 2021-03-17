public class Militaerresept extends HvitResept {
    private int nyPris; 

    public Militaerresept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit) {
        super(legemiddel, lege, pasient, reit);
        nyPris = 0; //100% rabatt på militærresept
    }
    @Override
    public int prisAaBetale() { //oppdaterer prisAaBetale() for ny pris
        return nyPris;
    }
}
