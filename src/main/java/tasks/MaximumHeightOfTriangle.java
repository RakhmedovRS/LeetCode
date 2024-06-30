package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-29
 */
@LeetCode(
		id = 3200,
		name = "Maximum Height of a Triangle",
		url = "https://leetcode.com/problems/maximum-height-of-a-triangle/description/",
		difficulty = Difficulty.EASY
)
public class MaximumHeightOfTriangle {
	public int maxHeightOfTriangle(int red, int blue) {
		return Math.max(maxHeightOfTriangle(red, blue, true), maxHeightOfTriangle(red, blue, false));
	}

	public int maxHeightOfTriangle(int red, int blue, boolean useRed) {
		int level = 0;
		boolean seenMatch = true;
		int required = 1;
		while (seenMatch) {
			seenMatch = false;
			if (useRed) {
				if (red >= required) {
					red -= required;
					required++;
					seenMatch = true;
					useRed = false;
					level++;
				}
			} else {
				if (blue >= required) {
					blue -= required;
					required++;
					seenMatch = true;
					useRed = true;
					level++;
				}
			}
		}
		return level;
	}
}