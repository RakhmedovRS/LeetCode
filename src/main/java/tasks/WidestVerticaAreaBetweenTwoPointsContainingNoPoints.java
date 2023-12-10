package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author RakhmedovRS
 * @created 10/31/2020
 */
@LeetCode(id = 1637, name = "Widest Vertical Area Between Two Points Containing No Points", url = "https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/")
public class WidestVerticaAreaBetweenTwoPointsContainingNoPoints {
	public int maxWidthOfVerticalArea(int[][] points) {
		Arrays.sort(points, Comparator.comparingInt(arr -> arr[0]));
		int max = 0;
		for (int i = 1; i < points.length; i++) {
			max = Math.max(max, points[i][0] - points[i - 1][0]);
		}

		return max;
	}
}
