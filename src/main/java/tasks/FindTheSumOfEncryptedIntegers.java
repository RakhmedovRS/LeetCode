package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 3/17/2024
 */
@LeetCode(
		id = 3079,
		name = "Find the Sum of Encrypted Integers",
		url = "https://leetcode.com/problems/find-the-sum-of-encrypted-integers/description/",
		difficulty = Difficulty.EASY
)
public class FindTheSumOfEncryptedIntegers {
	public int sumOfEncryptedInt(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			int max = 0;
			int count = 0;
			while (num > 0) {
				max = Math.max(max, num % 10);
				num /= 10;
				count++;
			}
			int newNum = 0;
			while (count-- > 0) {
				newNum *= 10;
				newNum += max;
			}


			sum += newNum;
		}
		return sum;
	}
}
