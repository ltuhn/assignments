public abstract class Legemiddel {
private String navn;
private int pris;
private double virkestoff;
private static int teller = 1; //med en static teller lages original ID for hvert objekt
private int id;
private int styrke = 0;
//note: i datastrukturStart.xml står det at ID-en på første instans er 0, men i oppgaveteksten står det at det første objektet skal ha ID = 1. Jeg holder meg til oppgaveteksten & begynner på 1 

    public Legemiddel(String navn, int pris, double vStoff) {
        this.navn = navn;
        this.pris = pris;
        virkestoff = vStoff;

        id = teller; //original id
        teller++;
    }
    public int hentStyrke() {
        return styrke;
    }
    public int hentId() { //henter informasjon
        return id;
    }
    public String hentNavn() {
        return navn; 
    }
    public int hentPris() {
        return pris;
    }
    public double hentVirkestoff() {
        return virkestoff;
    }
    public void settNyPris(int nyPris) { //setter ny pris på legemiddelet
        pris = nyPris; 
    }

    @Override
    public String toString() { //oppdatert toString metode
        return "ID: " + id + ", navn: " + navn + ", pris: " + pris + ", mengde: " + virkestoff;
    }
}
