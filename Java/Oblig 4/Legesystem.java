import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.io.IOException;
import java.io.FileWriter;

public class Legesystem {
    static Lenkeliste<Pasient> pasienter = new Lenkeliste<Pasient>(); //liste for hver objekt av klassen Pasient
    static Lenkeliste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();
    static Lenkeliste<Lege> leger = new SortertLenkeliste<Lege>();
    static Lenkeliste<Resept> resepter = new Lenkeliste<Resept>();

    public static void main(String[] args) { //kommandoløkke for brukeren (E2)
        
        try {
            lesFraFil("storFil.txt");
        } catch (FileNotFoundException e) { //hvis programmet ikke finner filen
            System.out.println(e);
        }

        System.out.println("Velkommen. Hva onsker du aa gjore?\n"); //kommandoløkke
        System.out.println("a - Skriv ut oversikt\nb - Legg til pasient / lege / legemiddel / resept\nc - Registrer bruk av resept\nd - Vis statistikk\ne - Lagre oppbevart informasjon i en fil\n");
        System.out.println("Tast q for aa avslutte programmet.");
        String fortsett = "";
        Scanner brukerInp = new Scanner(System.in); //scanner for brukerinput
        fortsett = brukerInp.nextLine(); 

        while (!fortsett.equalsIgnoreCase("q")) {

            if (fortsett.equalsIgnoreCase("a")) {
                System.out.println("Henter informasjon...\n");
                skrivUt();
            }
            else if (fortsett.equalsIgnoreCase("b")) {
                try {
                    leggTilKategori();
                } catch (UlovligUtskrift e) {
                    System.out.println(e);
                }
            }
            else if (fortsett.equalsIgnoreCase("c")) {
                velgPasient();
            }
            else if (fortsett.equalsIgnoreCase("d")) {
                hentStatistikk();
            }
            else if (fortsett.equalsIgnoreCase("e")) {
                try {
                    skrivTilFil();
                }catch (IOException e){
                    System.out.println(e); }
            }
            else {
                System.out.println("Ugyldig input.");
            }
            System.out.println("\na - Skriv ut oversikt\nb - Legg til pasient / lege / legemiddel / resept\nc - Registrer bruk av resept\nd - Vis statistikk\ne - Lagre oppbevart informasjon i en fil\n");
            System.out.println("Tast q for aa avslutte programmet.");
        fortsett = brukerInp.nextLine();
        }
        brukerInp.close();
        System.out.println("Avslutter program.");
    }

    static void lesFraFil(String filnavn) throws FileNotFoundException, NumberFormatException { //les fra fil (E1)
        try {
            File fil = new File(filnavn);
            Scanner sc = new Scanner(fil);
            String kategori = "";

            while (sc.hasNextLine()) { //så lenge filen har en til linje
                String nesteLinje = sc.nextLine();
                String[] biter1 = nesteLinje.split(" "); //deler opp linjen der det er mellomrom
                String[] biter2 = nesteLinje.split(","); //deler opp på komma

                if (biter1[0].equals("#")) { //hver gang filen finner en setning som begynner på #, endres kategori variabelen
                    kategori = biter1[1];
                }

                if (kategori.equalsIgnoreCase("Pasienter")) {                    
                    String navn = biter2[0];
                    String fnr = biter2[1];
                    if (navn.indexOf("#") != -1) { //hvis # finnes i setningen
                        ; //legger ikke til
                    } else {
                        Pasient nyPasient = new Pasient(navn, fnr); //lager nytt pasient objekt & lagrer i liste
                    pasienter.leggTil(nyPasient);
                    }
                }
                if (kategori.equalsIgnoreCase("Leger")) {
                    String navn = biter2[0];
                    String kontrollID = biter2[1].strip();
                    if (navn.indexOf("#") != -1) {
                        ; 
                    } else {
                        if (! kontrollID.equals("0")) { //hvis det er spesialist
                            Spesialist nySpes = new Spesialist(navn, kontrollID);
                            leger.leggTil(nySpes);
                        } else {
                            Lege nyLege = new Lege(navn);
                            leger.leggTil(nyLege);
                        }
                    } 
                }
                if (kategori.equalsIgnoreCase("Legemidler")) {
                    try {
                        String navn = biter2[0];
                        String type = biter2[1];
                        double pris = Double.parseDouble(biter2[2]);
                        int avrundetPris = (int) Math.round(pris);
                        double vStoff = Double.parseDouble(biter2[3]);

                        if (navn.indexOf("#") != -1) {
                            ;
                        } else {
                            if (type.equalsIgnoreCase("narkotisk")) { //sjekker type og implementerer riktig klasse i forhold
                                int styrke = Integer.parseInt(biter2[4]);
                                Legemiddel nyttLegemiddel = new Narkotisk(navn, avrundetPris, vStoff, styrke);
                                legemidler.leggTil(nyttLegemiddel);
                            }
                            else if (type.equalsIgnoreCase("vanedannende")) {
                                int styrke = Integer.parseInt(biter2[4]);
                                Legemiddel nyttLegemiddel = new Vanedannende(navn, avrundetPris, vStoff, styrke); 
                                legemidler.leggTil(nyttLegemiddel);
                            }
                            else if (type.equalsIgnoreCase("vanlig")) {
                                Legemiddel nyttLegemiddel = new Vanlig(navn, avrundetPris, vStoff);
                                legemidler.leggTil(nyttLegemiddel);
                            }
                        }
                    } catch (NumberFormatException e) {
                        ; // ignorerer feil tallformat
                    }
                }
                if (kategori.equalsIgnoreCase("Resepter")) {
                    try {
                        if (biter2[0].indexOf("#") != -1) {
                            ;
                        }
                        else {
                            int legemiddelNr = Integer.parseInt(biter2[0]);
                            String legeNavn = biter2[1];
                            int pasientId = Integer.parseInt(biter2[2]);
                            String legemiddelType = biter2[3];

                            Legemiddel riktigLegemiddel = null;
                            Pasient riktigPasient = null;

                            for (Legemiddel legemiddel : legemidler) {
                                if (legemiddel.hentId() == legemiddelNr) {
                                    riktigLegemiddel = legemiddel; //finner fram til bestemt objekt i listen vha ID-en
                                }
                            }
                            for (Pasient pasient : pasienter) {
                                if (pasient.hentId() == pasientId) {
                                    riktigPasient = pasient;                
                                }
                            }

                            for (Lege lege : leger) {
                                if (lege.hentNavn().equalsIgnoreCase(legeNavn)) {
                                    
                                    if (legemiddelType.equalsIgnoreCase("p")) { //sjekker hvilken type resept
                                        try {
                                            if (riktigLegemiddel != null && riktigPasient != null) {
                                                Resept nyResept = lege.skrivPResept(riktigLegemiddel, riktigPasient);
                                                riktigPasient.leggTilResept(nyResept);
                                                resepter.leggTil(nyResept);
                                            }
                                        } catch (UlovligUtskrift e) {
                                            System.out.println(e);
                                        }
                                    }
                                    else if (legemiddelType.equalsIgnoreCase("blaa")) {
                                        try {
                                            if (riktigLegemiddel != null && riktigPasient != null) {
                                                int reit = Integer.parseInt(biter2[4]);
                                                Resept nyResept = lege.skrivBlaaResept(riktigLegemiddel, riktigPasient, reit);
                                                riktigPasient.leggTilResept(nyResept);
                                                resepter.leggTil(nyResept);
                                            }
                                        } catch (UlovligUtskrift e) {
                                            System.out.println(e);
                                        }
                                    }
                                    else if (legemiddelType.equalsIgnoreCase("millitaer")) {
                                        try {
                                            if (riktigLegemiddel != null && riktigPasient != null) {
                                                int reit = Integer.parseInt(biter2[4]);
                                                Resept nyResept = lege.skrivMilitaerresept(riktigLegemiddel, riktigPasient, reit);
                                                riktigPasient.leggTilResept(nyResept);
                                                resepter.leggTil(nyResept);
                                            }                                           
                                        } catch (UlovligUtskrift e) {
                                            System.out.println(e);
                                        }
                                    }
                                    else if (legemiddelType.equalsIgnoreCase("hvit")) {
                                        try {
                                            if (riktigLegemiddel != null && riktigPasient != null) {
                                                int reit = Integer.parseInt(biter2[4]);
                                                Resept nyResept = lege.skrivHvitResept(riktigLegemiddel, riktigPasient, reit);
                                                riktigPasient.leggTilResept(nyResept);
                                                resepter.leggTil(nyResept);
                                            }
                                        } catch (UlovligUtskrift e) {
                                            System.out.println(e);
                                        }
                                    }
                                }
                            }
                        }      
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }   
            }
                        
        }
        sc.close(); //lukk scanner
        } catch (FileNotFoundException e) { //hvis programmet ikke finner filen
            System.out.println(e);
        }
    }
    public static void skrivUt() { //(E3)
        for (Lege lege : leger) {
            if (lege.hentReseptListe().stoerrelse() == 0) {
                System.out.println(lege + "\nLegen har ikke skrevet ut noen resepter.\n");
            } else {
                System.out.println(lege + "\nLegens utskrevne resepter: " + lege.hentReseptListeString());
            }
        }
        System.out.println(pasienter);
        System.out.println(legemidler);
    }

    public static void leggTilKategori() throws NumberFormatException, UlovligUtskrift { //metode for å legge til objekt (E4)
        String kategori;
        Scanner inp = new Scanner(System.in);
        System.out.println("Hva vil du legge til? ");
        kategori = inp.nextLine();

        if (kategori.equalsIgnoreCase("pasient")) {
            System.out.println("Skriv inn navn til pasienten: ");
            String navn = inp.nextLine();
            System.out.println("Skriv inn fodselsnummeret til pasienten: ");
            String fnr = inp.nextLine(); 
            Pasient nyPasient = new Pasient(navn, fnr); 
            pasienter.leggTil(nyPasient); 
            System.out.println("Pasient er lagt til.\n");
        }
        else if (kategori.equalsIgnoreCase("lege")) {
            Lege nyLege;
            System.out.println("Skriv inn navn til legen: ");
            String navn = inp.nextLine();
            System.out.println("Er legen en spesialist?");
            String spesialist = inp.nextLine();

            if (spesialist.equalsIgnoreCase("ja")) {
                System.out.println("Skriv inn kontrollID: ");
                String kontrollID = inp.nextLine();
                nyLege = new Spesialist(navn, kontrollID); 
            } else {
                nyLege = new Lege(navn);
            }
            leger.leggTil(nyLege);
            System.out.println("Lege er lagt til.\n");
        }
        else if (kategori.equalsIgnoreCase("legemiddel")) {
            System.out.println("Hva slags legemiddel? (1 for narkotisk / 2 for vanedannende / 3 for vanlig)"); 
            int type = Integer.parseInt(inp.nextLine().strip());

            try {
                if (type == 1) {
                    System.out.println("Skriv inn navn, deretter pris, deretter mengden virkestoff.");
                    String navn = inp.nextLine();
                    int pris = Integer.parseInt(inp.nextLine());
                    double vStoff = Double.parseDouble(inp.nextLine());
                    System.out.println("Skriv inn narkotisk styrke: ");
                    int styrke = Integer.parseInt(inp.nextLine());
                    Narkotisk ny = new Narkotisk(navn, pris, vStoff, styrke);
                    legemidler.leggTil(ny);
                    System.out.println("Narkotisk legemiddel lagt til.\n"); 
                    return;
                } 
                else  if (type == 2) {
                    System.out.println("Skriv inn navn, deretter pris, deretter mengden virkestoff.");
                    String navn = inp.nextLine();
                    int pris = Integer.parseInt(inp.nextLine());
                    double vStoff = Double.parseDouble(inp.nextLine());
                    System.out.println("Skriv inn vanedannende styrke: ");
                    int styrke = Integer.parseInt(inp.nextLine());
                    Vanedannende ny = new Vanedannende(navn, pris, vStoff, styrke);
                    legemidler.leggTil(ny);
                    System.out.println("Vanedannende legemiddel lagt til.\n");
                    return;
                } 
                else if (type == 3) {
                    System.out.println("Skriv inn navn, deretter pris, deretter mengden virkestoff.");
                    String navn = inp.nextLine();
                    int pris = Integer.parseInt(inp.nextLine());
                    double vStoff = Double.parseDouble(inp.nextLine());
                    Vanlig ny = new Vanlig(navn, pris, vStoff);
                    legemidler.leggTil(ny);
                    System.out.println("Vanlig legemiddel lagt til.\n");
                    return;
                }   
                System.out.println("Vennligst skriv inn et gyldig tall: 1 (narkotisk) / 2 (vanedannende) / 3 (vanlig)"); //hvis ugyldig tall som input
                leggTilKategori();
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
        else if (kategori.equalsIgnoreCase("resept")) {
            int teller = 0;
            Lege valgtLege = null;
            Legemiddel valgtLegemiddel = null; 
            Pasient valgtPasient = null; 
            
            System.out.println("Hvilken lege er det som skal skrive ut resepten?");
            for (Lege l : leger) {
                System.out.println(teller + ": " + l);
                teller++;
            }
            int legeNr = Integer.parseInt(inp.nextLine());
            valgtLege = leger.hent(legeNr);
            teller = 0;

            System.out.println("Hvilket legemiddel er resepten for?");
            for (Legemiddel l : legemidler) {
                System.out.println(teller + ": " + l);
                teller++;
            }
            int legemiddelNr = Integer.parseInt(inp.nextLine());
            valgtLegemiddel = legemidler.hent(legemiddelNr);
            teller = 0;
    
            System.out.println("Hvilken pasient er resepten for?");
            for (Pasient p : pasienter) {
                System.out.println(teller + ": " + p);
                teller++;
            }
            int pasientNr = Integer.parseInt(inp.nextLine());
            valgtPasient = pasienter.hent(pasientNr);
            teller = 0;

            System.out.println("Hvilken type resept skal pasienten ha? 1 (blaa) / 2 (p) / 3 (militaer) / 4 (hvit)");
            int valgtResept = Integer.parseInt(inp.nextLine());            
            
            if (valgtLege != null && valgtLegemiddel != null && valgtPasient != null) {
                if (valgtResept == 1) {
                    System.out.println("Hvor mange reit skal resepten ha?");
                    int reit = Integer.parseInt(inp.nextLine());
                    try {
                        valgtLege.skrivBlaaResept(valgtLegemiddel, valgtPasient, reit);
                        System.out.println("Resept er lagt til.\n");
                        return;
                    } catch (UlovligUtskrift e) {
                        System.out.println(e);
                    }
                }

                if (valgtResept == 2) {
                    try {
                        valgtLege.skrivPResept(valgtLegemiddel, valgtPasient);
                        System.out.println("Resept er lagt til.\n");
                        return;
                    } catch (UlovligUtskrift e) {
                        System.out.println(e);
                    }
                }
                
                if (valgtResept == 3) {
                    System.out.println("Hvor mange reit skal resepten ha?");
                    int reit = Integer.parseInt(inp.nextLine());
                    try {
                        valgtLege.skrivMilitaerresept(valgtLegemiddel, valgtPasient, reit);
                        System.out.println("Resept er lagt til.\n");
                        return;
                    } catch (UlovligUtskrift e) {
                        System.out.println(e);
                    }
                }
                if (valgtResept == 4) {
                    System.out.println("Hvor mange reit skal resepten ha?");
                    int reit = Integer.parseInt(inp.nextLine());
                    try {
                        valgtLege.skrivHvitResept(valgtLegemiddel, valgtPasient, reit);
                        System.out.println("Resept er lagt til.\n");
                        return;
                    } catch (UlovligUtskrift e) {
                        System.out.println(e);
                        return;
                    }
                }
                System.out.println("Vennligst skriv inn et gyldig tall.");
            }
        }
    }

    public static void velgPasient() throws NumberFormatException, UgyldigListeIndeks {
        Scanner inp = new Scanner(System.in);
        System.out.println("Hvilken pasient vil du se resepter for? Skriv inn ID til pasienten.");

        for (Pasient p : pasienter) {
            System.out.println("ID: " + p.hentId() + ", " + p.hentNavn()); 
        }   
        String brukerInput = inp.nextLine();
        try {
            int valgtPasientID = Integer.parseInt(brukerInput.strip());
            for (Pasient p : pasienter) {
                if (valgtPasientID > pasienter.stoerrelse() || valgtPasientID < 0) {
                    throw new UgyldigListeIndeks(valgtPasientID);
                }
                else if (valgtPasientID == p.hentId()){
                    velgResept(valgtPasientID);
                }
            }
        } catch (NumberFormatException e) { // feilmelding hvis man skriver inn et ugyldig tall
            System.out.println(e);
        }
    }

    public static void velgResept(int valgtPasientID) throws NumberFormatException, UgyldigListeIndeks { //(E5)
        Scanner inp = new Scanner(System.in);
        for (Pasient p : pasienter) {
            if (valgtPasientID == p.hentId()) { // hvis ID fra input fins i pasientlisten
                if (p.hentListeStoerrelse() == 0) {
                    System.out.println("Pasienten har ingen resepter.");
                    return;
                } else {
                    System.out.println("Hvilken resept vil du bruke? Skriv inn ID til resepten.");

                    for (Resept r : p.hentReseptListe()) {
                        System.out.println("Resept ID: " + r.hentId() + ", for legemiddel " + r.hentLegemiddel().hentNavn() + ", antall bruk igjen: " + r.hentReit());
                    }                
                }
                
                try {
                    int valgtReseptID = Integer.parseInt(inp.nextLine().strip()); 
                    
                    for (Resept r : p.hentReseptListe()) {
                        if (valgtReseptID == r.hentId()) {
                            if (r.hentReit() != 0) {
                                r.bruk();
                                System.out.println("Resept brukt. Gjenvaerende reit: " + r.hentReit());
                                return;
                            } else {
                                System.out.println("Resepten er ikke lenger gyldig.");
                            }
                        } else {
                            throw new UgyldigListeIndeks(valgtReseptID);
                        }
                    }   
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            }
        }
    }
    public static void hentStatistikk() { //(E6)
        int antallVanedannende = 0; //tellere
        int antallNarkotiske = 0;

        for (Legemiddel l : legemidler) {
            if (l instanceof Narkotisk) {
                antallNarkotiske++;
            }
            else if (l instanceof Vanedannende) {
                antallVanedannende++;
            }
        }
        System.out.println("Totalt antall narkotiske legemidler: " + antallNarkotiske + "\nTotalt antall vanedannende legemidler: " + antallVanedannende);
        
        int narkotiskReseptPerLege = 0; //teller

        System.out.println("Leger som har skrevet ut resept paa narkotiske legemidler: ");
        for (Lege lege : leger) {
            for (Resept r : lege.hentReseptListe()) {
                if (r.hentLegemiddel() instanceof Narkotisk) {
                    narkotiskReseptPerLege++;
                }
            }
            if (narkotiskReseptPerLege != 0) {
                System.out.println(lege.hentNavn() + " har skrevet ut " + narkotiskReseptPerLege + " narkotiske resept(er).");
            }
            narkotiskReseptPerLege = 0;
        }
        
        int  narkotiskReseptPerPasient = 0;

        for (Pasient p : pasienter) {
            for (Resept r : p.hentReseptListe()) {
                if (r.hentLegemiddel() instanceof Narkotisk) {
                    narkotiskReseptPerPasient++;
                }
            }
            if (narkotiskReseptPerPasient != 0) {
                System.out.println("Antall gyldige narkotiske resepter for " + p.hentNavn() + ": " + narkotiskReseptPerPasient);
            }
            narkotiskReseptPerPasient = 0;
        }       
    }
    public static void skrivTilFil() throws IOException { //(E7)
        try {
            FileWriter filUtskriver = new FileWriter("UtskrevetLegesystem.txt");
            filUtskriver.write("# Pasienter (navn, fnr)\n");
            for (Pasient p : pasienter) {
                filUtskriver.write(p.hentNavn() + "," + p.hentFnr() + "\n");
            }
            
            filUtskriver.write("# Legemidler (navn,type,pris,virkestoff,[styrke])\n");
            for (Legemiddel l : legemidler) {
                String type = "";
                if (l instanceof Narkotisk) {
                    type = "narkotisk";
                    filUtskriver.write(l.hentNavn() + "," + type + "," + l.hentPris() + "," + l.hentVirkestoff() + "," + l.hentStyrke() + "\n");
                }
                else if (l instanceof Vanedannende) {
                    type = "vanedannende";
                    filUtskriver.write(l.hentNavn() + "," + type + "," + l.hentPris() + "," + l.hentVirkestoff() + "," + l.hentStyrke() + "\n");
                }
                else if (l instanceof Vanlig) {
                    type = "vanlig";
                    filUtskriver.write(l.hentNavn() + "," + type + "," + l.hentPris() + "," + l.hentVirkestoff() + "\n");
                }
            }

            filUtskriver.write("# Leger (navn,kontrollid / 0 hvis vanlig lege)\n");
            for (Lege l : leger) {
                filUtskriver.write(l.hentNavn() + "," + l.hentKontrollID() + "\n");
            }
            
            filUtskriver.write("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n");
            for (Resept r : resepter) {
                String type = "";
                if (r instanceof HvitResept) {
                    type = "hvit";
                    filUtskriver.write(r.hentLegemiddel().hentId() + "," + r.hentLege().hentNavn() + "," + r.hentPasientId().hentId() + "," + type + "," + r.hentReit() + "\n");
                }
                if (r instanceof PResept) {
                    type = "p";
                    filUtskriver.write(r.hentLegemiddel().hentId() + "," + r.hentLege().hentNavn() + "," + r.hentPasientId().hentId() + "," + type + "\n");     
                }
                if (r instanceof BlaaResept) {
                    type = "blaa";
                    filUtskriver.write(r.hentLegemiddel().hentId() + "," + r.hentLege().hentNavn() + "," + r.hentPasientId().hentId() + "," + type + "," + r.hentReit() + "\n");
                }
                if (r instanceof Militaerresept) {
                    type = "millitaer";
                    filUtskriver.write(r.hentLegemiddel().hentId() + "," + r.hentLege().hentNavn() + "," + r.hentPasientId().hentId() + "," + type + "," + r.hentReit() + "\n");
                }
            }
            System.out.println("Opprettet fil.");
            filUtskriver.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
