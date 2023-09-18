public class Spesialist implements Godkjenningsfritak {
    private String kontrollID;
    
    public Spesialist(String navn, String kontrollID) {
        this.kontrollID = kontrollID;
    }
    
    public String hentKontrollID() {
        return kontrollID;
    }

    public String toString() {
        return "SPESIALIST | Navn: " + hentKontrollID();
    }
}
