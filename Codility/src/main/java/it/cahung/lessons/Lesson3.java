package it.cahung.lessons;

public class Lesson3 {

	public int solutionFrogJmp(int X, int Y, int D) {
		if (X > Y) {
			throw new IllegalArgumentException("Must be X <= Y");
		}
		if (X < 1 || Y < 1 || D < 1) {
			throw new IllegalArgumentException("X, Y and D must be >0");
		}
		int totalDistanceToCover = Y - X;
		return (totalDistanceToCover / D) + (totalDistanceToCover % D > 0 ? 1 : 0);
	}

	public int solutionPermMissingElement(int[] A) {
		int N = A.length;
		long total = 0;
		long expectedTotal = ((long) N + 2L) * ((long) N + 1L) / 2L;
		for (int i = 0; i < N; ++i) {
			total += (long) A[i];
		}
		return (int) (expectedTotal - total);
	}

	public int solutionTapeEquilibrium(int[] A) {
		int N = A.length;
		if (N < 2 || N > 100000) {
			throw new IllegalArgumentException("Size of the array is not valid");
		}
		int[] cumulativeSum = new int[N];
		cumulativeSum[0] = A[0];
		for (int i = 1; i < N; ++i) {
			cumulativeSum[i] = A[i] + cumulativeSum[i - 1];
		}
		int minDifference = Integer.MAX_VALUE;
		int currentBackwardAccumulation = 0;
		int currentDifference = Integer.MAX_VALUE;
		for (int i = N - 1; i > 0; --i) {
			currentBackwardAccumulation += A[i];
			currentDifference = Math.abs(currentBackwardAccumulation - cumulativeSum[i - 1]);
			if (currentDifference < minDifference) {
				minDifference = currentDifference;
			}
		}
		return minDifference;
	}

}
