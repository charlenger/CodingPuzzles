package it.cahung.lessons;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class Lesson2Test {
	Lesson2 lesson2;

	@Before
	public void init() {
		lesson2 = new Lesson2();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson2CyclicRotationOutOfRange() {
		int[] A = new int[1000];
		int K = 1000;
		lesson2.solution(A, K);
	}

	@Test
	public void lesson2CyclicRotation() {
		int[] A = new int[] { 3, 8, 9, 7, 6 };
		int[] R = new int[] { 9, 7, 6, 3, 8 };
		int K = 3;
		assertArrayEquals(R, lesson2.solution(A, K));

		A = new int[] { 0, 0, 0 };
		R = new int[] { 0, 0, 0 };
		K = 1;
		assertArrayEquals(R, lesson2.solution(A, K));

		A = new int[] { 0, 1, 0 };
		R = new int[] { 0, 0, 1 };
		K = 1;
		assertArrayEquals(R, lesson2.solution(A, K));

		A = new int[] { 1, 2, 3, 4 };
		R = new int[] { 1, 2, 3, 4 };
		K = 4;
		assertArrayEquals(R, lesson2.solution(A, K));
		
		A = new int[] { 1, 2, 3, 4 };
		R = new int[] { 1, 2, 3, 4 };
		K = 8;
		assertArrayEquals(R, lesson2.solution(A, K));
	}
}
