import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Random;

public class Main {
	private static int height = 4;
	private static int maxHeight = 20;
	private static int maxIterations = 10;

	public static void main(String[] args) {
		process1(height);
		process2(height);
		process3(height);

		int process1Results[][] = new int[maxHeight][maxIterations];
		int process2Results[][] = new int[maxHeight][maxIterations];
		int process3Results[][] = new int[maxHeight][maxIterations];

		for (int i = 0; i < maxHeight; i++) {
			for (int j = 0; j < maxIterations; j++) {
				process1Results[i][j] = process1(i + 1);
				process2Results[i][j] = process2(i + 1);
				process3Results[i][j] = process3(i + 1);
			}
		}

		double[] process1Mean = mean(process1Results);
		double[] process2Mean = mean(process2Results);
		double[] process3Mean = mean(process3Results);

	}

	private static double[] mean(int[][] results) {
		double[] mean = new double[maxHeight];
		for (int i = 0; i < maxHeight; i++) {
			double sum = 0;
			for (int j = 0; j < maxIterations; j++) {
				sum += results[i][j];
			}
			double d = sum / (double) maxIterations;
			BigDecimal bd = new BigDecimal(d);
			bd = bd.round(new MathContext(1));
			double rounded = bd.doubleValue();
			mean[i] = rounded;
		}
		return mean;
	}

	private static double[] deviation(int[][] results) {
		double powerSum1 = 0;
		double powerSum2 = 0;
		double stdev = 0;
		for (int i = 0; i < maxHeight; i++) {
			for (int j = 0; j < maxIterations; j++) {
				powerSum1 += total[i];
				powerSum2 += Math.pow(total[i], 2);
				stdev = Math.sqrt(i * powerSum2 - Math.pow(powerSum1, 2)) / i;
				System.out.println(total[i]); // You specified that you needed
												// to print each value of the
												// array
			}
		}
		System.out.println(stdev);
	}

	private static int process1(int height) {
		int N = (int) (Math.pow(2, height) - 1.0);
		BinaryTree tree = new BinaryTree(N);
		Random rand = new Random();
		int count = 0;
		while (tree.getCount() < N) {
			count++;
			tree.checkTriangle(rand.nextInt(N) + 1);
		}
		// for (int i = 1; i < tree.getNodes().length; i++) {
		// System.out.println(i + " = " + tree.getNodes()[i]);
		// }
		System.out.println("Process 1 finished in iterations: " + count);
		return count;
	}

	private static int process2(int height) {
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
		// for (int i = 1; i < tree.getNodes().length; i++) {
		// System.out.println(i + " = " + tree.getNodes()[i]);
		// }
		System.out.println("Process 2 finished in iterations: " + count);
		return count;
	}

	private static int process3(int height) {
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
			boolean[] nodes = tree.getNodes();
			if (!nodes[node]) {
				tree.checkTriangle(node);
			}
			if (tree.getCount() >= N)
				break;
		}
		// for (int i = 1; i < tree.getNodes().length; i++) {
		// System.out.println(i + " = " + tree.getNodes()[i]);
		// }
		System.out.println("Process 3 finished in iterations: " + count);
		return count;
	}

}
