package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-29
 */
@LeetCode(
		id = 3160,
		name = "Find the Number of Distinct Colors Among the Balls",
		url = "https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheNumberOfDistinctColorsAmongTheBalls {
	public int[] queryResults(int limit, int[][] queries) {
		Map<Integer, Set<Integer>> colorToPos = new HashMap<>();
		Map<Integer, Integer> postToColor = new HashMap<>();
		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int ball = queries[i][0];
			int color = queries[i][1];
			if (postToColor.containsKey(ball) && !postToColor.get(ball).equals(color)) {
				int currentColor = postToColor.get(ball);
				colorToPos.get(currentColor).remove(ball);
				if (colorToPos.get(currentColor).isEmpty()) {
					colorToPos.remove(currentColor);
				}

			}
			postToColor.put(ball, color);
			colorToPos.putIfAbsent(color, new HashSet<>());
			colorToPos.get(color).add(ball);

			ans[i] = colorToPos.size();
		}
		return ans;
	}
}