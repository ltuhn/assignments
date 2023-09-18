import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.concurrent.CountDownLatch;

public class Immunrepertoarleser implements Runnable {
    public static int subsekvenslengde = 3;
    private String filnavn;
    private boolean hattVirus;
    private CountDownLatch barriere;
    private Monitor monitor;

    public Immunrepertoarleser(String filnavn, boolean hattVirus, CountDownLatch barriere, Monitor monitor) {
        this.filnavn = filnavn;
        this.hattVirus = hattVirus;
        this.barriere = barriere;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        System.out.println("Leser naa av " + filnavn);
        String linje, subsekvens;
        try {
            Scanner scanner = new Scanner(new File(filnavn));
            HashMap<String, SubSekvens> subsekvensMap = new HashMap<>();		

            scanner.nextLine(); // hopper over "repertoire_file.CMV"
            while(scanner.hasNextLine()) {
                linje = scanner.nextLine();  
                linje = linje.trim();
                for (int i = 0; i + subsekvenslengde <= linje.length(); i++) {
                    subsekvens = linje.substring(i, i + subsekvenslengde);
                    subsekvensMap.putIfAbsent(subsekvens, new SubSekvens(subsekvens));
                }
            }

            monitor.leggTil(subsekvensMap, hattVirus);
            scanner.close();
            barriere.countDown(); // reduserer countdown i barrieren slik at den eventuelt kan gaa videre naar countdown har naadd 0
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}