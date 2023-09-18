public class Bil3 {
    private String bilNr;
    public Bil3(String bilNr) { 
        this.bilNr = bilNr;
    }
    public void printBilNr() {
        System.out.println("Bilnummeret er: " + bilNr);
    }
    public String hentNummer() {
        return bilNr;
    }
}
