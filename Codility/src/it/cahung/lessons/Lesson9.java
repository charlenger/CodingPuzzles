package it.cahung.lessons;

public class Lesson9 extends Lesson8 {

	public int solutionMaxProfit(int[] A) {
		int N = A == null ? -1 : A.length;
		if (N < 0 || N > 400001) {
			throw new IllegalArgumentException("Wrong input size");
		}
		return 0;
	}

}
