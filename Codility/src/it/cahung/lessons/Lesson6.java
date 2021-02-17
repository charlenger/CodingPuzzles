package it.cahung.lessons;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lesson6 {

	public int solutionDistinct(int[] A) {
		int N = A != null ? A.length : -1;
		if (N < 0 || N > 100000) {
			throw new IllegalArgumentException("Wrong input size");
		}
		Set<Integer> distinct = new HashSet<>();
		for (int i = 0; i < N; ++i) {
			distinct.add(A[i]);
		}
		return distinct.size();
	}

	public int solutionMaxProductOfThree(int[] A) {
		int N = A != null ? A.length : 0;
		if (N < 3 || N > 100000) {
			throw new IllegalArgumentException("Wrong input size");
		}
		Arrays.sort(A); // If using built-in Java code is not allowed, just re-use QuickSort
		int maxProductOfTopPositives = A[N - 1] * A[N - 2] * A[N - 3];
		int maxProductOfTopTwoNegatives = A[N - 1] * A[0] * A[1];
		return maxProductOfTopPositives > maxProductOfTopTwoNegatives ? maxProductOfTopPositives
				: maxProductOfTopTwoNegatives;
	}

}
