public class Blaa extends Resept {

    public Blaa(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit, int rId) {
        super(legemiddel, utskrivendeLege, pasientId, reit, rId);
    }

    public String toString() {
        return "BLAATT RESEPT | " + this.legemiddel + "Pasient-ID: " + this.pasientId + " | Reit: " + this.reit;
    }

    public double prisAaBetale() {
        return pris * 0.25;
    }

    public String farge() {
        return "blaa";
    }

}
