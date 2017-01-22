public class Board {
	private Node blank;
	public Node topLeft = new Node();
	public Node topMid = new Node();
	public Node topRight = new Node();
	public Node midLeft = new Node();
	public Node midMid = new Node();
	public Node midRight = new Node();
	public Node botLeft = new Node();
	public Node botMid = new Node();
	public Node botRight = new Node();

	public Board() {
		topLeft.initialize(0, null, null, topMid, midLeft);
		topMid.initialize(1, null, topLeft, topRight, midMid);
		topRight.initialize(2, null, topMid, null, midRight);
		midLeft.initialize(3, topLeft, null, midMid, botLeft);
		midMid.initialize(4, topMid, midLeft, midRight, botMid);
		midRight.initialize(5, topRight, midMid, null, botRight);
		botLeft.initialize(6, midLeft, null, botMid, null);
		botMid.initialize(7, midMid, botLeft, botRight, null);
		botRight.initialize(8, midRight, botMid, null, null);
		blank = topLeft;
	}

	public String getFirst() {
		return topLeft.getValue() + topMid.getValue() + topRight.getValue();
	}

	public String getSecond() {
		return midLeft.getValue() + midMid.getValue() + midRight.getValue();
	}

	public String getThird() {
		return botLeft.getValue() + botMid.getValue() + botRight.getValue();
	}

	public String getAll() {
		return getFirst() + getSecond() + getThird();
	}

	public boolean shiftLeft() {
		if (blank.getLeft() != null) {
			blank.swap(blank.getLeft().swap(blank.getValue()));
			blank = blank.getLeft();
			return true;
		} else {
			return false;
		}
	}

	public boolean shiftRight() {
		if (blank.getRight() != null) {
			blank.swap(blank.getRight().swap(blank.getValue()));
			blank = blank.getRight();
			return true;
		} else {
			return false;
		}
	}

	public boolean shiftUp() {
		if (blank.getTop() != null) {
			blank.swap(blank.getTop().swap(blank.getValue()));
			blank = blank.getTop();
			return true;
		} else {
			return false;
		}
	}

	public boolean shiftDown() {
		if (blank.getBot() != null) {
			blank.swap(blank.getBot().swap(blank.getValue()));
			blank = blank.getBot();
			return true;
		} else {
			return false;
		}
	}
}
