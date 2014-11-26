import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.*;

public class KontoTest {
	Konto konto;
	
	@Before
	public void startGuthabenEinzahlen(){
		konto = new Konto(10);
	}
	
	@Test
	public void guthabenNachAnlegenDesKontos(){
		assertEquals(10, konto.getGuthaben());
	}
	@Test
	public void auszahlen() throws Exception{
		konto.auszahlen(5);
		assertEquals(5, konto.getGuthaben());
	}
	@Test
	public void mehrmaligeEinzahlungUndAuszahlung() throws Exception{
		konto.einzahlen(20);
		konto.einzahlen(50);
		konto.auszahlen(30);
		konto.auszahlen(50);
		assertEquals(0, konto.getGuthaben());
	}
}
