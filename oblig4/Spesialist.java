public class Spesialist extends Lege implements Godkjenningsfritak { //implementerer også grensesnittet 
    private String kontrollID;
    public Spesialist(String navn, String kontrollID) {
        super(navn);
        this.kontrollID = kontrollID;
    }
    public String hentKontrollID() {
        return kontrollID; 
    }
    @Override
    public String toString() { //oppdaterer toString
        return super.toString() + " Godkjenningsfritak: " + hentKontrollID() + ".";
    }

    @Override
    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        HvitResept hvit = new HvitResept(legemiddel, this, pasient, reit);
        super.utskrevedeResepter.leggTil(hvit);
        return hvit;
    }

    @Override
    public Militaerresept skrivMilitaerresept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        Militaerresept militaer = new Militaerresept(legemiddel, this, pasient, reit);
        super.utskrevedeResepter.leggTil(militaer);
        return militaer;
    }

    @Override
    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        PResept pres = new PResept(legemiddel, this, pasient);
        super.utskrevedeResepter.leggTil(pres);
        return pres;
    }

    @Override
    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        BlaaResept blaa = new BlaaResept(legemiddel, this, pasient, reit);
        super.utskrevedeResepter.leggTil(blaa);
        return blaa;
    }
}