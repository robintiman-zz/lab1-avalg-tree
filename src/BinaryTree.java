
public class BinaryTree {
	private int height;
	private Node[] nodes;
	
	public BinaryTree(int height) {
		this.height = height;
		int nbrOfNodes = (int) (Math.pow(2, height) - 1.0);
		nodes = new Node[nbrOfNodes];
	}
	
	public void add(Node n) {
		
	}
	
	public void mark(int name) {
		nodes[name].mark();
	}
	
}