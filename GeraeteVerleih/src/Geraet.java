
public class Geraet {
	private String bezeichnung;
	int id;
	public Geraet(String bezeichnung) {
		super();
		this.bezeichnung = bezeichnung;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
}
