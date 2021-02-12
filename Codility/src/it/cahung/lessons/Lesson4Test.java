package it.cahung.lessons;

import static org.junit.Assert.assertArrayEquals;
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
	public void lesson4FrogRiverWrongInputA() {
		lesson4.solutionFrogRiver(4, new int[] {});
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson4FrogRiverWrongInputX() {
		lesson4.solutionFrogRiver(-2, new int[] { 12, 123, 12 });
	}

	@Test
	public void lesson4FrogRiver() {
		assertEquals(Integer.valueOf(-1), Integer.valueOf(lesson4.solutionFrogRiver(2, new int[] { 12, 123, 12 })));
		assertEquals(Integer.valueOf(6),
				Integer.valueOf(lesson4.solutionFrogRiver(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 })));
		assertEquals(Integer.valueOf(-1), Integer.valueOf(lesson4.solutionFrogRiver(3, new int[] { 1 })));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson4.solutionFrogRiver(1, new int[] { 1 })));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson4MaxCountersWrongInputN() {
		lesson4.solutionMaxCounters(-2, new int[] { 12, 123, 12 });
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson4MaxCountersWrongInputA() {
		lesson4.solutionMaxCounters(5, new int[] {});
	}

	@Test
	public void lesson4MaxCounter() {
		assertArrayEquals(new int[] { 3, 2, 2, 4, 2 },
				lesson4.solutionMaxCounters(5, new int[] { 3, 4, 4, 6, 1, 4, 4 }));
		assertArrayEquals(new int[] { 1, 0, 1, 4, 0 }, lesson4.solutionMaxCounters(5, new int[] { 3, 4, 4, 1, 4, 4 }));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson4MissingIntegerWrongInputA0() {
		lesson4.solutionMissingInteger(new int[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson4MissingIntegerWrongInputA100001() {
		lesson4.solutionMissingInteger(new int[100001]);
	}

	@Test
	public void lesson4MissingInteger() {
		assertEquals(Integer.valueOf(5),
				Integer.valueOf(lesson4.solutionMissingInteger(new int[] { 1, 3, 6, 4, 1, 2 })));
		assertEquals(Integer.valueOf(4), Integer.valueOf(lesson4.solutionMissingInteger(new int[] { 1, 2, 3 })));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson4.solutionMissingInteger(new int[] { -3, -1 })));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson4.solutionMissingInteger(new int[] { 2, 4 })));
		assertEquals(Integer.valueOf(3), Integer.valueOf(lesson4.solutionMissingInteger(new int[] { 1, 2, 4 })));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson4PermCheckWrongInputA0() {
		lesson4.solutionPermCheck(new int[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson4PermCheckWrongInputA100001() {
		lesson4.solutionPermCheck(new int[100001]);
	}

	@Test
	public void lesson4PermCheck() {
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson4.solutionPermCheck(new int[] { 4, 1, 3, 2 })));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson4.solutionPermCheck(new int[] { 4, 1, 3 })));
	}
}
