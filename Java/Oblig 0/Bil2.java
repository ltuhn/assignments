public class Bil2 {
    private String bilNr; // instansvariabel som settes som privat. variabeltypen er String
    public Bil2(String bilNr){ // tar imot bilNr som parameter, som er en String
        this.bilNr = bilNr;
    }
    public void printBilNr() {
        System.out.println("Bilnummeret er: " + bilNr); // skriver ut bilnummeret, bruker variabelen bilNr
    }
}