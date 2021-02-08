package it.cahung.lessons;

public class Lesson1 {

	public int solution(int N) {
		if (N < 0) {
			throw new IllegalArgumentException("N is an integer within the range [1..2,147,483,647]");
		}
		int gap = 0;
		int currentGap = 0;
		String binaryStringOfN = Integer.toBinaryString(N);
		for (int i = 0; i < binaryStringOfN.length(); ++i) {
			if (binaryStringOfN.charAt(i) == '1') {
				gap = currentGap > gap ? currentGap : gap;
				currentGap = 0;
			} else {
				currentGap++;
			}
		}
		return gap;
	}
}
