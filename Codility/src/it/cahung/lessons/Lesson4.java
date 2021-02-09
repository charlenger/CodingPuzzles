package it.cahung.lessons;

import java.util.HashSet;
import java.util.Set;

public class Lesson4 {

	public int solutionFrogRiver(int X, int[] A) {
		if (A.length < 1 || X < 1) {
			throw new IllegalArgumentException("input must be positive");
		}
		int crossingTime = -1;
		Set<Integer> presentLeafs = new HashSet<>();
		for (int i = 0; i < A.length; ++i) {
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

}
