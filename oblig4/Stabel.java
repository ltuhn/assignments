public class Stabel<T> extends Lenkeliste<T> {

    public void leggPaa(T x) {
        Node temp = forste;
        Node n = new Node(x);

        if (forste == null) {
            forste = n;
        } else {
            for (int i = 0; i < stoerrelse(); i++) {
                if (i == stoerrelse() - 1) {
                    temp.neste = n;
                    return;
                }
                temp = temp.neste;
            }
        }  

    }

    public T taAv() { // fjerne element fra slutten av liste
        if (forste == null) {
            throw new UgyldigListeIndeks(0);
        }
        
        Node temp = forste; 

        if (forste.neste == null) {
            forste = null;
            return temp.data;
        }

        for (int i = 0; i < stoerrelse(); i++) {
            if (i == stoerrelse() - 2) {
                Node taAv = temp.neste;
                temp.neste = null;
                return taAv.data;
            }
            temp = temp.neste;
        }
        return null;
    }
}