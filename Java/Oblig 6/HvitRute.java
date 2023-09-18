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
    public void gaa(Rute rute, ArrayList<Tuppel> vei) {
        if (nNabo != null && nNabo != rute) { // hvis denne rutens nord-nabo fins, og naboen ikke er det samme som den forrige ruten, kan vi bevege oss til denne ruta
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei); // lager en lokal kopi av ArrayList<Tuppel> vei
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne); // lagrer koordinatene i et objekt av klassen Tuppel
            oppdatertVei.add(koordinater); // beholder koordinatene i den lokale kopien av ArrayList<Tuppel> vei
            nNabo.gaa(this, vei); // nord-naboen kaller paa denne metoden paa nytt paa sine naboer
        } else if (nNabo == null) { // hvis denne ruta ikke har en nabo her, har vi funnet en aapning i labyrinten
            Aapning aapningsrute = new Aapning(labyrint, this.rad, this.kolonne);
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(aapningsrute.rad, aapningsrute.kolonne);
            oppdatertVei.add(koordinater);
            labyrint.utveierListe.add(oppdatertVei); // legger til denne utveien i lista av utveier i labyrintobjektet
            return;
        }

        if (vNabo != null && vNabo != rute) {
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
            oppdatertVei.add(koordinater);
            vNabo.gaa(this, vei);
        } else if (vNabo == null) {
            Aapning aapningsrute = new Aapning(labyrint, this.rad, this.kolonne);
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(aapningsrute.rad, aapningsrute.kolonne);
            oppdatertVei.add(koordinater);
            labyrint.utveierListe.add(oppdatertVei);
            return;
        }

        if (oNabo != null && oNabo != rute) {
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
            oppdatertVei.add(koordinater);
            oNabo.gaa(this, vei);
        } else if (oNabo == null) {
            Aapning aapningsrute = new Aapning(labyrint, this.rad, this.kolonne);
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(aapningsrute.rad, aapningsrute.kolonne);
            oppdatertVei.add(koordinater);
            labyrint.utveierListe.add(oppdatertVei);
            return;
        }

        if (sNabo != null && sNabo != rute) {
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(this.rad, this.kolonne);
            oppdatertVei.add(koordinater);
            sNabo.gaa(this, vei);
        } else if (sNabo == null) {
            Aapning aapningsrute = new Aapning(labyrint, this.rad, this.kolonne);
            ArrayList<Tuppel> oppdatertVei = new ArrayList<>(vei);
            Tuppel koordinater = new Tuppel(aapningsrute.rad, aapningsrute.kolonne);
            oppdatertVei.add(koordinater);
            labyrint.utveierListe.add(oppdatertVei);
            return;
        }
    }

}
