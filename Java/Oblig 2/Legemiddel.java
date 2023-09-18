public abstract class Legemiddel {
    protected int pris, lId;
    protected double virkestoff;
    protected String navn;

    public Legemiddel(String navn, int pris, double virkestoff, int lId) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.lId = lId;
    }

    public int hentId() {
        return lId;
    }

    public double hentVirkestoff() {
        return virkestoff;
    }

    public String hentNavn() {
        return navn;
    }

    public int hentPris() {
        return pris;
    }

    public void settNyPris(int nyPris) {
        pris = nyPris;
    }

}