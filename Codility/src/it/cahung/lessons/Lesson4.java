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
}
