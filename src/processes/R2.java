package processes;

import datacalculations.BinaryTree;
import datacalculations.Knuth;

public class R2 {

	public static int r2(int height) {
		int N = (int) (Math.pow(2, height) - 1.0);
		int[] knuth = new int[N];
		BinaryTree tree = new BinaryTree(N);
		int count = 0;
		for (int i = 1; i <= N; i++) {
			knuth[i - 1] = i;
		}
		Knuth.shuffle(knuth);
		for (int node : knuth) {
			count++;
			tree.checkTriangle(node);
			if (tree.getCount() >= N)
				break;
		}
		return count;
	}

}
