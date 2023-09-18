public abstract class Resept {
    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected int pasientId, reit, pris, rId;
    
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit, int rId) {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        this.rId = rId;
        pris = legemiddel.hentPris();
    }

    public int hentID() {
        return rId;
    }

    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }

    public Lege hentLege() {
        return utskrivendeLege;
    }

    public int hentPasientId() {
        return pasientId;
    }

    public int hentReit() {
        return reit;
    }

    // false hvis resepten er oppbrukt
    public boolean bruk() {
        if (reit == 0) {
            return false;
        }
        reit -= 1;
        return true;
    }

    abstract public String farge(); // returnerer reseptens farge (hvit eller blaa)
    abstract public double prisAaBetale(); // returnerer prisen pasient maa betale

}
