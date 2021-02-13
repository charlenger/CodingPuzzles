package it.cahung.lessons;

public class Lesson5 {

	private final int MAX = 2000000000;

	public int solutionCountDiv(int A, int B, int K) {
		if (A < 0 || A > MAX || B < 0 || B > MAX || K < 1 || K > MAX || A > B) {
			throw new IllegalArgumentException("Input value out of range");
		}
		return (B / K - A / K) + (A % K == 0 ? 1 : 0);
	}

}
