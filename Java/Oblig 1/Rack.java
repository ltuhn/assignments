import java.util.ArrayList;

public class Rack {
    private List<Node> noder = new ArrayList<>(); // deklarerer variabler
    private int maxN, antP;

    public Rack(int maksNoder) { // konstruktor som tar imot maks noder til racket
        maxN = maksNoder;
    }

    public void leggTilNode(Node node) {
        noder.add(node); // legger til en node i ArrayListen noder
    }

    public boolean erMaks() { // returnerer boolean verdi
        if (noder.size() >= maxN) { // hvis lengden til noder er storre eller er lik maxN (fins i konstruktor), returner True
            return true; 
        }
        else {
            return false;
        }
    }

    public int getAntPros() {
        int ant = 0; // integer-variabel med verdi 0
        for (Node n : noder) { // for antall Node-objekter i ArrayListen noder, kjor koden nedenfor
            antP = n.getAntPros(); // Node-objekt kaller paa metoden getAntPros for aa finne ut antall prosessorer noden har
            ant += antP; // ok "ant" med antall prosessorer noden har
        }
        return ant; // returnerer "ant"
    }

    public int nMedNokMinne(int paakrevdMinne) { 
        int nokMinne = 0;
        for (Node n : noder) { 
            if (n.getMinne() >= paakrevdMinne) { // for hver gang et node-objekt i ArrayListen "noder" har mer eller har like mye minne som paakrevde minnet i parameteret, ok nokMinne med 1
                nokMinne += 1;
            }
        }
        return nokMinne;
    }
}
