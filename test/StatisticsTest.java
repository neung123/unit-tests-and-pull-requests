import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;
	
	@Test
	public void testAverageTinyArray() {
		double[] x = { 123.01 };
		assertEquals( x[0], Statistics.average(x), TOL);
		double[] y = { 123.01, 123.02 };
		assertEquals( 123.015, Statistics.average(y), TOL);
	}
	
	@Test
	public void testAverageMixedValues() {
		double[] x = new double[99];
		java.util.Arrays.fill(x, 12.5);
		assertEquals( 12.5, Statistics.average(x), TOL);
		// many values spaced around a known mean
		double avg = 1.125;
		int n = x.length;
		java.util.Arrays.fill(x, avg);
		for(int k=0; k<=n/2; k++) {
			x[k] -= 0.5*k;
			x[n-k-1] += 0.5*k;
		}
		assertEquals( avg, Statistics.average(x), TOL);
	}
	
	//TODO add test cases:
	//1. slightly illegal case. What if array is empty?
	//2. extrame case: very large array or very different values
	
	//TODO add test for variance.
	// What are test cases?

}
