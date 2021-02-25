package it.cahung.lessons;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lesson7 {

	public int solutionBrackets(String S) {
		int N = S == null ? -1 : S.length();
		if (N < 0 || N > 200000) {
			throw new IllegalArgumentException("Wrong input size");
		}
		char[] brackets = S.toCharArray();
		Deque<Character> deque = new ArrayDeque<>();
		for (int i = 0; i < N; ++i) {
			char currentBracket = brackets[i];
			if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {
				deque.push(currentBracket);
			} else {
				Character lastChar = deque.poll();
				if (lastChar == null) {
					return 0;
				}
				switch (currentBracket) {
				case '}':
					if (lastChar != '{') {
						return 0;
					}
					break;
				case ']':
					if (lastChar != '[') {
						return 0;
					}
					break;
				case ')':
					if (lastChar != '(') {
						return 0;
					}
					break;
				}
			}
		}
		return deque.size() == 0 ? 1 : 0;
	}

	public int solutionFish(int[] A, int[] B) {
		int N = A != null ? A.length : 0;
		if (N < 1 || N > 100001 || N != B.length) {
			throw new IllegalArgumentException("Wrong input sizes");
		}
		Deque<Integer> fishes = new ArrayDeque<>();
		int aliveFishes = 0;
		for (int i = 0; i < N; ++i) {
			int currentDirection = B[i];
			int currentFishSize = A[i];
			if (currentDirection == 0) {
				while (!fishes.isEmpty()) {
					Integer lastPoll = fishes.poll();
					if (lastPoll == currentFishSize) {
						throw new IllegalArgumentException("Wrong array content");
					} else if (lastPoll > currentFishSize) {
						fishes.push(lastPoll);
						break;
					}
				}
				if (fishes.isEmpty()) {
					aliveFishes++;
				}
			} else {
				fishes.push(currentFishSize);
			}
		}
		return aliveFishes + fishes.size();
	}

	public int solutionNesting(String S) {
		int N = S != null ? S.length() : -1;
		if (N < 0 || N > 1000000) {
			throw new IllegalArgumentException("Wrong input size");
		}
		int openBrackets = 0;
		for (int i = 0; i < N; ++i) {
			char currentChar = S.charAt(i);
			switch (currentChar) {
			case '(':
				openBrackets++;
				break;
			case ')':
				openBrackets--;
				if (openBrackets < 0) {
					return 0;
				}
				break;
			default:
				throw new IllegalArgumentException("Wrong input type");
			}
		}
		return openBrackets == 0 ? 1 : 0;
	}

	public int solutionSkyline(int[] H) {
		int N = H != null ? H.length : 0;
		if (N < 1 || N > 100000) {
			throw new IllegalArgumentException("Wrong input size");
		}
		int numberOfCuboids = 0;
		Deque<Integer> deque = new ArrayDeque<>();
		deque.push(H[0]);
		for (int i = 1; i < N; ++i) {
			int currentHeight = H[i];
			while (!deque.isEmpty() && currentHeight < deque.peek()) {
				deque.poll();
				numberOfCuboids++;
			}
			if (deque.isEmpty() || currentHeight != deque.peek()) {
				deque.push(currentHeight);
			}
		}
		return numberOfCuboids + deque.size();
	}

}
