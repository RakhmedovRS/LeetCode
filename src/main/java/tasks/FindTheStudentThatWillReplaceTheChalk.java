package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/13/2021
 */
@LeetCode(
		id = 1894,
		name = "Find the Student that Will Replace the Chalk",
		url = "https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheStudentThatWillReplaceTheChalk {
	public int chalkReplacer(int[] chalk, int k) {
		long sum = 0;
		for (int ch : chalk) {
			sum += ch;
		}

		k %= sum;

		for (int i = 0; i < chalk.length; i++) {
			k -= chalk[i];
			if (k < 0) {
				return i;
			}
		}

		return -1;
	}
}
