package it.cahung.lessons;

import java.util.ArrayList;
import java.util.List;

public class Lesson10 {

	public int solutionCountFactors(int N) {
		if (N < 1) {
			throw new IllegalArgumentException("Wrong input");
		}
		int counter = 0;
		int sqrtN = (int) Math.sqrt(N);
		if (Math.pow(sqrtN, 2) < N) {
			sqrtN++;
		} else {
			counter++;
		}
		for (int i = 1; i < sqrtN; ++i) {
			if (N % i == 0) {
				counter += 2;
			}
		}
		return counter;
	}

	public int solutionFlags(int[] A) {
		int N = A != null ? A.length : 0;
		if (N < 1 || N > 400000) {
			throw new IllegalArgumentException("Wrong input");
		}
		List<Integer> peaksIndexes = findPeaks(A, N);
		int maxFlags = peaksIndexes.size();
		if (maxFlags < 2) {
			return maxFlags;
		} else {
			int totalWidth = peaksIndexes.get(maxFlags - 1) - peaksIndexes.get(0) - 1;
			int averageDistanceBetweenPeaks = totalWidth / maxFlags;

		}
		return 0;
	}

	private List<Integer> findPeaks(int[] A, int N) {
		List<Integer> peaksIndexes = new ArrayList<>();
		for (int i = 1; i < N - 1; ++i) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				peaksIndexes.add(i);
			}
		}
		return peaksIndexes;
	}
}
