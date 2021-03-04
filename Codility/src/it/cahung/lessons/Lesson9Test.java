package it.cahung.lessons;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Lesson9Test {
	Lesson9 lesson9;

	@Before
	public void init() {
		lesson9 = new Lesson9();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson9MaxProfitWrongInput() {
		lesson9.solutionMaxProfit(new int[400001]);
	}

	@Test
	public void lesson9MaxProfit() {
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson9.solutionMaxProfit(new int[] { 5, 4, 3, 2, 1, 0 })));
		assertEquals(Integer.valueOf(0),
				Integer.valueOf(lesson9.solutionMaxProfit(new int[] { 10, 10, 10, 10, 10, 10 })));
		assertEquals(Integer.valueOf(356),
				Integer.valueOf(lesson9.solutionMaxProfit(new int[] { 23171, 21011, 21123, 21366, 21013, 21367 })));
		assertEquals(Integer.valueOf(200),
				Integer.valueOf(lesson9.solutionMaxProfit(new int[] { 200, 300, 300, 300, 300, 400 })));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson9.solutionMaxProfit(new int[0])));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson9MaxSliceSumWrongInput() {
		lesson9.solutionMaxSliceSum(new int[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson9MaxSliceSumWrongInputTooMuch() {
		lesson9.solutionMaxSliceSum(new int[1000001]);
	}

	@Test
	public void lesson9MaxSliceSum() {
		assertEquals(Integer.valueOf(5), Integer.valueOf(lesson9.solutionMaxSliceSum(new int[] { 3, 2, -6, 4, 0 })));
		assertEquals(Integer.valueOf(5), Integer.valueOf(lesson9.solutionMaxSliceSum(new int[] { 1, 1, 1, 1, 1 })));
		assertEquals(Integer.valueOf(5), Integer.valueOf(lesson9.solutionMaxSliceSum(new int[] { 5 })));
		assertEquals(Integer.valueOf(5), Integer.valueOf(lesson9.solutionMaxSliceSum(new int[] { 5, 0, 0 })));
		assertEquals(Integer.valueOf(5), Integer.valueOf(lesson9.solutionMaxSliceSum(new int[] { -6, 5, 0, 0, -6 })));
		assertEquals(Integer.valueOf(23), Integer.valueOf(lesson9.solutionMaxSliceSum(new int[] { -6, -5, 11, 12, -6 })));
		assertEquals(Integer.valueOf(-1), Integer.valueOf(lesson9.solutionMaxSliceSum(new int[] { -1, -1, -1, -1, -1 })));
		assertEquals(Integer.valueOf(-1), Integer.valueOf(lesson9.solutionMaxSliceSum(new int[] { -1, -1, -1, -1, -6 })));
		assertEquals(Integer.valueOf(4), Integer.valueOf(lesson9.solutionMaxSliceSum(new int[] { 3, -2, 3 })));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void lesson9MaxDoubleSliceSumWrongInputTooSmall() {
		lesson9.solutionMaxDoubleSliceSum(new int[2]);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void lesson9MaxDoubleSliceSumWrongInputTooMuch() {
		lesson9.solutionMaxDoubleSliceSum(new int[100001]);
	}

}
