import java.util.ArrayList;

abstract public class Rute {
    protected int rad, kolonne;
    protected Labyrint labyrint;
    protected Rute nNabo, vNabo, oNabo, sNabo = null;

    public Rute(Labyrint labyrint, int rad, int kolonne) {
        this.labyrint = labyrint;
        this.rad = rad;
        this.kolonne = kolonne;
    }

    public abstract String charTilTegn();

    public void gaa(Rute rute, ArrayList<Tuppel> vei) { // metoden overskrives av metodene i HvitRute og SortRute
        if (nNabo != null) {
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
            oppdatertVei.add(koordinater);
            nNabo.gaa(this, vei);
        }
        if (vNabo != null) {
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
            oppdatertVei.add(koordinater);
            vNabo.gaa(this, vei);
        }
        if (oNabo != null) {
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
            oppdatertVei.add(koordinater);
            oNabo.gaa(this, vei);
        }
        if (sNabo != null) {
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
            oppdatertVei.add(koordinater);
            sNabo.gaa(this, vei);
        }
    }

    public void finnUtvei() { // starter gaa()-metoden
        gaa(this, labyrint.hentVeiListe());
    }

}