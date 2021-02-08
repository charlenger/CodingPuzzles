package it.cahung.lessons;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Lesson3Test {

	Lesson3 lesson3;

	@Before
	public void init() {
		lesson3 = new Lesson3();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson3FrogJmpWrongXYInput() {
		lesson3.solutionFrogJmp(4, 2, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson3FrogJmpWrongXInput() {
		lesson3.solutionFrogJmp(-4, 2, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson3FrogJmpWrongYInput() {
		lesson3.solutionFrogJmp(4, -2, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson3FrogJmpWrongDInput() {
		lesson3.solutionFrogJmp(4, 2, -20);
	}

	@Test
	public void lesson3FrogJmp() {
		int X = 10;
		int Y = 85;
		int D = 30;
		assertEquals(Integer.valueOf(3), Integer.valueOf(lesson3.solutionFrogJmp(X, Y, D)));
	}

	@Test
	public void lesson3PermMissingElement() {
		assertEquals(Integer.valueOf(2), Integer.valueOf(lesson3.solutionPermMissingElement(new int[] { 1 })));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson3.solutionPermMissingElement(new int[] { 2 })));
		assertEquals(Integer.valueOf(4), Integer.valueOf(lesson3.solutionPermMissingElement(new int[] { 1, 2, 3, 5 })));
		assertEquals(Integer.valueOf(6),
				Integer.valueOf(lesson3.solutionPermMissingElement(new int[] { 1, 2, 3, 5, 4 })));
		assertEquals(Integer.valueOf(7),
				Integer.valueOf(lesson3.solutionPermMissingElement(new int[] { 1, 2, 3, 5, 4, 6, 8 })));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson3.solutionPermMissingElement(new int[] {})));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson3TapeEquilibriumWrongInput0() {
		int[] A = new int[0];
		lesson3.solutionTapeEquilibrium(A);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson3TapeEquilibriumWrongInput1() {
		int[] A = new int[1];
		lesson3.solutionTapeEquilibrium(A);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson3TapeEquilibriumWrongInput101() {
		int[] A = new int[100001];
		lesson3.solutionTapeEquilibrium(A);
	}

	@Test
	public void lesson3TapeEquilibrium() {
		int[] A = new int[] { 3, 1, 2, 4, 3 };
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson3.solutionTapeEquilibrium(A)));
		A = new int[100000];
		for (int i = 0; i < 100000; ++i) {
			A[i] = 1000;
		}
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson3.solutionTapeEquilibrium(A)));
	}
}
