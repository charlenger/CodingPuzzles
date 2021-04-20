package it.cahung.lessons;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Lesson10Test {
	Lesson10 lesson10;

	@Before
	public void init() {
		lesson10 = new Lesson10();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson10CountFactorsWrongInput() {
		lesson10.solutionCountFactors(0);
	}

	@Test
	public void lesson10CountFactors() {
		assertEquals(Integer.valueOf(8), Integer.valueOf(lesson10.solutionCountFactors(24)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson10.solutionCountFactors(1)));
		assertEquals(Integer.valueOf(2), Integer.valueOf(lesson10.solutionCountFactors(2)));
		assertEquals(Integer.valueOf(3), Integer.valueOf(lesson10.solutionCountFactors(4)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson10FlagsWrongInput() {
		lesson10.solutionFlags(new int[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson10FlagsWrongInputTooMuch() {
		lesson10.solutionFlags(new int[400001]);
	}

	@Test
	public void lesson10Flags() {
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson10.solutionFlags(new int[] { 0, })));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson10.solutionFlags(new int[] { 0, 0 })));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson10.solutionFlags(new int[] { 0, 0, 0 })));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson10.solutionFlags(new int[] { 0, 0, 0, 0, 0, 0, 0, 0 })));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson10.solutionFlags(new int[] { 0, 0, 0, 1, 0, 0, 0, 0 })));
		assertEquals(Integer.valueOf(2), Integer.valueOf(lesson10.solutionFlags(new int[] { 0, 0, 0, 1, 0, 1, 0, 0 })));
		assertEquals(Integer.valueOf(2), Integer.valueOf(lesson10.solutionFlags(new int[] { 0, 0, 0, 1, 0, 0, 1, 0 })));
		assertEquals(Integer.valueOf(3),
				Integer.valueOf(lesson10.solutionFlags(new int[] { 1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 })));
		assertEquals(Integer.valueOf(2),
				Integer.valueOf(lesson10.solutionFlags(new int[] { 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 })));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson10MinPerimeterRectangleWrongInput() {
		lesson10.solutionMinPerimeterRectangle(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson10MinPerimeterRectangleWrongInputTooMuch() {
		lesson10.solutionMinPerimeterRectangle(1000000001);
	}

	@Test
	public void lesson10MinPerimeterRectangle() {
		assertEquals(Integer.valueOf(22), Integer.valueOf(lesson10.solutionMinPerimeterRectangle(30)));
		assertEquals(Integer.valueOf(6), Integer.valueOf(lesson10.solutionMinPerimeterRectangle(2)));
		assertEquals(Integer.valueOf(4), Integer.valueOf(lesson10.solutionMinPerimeterRectangle(1)));
		assertEquals(Integer.valueOf(24), Integer.valueOf(lesson10.solutionMinPerimeterRectangle(36)));
		assertEquals(Integer.valueOf(28), Integer.valueOf(lesson10.solutionMinPerimeterRectangle(48)));
		assertEquals(Integer.valueOf(8552), Integer.valueOf(lesson10.solutionMinPerimeterRectangle(4564320)));
		assertEquals(Integer.valueOf(40000), Integer.valueOf(lesson10.solutionMinPerimeterRectangle(100000000)));
		assertEquals(Integer.valueOf(126500), Integer.valueOf(lesson10.solutionMinPerimeterRectangle(1000000000)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson10PeaksWrongInput() {
		lesson10.solutionPeaks(new int[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson10PeaksWrongInputTooMuch() {
		lesson10.solutionPeaks(new int[100001]);
	}

	@Test
	public void lesson10Peaks() {
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson10.solutionPeaks(new int[] { 0 })));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson10.solutionPeaks(new int[] { 0, 1, 0, 0, 0, 0 })));
		assertEquals(Integer.valueOf(2), Integer.valueOf(lesson10.solutionPeaks(new int[] { 0, 1, 0, 0, 1, 0 })));
		assertEquals(Integer.valueOf(3),
				Integer.valueOf(lesson10.solutionPeaks(new int[] { 0, 1, 0, 0, 1, 0, 0, 1, 0 })));
		assertEquals(Integer.valueOf(3),
				Integer.valueOf(lesson10.solutionPeaks(new int[] { 1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2 })));
	}
}
