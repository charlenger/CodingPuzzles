package it.cahung.lessons;

public class Lesson11 {

	public int[] solutionCountNonDivisors(int[] A) {
		int N = A != null ? A.length : 0;
		if (N < 1 || N > 50000) {
			throw new IllegalArgumentException("Wrong input");
		}
		int[] solution = new int[N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (A[i] % A[j] != 0) {
					solution[i]++;
				}
			}
		}
		return solution;
	}

}
