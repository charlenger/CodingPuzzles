package it.cahung.lessons;

public class Lesson3 {

	public int solutionFrogJmp(int X, int Y, int D) {
		if (X > Y) {
			throw new IllegalArgumentException("Must be X <= Y");
		}
		if (X < 1 || Y < 1 || D < 1) {
			throw new IllegalArgumentException("X, Y and D must be >0");
		}
		int totalDistanceToCover = Y - X;
		return (totalDistanceToCover / D) + (totalDistanceToCover % D > 0 ? 1 : 0);
	}

}
