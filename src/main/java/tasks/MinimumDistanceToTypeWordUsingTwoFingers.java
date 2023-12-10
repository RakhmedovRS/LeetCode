package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @since 25.02.2021
 */
@LeetCode(
		id = 1320,
		name = "Minimum Distance to Type a Word Using Two Fingers",
		url = "https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/",
		difficulty = Difficulty.HARD
)
public class MinimumDistanceToTypeWordUsingTwoFingers {
	public int minimumDistance(String word) {
		Map<Character, int[]> positions = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			positions.put((char) ('A' + i), new int[]{i / 6, i % 6});
		}

		return dfs(0, word.toCharArray(), 0, new int[]{-1, -1},
				0, new int[]{-1, -1}, positions, new Integer[word.length() + 2][word.length() + 2]);
	}

	private int dfs(int pos, char[] chars, int f1Pos, int[] firstFinger,
					int f2Pos, int[] secondFinger, Map<Character, int[]> positions, Integer[][] memo) {
		if (pos == chars.length) {
			return 0;
		}

		if (memo[f1Pos][f2Pos] != null) {
			return memo[f1Pos][f2Pos];
		}

		int[] charPos = positions.get(chars[pos]);
		int fingerOneDistance = manhattanDistance(firstFinger, charPos)
				+ dfs(pos + 1, chars, pos + 1, charPos, f2Pos, secondFinger, positions, memo);

		int secondTwoDistance = manhattanDistance(secondFinger, charPos)
				+ dfs(pos + 1, chars, f1Pos, firstFinger, pos + 1, charPos, positions, memo);

		memo[f1Pos][f2Pos] = Math.min(fingerOneDistance, secondTwoDistance);
		return memo[f1Pos][f2Pos];
	}

	private int manhattanDistance(int[] a, int[] b) {
		if (a[0] == -1 || b[0] == -1) {
			return 0;
		}

		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}
