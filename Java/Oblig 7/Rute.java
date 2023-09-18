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

    public void gaa(Rute rute, ArrayList<Tuppel> vei, ArrayList<Tuppel> journey) { // metoden overskrives av metodene i HvitRute og SortRute
        if (nNabo != null) {
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
            oppdatertVei.add(koordinater);
            journey.add(koordinater);
            nNabo.gaa(this, vei, journey);
        }
        if (vNabo != null) {
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
            oppdatertVei.add(koordinater);
            journey.add(koordinater);
            vNabo.gaa(this, vei, journey);
        }
        if (oNabo != null) {
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
            oppdatertVei.add(koordinater);
            journey.add(koordinater);
            oNabo.gaa(this, vei, journey);
        }
        if (sNabo != null) {
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
            oppdatertVei.add(koordinater);
            journey.add(koordinater);
            sNabo.gaa(this, vei, journey);
        }
    }

    public void finnUtvei() { // starter gaa()-metoden
        gaa(this, labyrint.getRouteArrayList(), labyrint.getRouteArrayList());
    }

    public int getRow() {
        return rad;
    }

    public int getColumn() {
        return kolonne;
    }
}