abstract class Legemidler {
    private int id;

    public Legemidler(String navn, int pris, double virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
    }

    public double hentVirkestoff() {
        return virkestoff;
    }
    
    public int hentID() {
        return id;
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
