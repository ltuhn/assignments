public class Militaer extends Hvit {
    
    public Militaer(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit, int rId) {
        super(legemiddel, utskrivendeLege, pasientId, reit, rId);
    }  

    public String toString() {
        return "MILITAERRESEPT | "+ this.legemiddel + " | Utskrivende lege: " + this.utskrivendeLege.hentNavn() + " | Pasient-ID: " + this.pasientId + " | Reit: " + this.reit;
    }

    @Override
    public double prisAaBetale() {
        return pris * 0;
    }

    public String farge() {
        return "hvit";
    }

}
