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
		if (N < 3) {
			return 0;
		}
		List<Integer> peaksIndexes = new ArrayList<>();
		for (int i = 1; i < N - 1; ++i) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				peaksIndexes.add(i);
			}
		}
		int maximumNumberOfFlags = peaksIndexes.size();
		for (int i = 1; i < maximumNumberOfFlags; ++i) {
			
		}
		return 0;
	}

}
