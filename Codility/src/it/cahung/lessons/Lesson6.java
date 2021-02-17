package it.cahung.lessons;

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

}
