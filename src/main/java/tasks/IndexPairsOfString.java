package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/4/2020
 */
@LeetCode(
		id = 1065,
		name = "Index Pairs of a String",
		url = "https://leetcode.com/problems/index-pairs-of-a-string/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class IndexPairsOfString {
	public int[][] indexPairs(String text, String[] words) {
		int currentPos;
		boolean[][] memo = new boolean[101][101];
		for (String word : words) {
			currentPos = 0;
			while (currentPos != -1) {
				currentPos = text.indexOf(word, currentPos);
				if (currentPos == -1) {
					break;
				}
				memo[currentPos][currentPos + word.length() - 1] = true;
				currentPos++;
			}
		}

		List<int[]> pairs = new ArrayList<>();
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[i].length; j++) {
				if (memo[i][j]) {
					pairs.add(new int[]{i, j});
				}
			}
		}

		int[][] answer = new int[pairs.size()][];
		for (int i = 0; i < pairs.size(); i++) {
			answer[i] = pairs.get(i);
		}

		return answer;
	}
}
