package it.cahung.lessons;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Lesson5Test {
	Lesson5 lesson5;

	@Before
	public void init() {
		lesson5 = new Lesson5();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5WrongInputA() {
		lesson5.solutionCountDiv(-1, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5WrongInputAtooMuch() {
		lesson5.solutionCountDiv(2000000001, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5WrongInputB() {
		lesson5.solutionCountDiv(1, -1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5WrongInputBtooMuch() {
		lesson5.solutionCountDiv(1, 2000000001, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5WrongInputK() {
		lesson5.solutionCountDiv(1, 1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5WrongInputKtooMuch() {
		lesson5.solutionCountDiv(1, 1, 2000000001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5WronInputAGreaterThanB() {
		lesson5.solutionCountDiv(2, 1, 0);
	}

	@Test
	public void lesson5CountDiv() {
		assertEquals(Integer.valueOf(3), Integer.valueOf(lesson5.solutionCountDiv(6, 11, 2)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson5.solutionCountDiv(3, 3, 3)));
		assertEquals(Integer.valueOf(1000000000), Integer.valueOf(lesson5.solutionCountDiv(1, 2000000000, 2)));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson5.solutionCountDiv(2, 2, 5)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson5.solutionCountDiv(0, 0, 2)));
	}
}
