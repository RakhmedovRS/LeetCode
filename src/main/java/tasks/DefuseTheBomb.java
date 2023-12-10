package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/14/2020
 */
@LeetCode(
		id = 1652,
		name = "Defuse the Bomb",
		url = "https://leetcode.com/problems/defuse-the-bomb/",
		difficulty = Difficulty.EASY)
public class DefuseTheBomb {
	public int[] decrypt(int[] code, int k) {
		int[] answer = new int[code.length];
		if (k > 0) {
			int left = 1;
			int right = 1;
			int sum = 0;
			for (int i = 0; i < k; i++) {
				right = right % code.length;
				sum += code[right++];
			}

			for (int i = 0; i < code.length; i++) {
				answer[i] = sum;
				left %= code.length;
				right %= code.length;
				sum -= code[left++];
				sum += code[right++];
			}
		}
		else if (k < 0) {
			int left = code.length + k;
			int right = 0;
			int sum = 0;
			for (int i = left; i < code.length; i++) {
				sum += code[i];
			}

			for (int i = 0; i < code.length; i++) {
				answer[i] = sum;
				left %= code.length;
				right %= code.length;
				sum -= code[left++];
				sum += code[right++];
			}
		}

		return answer;
	}
}
