public class Node {
	private String value;
	private Node top, left, right, bot;

	public void initialize(int val, Node top, Node left, Node right, Node bot) {
		this.value = Integer.toString(val);
		this.top = top;
		this.left = left;
		this.right = right;
		this.bot = bot;
	}

	public String swap(String value){
		String hold = this.value;
		this.value = value;
		return hold;
	}

	public String getValue() {
		return this.value;
	}

	public Node getTop() {
		return this.top;
	}

	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.right;
	}

	public Node getBot() {
		return this.bot;
	}
}
