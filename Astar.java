import java.util.*;

public class Astar {
	private Hashtable<String, Integer> misplacedExistSet = new Hashtable<String, Integer>();
	private Hashtable<String, Integer> manhattanExistSet = new Hashtable<String, Integer>();
	private MisplacedHeuristic misplacedAlg = new MisplacedHeuristic();
	private ManhattanHeuristic manhattanAlg = new ManhattanHeuristic();
	private PriorityQueue<Board> misplacedFrontier = new PriorityQueue<Board>(20, misplacedAlg);
	private PriorityQueue<Board> manhattanFrontier = new PriorityQueue<Board>(20, manhattanAlg);
	private String goal = "012345678";
	public Astar(Board board) throws InterruptedException{
		Board intState;
		manhattanExistSet.put(board.getAll(), 1);
		board.putCost(0);
		manhattanFrontier.add(board);
		while ((manhattanFrontier.size() > 0) && (!manhattanFrontier.peek().getAll().equals(goal))) {
			Thread.sleep(1000);
			intState = manhattanFrontier.peek();
			System.out.println("Cost: " + intState.getCost());
			System.out.println("Heuristic: " + manhattanAlg.manhattanDist(intState));
			System.out.println(intState.getFirst());
			System.out.println(intState.getSecond());
			System.out.println(intState.getThird());
			processChildren(manhattanFrontier.poll());
		}
		Board goalState = manhattanFrontier.poll();
		System.out.println("End Cost: " + goalState.getCost());
		System.out.println(goalState.getFirst());
		System.out.println(goalState.getSecond());
		System.out.println(goalState.getThird());
	}

	private void processChildren(Board board) {
		int cost = board.getCost();
		Board testLeft = testMove(board, "left");
		Board testRight = testMove(board, "right");
		Board testUp = testMove(board, "up");
		Board testDown = testMove(board, "down");
		if (testLeft != null) {
			if (manhattanExistSet.get(testLeft.getAll()) == null) {
				manhattanExistSet.put(testLeft.getAll(), 1);
				testLeft.putCost(cost + 1);
				manhattanFrontier.add(testLeft);
			}
		}
		if (testRight != null) {
			if (manhattanExistSet.get(testRight.getAll()) == null) {
				manhattanExistSet.put(testRight.getAll(), 1);
				testRight.putCost(cost + 1);
				manhattanFrontier.add(testRight);
			}
		}
		if (testUp != null) {
			if (manhattanExistSet.get(testUp.getAll()) == null) {
				manhattanExistSet.put(testUp.getAll(), 1);
				testUp.putCost(cost + 1);
				manhattanFrontier.add(testUp);
			}
		}
		if (testDown != null) {
			if (manhattanExistSet.get(testDown.getAll()) == null) {
				manhattanExistSet.put(testDown.getAll(), 1);
				testDown.putCost(cost + 1);
				manhattanFrontier.add(testDown);
			}
		}
	}

	private Board testMove(Board board, String direction) {
		Board tempBoard = new Board(board.getAll());
		if (direction.equals("left")) {
			if (tempBoard.shiftLeft()) {
				return tempBoard;
			} else {
				return null;
			}
		} else if (direction.equals("right")) {
			if (tempBoard.shiftRight()) {
				return tempBoard;
			} else {
				return null;
			}
		} else if (direction.equals("up")) {
			if (tempBoard.shiftUp()) {
				return tempBoard;
			} else {
				return null;
			}
		} else if (direction.equals("down")) {
			if (tempBoard.shiftDown()) {
				return tempBoard;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
