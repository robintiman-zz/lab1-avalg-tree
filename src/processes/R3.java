package processes;

import datacalculations.BinaryTree;
import datacalculations.Knuth;

public class R3 {
	
	public static int r3(int height) {
		int N = (int) (Math.pow(2, height) - 1.0);
		int[] knuth = new int[N];
		BinaryTree tree = new BinaryTree(N);
		int count = 0;
		for (int i = 1; i <= N; i++) {
			knuth[i - 1] = i;
		}
		Knuth.shuffle(knuth);
		for (int node : knuth) {
			boolean[] nodes = tree.getNodes();
			if (!nodes[node]) {
				tree.checkTriangle(node);
			} else {
				continue;
			}
			if (tree.getCount() >= N) break;
			count++;
		}
		return count;
	}
}
