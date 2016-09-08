package datacalculations;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import processes.R1;
import processes.R2;
import processes.R3;

public class Main {
	private static final int HEIGHT = 20;
	private static final int ITERATIONS = 10;

	public static void main(String[] args) {

		int process1Results[][] = new int[HEIGHT][ITERATIONS];
		int process2Results[][] = new int[HEIGHT][ITERATIONS];
		int process3Results[][] = new int[HEIGHT][ITERATIONS];

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < ITERATIONS; j++) {
				process1Results[i][j] = R1.r1(i + 1);
				process2Results[i][j] = R2.r2(i + 1);
				process3Results[i][j] = R3.r3(i + 1);
			}
		}

		double[] r1Mean = mean(process1Results);
		double[] r2Mean = mean(process2Results);
		double[] r3Mean = mean(process3Results);
		double[] r1Std = std(process1Results, r1Mean);
		double[] r2Std = std(process2Results, r2Mean);
		double[] r3Std = std(process3Results, r3Mean);

		// Print to file
		try {
			PrintWriter pw = new PrintWriter("lab1-avalg.txt");
			// Process 1
			pw.println("Process 1:");
			for (int i = 0; i < HEIGHT; i++) {
				int N = (int) (Math.pow(2, i + 1) - 1.0);
				pw.println("Mean value for N = " + N + " is " + r1Mean[i]
						+ " +- " + r1Std[i]);
			}

			// Process 2
			pw.println("\nProcess 2:");
			for (int i = 0; i < HEIGHT; i++) {
				int N = (int) (Math.pow(2, i + 1) - 1.0);
				pw.println("Mean value for N = " + N + " is " + r2Mean[i]
						+ " +- " + r2Std[i]);
			}

			// Process 2
			pw.println("\nProcess 3:");
			for (int i = 0; i < HEIGHT; i++) {
				int N = (int) (Math.pow(2, i + 1) - 1.0);
				pw.println("Mean value for N = " + N + " is " + r3Mean[i]
						+ " +- " + r3Std[i]);
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Calculate the mean value of a given data set
	 * 
	 * @param results
	 *            - the data set
	 * @return a double array with the mean values
	 */
	private static double[] mean(int[][] results) {
		double[] mean = new double[HEIGHT];
		for (int i = 0; i < HEIGHT; i++) {
			double sum = 0;
			for (int j = 0; j < ITERATIONS; j++) {
				sum += results[i][j];
			}
			mean[i] = sum / (double) ITERATIONS;
		}
		return mean;
	}

	/**
	 * Calculate the standard deviation of a given data set
	 * 
	 * @param results
	 *            - the data set
	 * @return a double array with the standard deviation values
	 */
	private static double[] std(int[][] results, double[] mean) {
		double[] std = new double[HEIGHT];
		for (int i = 0; i < HEIGHT; i++) {
			double sum = 0;
			for (int j = 0; j < ITERATIONS; j++) {
				double dev = (double) results[i][j] - mean[i];
				sum += dev * dev;
			}
			std[i] = Math.sqrt(sum / (double) ITERATIONS);
		}
		return std;
	}
}
