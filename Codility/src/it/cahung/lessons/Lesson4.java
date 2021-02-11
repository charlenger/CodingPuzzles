package it.cahung.lessons;

import java.util.HashSet;
import java.util.Set;

public class Lesson4 {

	public int solutionFrogRiver(int X, int[] A) {
		int N = A != null ? A.length : 0;
		if (N < 1 || X < 1) {
			throw new IllegalArgumentException("input must be positive");
		}
		int crossingTime = -1;
		Set<Integer> presentLeafs = new HashSet<>();
		for (int i = 0; i < N; ++i) {
			int currentLeafPosition = A[i];
			if (currentLeafPosition <= X) {
				presentLeafs.add(currentLeafPosition);
			}
			if (presentLeafs.size() == X) {
				return i;
			}
		}
		return crossingTime;
	}

	public int[] solutionMaxCounters(int N, int[] A) {
		int M = A != null ? A.length : 0;
		if (N < 1 || M < 1) {
			throw new IllegalArgumentException("must be positive numbers");
		}
		int[] solution = new int[N];
		int currentMaxCounter = 0;
		int lastUsedMaxCounter = 0;
		for (int i = 0; i < M; ++i) {
			int currentIndex = A[i];
			if (currentIndex > N) {
				lastUsedMaxCounter = currentMaxCounter;
			} else {
				int currentCounter = solution[currentIndex - 1];
				currentCounter = solution[currentIndex - 1] = currentCounter < lastUsedMaxCounter
						? lastUsedMaxCounter + 1
						: currentCounter + 1;
				if (currentCounter > currentMaxCounter) {
					currentMaxCounter = currentCounter;
				}
			}
		}
		for (int i = 0; i < N; ++i) {
			if (solution[i] < lastUsedMaxCounter) {
				solution[i] = lastUsedMaxCounter;
			}
		}
		return solution;
	}

	public int solutionMissingInteger(int[] A) {
		int N = A != null ? A.length : 0;
		if (N < 1 || N > 100000) {
			throw new IllegalArgumentException("N must be between 1 and 100000");
		}
		Set<Integer> foundNumbers = new HashSet<>();
		int lowerBoundary = Integer.MAX_VALUE;
		int higherBoundary = 0;
		for (int i = 0; i < N; ++i) {
			int currentInteger = A[i];
			if (currentInteger > 0) {
				foundNumbers.add(currentInteger);
				if (currentInteger < lowerBoundary) {
					lowerBoundary = currentInteger;
				}
				if (currentInteger > higherBoundary) {
					higherBoundary = currentInteger;
				}
			}
		}
		// special cases
		if (lowerBoundary != 1) {
			return 1;
		}
		if (higherBoundary == foundNumbers.size()) {
			return higherBoundary + 1;
		}
		// Search for the number
		for (int i = lowerBoundary; i < higherBoundary; ++i) {
			if (!foundNumbers.contains(i)) {
				return i;
			}
		}
		return 1;
	}
}
