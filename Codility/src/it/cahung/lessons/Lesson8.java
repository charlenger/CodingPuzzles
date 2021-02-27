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
		int halfN = N / 2;
		Integer leader = null;
		Map<Integer, Integer> foundNumbers = new HashMap<>();
		for (int i = 0; i < N; ++i) {
			int currentValue = A[i];
			int newValue = foundNumbers.getOrDefault(currentValue, 0) + 1;
			if (newValue > halfN) {
				leader = currentValue;
			}
			foundNumbers.put(currentValue, newValue);
		}
		int leadersCount = 0;
		if (leader != null) {
			int totalLeaders = foundNumbers.get(leader);
			int leadersFound = 0;
			for (int i = 0; i < N - 1; ++i) {
				if (leader.equals(Integer.valueOf(A[i]))) {
					leadersFound++;
					totalLeaders--;
				}
				int leftHalf = (i + 1) / 2;
				int rightHalf = (N - i - 1) / 2;
				if (leadersFound > leftHalf && totalLeaders > rightHalf) {
					leadersCount++;
				}
			}
		}
		return leadersCount;
	}

}
