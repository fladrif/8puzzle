import java.util.*;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		Generate gen = new Generate();
		Board board;

		do {
			board = gen.genBoard();
		} while (!gen.validateBoard(board));

		System.out.println(board.getFirst());
		System.out.println(board.getSecond());
		System.out.println(board.getThird());
		Astar alg = new Astar(board);
	}

	// public static void main(String[] args) throws InterruptedException {
	// 	Board board = new Board();
	// 	Heuristic func = new Heuristic();
  //   Random rand = new Random();
  //   char[] maxBoard = null;
  //   int maxH1 = 0;
  //   int maxH2 = 0;
	// 	int count = 0;
	// 	while (true) {
	// 		Thread.sleep(10);
  //     System.out.print("\033[H\033[2J");
  //     System.out.println(board.getFirst());
  //     System.out.println(board.getSecond());
  //     System.out.println(board.getThird());
  //     int h1 = func.misplacedTile(board);
  //     int h2 = func.manhattanDist(board);
  //     System.out.println("h1: " + h1);
  //     System.out.println("h2: " + h2);
  //     if (h1 >= maxH1 && h2 >= maxH2) {
  //       maxH1 = h1;
  //       maxH2 = h2;
  //       maxBoard = board.getAll().toCharArray();
  //     }
  //     System.out.println("h1: " + maxH1 + " h2: " + maxH2 +  " " + Arrays.toString(maxBoard));

  //     int move = rand.nextInt(4);
  //     if (move == 0) {
  //       board.shiftUp();
  //     } else if (move == 1) {
  //       board.shiftLeft();
  //     } else if (move == 2) {
  //       board.shiftRight();
  //     } else {
  //       board.shiftDown();
  //     }
	// 	}
	// }
}
