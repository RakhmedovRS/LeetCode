package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-06
 */
@LeetCode(
		id = 3206,
		name = "Alternating Groups I",
		url = "https://leetcode.com/problems/alternating-groups-i/description/",
		difficulty = Difficulty.EASY
)
public class AlternatingGroupsI {
	public int numberOfAlternatingGroups(int[] colors) {
		int[] newArr = new int[colors.length + 2];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = colors[i % colors.length];
		}

		int ans = 0;
		for (int i = 2; i < newArr.length; i++) {
			if (newArr[i - 2] != newArr[i - 1] && newArr[i - 1] != newArr[i]) {
				ans++;
			}
		}

		return ans;
	}
}