public class Node {
    private int minStr, pAnt; // deklarerer private variabler (fins ikke utenfor klassen Node)
    public Node(int minneStr, int prosAnt) { // konstruktor som har minnestorrelse og antall prosessorer til noden som parametere
        minStr = minneStr;
        pAnt = prosAnt;
    }

    public int getAntPros() {
        return pAnt; // returnerer antall prosessorer
    }

    public int getMinne() {
        return minStr; // returnerer minne
    }
}
