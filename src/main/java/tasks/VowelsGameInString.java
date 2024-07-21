package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-21
 */
@LeetCode(
		id = 3227,
		name = "Vowels Game in a String",
		url = "https://leetcode.com/problems/vowels-game-in-a-string/description/",
		difficulty = Difficulty.MEDIUM
)
public class VowelsGameInString {
	public boolean doesAliceWin(String s) {
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int[][] memo = new int[s.length()][2];
		for (int i = 0; i < s.length(); i++) {
			int prevVowels = i > 0 ? memo[i - 1][0] : 0;
			int prevCons = i > 0 ? memo[i - 1][1] : 0;
			if (vowels.contains(s.charAt(i))) {
				prevVowels++;
			} else {
				prevCons++;
			}

			memo[i][0] = prevVowels;
			memo[i][1] = prevCons;
		}

		int left = -1;
		boolean madeMove = true;
		boolean aliceTurn = true;
		while (madeMove) {
			int vSub = left >= 0 ? memo[left][0] : 0;
			int vCons = left >= 0 ? memo[left][1] : 0;

			madeMove = false;
			if (aliceTurn) {
				for (int right = memo.length - 1; right > left; right--) {
					if ((memo[right][0] - vSub) % 2 == 1) {
						madeMove = true;
						left = right;
						break;
					}
				}
			} else {
				for (int right = memo.length - 1; right > left; right--) {
					if ((memo[right][0] - vSub) % 2 == 0) {
						madeMove = true;
						left = right;
						break;
					}
				}
			}

			if (!madeMove) {
				return !aliceTurn;
			}

			aliceTurn = !aliceTurn;
		}

		return true;
	}
}