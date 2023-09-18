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
    public ArrayList<ArrayList<Tuppel>> fullRoute = new ArrayList<ArrayList<Tuppel>>();
    private Rute[][] labyrint;
    private boolean unntak1, unntak2, unntak3, unntak4, unntak5, unntak6, unntak7, unntak8 = false;

    public Labyrint(File fil) throws FileNotFoundException {
        this.fil = fil;
        labyrint = opprettLabyrint(fil);
        finnNaboer(labyrint, rader, kolonner);
    }

    public ArrayList<Tuppel> getRouteArrayList() {
        ArrayList<Tuppel> vei = new ArrayList<Tuppel>();
        return vei;
    }

    public int getRows() {
        return rader;
    }

    public int getColumns() {
        return kolonner;
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

                // unntak:
                if (i == 0 && j == 0) {
                    midtRute.oNabo = labyrint[i][j+1];
                    midtRute.sNabo = labyrint[i+1][j];
                } else if (i == 0 && j < kolonner - 1) {
                    midtRute.vNabo = labyrint[i][j-1];
                    midtRute.oNabo = labyrint[i][j+1];
                    midtRute.sNabo = labyrint[i+1][j];
                } else if (i == 0 && j == kolonner - 1) {
                    midtRute.vNabo = labyrint[i][j-1];   
                    midtRute.sNabo = labyrint[i+1][j]; 
                } else if (j == 0 && i > 0 && i < rader - 1) {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.oNabo = labyrint[i][j+1];
                    midtRute.sNabo = labyrint[i+1][j];
                } else if (i == rader - 1 && j == 0) {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.oNabo = labyrint[i][j+1];
                } else if (i > 0 && i < rader - 1 && j == kolonner - 1) {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.vNabo = labyrint[i][j-1];  
                    midtRute.sNabo = labyrint[i+1][j]; 
                } else if (i == rader - 1 && j == kolonner - 1) {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.vNabo = labyrint[i][j-1]; 
                } else if (i == rader - 1 && j > 0 && j < kolonner - 1) {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.vNabo = labyrint[i][j-1]; 
                    midtRute.oNabo = labyrint[i][j+1];
                // alt som ikke er unntak:
                } else if (i > 0 && j > 0) {
                    midtRute.nNabo = labyrint[i-1][j];
                    midtRute.vNabo = labyrint[i][j-1]; 
                    midtRute.oNabo = labyrint[i][j+1]; 
                    midtRute.sNabo = labyrint[i+1][j]; 
                }
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
        System.out.println("Totale utganger: ");
        for (ArrayList<Tuppel> koordinater : utveierListe) {
            System.out.println(koordinater);
        }
        return utveierListe;
    }

    public void findExit(int kol, int rad) throws FileNotFoundException {
        labyrint[rad][kol].finnUtvei();
    }

}