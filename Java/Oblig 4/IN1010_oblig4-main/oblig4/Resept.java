public abstract class Resept {
    private static int teller = 1; //original id for hvert resept objekt
    private int id;
    private int reit;
    protected Legemiddel legemiddel;
    protected Lege lege;
    protected Pasient pasient;

    public Resept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit) { //konstruktør
        this.legemiddel = legemiddel;
        this.lege = lege;
        this.pasient = pasient;
        this.reit = reit;
        id = teller;
        teller++;

    }
    public int hentId() { //disse metodene henter informasjon for bruk utenfor klassen
        return id;
    }
    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }
    public Lege hentLege() {
        return lege;
    }
    public Pasient hentPasientId() {
        return pasient;
    }
    public int hentReit() {
        return reit;
    }
    public boolean bruk() {
        if (reit == 0) { //hvis resepten ikke er gyldig
            return false;
        }
        reit -= 1; //bruker resept, reit - 1
        return true;
    }
    
    
    @Override 
    public String toString() { //oppdatert toString metode
        return "Resept ID: " + id + " " + pasient + ". Legemiddel: " + legemiddel.hentNavn() + ". Lege: " + lege.hentNavn() + ". Antall bruk igjen: " + reit + ".";
    }
    abstract public String farge(); //abstrakte metoder som defineres i subklassene
    abstract public int prisAaBetale();
}
