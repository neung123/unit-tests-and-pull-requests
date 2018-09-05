import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * Test methods in the ArrayMath class.
 */
public class ArrayMathTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;

	@Test
	public void testDotProductTinyVectors() {
		// vector of length one
		double[] x = {5.2};
		double[] y = {-7.5};
		double expected = x[0]*y[0];
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
		// vector of size 0?
		x = new double[] { };
		y = new double[] { };
		assertEquals( 0.0, ArrayMath.dotProduct(x, y), TOL);
	}
	
	@Test
	public void testDotProductThreeVectors() {
		// vectors with 3 axis
		double[] x = {-0.9, 8.5, 1.2};
		double[] y = {90.0, 5.2, 7.9};
		double[] z = {4.2, 0.36, 8.6};
		
		double[] sumOfTwoVectors = new double[x.length];
		double expected = 0;
		for (int i = 0; i < x.length; i++) {
			sumOfTwoVectors[i] = y[i] + z[i];
			expected += x[i] * sumOfTwoVectors[i];
		}
		
		assertEquals( expected, ArrayMath.dotProduct(x, y) + ArrayMath.dotProduct(x, z), TOL);
		
	}
		
	@Test
	public void testDotProductOfEachAxis() {
		// unit vectors
		double[] i = {1, 0, 0};
		double[] j = {0, 1, 0};
		double[] k = {0, 0, 1};
		
		assertEquals( 0, ArrayMath.dotProduct(i, j), TOL);
		assertEquals( 0, ArrayMath.dotProduct(i, k), TOL);
		assertEquals( 0, ArrayMath.dotProduct(j, k), TOL);
	}
	
	@Test
	public void testDotProductWithConstant() {
		double[] x = {1.0, 2.6};
		double[] y = {8.6, -8.7};
		Random rand = new Random();
		int c = rand.nextInt(100) + 1;
		
		double[] cX = {c*x[0], c*x[1]};
		double[] cY = {c*y[0], c*y[1]};
		
		//properties of dot product
		assertEquals( cX[0]*y[0] + cX[1]*y[1], ArrayMath.dotProduct(x, cY), TOL);
		assertEquals( x[0]*cY[0] + x[1]*cY[1], c*ArrayMath.dotProduct(x, y), TOL);
		assertEquals( c*(x[0]*y[0] + x[1]*y[1]), ArrayMath.dotProduct(cX, y), TOL);
	}
	
	
	@Test 
	public void testDotProductSameVectors() {
		double[] x = {8.0, -7.0, 9.0, -2.3};
		
		double sum = 0;
		for (int i = 0; i < x.length; i++) sum += (x[i]*x[i]);
		
		double expected = Math.pow(Math.sqrt(sum), 2);
		
		assertEquals( expected, ArrayMath.dotProduct(x, x), TOL);
	}

	@Test
	public void testDotProductHugeVectors() {
		int len = 1_000_000;
		double[] x = new double[len];
		double[] y = new double[len];
		Random rand = new Random();
		double product = 0.0;
		for(int k=0; k<len; k++) {
			// to avoid overflowing the product using floats for elements
			double xk = (double) rand.nextFloat();
			double yk = (double) rand.nextFloat();
			x[k] = xk;
			y[k] = yk;
			product += xk*yk;
		}
		assertEquals( product, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( product, ArrayMath.dotProduct(y, x), TOL);
	}

	
	@Test
	public void testDotProductLengthsNotSame() {
		double[] x = new double[] {1, 3, 5, 7, 9};
		double[] y = new double[] {-2, 0.5, 4};
		assertEquals( 19.5, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( 19.5, ArrayMath.dotProduct(y, x), TOL);
	}

}
