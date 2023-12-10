package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/12/2020
 */
@LeetCode(
		id = 923,
		name = "3Sum With Multiplicity",
		url = "https://leetcode.com/problems/3sum-with-multiplicity/",
		difficulty = Difficulty.MEDIUM
)
public class ThreeSumWithMultiplicity {
	public int threeSumMulti(int[] arr, int target) {
		int mod = 1_000_000_001;
		long result = 0L;
		long[] counts = new long[101];
		int numCount = 0;
		for (int num : arr) {
			counts[num]++;
			if (counts[num] == 1) {
				numCount++;
			}
		}

		int[] numbers = new int[numCount];
		int i = 0;
		for (int j = 0; j < counts.length; j++) {
			if (counts[j] > 0) {
				numbers[i++] = j;
			}
		}

		int numC;
		for (int numA : numbers) {
			for (int numB : numbers) {
				numC = target - numA - numB;
				if (numC < 0) {
					continue;
				}

				if (numA == numB && numB == numC) {
					result += (counts[numA] * (counts[numA] - 1) * (counts[numA] - 2)) / 6;
				}
				else if (numA == numB) {
					result += (counts[numA] * (counts[numA] - 1)) / 2 * counts[numC];
				}
				else if (numC > numB && numB > numA) {
					result += counts[numA] * counts[numB] * counts[numC];
				}
			}
		}

		return (int) (result % mod);
	}

	public static void main(String[] args) {
		System.out.println(new ThreeSumWithMultiplicity().threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
	}
}
