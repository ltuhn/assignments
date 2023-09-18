public class Lege implements Comparable<Lege> {
    private String navn;
    protected SortertLenkeliste<Lege> legeliste = new SortertLenkeliste<Lege>(); // legeliste
    protected Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<Resept>(); // reseptliste
    private String kontrollID = "0";

    public Lege(String navn) {
        this.navn = navn;
    }
    public String hentNavn() { // henter navnet til legen
        return navn;
    }
    public String hentKontrollID() {
        return kontrollID;
    }

    @Override
    public String toString() { // oppdaterer toString metoden
        return "Legens navn: " + hentNavn() + ".";
    }
    public Lenkeliste<Resept> hentReseptListe() {
        return utskrevedeResepter;
    }

    public void leggTilLege(Lege lege) {
        legeliste.leggTil(lege);
    }

    @Override
    public int compareTo(Lege lege) {
        return navn.compareTo(lege.navn);
    }

    public String hentReseptListeString() { // skriver ut liste av Resept-objekter
        return utskrevedeResepter.toString();
    }

    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit  ) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            HvitResept hvit = new HvitResept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(hvit); // legger til resepten i reseptliste
            return hvit;
        }
    }

    public Militaerresept skrivMilitaerresept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            Militaerresept militaer = new Militaerresept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(militaer);
            return militaer;
        }
    }

    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            PResept pres = new PResept(legemiddel, this, pasient);
            utskrevedeResepter.leggTil(pres);
            return pres;
        }
    }

    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            BlaaResept blaa = new BlaaResept(legemiddel, this, pasient, reit);
            utskrevedeResepter.leggTil(blaa);
            return blaa;
        }
    }
}