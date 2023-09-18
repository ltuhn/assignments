import java.util.Iterator;

public class Lenkeliste<T> implements Liste<T> {
    protected int teller, storrelse;
    protected Node forste;

    protected class Node { // Indre klasse
        Node neste = null;
        T data;

        public Node (T data) {
            this.data = data;
        }
    }

    protected class LenkelisteIterator implements Iterator<T> {
        protected Node current; 
        protected Lenkeliste<T> lenkeliste;

        public LenkelisteIterator(Lenkeliste<T> lenkeliste) {
            this.lenkeliste = lenkeliste;
            current = lenkeliste.forste;
        }
        public boolean hasNext() { //returnerer true om listen har et neste element
            return current != null;
        }
        public T next() { //returnerer data fra element og oppdaterer pekeren
            if (hasNext()) {
                T data = current.data;
                current = current.neste;
                return data;
            }
            return null;
        }
    }

    public Iterator<T> iterator() { //metode fra Iterable interface
        return new LenkelisteIterator(this);
    }


    public String toString() {
        Node temp = forste;
        String stringTemp = "";
        while (temp != null) {
            stringTemp += temp.data + " => " + "\n";
            temp = temp.neste;
        }
        return stringTemp;
    }

    public void settInnForst(T data) {
        Node n = new Node(data);
        n.neste = forste;
        forste = n;
    }
    
    @Override
    public int stoerrelse() {
        teller = 0;
        Node temp = forste;
        
        while (temp != null) {
            teller++;
            temp = temp.neste;
        }
        return teller;
    }

    @Override
    public void leggTil(int pos, T x) {
        if (pos == 0) {
            Node n = new Node(x);
            n.neste = forste;
            forste = n;
            return;
        }

        if (pos > stoerrelse() || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }

        teller = 1;
        Node temp = forste;
    
        while (temp != null) {
            if (teller == pos) {
                Node n = new Node(x);
                n.neste = temp.neste;
                temp.neste = n;
                return;
            }
            temp = temp.neste;
            teller++;
        }
    }

    @Override
    public void leggTil(T x) { // sette inn element paa slutten av listen.
        Node temp = forste;
        Node n = new Node(x);

        if (forste == null) {
            forste = n;
        } else {
            for (int i = 0; i <= stoerrelse(); i++) {
                if (i == stoerrelse() - 1) {
                    temp.neste = n;
                    return;
                }
                temp = temp.neste;
            }
        }  
    }

    @Override
    public void sett(int pos, T x) { // sette inn elementet paa angitt posisjon + overskrive det som var der fra for av
        if (forste == null) {
            throw new UgyldigListeIndeks(pos);
        }
        
        if (pos == 0) {
            Node n = new Node(x);
            n.neste = forste.neste;
            forste = n;
            return;
        }

        if (pos > stoerrelse() - 1 || pos < 0) {
            throw new UgyldigListeIndeks(pos);
        }

        teller = 1;
        Node temp = forste;

        while (temp != null) {
            if (teller == pos) {
                Node n = new Node(x);
                if (temp.neste != null) {
                    n.neste = temp.neste.neste;
                }
                temp.neste = n;
                return;
            }
            temp = temp.neste;
            teller++;
        }
    }

    @Override
    public T hent(int pos) { // hente ut elem paa oppgitt indeks
        if (pos > stoerrelse() - 1 || pos < 0 || forste == null) { // sjekker "umulige" tilfeller
            throw new UgyldigListeIndeks(pos);
        }

        Node temp = forste;
        
        for (int i = 0; i < pos; i++) {
            if (i == pos) {
                return temp.data;
            }
            temp = temp.neste;
        }
        return temp.data;

    }

    @Override
    public T fjern(int pos) { // fjerne element paa gitt indeks i listen. etterfolgende elems faar en lavere posisjon
        if (pos > stoerrelse() - 1 || pos < 0 || forste == null) {
            throw new UgyldigListeIndeks(pos);
        }

        if (pos == 0) {
            Node fjern = forste;
            forste = forste.neste;
            return fjern.data;
        }

        teller = 1;
        Node temp = forste;
        while (temp.neste != null) {
            if (teller == pos) {
                Node fjern = temp.neste;
                temp.neste = temp.neste.neste;
                return fjern.data;
            }
            temp = temp.neste;
            teller++;
        }
        return null;
    }

    @Override
    public T fjern() { // fjerne og returnere elementet paa starten av listen
        if (forste == null) {
            throw new UgyldigListeIndeks(0);
        }

        Node fjern = forste;
        forste = forste.neste;
        return fjern.data;
    }

}