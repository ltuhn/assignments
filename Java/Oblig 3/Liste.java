interface Liste<T> {
    public int stoerrelse();
    public void leggTil(int pos, T x);
    public void leggTil(T x); // sette inn element paa slutten av listen
    public void sett(int pos, T x); // sette inn elementet paa angitt posisjon + overskrive det som var der fra for av
    public T hent(int pos); // hente ut elem paa oppgitt indeks
    public T fjern(int pos); // fjerne element paa gitt indeks i listen. etterfolgende elems faar en lavere posisjon
    public T fjern(); // fjerne og returnere elementet paa starten av listen
}
