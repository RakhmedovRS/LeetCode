package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 10.03.2021
 */
@LeetCode(
		id = 1465,
		name = "Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts",
		url = "https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumAreaOfPieceOfCakeAfterHorizontalAndVerticalCuts {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		List<Integer> hs = new ArrayList<>();
		hs.add(0);
		hs.add(h);
		for (int num : horizontalCuts) {
			hs.add(num);
		}

		List<Integer> ws = new ArrayList<>();
		ws.add(0);
		ws.add(w);
		for (int num : verticalCuts) {
			ws.add(num);
		}

		long hMax = 0;
		long wMax = 0;

		hs.sort(null);
		ws.sort(null);
		for (int i = 1; i < hs.size(); i++) {
			hMax = Math.max(hMax, hs.get(i) - hs.get(i - 1));
		}

		for (int i = 1; i < ws.size(); i++) {
			wMax = Math.max(wMax, ws.get(i) - ws.get(i - 1));
		}

		return (int) ((hMax * wMax) % 1_000_000_007);
	}
}
