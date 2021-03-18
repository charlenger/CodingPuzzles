package it.cahung.lessons;

import java.util.ArrayList;
import java.util.List;

public class Lesson10 {

	public int solutionCountFactors(int N) {
		if (N < 1) {
			throw new IllegalArgumentException("Wrong input");
		}
		int counter = 0;
		int sqrtN = (int) Math.sqrt(N);
		if (Math.pow(sqrtN, 2) < N) {
			sqrtN++;
		} else {
			counter++;
		}
		for (int i = 1; i < sqrtN; ++i) {
			if (N % i == 0) {
				counter += 2;
			}
		}
		return counter;
	}

	public int solutionFlags(int[] A) {
		int N = A != null ? A.length : 0;
		if (N < 1 || N > 400000) {
			throw new IllegalArgumentException("Wrong input");
		}
		List<Integer> peaksIndexes = findPeaks(A, N);
		int maxFlags = peaksIndexes.size();
		if (maxFlags < 2) {
			return maxFlags;
		} else if (maxFlags == 2) {
			return peaksIndexes.get(1) - peaksIndexes.get(0) >= 2 ? 2 : 1;
		} else {
			int lowerbound = 2;
			int upperbound = maxFlags;
			int currentFlagCount = (upperbound + lowerbound) / 2;
			while (lowerbound != upperbound) {
				boolean success = testNumberOfFlags(currentFlagCount, peaksIndexes);
				if (success) {
					lowerbound = currentFlagCount > lowerbound ? currentFlagCount : lowerbound + 1;
				} else {
					upperbound = currentFlagCount < upperbound ? currentFlagCount : upperbound - 1;
				}
				currentFlagCount = (upperbound + lowerbound) / 2;
			}
			return currentFlagCount;
		}
	}

	private boolean testNumberOfFlags(int currentFlagCount, List<Integer> peaksIndexes) {
		int remainingFlags = currentFlagCount;
		int prevPos = peaksIndexes.get(0);
		for (int i = 1; i < peaksIndexes.size(); ++i) {
			int currPos = peaksIndexes.get(i);
			if (currPos - prevPos > currentFlagCount) {
				remainingFlags--;
				prevPos = currPos;
				if (remainingFlags == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public int solutionMinPerimeterRectangle(int N) {
		if (N < 1 || N > 1000000000) {
			throw new IllegalArgumentException("Wrong input");
		}
		int minSumFound = Integer.MAX_VALUE;
		int currentPerimeter;
		double sqrtN = Math.sqrt(N);
		for (int i = 1; i <= sqrtN; ++i) {
			if ((N % i == 0) && ((currentPerimeter = 2 * (N / i + i)) < minSumFound)) {
				minSumFound = currentPerimeter;
			}
		}
		return minSumFound;
	}

	public int solutionPeaks(int[] A) {
		int N = A != null ? A.length : 0;
		if (N < 1 || N > 100000) {
			throw new IllegalArgumentException("Wrong input");
		}
		List<Integer> peaks = findPeaks(A, N);
		int numberOfPeaks = peaks.size();
		if (numberOfPeaks < 2) {
			return numberOfPeaks;
		}
		for (int i = numberOfPeaks; i >= 1; --i) {
			if (N % i == 0) {
				if (testNumberOfBlocks(i, N, peaks)) {
					return i;
				}
			}
		}
		return 0;
	}

	private boolean testNumberOfBlocks(int i, int n, List<Integer> peaks) {
		int currentPeaksIndex = 0;
		for (int j = i; j <= n; j += i) {
			int nextValue = peaks.get(currentPeaksIndex);
			while (nextValue < j) {
				currentPeaksIndex++;
				if (currentPeaksIndex < peaks.size()) {
					nextValue = peaks.get(currentPeaksIndex);
				} else if (j == n) {
					return true;
				}
			}
		}
		return false;
	}

	private List<Integer> findPeaks(int[] A, int N) {
		List<Integer> peaksIndexes = new ArrayList<>();
		for (int i = 1; i < N - 1; ++i) {
			if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
				peaksIndexes.add(i);
			}
		}
		return peaksIndexes;
	}
}
