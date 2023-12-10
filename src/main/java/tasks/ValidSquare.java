package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11/11/2020
 */
@LeetCode(id = 593, name = "Valid Square", url = "https://leetcode.com/problems/valid-square/")
public class ValidSquare {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		List<int[]> points = Arrays.asList(p1, p2, p3, p4);

		points.sort((a, b) ->
		{
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}

			return a[0] - b[0];
		});

		p1 = points.get(0);
		p2 = points.get(1);
		p3 = points.get(2);
		p4 = points.get(3);

		if ((p1[0] == p2[0] && p1[1] == p2[1])
				|| (p2[0] == p3[0] && p2[1] == p3[1])
				|| (p3[0] == p4[0] && p3[1] == p4[1])
		) {
			return false;
		}

		return distance(p1, p2) == distance(p1, p3)
				&& distance(p4, p2) == distance(p4, p3)
				&& distance(p1, p4) == distance(p2, p3);
	}

	private double distance(int[] aPoint, int[] bPoint) {
		return Math.sqrt(Math.pow(bPoint[0] - aPoint[0], 2) + Math.pow(bPoint[1] - aPoint[1], 2));
	}
}
