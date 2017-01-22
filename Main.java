import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Board board = new Board();
		Heuristic func = new Heuristic();
		Scanner keyboard = new Scanner(System.in);
		int count = 0;
		while (true) {
			Thread.sleep(50);
			System.out.print("\r " + count + "/250");
			if (count < 250) {
				count++;
			} else {
				System.out.println();
				break;
			}
		}
	}
}
