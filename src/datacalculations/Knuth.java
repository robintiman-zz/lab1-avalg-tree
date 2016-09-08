package datacalculations;
import java.util.Random;

public class Knuth {

	public static final Random gen = new Random();
	 
	public static void shuffle (int[] array) {
	    int n = array.length;
	    while (n > 1) {
	        int k = gen.nextInt(n--); //decrements after using the value
	        int temp = array[n];
	        array[n] = array[k];
	        array[k] = temp;
	    }
	}
}
