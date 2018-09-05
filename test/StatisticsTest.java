import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class StatisticsTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;
	static double random = Math.random() * 1000;
	
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
		java.util.Arrays.fill( x, 12.5);
		assertEquals( 12.5, Statistics.average(x), TOL);
		// many values spaced around a known mean
		double avg = 1.125;
		int n = x.length;
		java.util.Arrays.fill( x, avg);
		for(int k = 0; k <= n/2; k++) {
			x[k] -= 0.5*k;
			x[n - k - 1] += 0.5*k;
		}
		assertEquals( avg, Statistics.average(x), TOL);
	}

	@Test
	public void testAverageLargeArray() {
		double[] large = new double[100];

		for (int i = 0; i < 100; i++) large[i] = i;

		double sumLarge = 0;
		for (double num: large) sumLarge += num;
		assertEquals( sumLarge/100, Statistics.average(large), TOL);
	}

	@Test
	public void testAverageDiffValue() {
		double[] x = { 1.5, 22.02, 35.98, 54.44, 203.7, 4580 };
		double sum = 1.5 + 22.02 + 35.98 + 54.44 + 203.7 + 4580;

		assertEquals( sum/6, Statistics.average(x), TOL);
	}

	@Test
	public void testVarianceTinyArray() {
		double[] x = { 123.01 };
		assertEquals( 0, Statistics.variance(x), TOL);
		double[] y = { 123.01, 123.02 };
		double avgSquare = (123.01*123.01) + (123.02*123.02);
		assertEquals( (avgSquare/2) - (123.015*123.015), Statistics.variance(y), TOL);
	}

	@Test
	public void testCovariance() {
		double[] x = new double[100];
		double[] y = new double[100];

		java.util.Arrays.fill(x, 123);
		java.util.Arrays.fill(y, 123);
		assertEquals( 0, Statistics.covariance(x, y), TOL);
	}


	@Test
	public void testVeryDiffValueCase() {
		double[] largeX = new double[100];
		double[] largeY = new double[100];

		for (int i = 0; i < 100; i++){
			largeX[i] = random;
			largeY[i] = random;
		}


		double sum = 0;
		for(int i = 0; i < 100; i++) {
			sum += largeX[i] * largeX[i];
		}
		double avgPow = Math.pow(Statistics.average(largeX),2);
		assertEquals( sum/100 - avgPow, Statistics.variance(largeX), TOL);

		double sumSq = 0;
		for(int i = 0; i < 100; i++) {
			double avgX = Statistics.average(largeX);
			double avgY = Statistics.average(largeY);
			sumSq += (largeX[i] - avgX) * (largeY[i] - avgY);
		}
		assertEquals( sumSq/100, Statistics.covariance(largeX, largeY), TOL);
	}

	@Test
	public void testAvgIllegalCase() {
		double[] x = {};
		double ans = 0;
		assertEquals( ans, Statistics.average(x), TOL);

	}

	@Test (expected = IllegalArgumentException.class)
	public void testVarianceIllegalCase() {
		double[] x = {};
		Statistics.variance(x);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testCovarianceIllegalCase() {
		double[] x = {};
		double[] y = {1, 2, 3};
		double[] z = {1, 2};
		Statistics.covariance(x,y);
		Statistics.covariance(y,z);
	}

}
