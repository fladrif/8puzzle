public class Heuristic {
	public int misplacedTiles(Board board) {
		int count = 0;
		String[] boardState = new String[9];
		boardState[0] = board.topLeft.getValue();
		boardState[1] = board.topMid.getValue();
		boardState[2] = board.topRight.getValue();
		boardState[3] = board.midLeft.getValue();
		boardState[4] = board.midMid.getValue();
		boardState[5] = board.midRight.getValue();
		boardState[6] = board.botLeft.getValue();
		boardState[7] = board.botMid.getValue();
		boardState[8] = board.botRight.getValue();
		for (int i = 1; i < boardState.length; i++) {
			if (!boardState[i].equals(Integer.toString(i))) count++;
		}
		return count;
	}

	public int manhattanDist(Board board) {
		int count = 0;
		return count;
	}
}
