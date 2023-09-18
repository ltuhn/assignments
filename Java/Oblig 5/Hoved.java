import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.concurrent.CountDownLatch;
import java.util.ArrayList;

// Deler av koden i noen av klassene er fra uke 8-oppgavens losningsforslag

public class Hoved {
    public static String metadata = "metadata.csv";

    public static void main (String [] args) throws IOException, InterruptedException {	
        String linje;
        HashBeholder hattVirusBeholder = new HashBeholder(true); // subsekvenser til dem som har hatt viruset beholdes her
        HashBeholder ikkeHattVirusBeholder = new HashBeholder(false); // subsekvenser til dem som ikke har hatt viruset beholdes her
        Monitor monitor = new Monitor(hattVirusBeholder, ikkeHattVirusBeholder);
        int antFiler = antallFiler(metadata);
        int hattVirusFiler = 0;
        int ikkeHattVirusFiler = 0;
        CountDownLatch barriere = new CountDownLatch(antFiler); // barriere til innlesing av filer

        try {
            Scanner scanner = new Scanner(new File(metadata));

            while(scanner.hasNextLine()) {
                linje = scanner.nextLine();
                linje = linje.trim(); // Filnavn
                String[] linjedeler = linje.split(",");
                if (linjedeler[0].equalsIgnoreCase("repertoire_file")) {;} else {
                    if (linjedeler[1].equalsIgnoreCase("True")) {
                        hattVirusFiler++;
                        Thread subsekvensleser = new Thread(new Immunrepertoarleser(linjedeler[0], true, barriere, monitor));
                        subsekvensleser.start();
                    } else {
                        ikkeHattVirusFiler++;
                        Thread subsekvensleser = new Thread(new Immunrepertoarleser(linjedeler[0], false, barriere, monitor));
                        subsekvensleser.start();
                    }
                }
            }

            System.out.println("Countdown: " + barriere.getCount());
            try {
                System.out.println("Venter paa at countdown naar 0...");
                barriere.await(); // venter paa at alle traader har avsluttet sin oppgave
                System.out.println("Ferdig med countdown");
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println(e);
        }

        subsekvensfletting(hattVirusFiler, ikkeHattVirusFiler, monitor);
        statistiskTest(monitor);
    }

    private static int antallFiler(String metadata) {
        int antallFiler = 0;
        try {
            Scanner scanner = new Scanner(new File(metadata));
            scanner.nextLine();
            while(scanner.hasNextLine()) {
                scanner.nextLine();
                antallFiler++;
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }

        return antallFiler;
    }

    private static void subsekvensfletting(int hattVirusFiler, int ikkeHattVirusFiler, Monitor monitor) {
        int hattVirusTraader = hattVirusFiler;
        int ikkeHattVirusTraader = ikkeHattVirusFiler;

        while (hattVirusTraader > 0) { // oppretter traader til filer fra personer som har hatt viruset
            Thread hashmapfletter = new Thread(new HashMapFletter(monitor, true, hattVirusTraader, ikkeHattVirusTraader));
            hashmapfletter.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            hattVirusTraader--;
        }

        while (ikkeHattVirusTraader > 0) { // oppretter traader til filer fra personer som ikke har hatt viruset
            Thread hashmapfletter = new Thread(new HashMapFletter(monitor, false, hattVirusTraader, ikkeHattVirusTraader));
            hashmapfletter.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            ikkeHattVirusTraader--;
        }

        System.out.println("FERDIG MED DATAINNSAMLING |" + " Ant hattVirusTraader: " + hattVirusTraader + " Ant ikkeHattVirusTraader: " + ikkeHattVirusTraader);
    }

    private static void statistiskTest(Monitor monitor) {
        int diff = 0;
        int antallDominante = 0;
        HashMap<String, SubSekvens> hattVirus = monitor.hentHashbeholder(true).get(0);  
        HashMap<String, SubSekvens> ikkeHattVirus = monitor.hentHashbeholder(false).get(0);

        for (String key : hattVirus.keySet()) {
        if (ikkeHattVirus.containsKey(key)) {
                int a = (hattVirus.get(key).hentForekomst());
                int b = (ikkeHattVirus.get(key).hentForekomst());
                diff = a - b;
                
                if (diff >= 5) {
                    System.out.println("FANT DOMINANT SUBSEKVENS " + hattVirus.get(key) + " Forekomst for person 1: " + a + " Forekomst for person 2: " + b + " Differanse: " + diff);
                    antallDominante++;
                }
                diff = 0;
            }
        }
        System.out.println("Antall dominante subsekvenser funnet totalt: " + antallDominante);
        System.exit(1);
    }
}