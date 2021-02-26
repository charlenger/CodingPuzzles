package it.cahung.lessons;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Lesson8Test {
	Lesson8 lesson8;

	@Before
	public void init() {
		lesson8 = new Lesson8();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson8DominatorWrongInput() {
		lesson8.solutionDominator(new int[100001]);
	}

	@Test
	public void lesson8Dominator() {
		Integer returnValue = Integer.valueOf(lesson8.solutionDominator(new int[] { 3, 4, 3, 2, 3, -1, 3, 3 }));
		assertTrue(returnValue == 0 || returnValue == 2 || returnValue == 4 || returnValue == 6 || returnValue == 7);
	}
}
