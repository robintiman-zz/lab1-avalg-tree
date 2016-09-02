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
		for (int i : knuth) {
			count++;
			tree.checkTriangle(i);
			if (tree.getCount() >= N)
				break;
		}
		System.out.println(count);
	}

	private static void process3() {
		
	}

}
