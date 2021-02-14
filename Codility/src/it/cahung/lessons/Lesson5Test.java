package it.cahung.lessons;

import static org.junit.Assert.assertArrayEquals;
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
	public void lesson5CountDivWrongInputA() {
		lesson5.solutionCountDiv(-1, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5CountDivWrongInputAtooMuch() {
		lesson5.solutionCountDiv(2000000001, 1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5CountDivWrongInputB() {
		lesson5.solutionCountDiv(1, -1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5CountDivWrongInputBtooMuch() {
		lesson5.solutionCountDiv(1, 2000000001, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5CountDivWrongInputK() {
		lesson5.solutionCountDiv(1, 1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5CountDivWrongInputKtooMuch() {
		lesson5.solutionCountDiv(1, 1, 2000000001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5CountDivWronInputAGreaterThanB() {
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

	@Test(expected = IllegalArgumentException.class)
	public void lesson5GenomicRangeQueryWrongInputDifferentPQSizes() {
		lesson5.solutionGenomicRangeQuery("ACGT", new int[] { 1, 2, 3 }, new int[] { 2, 3 });
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5GenomicRangeQueryWrongInputPQSizesTooLong() {
		lesson5.solutionGenomicRangeQuery("ACGT", new int[50001], new int[50001]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5GenomicRangeQueryWrongInputSTooLong() {
		String S = new String(new char[100001]);
		lesson5.solutionGenomicRangeQuery(S, new int[1], new int[1]);
	}

	@Test(expected = IllegalArgumentException.class)
	public void lesson5GenomicRangeQueryWrongQuery() {
		String S = new String("ACGTACGTACGT");
		lesson5.solutionGenomicRangeQuery(S, new int[] { 3, 2, 1 }, new int[] { 1, 2, 3 });
	}

	@Test
	public void lesson5GenomicRangeQuery() {
		assertArrayEquals(new int[] { 2, 4, 1 },
				lesson5.solutionGenomicRangeQuery("CAGCCTA", new int[] { 2, 5, 0 }, new int[] { 4, 5, 6 }));
		assertArrayEquals(new int[] { 4, 2, 2 },
				lesson5.solutionGenomicRangeQuery("TC", new int[] { 0, 0, 1 }, new int[] { 0, 1, 1 }));
		assertArrayEquals(new int[] { 2, 2, 2 },
				lesson5.solutionGenomicRangeQuery("CCCC", new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }));
		assertArrayEquals(new int[] { 1, 1, 1, 2 },
				lesson5.solutionGenomicRangeQuery("ACC", new int[] { 0, 0, 0, 1 }, new int[] { 0, 1, 2, 1 }));
		assertArrayEquals(new int[] { 1, 1, 2 },
				lesson5.solutionGenomicRangeQuery("AC", new int[] { 0, 0, 1 }, new int[] { 0, 1, 1 }));

	}
}
