package it.cahung.lessons;

import java.util.HashSet;
import java.util.Set;

public class Lesson2 {

	public int[] solutionCyclicRotation(int[] A, int K) throws IllegalArgumentException {
		int N = A.length;
		if (N > 100 || K > 100) {
			throw new IllegalArgumentException("N and K are integers within the range [0..100]");
		}
		if (N == 0) {
			return A;
		}
		int[] R = new int[N];
		int startingIndex = K >= N ? K % N : K;
		for (int i = 0; i < N; ++i) {
			int currentResultIndex = (startingIndex + i) % N;
			R[currentResultIndex] = A[i];
		}
		return R;
	}

	public int solutionOddOccurrencesInArray(int[] A) {
		int N = A.length;
		if (N % 2 == 0) {
			throw new IllegalArgumentException("N is an odd integer within the range [1..1000000]");
		}
		int result = -1;
		Set<Integer> pairedNumbers = new HashSet<>();
		for (int i = 0; i < N; ++i) {
			int currentValue = A[i];
			if (pairedNumbers.contains(currentValue)) {
				pairedNumbers.remove(currentValue);
			} else {
				pairedNumbers.add(currentValue);
			}
		}
		result = pairedNumbers.iterator().next();
		return result;
	}

}
