package it.cahung.lessons;

public class Lesson11 {

	public int[] solutionCountNonDivisors(int[] A) {
		int N = A != null ? A.length : 0;
		if (N < 1 || N > 50000) {
			throw new IllegalArgumentException("Wrong input");
		}
		if (N == 1) {
			return new int[] { 0 };
		}
		int[] solution = new int[N];
		
		return solution;
	}
}