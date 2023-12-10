package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/23/2020
 */
@LeetCode(
		id = 223,
		name = "Rectangle Area",
		url = "https://leetcode.com/problems/rectangle-area/",
		difficulty = Difficulty.MEDIUM
)
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int areaA = (C - A) * (D - B);
		int areaB = (G - E) * (H - F);
		int overlap = 0;
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int top = Math.min(D, H);
		int bottom = Math.max(B, F);

		if (right > left && top > bottom) {
			overlap = (right - left) * (top - bottom);
		}

		return areaA + areaB - overlap;
	}
}
