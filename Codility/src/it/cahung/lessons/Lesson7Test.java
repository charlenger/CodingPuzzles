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
}
