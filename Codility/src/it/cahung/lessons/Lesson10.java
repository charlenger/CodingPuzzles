package it.cahung.lessons;

public class Lesson10 {

	public int solutionCountFactors(int N) {
		if (N < 1) {
			throw new IllegalArgumentException("Wrong input");
		}
		if (N == 1) {
			return 1;
		}
		int counter = 2;
		for (int i = 2; i <= N / 2; ++i) {
			if (N % i == 0) {
				counter++;
			}
		}
		return counter;
	}

}
