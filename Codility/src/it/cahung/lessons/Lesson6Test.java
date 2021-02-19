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

	@Test(expected = IllegalArgumentException.class)
	public void lesson6MaxProductOfThreeWrongInputSmall() {
		lesson6.solutionMaxProductOfThree(new int[2]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson6MaxProductOfThreeWrongInputLarge() {
		lesson6.solutionMaxProductOfThree(new int[100001]);
	}

	@Test
	public void lesson6MaxProductOfThree() {
		assertEquals(Integer.valueOf(60),
				Integer.valueOf(lesson6.solutionMaxProductOfThree(new int[] { -3, 1, 2, -2, 5, 6 })));
		assertEquals(Integer.valueOf(125),
				Integer.valueOf(lesson6.solutionMaxProductOfThree(new int[] { -5, 5, -5, 4 })));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson6TriangleWrongInputLarge() {
		lesson6.solutionTrinagle(new int[100001]);
	}

	@Test
	public void lesson6Triangle() {
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson6.solutionTrinagle(new int[2])));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson6.solutionTrinagle(new int[] { 10, 2, 5, 1, 8, 20 })));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson6.solutionTrinagle(new int[] { 10, 50, 5, 1 })));
	}
}
