import java.util.*;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		Generate gen = new Generate();
		Scanner input = new Scanner(System.in);
		Board board;

		do {
			board = gen.genBoard();
		} while (!gen.validateBoard(board));

		// String userInput = input.nextLine();
		// board = new Board(userInput);
		// if (gen.validateBoard(board)) System.out.println("valid");

		System.out.println(board.getFirst());
		System.out.println(board.getSecond());
		System.out.println(board.getThird());
		Astar alg = new Astar();
		int manhattanNodes = alg.astarManhattan(board);
		System.out.println(manhattanNodes);
		int misplacedNodes = alg.astarMisplaced(board);
		System.out.println(misplacedNodes);
	}
}
