public class Pasient {
    private static int teller = 1; 
    private int id; 
    private String navn, fodselsnr;
    private Stabel<Resept> utskrevneResepter = new Stabel<Resept>(); //oppretter ny Stabel med Resept-objekter

    public Pasient(String navn, String fodselsnr) {
        this.navn = navn;
        this.fodselsnr = fodselsnr;

        id = teller; //unik ID for hver pasient
        teller++;
    }
    public String hentFnr() {
        return fodselsnr;
    }
    public int hentListeStoerrelse() {
        return utskrevneResepter.stoerrelse();
    }
    public Stabel<Resept> hentReseptListe() {
        return utskrevneResepter;
    }
    public String hentNavn() {
        return navn;
    }
    public int hentId(){
        return id;
    }
    public void leggTilResept(Resept resept) {
        utskrevneResepter.leggPaa(resept); //bruker metode fra Stabel for å legge til en resept for pasienten
    }
    @Override
    public String toString() {
        return "pasient ID " + id + ", navn: " + navn;
    }
}