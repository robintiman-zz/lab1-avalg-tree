package processes;

import java.util.Random;

import datacalculations.BinaryTree;

public class R1 {

	public static int r1(int height) {
		int N = (int) (Math.pow(2, height) - 1.0);
		BinaryTree tree = new BinaryTree(N);
		Random rand = new Random();
		int count = 0;
		while (tree.getCount() < N) {
			count++;
			tree.checkTriangle(rand.nextInt(N) + 1);
		}
		return count;
	}

}
