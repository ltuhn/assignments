public class Narkotisk extends Legemiddel {
    private int styrke;

    public Narkotisk(String navn, int pris, double virkestoff, int styrke, int lId) {
        super(navn, pris, virkestoff, lId);
        this.styrke = styrke;
    }

    public String toString() {
        return "Navn paa legemiddel: " + this.navn + " | Pris: " + this.pris + " | Virkestoff: " + this.virkestoff + " | Styrke: " + this.styrke;
    }
   
    public int hentNarkotiskStyrke() {
        return styrke;
    }

}
