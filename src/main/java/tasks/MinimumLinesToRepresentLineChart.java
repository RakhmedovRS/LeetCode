package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author RakhmedovRS
 * @created 5/22/2022
 */
@LeetCode(
		id = 2280,
		name = "Minimum Lines to Represent a Line Chart",
		url = "https://leetcode.com/problems/minimum-lines-to-represent-a-line-chart/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumLinesToRepresentLineChart {
	public int minimumLines(int[][] stockPrices) {
		if (stockPrices.length < 2) {
			return 0;
		}

		Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
		int count = 1;

		for (int i = 1; i < stockPrices.length - 1; i++) {
			int x1 = stockPrices[i - 1][0];
			int y1 = stockPrices[i - 1][1];
			int x = stockPrices[i][0];
			int y = stockPrices[i][1];
			int x2 = stockPrices[i + 1][0];
			int y2 = stockPrices[i + 1][1];
			if (collinear(x1, y1, x, y, x2, y2)) {
				continue;
			}
			count++;
		}
		return count;
	}

	private boolean collinear(int x1, int y1, int x2, int y2, int x3, int y3) {

		int a = x1 * (y2 - y3) +
				x2 * (y3 - y1) +
				x3 * (y1 - y2);

		return a == 0;
	}
}
