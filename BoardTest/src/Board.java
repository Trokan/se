public class Board {
	private String[] marks;
	public Board(){
		marks = new String[9];

	}
	public void setMark(String mark, int x, int y) throws InvalidPositionException {
		if (x < 0 || x >= 3 || y < 0 || y > 3){
			throw new InvalidPositionException("invalid position (" + x + "," + y + ")");
		}
		int index = y * 3 + x;
		marks[index] = mark;
	}
	private boolean hasWinnerInRows(){
		boolean hasWinner = false;
		for (int i = 0; i < marks.length; i += 3){
			hasWinner = hasWinner || areEqualMarkersAt(i, i+1, i+2);
		}
		return hasWinner;
	}
	private boolean hasWinnerInCols(){
		boolean hasWinner = false;
		for(int i = 0; i < 3; i++){
			hasWinner = hasWinner || areEqualMarkersAt(i, i+3, i+6);
		}
		return hasWinner;
	}
	private boolean areEqualMarkersAt(int index1, int index2, int index3){
		if (marks[index1] == null){
			return false;
		}
		return marks[index1].equals(marks[index2]) 
				&& marks[index1].equals(marks[index3]);
	}
	private boolean hasWinnerInDiagonals(){
		return areEqualMarkersAt(0, 4, 8) || areEqualMarkersAt(2, 4, 6);
	}
	public boolean hasWinner(){
		return hasWinnerInRows() || hasWinnerInCols() || hasWinnerInDiagonals();
	}
}
