public class Astar {
	private Hashtable<String, int> table = new Hashtable<String, int>();
	private Heuristic algo = new Heuristic();
	public Astar(Board board) {
		table.put(board.getAll(), 0);
	}
}
