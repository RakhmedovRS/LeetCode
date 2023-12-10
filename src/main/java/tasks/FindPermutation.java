package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 2/15/2021
 */
@LeetCode(
		id = 484,
		name = "Find Permutation",
		url = "https://leetcode.com/problems/find-permutation/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class FindPermutation {
	public int[] findPermutation(String s) {
		int[] memo = new int[s.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'D') {
				memo[i + 1] = memo[i] - 1;
			}
			else {
				memo[i + 1] = memo[i] + 1;
			}
		}

		int[] answer = new int[s.length() + 1];
		int num = 1;
		for (int i = 0; i < memo.length; i++) {
			if (i + 1 < memo.length) {
				if (memo[i] < memo[i + 1]) {
					for (int j = i; j >= 0 && answer[j] == 0; j--) {
						answer[j] = num++;
					}
				}
			}
			else {
				for (int j = i; j >= 0 && answer[j] == 0; j--) {
					answer[j] = num++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		FindPermutation clazz = new FindPermutation();
		System.out.println(Arrays.toString(clazz.findPermutation("DDDDIIIIIIDDDDDDDD")));
		System.out.println(Arrays.toString(clazz.findPermutation("DDIIDI")));
		System.out.println(Arrays.toString(clazz.findPermutation("I")));
		System.out.println(Arrays.toString(clazz.findPermutation("DI")));
	}
}
