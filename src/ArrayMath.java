/**
 * Some linear algebra methods, for testing.
 * 
 * @author Dechabhol Kotheeranurak
 *
 */
public class ArrayMath {

	/**
	 * Compute dot product of two vectors.
	 * If vectors don't have the same length use the shortest one.
	 * 
	 * @param x first vector to multiply
	 * @param y second vector to multiply
	 * @return dot-product of x and y
	 */
	public static double dotProduct(double[] x, double[] y) {
		int size = x.length;
		// find the smallest array length
		if (x.length > y.length) size = y.length;
		
		double product = 0.0;
		for (int k = 0; k < size; k++) {
			product += x[k]*y[k];
		}
		return product;
	}
	
	
	
}


