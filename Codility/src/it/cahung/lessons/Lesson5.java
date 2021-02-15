package it.cahung.lessons;

public class Lesson5 {

	private final int MAX = 2000000000;

	public int solutionCountDiv(int A, int B, int K) {
		if (A < 0 || A > MAX || B < 0 || B > MAX || K < 1 || K > MAX || A > B) {
			throw new IllegalArgumentException("Input value out of range");
		}
		return (B / K - A / K) + (A % K == 0 ? 1 : 0);
	}

	public int[] solutionGenomicRangeQuery(String S, int[] P, int[] Q) {
		int N = S != null ? S.length() : 0;
		int M = P.length;
		if (M != Q.length || M > 50000 || N > 100000 || N < 1) {
			throw new IllegalArgumentException("P and Q must have the same length");
		}
		char[] genesChars = S.toCharArray();
		int[] counterOfA = new int[N + 1];
		int[] counterOfC = new int[N + 1];
		int[] counterOfG = new int[N + 1];
		int[] counterOfT = new int[N + 1];
		int prevA = 0;
		int prevC = 0;
		int prevG = 0;
		int prevT = 0;
		for (int i = 1; i <= N; ++i) {
			char currentChar = genesChars[i - 1];
			counterOfA[i] = currentChar == 'A' ? ++prevA : prevA;
			counterOfC[i] = currentChar == 'C' ? ++prevC : prevC;
			counterOfG[i] = currentChar == 'G' ? ++prevG : prevG;
			counterOfT[i] = currentChar == 'T' ? ++prevT : prevT;
		}
		int[] solution = new int[M];
		for (int i = 0; i < M; ++i) {
			char currentChar = 'Z';
			int pIdx = P[i];
			int qIdx = Q[i];
			if (pIdx > qIdx) {
				throw new IllegalArgumentException("Query range is not valid");
			} else if (pIdx == qIdx) {
				currentChar = genesChars[pIdx];
			} else {
				qIdx++;
				if (counterOfA[qIdx] != counterOfA[pIdx]) {
					currentChar = 'A';
				} else if (counterOfC[qIdx] != counterOfC[pIdx]) {
					currentChar = 'C';
				} else if (counterOfG[qIdx] != counterOfG[pIdx]) {
					currentChar = 'G';
				} else if (counterOfT[qIdx] != counterOfT[pIdx]) {
					currentChar = 'T';
				}
			}
			switch (currentChar) {
			case 'A':
				solution[i] = 1;
				break;
			case 'C':
				solution[i] = 2;
				break;
			case 'G':
				solution[i] = 3;
				break;
			default:
				solution[i] = 4;
			}

		}
		return solution;
	}

	public int solutionPassingCars(int[] A) {
		int N = A != null ? A.length : 0;
		if (N < 1 || N > 100000) {
			throw new IllegalArgumentException("Wrong array size");
		}
		int zeros = 0;
		int pairs = 0;
		for (int i = 0; i < N; ++i) {
			int currentValue = A[i];
			if (currentValue == 0) {
				zeros++;
			} else {
				pairs += zeros;
				if (pairs > 1000000000) {
					return -1;
				}
			}
		}
		return pairs;
	}
}
