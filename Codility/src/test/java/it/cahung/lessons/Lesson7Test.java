package it.cahung.lessons;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Lesson7Test {
	Lesson7 lesson7;

	@Before
	public void init() {
		lesson7 = new Lesson7();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson7BracketsWrongInput() {
		lesson7.solutionBrackets(new String(new char[200001]));
	}

	@Test
	public void lesson7Brackets() {
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson7.solutionBrackets("{[()()]}")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson7.solutionBrackets("([)()]")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson7.solutionBrackets(")(")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson7.solutionBrackets("{{{{")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson7FishWrongInputASmall() {
		lesson7.solutionFish(new int[0], new int[1]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson7FishWrongInputBSmall() {
		lesson7.solutionFish(new int[1], new int[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson7FishWrongInputALarge() {
		lesson7.solutionFish(new int[100001], new int[1]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson7FishWrongInputBLarge() {
		lesson7.solutionFish(new int[1], new int[100001]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson7FishWrongInputABDifferentSizes() {
		lesson7.solutionFish(new int[2], new int[4]);
	}

	@Test
	public void lesson7Fish() {
		assertEquals(Integer.valueOf(2),
				Integer.valueOf(lesson7.solutionFish(new int[] { 4, 3, 2, 1, 5 }, new int[] { 0, 1, 0, 0, 0 })));
		assertEquals(Integer.valueOf(5),
				Integer.valueOf(lesson7.solutionFish(new int[] { 4, 3, 2, 1, 5 }, new int[] { 0, 0, 0, 0, 0 })));
		assertEquals(Integer.valueOf(5),
				Integer.valueOf(lesson7.solutionFish(new int[] { 4, 3, 2, 1, 5 }, new int[] { 1, 1, 1, 1, 1 })));
		assertEquals(Integer.valueOf(1),
				Integer.valueOf(lesson7.solutionFish(new int[] { 4, 3, 2, 1, 5 }, new int[] { 1, 0, 0, 0, 0 })));
		assertEquals(Integer.valueOf(5),
				Integer.valueOf(lesson7.solutionFish(new int[] { 4, 3, 2, 1, 5 }, new int[] { 0, 0, 0, 1, 1 })));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson7NestingWrongInputNull() {
		lesson7.solutionNesting(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson7NestingWrongInput() {
		lesson7.solutionNesting(new String(new char[1000001]));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson7NestingWrongInputLetters() {
		lesson7.solutionNesting("ASD");
	}

	@Test
	public void lesson7Nesting() {
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson7.solutionNesting("(()(())())")));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson7.solutionNesting("())")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson7SkylineWrongInputNull() {
		lesson7.solutionSkyline(new int[0]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson7SkylineWrongInput() {
		lesson7.solutionSkyline(new int[100001]);
	}

	@Test
	public void lesson7Skyline() {
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson7.solutionSkyline(new int[] { 1, 1, 1, 1, 1, 1, 1 })));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson7.solutionSkyline(new int[] { 1 })));
		assertEquals(Integer.valueOf(2), Integer.valueOf(lesson7.solutionSkyline(new int[] { 1, 1, 1, 1, 1, 1, 2 })));
		assertEquals(Integer.valueOf(7),
				Integer.valueOf(lesson7.solutionSkyline(new int[] { 8, 8, 5, 7, 9, 8, 7, 4, 8 })));
	}
}
