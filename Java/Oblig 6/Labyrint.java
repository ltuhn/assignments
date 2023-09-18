import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Labyrint {
    private File fil;
    public int rader, kolonner;
    private int rad = 0;
    private int kolonne = 0;
    public ArrayList<ArrayList<Tuppel>> utveierListe = new ArrayList<ArrayList<Tuppel>>();
    private Rute[][] labyrint;

    public Labyrint(File fil) throws FileNotFoundException {
        this.fil = fil;
        labyrint = opprettLabyrint(fil);
        finnNaboer(labyrint, rader, kolonner);
    }

    public ArrayList<Tuppel> hentVeiListe() {
        ArrayList<Tuppel> vei = new ArrayList<Tuppel>();
        return vei;
    }

    public Rute[][] getLabyrinth() {
        return labyrint;
    }

    // Hvit rute = true. Sort rute = false
    public boolean setColor(int i, int j) {
        if (labyrint[i][j].charTilTegn().equalsIgnoreCase(".")) return true;
        return false;
    }

    public Rute[][] opprettLabyrint(File fil) throws FileNotFoundException {
        Scanner scanner = new Scanner(fil);
        Rute ruteTilLabyrint = null;

        String forsteLinje = scanner.nextLine();
        String[] raderKolonner = forsteLinje.split(" ");
        rader = Integer.parseInt(raderKolonner[0]);
        kolonner = Integer.parseInt(raderKolonner[1]);
        Rute[][] labyrint = new Rute[rader][kolonner];

        while(scanner.hasNextLine()) {
            String nesteLinje = scanner.nextLine();
            String[] sortHvitRute = nesteLinje.split("");

            for (int i = 0; i < sortHvitRute.length; i++) {
                if(sortHvitRute[i].equalsIgnoreCase("#")) {
                    SortRute svart = new SortRute(this, rad, kolonne);
                    ruteTilLabyrint = svart;
                } else {
                    HvitRute hvit = new HvitRute(this, rad, kolonne);
                    ruteTilLabyrint = hvit;
                }
                labyrint[rad][kolonne] = ruteTilLabyrint;
                if (kolonne == kolonner-1) {
                    kolonne = 0;
                    rad++;
                } else {
                    kolonne++;
                }
            }
        }
        scanner.close();
        return labyrint;
    }

    public void finnNaboer(Rute[][] labyrint, int rader, int kolonner) {
        Rute nNabo, vNabo, oNabo, sNabo = null;
        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                Rute midtRute = labyrint[i][j];

                if (i == 0 && j == 0) {
                    midtRute.oNabo = labyrint[i][j+1];
                    midtRute.sNabo = labyrint[i+1][j];
                } else if (i == 0 && j < kolonner) {
                    midtRute.vNabo = labyrint[i][j-1];
                    midtRute.oNabo = labyrint[i][j+1];
                    midtRute.sNabo = labyrint[i+1][j];
                } else if (i == 0 && j == kolonner) {
                    midtRute.vNabo = labyrint[i][j-1];   
                    midtRute.sNabo = labyrint[i+1][j]; 
                } else if (j == 0 && i > 0 && i < rader) {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.oNabo = labyrint[i][j+1];
                    midtRute.sNabo = labyrint[i+1][j];
                } else if (i == rader && j == 0) {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.oNabo = labyrint[i][j+1];
                } else if (i > 0 && i < rader && j == kolonner) {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.vNabo = labyrint[i][j-1];  
                    midtRute.sNabo = labyrint[i+1][j]; 
                } else if (i == rader && j == kolonner) {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.vNabo = labyrint[i][j-1]; 
                } else if (i == rader && j > 0 && j < kolonner) {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.vNabo = labyrint[i][j-1]; 
                    midtRute.oNabo = labyrint[i][j+1];
                // alt som ikke er unntak:
                } else {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.vNabo = labyrint[i][j-1]; 
                    midtRute.oNabo = labyrint[i][j+1]; 
                    midtRute.sNabo = labyrint[i+1][j]; 
                }
                
            //     try {
            //         if (labyrint[i-1][j] != null) { // hvis det fins et objekt i ruta over, faar denne ruta en nabo i nord
            //             nNabo = labyrint[i-1][j];
            //             midtRute.nNabo = nNabo;
            //         }
            //     } catch (ArrayIndexOutOfBoundsException e) { // Hvis vi gaar ut av arrayets indeks betyr det at det ikke er mulig for midtRute aa ha en nabo her
            //     }

            //     try {
            //         if (labyrint[i][j-1] != null) {
            //             vNabo = labyrint[i][j-1];
            //             midtRute.vNabo = vNabo;
            //         }
            //     } catch (ArrayIndexOutOfBoundsException e) {
            //     }

            //     try {
            //         if (labyrint[i][j+1] != null) {
            //             oNabo = labyrint[i][j+1];
            //             midtRute.oNabo = oNabo;
            //         }
            //     } catch (ArrayIndexOutOfBoundsException e) {
            //     }

            //     try {
            //         if(labyrint[i+1][j] != null) {
            //             sNabo = labyrint[i+1][j];
            //             midtRute.sNabo = sNabo;
            //         }
            //     } catch (ArrayIndexOutOfBoundsException e) {
            //     }
            }
        }
    }

    public void skrivUt(Rute[][] labyrint) {
        String labyrintKolonne = "";
        System.out.println("\nSkriver ut labyrint");
        for (int i = 0; i < labyrint.length; i++) {
            for (int j = 0; j <= labyrint.length - 1; j++) {
                labyrintKolonne+= labyrint[i][j].charTilTegn();
            }
            System.out.println(labyrintKolonne);
            labyrintKolonne = "";
        }
    }

    public ArrayList<ArrayList<Tuppel>> finnUtveiFra(int kol, int rad) throws FileNotFoundException {
        labyrint[rad][kol].finnUtvei();
        System.out.println("    Totale utganger: ");
        for (ArrayList<Tuppel> koordinater : utveierListe) {
            System.out.println(koordinater);
        }
        return utveierListe;
    }

}