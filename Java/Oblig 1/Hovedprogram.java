import java.io.FileNotFoundException;

public class Hovedprogram {
    public static void main(String[] args) {
        Dataklynge abel;
        try {
            abel = new Dataklynge("dataklynge.txt"); // oppretter objektet abel under klassen Dataklynge, sender inn filnavnet
        } catch(FileNotFoundException e) { // om programmet catcher feilen FileNotFoundException, kjor koden nedenfor
            System.out.println("Fant ikke fil " + e);
            return;
        }

        System.out.println("Noder med minst 32 GB: " + abel.noderMedNokMinne(32)); // abel kaller paa metoden noderMedNokMinne og sender inn tallet 32 for aa finne ut antall noder med minst 32gb
        System.out.println("Noder med minst 64 GB: " + abel.noderMedNokMinne(64));
        System.out.println("Antall prosessorer: " + abel.antProsessorer());
        System.out.println("Antall racks: " + abel.antRacks()); // abel kaller paa metoden antRacks for aa telle gjennom antall racks det er i dataklyngen
    }
}
