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
}
