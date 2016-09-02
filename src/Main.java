import java.util.Random;


public class Main {

	public static void main(String[] args) {
		int height = 4;
		int N = (int) (Math.pow(2, height) - 1.0);
		BinaryTree tree = new BinaryTree(N);
		Random rand = new Random();
		int count = 0;
		while (tree.getCount() < N) {
			count++;
			tree.checkTriangle(rand.nextInt(N) + 1);
		}
		System.out.println(count);
	}

}
