package it.cahung.lessons;

public class Lesson9 extends Lesson8 {

	public int solutionMaxProfit(int[] A) {
		int N = A == null ? -1 : A.length;
		if (N < 0 || N > 400000) {
			throw new IllegalArgumentException("Wrong input size");
		}
		if (N == 0) {
			return 0;
		}
		int minimumFound = A[0];
		int maxProfit = 0;
		for (int i = 1; i < N; ++i) {
			int currentValue = A[i];
			if (currentValue > minimumFound) {
				int currentProfit = currentValue - minimumFound;
				if (currentProfit > maxProfit) {
					maxProfit = currentProfit;
				}
			}
			if (currentValue < minimumFound) {
				minimumFound = currentValue;
			}
		}
		return maxProfit;
	}

	public int solutionMaxSliceSum(int[] A) {
		int N = A == null ? -1 : A.length;
		if (N < 1 || N > 1000000) {
			throw new IllegalArgumentException("Wrong input size");
		}
		long absoluteMaxSum = A[0];
		long currentMaxSum = A[0];
		for (int i = 1; i < N; ++i) {
			int currentValue = A[i];
			long newSum = currentMaxSum + currentValue;
			if (newSum >= currentMaxSum) {
				if (currentValue < newSum) {
					currentMaxSum = newSum;
				} else {
					currentMaxSum = currentValue;
				}
			} else {
				absoluteMaxSum = currentMaxSum > absoluteMaxSum ? currentMaxSum : absoluteMaxSum;
				currentMaxSum = currentValue;
			}
		}
		return absoluteMaxSum > currentMaxSum ? (int) absoluteMaxSum : (int) currentMaxSum;
	}

}
