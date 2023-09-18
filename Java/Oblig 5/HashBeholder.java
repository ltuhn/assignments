import java.util.HashMap;
import java.util.ArrayList;

public class HashBeholder {
    private ArrayList<HashMap<String, SubSekvens>> hashbeholder = new ArrayList<HashMap<String, SubSekvens>>();
    int antall = 0;
    boolean hattVirus;

    public HashBeholder(boolean hattVirus) {
        this.hattVirus = hattVirus;
    }

    public int hentAntall() {
        return hashbeholder.size();
    }
    
    public void leggTil(HashMap<String, SubSekvens> hashMap) {
        antall++;
        hashbeholder.add(hashMap);
    }

    public HashMap<String, SubSekvens> fjernHashMap() { // henter ut forste hashmap
        antall--;
        return hashbeholder.remove(0);
    }

    public boolean hattVirus() {
        return hattVirus;
    }

    public ArrayList<HashMap<String, SubSekvens>> hentHashbeholder() {
        return hashbeholder;
    }
}