import java.util.*;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		Generate gen = new Generate();
		Scanner input = new Scanner(System.in);
		Board board;
		Boolean done = false;
		Astar alg = new Astar();

		System.out.println("Run tests? (y, n)");
		String dec = input.nextLine();
		if (dec.toLowerCase().equals("y")) {
			Test test = new Test();
		} else {
			do {
				System.out.println("Enter your own puzzle or randomly generate one? (own, gen)");
				dec = input.nextLine();
				if (dec.toLowerCase().equals("own")) {
					board = getUserInput();
				} else {
					do {
						board = gen.genBoard();
					} while (!gen.validateBoard(board));

					System.out.println(board.getFirst());
					System.out.println(board.getSecond());
					System.out.println(board.getThird());
				}

				System.out.println("Manhatten Distance Heuristic");
				long startTime = System.nanoTime();
				int manhattanNodes = alg.astarManhattan(board);
				long endTime = System.nanoTime();
				System.out.println("Nodes generated: " + manhattanNodes);
				System.out.println("Time taken: " + (endTime - startTime) / 1000000 + "ms");
				displaySol(alg.getGoal());
				System.out.println("Misplaced Tile Heuristic");
				startTime = System.nanoTime();
				int misplacedNodes = alg.astarMisplaced(board);
				endTime = System.nanoTime();
				System.out.println("Nodes generated: " + misplacedNodes);
				System.out.println("Time taken: " + (endTime - startTime) / 1000000 + "ms");
				displaySol(alg.getGoal());
				System.out.println("Done? (y, n)");
				dec = input.nextLine();
				if (dec.toLowerCase().equals("y")) done = true;
			} while (!done);
		}
	}

	private static Board getUserInput() {
		Generate gen = new Generate();
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the 3 lines of the board, no spaces");
		String userInput = "";
		userInput += input.nextLine();
		userInput += input.nextLine();
		userInput += input.nextLine();
		Board board = new Board(userInput);

		while (!gen.validateBoard(board)) {
			System.out.println("Board not valid: Please enter the 3 lines of the board, no spaces");
			userInput = input.nextLine();
			userInput += input.nextLine();
			userInput += input.nextLine();
			board = new Board(userInput);
		}
		return board;
	}

	private static void displaySol(Board board) {
		if (board.getParent() != null) {
			displaySol(board.getParent());
		}
		System.out.println("----");
		System.out.println(board.getFirst());
		System.out.println(board.getSecond());
		System.out.println(board.getThird());
	}
}
