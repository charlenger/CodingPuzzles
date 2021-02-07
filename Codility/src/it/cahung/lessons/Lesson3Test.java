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
}
