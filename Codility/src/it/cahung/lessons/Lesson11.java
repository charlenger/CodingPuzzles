package it.cahung.lessons;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

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
		Set<Integer> divisors = new LinkedHashSet<>();
		divisors.add(1);
		int num = 2 * N;
		boolean[] divisorsMap = new boolean[num];
		for (int i = 0; i < divisorsMap.length; i++) {
			divisorsMap[i] = true;
		}
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (divisorsMap[i]) {
				for (int j = (i * i); j < num; j = j + i) {
					divisorsMap[j] = false;
				}
			}
		}
		for (int i = 2; i < divisorsMap.length; i++) {
			if (divisorsMap[i]) {
				divisors.add(i);
			}
		}
		Map<Integer, Integer> occurrences = new HashMap<>();
		for (int i = 0; i < N; ++i) {
			int currentValue = A[i];
			occurrences.put(currentValue, occurrences.getOrDefault(currentValue, 0) + 1);
		}
		for (int i = 0; i < N; ++i) {
			int currentValue = A[i];
			int totalDivisors = 0;
			for (Integer divisor : divisors) {
				if (currentValue % divisor == 0) {
					totalDivisors += occurrences.getOrDefault(divisor, 0);
				}
			}
			solution[i] = N - totalDivisors - (divisors.contains(currentValue) ? 0 : 1);
		}
		return solution;
	}
}