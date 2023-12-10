package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Sep-20
 */
@LeetCode(id = 299, name = "Bulls and Cows", url = "https://leetcode.com/problems/bulls-and-cows/")
public class BullsAndCows {
	public String getHint(String secret, String guess) {
		int[] seen = new int[10];
		boolean[] used = new boolean[secret.length()];
		int bulls = 0;
		int cows = 0;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				used[i] = true;
				bulls++;
			}
			else {
				seen[secret.charAt(i) - '0']++;
			}
		}

		for (int i = 0; i < guess.length(); i++) {
			char ch = guess.charAt(i);
			if (seen[ch - '0'] != 0 && !used[i]) {
				cows++;
				seen[ch - '0']--;
			}
		}

		return String.format("%dA%dB", bulls, cows);
	}
}
