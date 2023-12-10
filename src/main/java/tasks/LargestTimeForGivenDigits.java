package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 14-Aug-20
 */
@LeetCode(id = 949, name = "Largest Time for Given Digits", url = "https://leetcode.com/problems/largest-time-for-given-digits/")
public class LargestTimeForGivenDigits {
	public String largestTimeFromDigits(int[] A) {
		Integer currentMax = null;
		int[] currentPos = new int[0];
		for (int h1 = 0; h1 < 4; h1++) {
			for (int h2 = 0; h2 < 4; h2++) {
				if (h1 == h2 || A[h1] * 10 + A[h2] > 23) {
					continue;
				}

				for (int m1 = 0; m1 < 4; m1++) {
					if (h1 == m1 || h2 == m1) {
						continue;
					}

					for (int m2 = 0; m2 < 4; m2++) {
						if (h1 == m2 || h2 == m2 || m1 == m2 || A[m1] * 10 + A[m2] > 59) {
							continue;
						}

						int temp = ((A[h1] * 10 + A[h2]) * 60 + A[m1] * 10 + A[m2]) * 60;
						if (currentMax == null || temp > currentMax) {
							currentMax = temp;
							currentPos = new int[]{A[h1], A[h2], A[m1], A[m2]};
						}
					}
				}
			}
		}

		return currentMax == null ? "" : "" + currentPos[0] + currentPos[1] + ":" + currentPos[2] + currentPos[3];
	}

	public static void main(String[] args) {
		System.out.println(new LargestTimeForGivenDigits().largestTimeFromDigits(new int[]{1, 2, 3, 4}));
	}
}
