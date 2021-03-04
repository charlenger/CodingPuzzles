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
		long absoluteMax = Long.MIN_VALUE;
		long currentSum = 0;
		for (int i = 0; i < N; ++i) {
			int currentValue = A[i];
			currentSum += currentValue;
			if (currentSum > absoluteMax) {
				absoluteMax = currentSum;
			}
			if (currentSum < 0) {
				currentSum = 0;
			}
		}
		return (int) absoluteMax;
	}

	public int solutionMaxDoubleSliceSum(int[] A) {
		int N = A == null ? 0 : A.length;
		if (N < 3 || N > 100000) {
			throw new IllegalArgumentException("Wrong input size");
		}
		if (N == 3) {
			return 0;
		}
		long absoluteMax = Long.MIN_VALUE;
		long currentSum = 0;
		int absoluteMin = Integer.MAX_VALUE;
		int minimumFound = A[0] < 0 ? 0 : A[0];
		for (int i = 1; i < N - 1; ++i) {
			int currentValue = A[i];
			if (currentValue < minimumFound) {
				minimumFound = currentValue;
			}
			currentSum += currentValue;
			if (currentSum >= absoluteMax) {
				absoluteMax = currentSum;
				absoluteMin = minimumFound;
			}
			if (currentSum < 0) {
				currentSum = 0;
				minimumFound = Integer.MAX_VALUE;
			}
		}
		int result = (int) absoluteMax - (absoluteMin != absoluteMax ? absoluteMin : 0);
		return result < 0 ? 0 : result;
	}

}
