public class SortertLenkeliste <T extends Comparable<T>> extends Lenkeliste<T> {
    @Override
    public void leggTil(T x) {
        Node temp = forste;

        for (int i = 0; i < stoerrelse(); i++) {
            if (i != 0) {
                temp = temp.neste;
            }

            if (temp.data.compareTo(x) > 0) { // hvis noden vi er paa har stoerre dataverdi enn dataverdien x fra parameteren...
                super.leggTil(i, x); // ... legg til i lista
                return;
            }
        }

        super.leggTil(x); // superklasse sin metode
    }


    public void leggTil(int pos, T x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sett(int pos, T x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern() {
        return fjern(stoerrelse() - 1);
    }
}