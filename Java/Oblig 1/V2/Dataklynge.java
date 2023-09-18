import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Dataklynge {
    private int mxNoder; // deklarerer variabler, private saa den ikke "finnes" utenfor klassen og int for integer
    private ArrayList<Rack> racks;
.
        lesInn(filnavn); 
    }

        private void lesInn(String filnavn) throws FileNotFoundException { // hvis feilen FileNotFoundException oppstaar, saa "thrower" programmet feilen. Catches i hovedprogram

            File fil = new File(filnavn); // lager objekt av klassen Fil

            Scanner lesInn = new Scanner(fil); // lager objekt av klassen Scanner for aa kunne scanne linjene

            String l = lesInn.nextLine(); // leser inn forste linje i filen

            mxNoder = Integer.parseInt(l); // gjor String l om fra String til typen int

            Rack nyRack = new Rack(mxNoder); // oppretter ny rack
            racks.add(nyRack); // legger til racken i ArrayListen racks
            
            while(lesInn.hasNextLine()) { // saa lenge det fins en ny linje i filen, kjor koden nedenfor
                String[] data = lesInn.nextLine().split(" "); // Splitter for hvert mellomrom i linja

                int antNoder = Integer.parseInt(data[0]); // Integer.parseInt gjor forste ord (som er av typen String) om til int
                int minStr = Integer.parseInt(data[1]); 
                int prosAnt = Integer.parseInt(data[2]);

                for (int i = 0; i < antNoder; i++) { // saa lenge "i" er mindre enn antNoder, kjor koden nedenfor
                    if (prosAnt == 1 | prosAnt == 2) { // hvis antall prosessorer er 1 eller 2, kjor koden nedenfor
                        Node n = new Node(minStr, prosAnt); // oppretter objekt av klasse Node, sender inn argumentene minStr og prosAnt
                        nodeTilRack(n); // legger til objektet "n" i et ledig rack vha. metoden nodeTilRack
                    } else { // hvis antall prosessorer ikke er 1 eller 2, kjoer koden nedenfor
                        System.out.println("En node kan kun ha en eller to prosessorer");
                    }
                }
            }
            lesInn.close(); // lukker Scanner-objektet
            }

        public int antProsessorer() { 
            int ant = 0; // deklarerer variabelen ant
            for (Rack r : racks) { // for antall Rack-objekter "r" i ArrayListen racks, kjor koden nedenfor
                ant += r.getAntPros(); // ok "ant" med antall prosessorer Rack-objektet har
            }
            return ant; // returnerer verdien til ant
            }
        
        public int noderMedNokMinne(int paakrevdMinne) {
            int nokMinne = 0;
            for (Rack r : racks) {
                nokMinne += r.nMedNokMinne(paakrevdMinne); // ok "nokMinne" med antall minne Rack-objektet har
            }
            return nokMinne;
}

    public void nodeTilRack(Node node) {
        for (int i = 0; i < racks.size(); i++) { // saa lenge i er mindre enn lengden av racks, kjor koden nedenfor
            if (racks.size() - 1 == i && racks.get(i).erMaks()) { // hvis racken er full, kjor koden nedenfor
                nyRackTilNode(node); // kaller paa metoden nyRackTilNode for aa legge noden til i en ny og tom rack
                return;
            }
            else if (!racks.get(i).erMaks()) { // hvis racken ikke er full, kjor koden nedenfor
                racks.get(i).leggTilNode(node); // racks kaller paa metoden leggTilNode som legger node-objektet til i racken
                return;
            }
            // om full går den videre til neste
        }
    }

    public void nyRackTilNode(Node node) { // lager ny rack og legger en node til i det tomme racket
        Rack rack = new Rack(mxNoder); // oppretter objektet rack under klassen Rack, sender inn mxNoder (maks Noder racket kan ha)
        rack.leggTilNode(node); // legger node til i racket
        racks.add(rack); // legger racket til i ArrayListen racks
    }

    public int antRacks() {
        return racks.size(); // returnerer lengden av racks
    }
}

