package it.cahung.lessons;

import java.util.HashMap;
import java.util.Map;

public class Lesson8 extends Lesson7 {

	public int solutionDominator(int[] A) {
		int N = A != null ? A.length : -1;
		if (N > 100000) {
			throw new IllegalArgumentException("Wrong input sizes");
		}
		int halfN = N / 2;
		Map<Integer, Integer> foundNumbers = new HashMap<>();
		for (int i = 0; i < N; ++i) {
			int currentValue = A[i];
			int newValue = foundNumbers.getOrDefault(currentValue, 0) + 1;
			if (newValue > halfN) {
				return i;
			}
			foundNumbers.put(currentValue, newValue);
		}
		return -1;
	}

	public int solutionEquiLeader(int[] A) {
		int N = A != null ? A.length : 0;
		if (N < 1 || N > 100000) {
			throw new IllegalArgumentException("Wrong input sizes");
		}
		return 0;
	}

}
