import java.util.*;

public class Generate {
	public Board genBoard() {
		Random rand = new Random();
		String board = "";
		while(board.length() < 9) {
			String num = Integer.toString(rand.nextInt(9));
			if (!board.contains(num)) {
				board += num;
			}
		}
		return new Board(board);
	}

	public boolean validateBoard(Board board) {
		int count = 0;
		char[] boardArray = board.getAll().toCharArray();
		int[] boardToInt = new int[9];
		for (int i = 0; i < boardArray.length; i++) {
			boardToInt[i] = Character.getNumericValue(boardArray[i]);
		}
		for (int i = 0; i < boardToInt.length; i++) {
			for (int j = i + 1; j < boardToInt.length; j++) {
				if (boardToInt[j] != 0) {
					if (boardToInt[i] > boardToInt[j]) count++;
				}
			}
		}
		if (count % 2 == 0) return true;
		else return false;
	}
}
