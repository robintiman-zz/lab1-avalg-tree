public class BinaryTree {
	private int N, count;
	private boolean[] nodes;

	public BinaryTree(int N) {
		count = 0;
		this.N = N;
		nodes = new boolean[N + 1];
	}

	public void mark(int n) {
		nodes[n] = true;
	}

	public void checkTriangle(int n) {
		if (!nodes[n]) {
			count++;
			nodes[n] = true;
		}
		int[] children = calcChildren(n);
		int leftChild = children[0];
		int rightChild = children[1];
		int sibling = calcSibling(n);
		int parent = calcParent(n);

		if (n != 1) {
			// Check upper triangle
			if (nodes[sibling] && !nodes[parent]) {
				checkTriangle(parent);
			} else if (nodes[parent] && !nodes[sibling]) {
				checkTriangle(sibling);
			}
		}

		try {
			// Check lower triangle
			if (nodes[leftChild] && !nodes[rightChild]) {
				checkTriangle(rightChild);
			} else if (nodes[rightChild] && !nodes[leftChild]) {
				checkTriangle(leftChild);
			}
		} catch (Exception e) {
		}
		
		if (count >= N) {
			for (int i = 1; i < nodes.length; i++) {
				System.out.println(i + " = " + nodes[i]);
			}
			return;
		}

	}
	
	public int getCount() {
		return count;
	}

	private int calcSibling(int n) {
		if (n % 2 > 0) {
			return n - 1;
		} else {
			return n + 1;
		}
	}

	private int calcParent(int n) {
		return n / 2;
	}

	private int[] calcChildren(int n) {
		int[] children = new int[2];
		children[0] = n * 2;
		children[1] = n * 2 + 1;
		return children;
	}

}