
public class Main {

	public static void main(String[] args) {
		int height = 1;
		BinaryTree tree = new BinaryTree(height);
		int nbrOfNodes = (int) (Math.pow(2, height) - 1.0);
		for (int i = 0; i < nbrOfNodes; i++) {
			tree.add(new Node());
		}
	}

}
