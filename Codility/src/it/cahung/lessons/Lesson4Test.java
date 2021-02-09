package it.cahung.lessons;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Lesson4Test {
	Lesson4 lesson4;

	@Before
	public void init() {
		lesson4 = new Lesson4();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson3FrogRiverWrongInputA() {
		lesson4.solutionFrogRiver(4, new int[] {});
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson3FrogRiverWrongInputX() {
		lesson4.solutionFrogRiver(-2, new int[] { 12, 123, 12 });
	}

	@Test
	public void lesson3FrogRiver() {
		assertEquals(Integer.valueOf(-1), Integer.valueOf(lesson4.solutionFrogRiver(2, new int[] { 12, 123, 12 })));
		assertEquals(Integer.valueOf(6),
				Integer.valueOf(lesson4.solutionFrogRiver(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 })));
		assertEquals(Integer.valueOf(-1),
				Integer.valueOf(lesson4.solutionFrogRiver(3, new int[] { 1 })));
		assertEquals(Integer.valueOf(0),
				Integer.valueOf(lesson4.solutionFrogRiver(1, new int[] { 1 })));
	}
}
