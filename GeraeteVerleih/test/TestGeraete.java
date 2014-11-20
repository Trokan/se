import static org.junit.Assert.*;
import org.junit.*;


public class TestGeraete {
	GeraeteListe geraeteListe = new GeraeteListe();
	Geraet geraet1 = new Geraet("Nexus 7");
	Geraet geraet2 = new Geraet("Kinect");
	Geraet geraet3 = new Geraet("iPad Air");
	
	@Before
	public void initialisieren(){
		geraeteListe.hinzufuegen(geraet1);
	}
	@Test 
	public void testHinzufuegen(){
		geraeteListe.hinzufuegen(geraet2);
		geraeteListe.hinzufuegen(geraet3);
		assertEquals(3, geraeteListe.getAnzahlGeraete());
	}
	@Test 
	public void testEntfernen(){
		geraeteListe.entfernen(geraet1);
		assertEquals(0, geraeteListe.getAnzahlGeraete());
	}
	@Test (expected = NoSuchGeraetException.class)
	public void testEntfernenNoSuchGeraet(){
		geraeteListe.entfernen(geraet2);
	}
	
}
