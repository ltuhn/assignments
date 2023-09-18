import java.util.ArrayList;

public class HvitRute extends Rute {

    public HvitRute(Labyrint labyrint, int rad, int kolonne) {
        super(labyrint, rad, kolonne);
    }

    @Override
    public String charTilTegn() {
        return ".";
    }

    @Override
    public void gaa(Rute rute, ArrayList<Tuppel> vei, ArrayList<Tuppel> journey) {
        if (nNabo == null || vNabo == null || oNabo == null || sNabo == null) { // hvis denne rutens nord-nabo fins, og naboen ikke er det samme som den forrige ruten, kan vi bevege oss til denne ruta
            Aapning aapningsrute = new Aapning(labyrint, this.rad, this.kolonne);
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            ArrayList<Tuppel> newJourney = new ArrayList<>(journey);
            Tuppel koordinater = new Tuppel(aapningsrute.rad, aapningsrute.kolonne);
            oppdatertVei.add(koordinater);
            newJourney.add(koordinater);
    
            boolean leggTil = true;
            for (ArrayList<Tuppel> utveiListe : labyrint.utveierListe) {
                for (Tuppel utvei : utveiListe) {
                    if (koordinater.getX() == utvei.getX() && koordinater.getY() == utvei.getY()) {
                        leggTil = false;
                    }
                }
            }
               
            if (leggTil == true) {
                labyrint.utveierListe.add(oppdatertVei);
            }
            labyrint.fullRoute.add(newJourney);
            System.out.println("Utgang: " + koordinater.getX() + ", " + koordinater.getY());
            return;
        } else {
            if (nNabo != null && nNabo != rute) {
                ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
                ArrayList<Tuppel> newJourney = new ArrayList<>(journey);
                Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
                oppdatertVei.add(koordinater);
                newJourney.add(koordinater);
                nNabo.gaa(this, oppdatertVei, newJourney);
            }
            if (vNabo != null && vNabo != rute) {
                ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
                ArrayList<Tuppel> newJourney = new ArrayList<>(journey);
                Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
                oppdatertVei.add(koordinater);
                newJourney.add(koordinater);
                vNabo.gaa(this, oppdatertVei, newJourney);
            }
            if (oNabo != null && oNabo != rute) {
                ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
                ArrayList<Tuppel> newJourney = new ArrayList<>(journey);
                Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
                oppdatertVei.add(koordinater);
                newJourney.add(koordinater);
                oNabo.gaa(this, oppdatertVei, newJourney);
            }
            if (sNabo != null && sNabo != rute) {
                ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
                ArrayList<Tuppel> newJourney = new ArrayList<>(journey);
                Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
                oppdatertVei.add(koordinater);
                newJourney.add(koordinater);
                sNabo.gaa(this, oppdatertVei, newJourney);
            }   
        }
    }
}