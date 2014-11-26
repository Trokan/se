import static org.junit.Assert.*;
import org.junit.*;


public class BoardTest {
	Board board;
	@Before
	public void initialize(){
		board = new Board();
	}
	@Test
	public void emptyBoard(){
		assertFalse(board.hasWinner());
	}
	//	gültige Markierung setzen – kein Gewinner
	@Test
	public void setMarkerNoWinner(){
		board.setMark("X", 0, 1);
		assertFalse(board.hasWinner());
	}
	//	gültige Markierungen setzen – mit Gewinner
	@Test
	public void setMarkerWithWinner(){
		board.setMark("X", 0, 0);
		board.setMark("X", 1, 1);
		board.setMark("X", 2, 2);
		assertTrue(board.hasWinner());
	}
	//	ungültige Markierung setzen
	@Test (expected = InvalidPositionException.class)
	public void invalidPosition() {
		board.setMark("X", 3, 0);
	}

}
