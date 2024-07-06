package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-06
 */
@LeetCode(
		id = 3208,
		name = "Alternating Groups II",
		url = "https://leetcode.com/problems/alternating-groups-ii/description/",
		difficulty = Difficulty.MEDIUM
)
public class AlternatingGroupsII {
	public int numberOfAlternatingGroups(int[] colors, int k) {
		int[] newArr = new int[colors.length + k];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = colors[i % colors.length];
		}

		int ans = 0;
		int left = 1;
		int right = 1;
		while (right < newArr.length) {
			if (newArr[right - 1] != newArr[right]) {
				right++;
			} else {
				left = right;
				right++;
			}

			if (right - left >= k) {
				ans++;
			}
		}
		return ans;
	}
}