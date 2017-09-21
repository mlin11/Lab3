package lab3;

import java.util.Random;

public class AminoAcidQuiz {
	/*
	 * define arrays for short and full names for amino acids
	 */
	public static String[] SHORT_NAMES = { "A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P",
			"S", "T", "W", "Y", "V" };
	public static String[] FULL_NAMES = { "alanine", "arginine", "asparagine", "aspartic acid", "cysteine", "glutamine",
			"glutamic acid", "glycine", "histidine", "isoleucine", "leucine", "lysine", "methionine", "phenylalanine",
			"proline", "serine", "threonine", "tryptophan", "tyrosine", "valine" };

	public static void main(String[] args) {
		int remainingTime = 30;
		/*
		 * define startTime and endTime
		 */
		long startTime = System.currentTimeMillis();
		long timeout = System.currentTimeMillis() + (remainingTime * 1000);
		/*
		 * define the count for right answers
		 */
		int count = 0;
		// define flag for terminating the loop
		int loopFlag = 0;
		while (System.currentTimeMillis() < timeout) {
			if (loopFlag == 0) {
				/*
				 * generate random index to select random element from full name array print it
				 * out and also the right one letter code
				 */
				Random random = new Random();
				int n = random.nextInt(20);
				String target = FULL_NAMES[n];
				System.out.println(target);
				String right = SHORT_NAMES[n];
				/*
				 * ask users to type an input
				 */
				String aString = System.console().readLine().toUpperCase();
				String aChar = "" + aString.charAt(0);
				/*
				 * check answers and keep track of time used
				 */
				float timeUsed = (System.currentTimeMillis() - startTime) / 1000f;
				if ((aChar.equals(right)) && (timeUsed < 30)) {
					count = count + 1;
					System.out.println(right);
					System.out.println("Right. Score= " + count + "; second = " + timeUsed + " out of 30");
				} else if ((aChar.equals(right)) && (timeUsed >= 30)) {
					System.out.println("Right but out of time");
					System.out.println("Test ends");
					loopFlag = 1;
				} else {
					System.out.println("WRONG should be " + right);
					System.out.println("Test ends with score of " + count);
					loopFlag = 1;
					timeout = 0;
				}
			}

		}

	}
}
