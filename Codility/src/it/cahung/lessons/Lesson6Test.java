package it.cahung.lessons;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Lesson6Test {
	Lesson6 lesson6;

	@Before
	public void init() {
		lesson6 = new Lesson6();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson6DistinctWrongInput() {
		lesson6.solutionDistinct(new int[100001]);
	}

	@Test
	public void lesson6Distinct() {
		assertEquals(Integer.valueOf(3), Integer.valueOf(lesson6.solutionDistinct(new int[] { 2, 1, 1, 2, 3, 1 })));
	}
}
