package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11/1/2020
 */
@LeetCode(
		id = 1641,
		name = "Count Sorted Vowel Strings",
		url = "https://leetcode.com/problems/count-sorted-vowel-strings/",
		difficulty = Difficulty.MEDIUM
)
public class CountSortedVowelStrings {
	public int countVowelStrings(int n) {
		int[][] memo = new int[5][n];
		Arrays.fill(memo[0], 1);
		for (int i = 0; i < 5; i++) {
			memo[i][0] = 1;
		}

		for (int column = 1; column < n; column++) {
			for (int row = 1; row < 5; row++) {
				memo[row][column] = memo[row][column - 1] + memo[row - 1][column];
			}
		}

		int count = 0;
		for (int[] row : memo) {
			count += row[n - 1];
		}
		return count;
	}
}
