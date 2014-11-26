public class Konto {
	private int guthaben;

	public Konto(int guthaben) {
		this.guthaben = guthaben;
	}

	public void einzahlen(int betrag) {
		guthaben += betrag;
	}

	public void auszahlen(int betrag) throws Exception {
		if (guthaben > betrag) {
			guthaben -= betrag;
		} else {
			throw new Exception("ungültige Auszahlung");
		}

	}

	public int getGuthaben() {
		return guthaben;
	}
}