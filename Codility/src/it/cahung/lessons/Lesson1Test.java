package it.cahung.lessons;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Lesson1Test {

	Lesson1 lesson1;

	@Before
	public void init() {
		lesson1 = new Lesson1();
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson1NegativeInput() {
		lesson1.solution(-1);
	}

	@Test
	public void lesson1() {
		assertEquals(Integer.valueOf(5), Integer.valueOf(lesson1.solution(1041)));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson1.solution(32)));
		assertEquals(Integer.valueOf(2), Integer.valueOf(lesson1.solution(9)));
		assertEquals(Integer.valueOf(4), Integer.valueOf(lesson1.solution(529)));
		assertEquals(Integer.valueOf(1), Integer.valueOf(lesson1.solution(20)));
		assertEquals(Integer.valueOf(0), Integer.valueOf(lesson1.solution(15)));
	}
}
