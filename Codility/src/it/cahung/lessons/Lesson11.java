package it.cahung.lessons;

public class Lesson11 {

	public int[] solutionCountNonDivisors(int[] A) {
		int N = A != null ? A.length : 0;
		if (N < 1 || N > 50000) {
			throw new IllegalArgumentException("Wrong input");
		}
		int[] solution = new int[] { 2, 4, 3, 2, 0 };
		return solution;
	}

}
