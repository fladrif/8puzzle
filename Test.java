import java.io.*;
import java.util.*;

public class Test {
	int TEST_CASES = 100;

	public Test() {
		Random rand = new Random();
		TestStructure[][] manSet = new TestStructure[21][TEST_CASES];
		TestStructure[][] misSet = new TestStructure[21][TEST_CASES];
		int[] yPos = new int[21];
		int xPos = 0;
		Generate gen = new Generate();
		Astar alg = new Astar();
		File file = new File("sample.txt");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			while ((text = reader.readLine()) != null) {
				if (text.contains("Depth")) {
					String[] depthString = text.split(" ");
					xPos = Integer.parseInt(depthString[1]);
					yPos[xPos] = 0;
				} else if (yPos[xPos] < TEST_CASES) {
					long start = System.nanoTime();
					int nodes = alg.astarManhattan(new Board(text));
					long end = System.nanoTime();
					// long time = (end - start) / 1000000;
					long time = (end - start);
					manSet[xPos][yPos[xPos]] = new TestStructure(nodes, time);
					start = System.nanoTime();
					nodes = alg.astarMisplaced(new Board(text));
					end = System.nanoTime();
					// time = (end - start) / 1000000;
					time = (end - start);
					misSet[xPos][yPos[xPos]] = new TestStructure(nodes, time);
					yPos[xPos]++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Manhattan Dist Heuristic");
		System.out.println("----------------------------------");
		calculate(manSet);
		System.out.println("Misplaced Tile Heuristic");
		System.out.println("----------------------------------");
		calculate(misSet);
	}

	private void calculate(TestStructure[][] results) {
		for (int i = 0; i < results.length; i++) {
			int nodes = 0;
			int time = 0;
			for (int j = 0; j < results[i].length; j++) {
				if (results[i][j] != null) {
					nodes += results[i][j].getNodesExplored();
					time += results[i][j].getTimeTaken();
				} else {
					break;
				}
			}
			if (nodes != 0) {
				nodes = nodes / TEST_CASES;
				time = time / TEST_CASES;
				System.out.println("Depth: " + i);
				System.out.println("Avg nodes explored: " + nodes);
				System.out.println("Avg ms taken: " + time);
			}
		}
	}
}

class TestStructure {
	private int nodesExplored;
	private long timeTaken;

	public TestStructure(int nod, long tim) {
		nodesExplored = nod;
		timeTaken = tim;
	}

	public int getNodesExplored() {
		return nodesExplored;
	}

	public int getTimeTaken() {
		return (int) timeTaken/ 1000000;
	}
}
