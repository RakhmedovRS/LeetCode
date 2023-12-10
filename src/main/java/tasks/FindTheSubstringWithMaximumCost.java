package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 5/7/2023
 */
@LeetCode(
		id = 2606,
		name = "Find the Substring With Maximum Cost",
		url = "https://leetcode.com/problems/find-the-substring-with-maximum-cost/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheSubstringWithMaximumCost {
	public int maximumCostSubstring(String s, String chars, int[] vals) {
		int[] price = new int[26];
		for (int i = 0; i < price.length; i++) {
			price[i] = i + 1;
		}

		int ans = 0;
		for (int i = 0; i < chars.length(); i++) {
			price[chars.charAt(i) - 'a'] = vals[i];
		}

		int curr = 0;
		for (int right = 0; right < s.length(); ) {
			curr += price[s.charAt(right++) - 'a'];
			if (curr < 0) {
				curr = 0;
			}
			ans = Math.max(ans, curr);
		}

		return ans;
	}
}
