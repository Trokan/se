import java.util.ArrayList;


public class GeraeteListe {
	private ArrayList<Geraet> geraeteListe;
	private int id;
	public GeraeteListe(){
		geraeteListe = new ArrayList<Geraet>();
		id = 1;
	}
	public void hinzufuegen(Geraet geraet){
		geraeteListe.add(geraet);
		geraet.setId(id++);
	}
	public void entfernen(Geraet geraet) {
		geraeteListe.remove(geraet);
	}
	public Geraet finden(int id){
		for(Geraet geraet: geraeteListe){
			if (geraet.getId() == id){
				return geraet;
			}
		}
		throw new InvalidGeraetIdException("ungültige Geräte-ID: " + id);
	}
	public int getAnzahlGeraete() {
		return geraeteListe.size();
	}
}
