package it.cahung.lessons;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class Lesson11Test {
	Lesson11 lesson11;

	@Before
	public void init() {
		lesson11 = new Lesson11();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson11CountNonDivisorsWrongInput() {
		lesson11.solutionCountNonDivisors(new int[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson11CountNonDivisorsWrongInputTooMuch() {
		lesson11.solutionCountNonDivisors(new int[50001]);
	}

	@Test
	public void lesson11CountNonDivisors() {
		assertArrayEquals(new int[] { 2, 4, 3, 2, 0 }, lesson11.solutionCountNonDivisors(new int[] { 3, 1, 2, 3, 6 }));
	}
}
