
public class Node {
	private boolean marked = false;
	private Node leftChild, rightChild, parent, sibling;
	
	public boolean isMarked() {
		return marked;
	}
	
	public void mark() {
		marked = true;
	}
	
	public void setLeftChild(Node n) {
		leftChild = n;
	}
	
	public void setRightChild(Node n) {
		rightChild = n;
	}
	
	public void setParent(Node n) {
		parent = n;
	}
	
	public void setSibling(Node n) {
		sibling = n;
	}
	
	public void checkTriangle() {
		if (leftChild.isMarked() && rightChild.isMarked()) {
			mark();
		} 
		if (parent.isMarked() && sibling.isMarked()) {
			mark();
		}
	}
}
