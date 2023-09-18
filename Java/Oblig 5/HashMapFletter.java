import java.util.concurrent.CountDownLatch;
import java.io.*;
import java.util.*;

public class HashMapFletter implements Runnable {
    private Monitor monitor;
    private boolean hattVirus;
    private HashMap<String, SubSekvens> nySubsekvensMap = new HashMap<String, SubSekvens>();
    private ArrayList<HashMap<String, SubSekvens>> subsekvensMap;

    private int hattVirusTraader, ikkeHattVirusTraader; // antall traader som skal bearbeide i hattVirus-beholderen, og ikkeHattVirus-beholderen

    public HashMapFletter(Monitor monitor, boolean hattVirus, int hattVirusTraader, int ikkeHattVirusTraader) {
        this.monitor = monitor;
        this.hattVirus = hattVirus;

        this.hattVirusTraader = hattVirusTraader;
        this.ikkeHattVirusTraader = ikkeHattVirusTraader;
    }

    // 1. Oppretter variabel som oppbevarer en arraylist av en metode fra monitor som henter ut to hashmapper (metoden skal returnere null hvis det ikke er noen hashmapper igjen som kan returneres)
    // 2. Fletter disse to hashmappene
    // 3. Setter inn det nye igjen via legg-til metoden i monitoren
    public void run() {
        while (!Thread.interrupted()) {
            subsekvensMap = monitor.flett(hattVirus, hattVirusTraader, ikkeHattVirusTraader);
            nySubsekvensMap = subsekvensMap.get(0);
            for (String key : subsekvensMap.get(1).keySet()) {
                if (nySubsekvensMap.containsKey(key)) {
                    nySubsekvensMap.get(key).okForekomst(subsekvensMap.get(1).get(key).hentForekomst());
                } else {
                    nySubsekvensMap.put(key, subsekvensMap.get(1).get(key));
                }
            }
            monitor.leggTil(nySubsekvensMap, hattVirus);
        }
    }
}