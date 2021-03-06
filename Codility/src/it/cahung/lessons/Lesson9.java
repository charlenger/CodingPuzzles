package it.cahung.lessons;

import java.util.Arrays;

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
			throw new IllegalArgumentException("Wrong input size of array");
		}
		if (N == 3) {
			return 0;
		}
		int maxElement = -1;
		long[] maxForwardSums = new long[N];
		long[] maxBackwardSums = new long[N];
		maxForwardSums[0] = 0;
		maxBackwardSums[N - 1] = 0;
		for (int i = 1; i < N - 1; ++i) {
			int currentForwardValue = A[i];
			if (currentForwardValue > maxElement) {
				maxElement = currentForwardValue;
			}
			int currentBackwardValue = A[N - i - 1];
			long newForwardSlice = currentForwardValue + maxForwardSums[i - 1];
			long newBackwardSlice = currentBackwardValue + maxBackwardSums[N - i];
			maxForwardSums[i] = currentForwardValue > newForwardSlice ? currentForwardValue : newForwardSlice;
			maxBackwardSums[N - i - 1] = currentBackwardValue > newBackwardSlice ? currentBackwardValue
					: newBackwardSlice;
		}
		int absoluteSum = 0;
		for (int i = 1; i < N - 1; ++i) {
			int currentForwardSum = (int) maxForwardSums[i - 1];
			int currentBackwardSum = (int) maxBackwardSums[i + 1];
			int currentSum = (currentForwardSum > 0 ? currentForwardSum : 0)
					+ (currentBackwardSum > 0 ? currentBackwardSum : 0);
			if (currentSum > absoluteSum) {
				absoluteSum = currentSum;
			}
		}
		return absoluteSum > maxElement ? absoluteSum : maxElement;
	}

}
