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
		Deque<Character> deque = new ArrayDeque<Character>();
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

}
