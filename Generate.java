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
		System.out.println(board);
		return new Board(board);
	}

	public boolean validateBoard(Board board) {
		int count = 0;
		count += numOfSwap(board.getFirst());
		count += numOfSwap(board.getSecond());
		count += numOfSwap(board.getThird());
		if (count % 2 == 0) return true;
		else return false;
	}

	public int numOfSwap(String line) {
		char[] array = line.toCharArray();
		int[] numarray = new int[3];
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			numarray[i] = Character.getNumericValue(array[i]);
		}
		if (numarray[0] > numarray[1]) count++;
		if (numarray[0] > numarray[2]) count++;
		if (numarray[1] > numarray[2]) count++;
		return count;
	}
}
