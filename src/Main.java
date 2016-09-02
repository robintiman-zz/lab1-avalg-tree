import java.util.Random;

public class Main {
	private static int height = 4;
	private static int N = (int) (Math.pow(2, height) - 1.0);

	public static void main(String[] args) {
		process1();
		process2();
		process3();
	}

	private static void process1() {
		BinaryTree tree = new BinaryTree(N);
		Random rand = new Random();
		int count = 0;
		while (tree.getCount() < N) {
			count++;
			tree.checkTriangle(rand.nextInt(N) + 1);
		}
		for (int i = 1; i < tree.getNodes().length; i++) {
			System.out.println(i + " = " + tree.getNodes()[i]);
		}
		System.out.println(count);
	}

	private static void process2() {
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
		for (int i = 1; i < tree.getNodes().length; i++) {
			System.out.println(i + " = " + tree.getNodes()[i]);
		}
		System.out.println(count);
	}

	private static void process3() {
		int[] knuth = new int[N];
		BinaryTree tree = new BinaryTree(N);
		int count = 0;
		for (int i = 1; i <= N; i++) {
			knuth[i - 1] = i;
		}
		Knuth.shuffle(knuth);
		for (int node : knuth) {
			count++;
			boolean[] nodes = tree.getNodes();
			if(!nodes[node]){
				tree.checkTriangle(node);
			}
			if (tree.getCount() >= N)
				break;
		}
		for (int i = 1; i < tree.getNodes().length; i++) {
			System.out.println(i + " = " + tree.getNodes()[i]);
		}
		System.out.println(count);
	}

}
