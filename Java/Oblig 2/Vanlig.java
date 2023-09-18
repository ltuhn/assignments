public class Vanlig extends Legemiddel {

    public Vanlig(String navn, int pris, double virkestoff, int lId) {
        super(navn, pris, virkestoff, lId);
    }

    public String toString() {
        return "Navn paa legemiddel: " + this.navn + " | Pris: " + this.pris + " | Virkestoff: " + this.virkestoff;
    }

}
