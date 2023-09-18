public class PResept extends Hvit {
    public static int reit = 3;

    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int rId) {
        super(legemiddel, utskrivendeLege, pasientId, reit, rId); // sender parameterene opp til superkonstruktor
    }

    public String toString() {
        return "P-RESEPT | Navn paa legemiddel: " + this.legemiddel + "Pasient-ID: " + this.pasientId + "| Reit: " + reit;
    }

    public double prisAaBetale() { // *** STATISK RABATT
        if (pris == 0) {
            return pris;
        }
        return pris - 108;
    }

    public String farge() {
        return "hvit";
    }

}