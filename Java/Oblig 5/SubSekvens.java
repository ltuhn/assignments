public class SubSekvens {
    private String sekvens;
	private int forekomst = 1;

	public SubSekvens(String sekvens) {
        this.sekvens = sekvens;
    }

	public void okForekomst() {
        forekomst++;
    }

	public String hentNokkel() {
        return sekvens;
    }

	public int hentForekomst() {
        return forekomst;
    }
	public void okForekomst(int antall) {
        forekomst = forekomst + antall;
    }

    @Override
    public String toString() {
        return "Forekomst " + hentForekomst();
    }
}