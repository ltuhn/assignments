import java.util.ArrayList;

public class SortRute extends Rute {

    public SortRute(Labyrint labyrint, int rad, int kolonne) {
        super(labyrint, rad, kolonne);
    }

    @Override
    public String charTilTegn() {
        return "#";
    }

    @Override
    public void gaa(Rute rute, ArrayList<Tuppel> vei, ArrayList<Tuppel> journey) {
        return;
    }

}
