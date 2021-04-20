package it.cahung.lessons;

import java.util.Arrays;
import java.util.Comparator;
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

	public int solutionTrinagle(int[] A) {
		int N = A != null ? A.length : 0;
		if (N > 100000) {
			throw new IllegalArgumentException("Wrong input size");
		} else if (N < 3) {
			return 0;
		} else {
			Arrays.sort(A);
			for (int i = 0; i < N - 2; ++i) {
				if ((long) A[i] + (long) A[i + 1] > (long) A[i + 2]) {
					return 1;
				}
			}
		}
		return 0;
	}

	public int solutionNumberOfDiscIntersections(int[] A) {
		int N = A != null ? A.length : 0;
		if (N > 100000) {
			throw new IllegalArgumentException("Wrong input size");
		}
		int intersections = 0;
		// O(N^2) 50% to be refactored
//		for (int i = 0; i < N - 1; ++i) {
//			for (int j = i + 1; j < N; ++j) {
//				long minA = (long) i - (long) A[i];
//				long maxA = (long) i + (long) A[i];
//				long minB = (long) j - (long) A[j];
//				long maxB = (long) j + (long) A[j];
//				if ((minA >= minB && minA <= maxB) || (minB >= minA && minB <= maxA) || (minA >= minB && maxA <= maxB)
//						|| (minA <= minB && maxA >= maxB)) {
//					intersections++;
//					if (intersections > 10000000) {
//						return -1;
//					}
//				}
//			}
//		}

		// O(N^2) 81% to be refactored
//		List<Entry<Long, Boolean>> circles = new ArrayList<>();
//		for (int i = 0; i < N; ++i) {
//			long min = (long) i - (long) A[i];
//			long max = (long) i + (long) A[i];
//			circles.add(new SimpleEntry<Long, Boolean>(min, true));
//			circles.add(new SimpleEntry<Long, Boolean>(max, false));
//		}
//		circles.sort(new Comparator<Entry<Long, Boolean>>() {
//			@Override
//			public int compare(Entry<Long, Boolean> e1, Entry<Long, Boolean> e2) {
//				if (e1.getKey().equals(e2.getKey())) {
//					return e2.getValue().compareTo(e1.getValue());
//				} else {
//					return e1.getKey().compareTo(e2.getKey());
//				}
//			}
//		});
//		int openCircles = 0;
//		for (Entry<Long, Boolean> e : circles) {
//			if (Boolean.TRUE.equals(e.getValue())) {
//				intersections += openCircles;
//				openCircles++;
//			} else {
//				openCircles--;
//			}
//		}
		int N2 = 2 * N;
		long[][] circleBoundaries = new long[N2][2];
		for (int i = 0; i < N2; i += 2) {
			int sourceIndex = i / 2;
			long min = (long) sourceIndex - (long) A[sourceIndex];
			long max = (long) sourceIndex + (long) A[sourceIndex];
			circleBoundaries[i][0] = min;
			circleBoundaries[i][1] = 0;
			circleBoundaries[i + 1][0] = max;
			circleBoundaries[i + 1][1] = 1;
		}
		Arrays.sort(circleBoundaries, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				if (o1[0] == o2[0]) {
					return Long.compare(o1[1], o2[1]);
				} else {
					return Long.compare(o1[0], o2[0]);
				}
			}

		});
		int openCircles = 0;
		for (int i = 0; i < N2; ++i) {
			if (circleBoundaries[i][1] == 0) {
				intersections += openCircles;
				openCircles++;
				if (intersections > 10000000) {
					return -1;
				}
			} else {
				openCircles--;
			}
		}
		return intersections;
	}

}
