package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 24-Apr-20
 */
@LeetCode(id = 1051, name = "Height Checker", url = "https://leetcode.com/problems/height-checker/")
public class HeightChecker {
	public int heightChecker(int[] heights) {
		int[] pre = Arrays.copyOf(heights, heights.length);
		Arrays.sort(heights);
		int ans = 0;
		for (int i = 0; i < heights.length; i++) {
			if (pre[i] != heights[i]) {
				ans++;
			}
		}
		return ans;
	}
}
