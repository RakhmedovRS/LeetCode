package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author RakhmedovRS
 * @created 21-May-20
 */
@LeetCode(
		id = 470,
		name = "Implement Rand10() Using Rand7()",
		url = "https://leetcode.com/problems/implement-rand10-using-rand7/",
		difficulty = Difficulty.MEDIUM
)
public class ImplementRand10UsingRand7 {
	private abstract class SolBase {
		int rand7() {
			return new Random().nextInt(7) + 1;
		}
	}

	public class Solution extends SolBase {
		int num = 0;

		public int rand10() {
			num += rand7();
			return num % 10 + 1;
		}
	}

	public static void main(String[] args) {
		int[] count = new int[10];
		Solution solution = new ImplementRand10UsingRand7().new Solution();
		for (int i = 0; i < 10000; i++) {
			count[solution.rand10() - 1]++;
		}

		System.out.println(Arrays.toString(count));
	}
}
