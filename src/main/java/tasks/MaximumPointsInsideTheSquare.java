package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-05-11
 */
@LeetCode(
		id = 3143,
		name = "Maximum Points Inside the Square",
		url = "https://leetcode.com/problems/maximum-points-inside-the-square/description/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumPointsInsideTheSquare {
	class Point {
		int[] coordinates;
		char tag;

		public Point(int x, int y, char tag) {
			this.coordinates = new int[]{x, y};
			this.tag = tag;
		}
	}

	public int maxPointsInsideSquare1(int[][] points, String s) {
		List<Point> pointsList = new ArrayList<>();
		for (int i = 0; i < points.length; i++) {
			pointsList.add(new Point(points[i][0], points[i][1], s.charAt(i)));
		}

		int[] origin = new int[]{0, 0};
		pointsList.sort((a, b) -> manhattanDistance(origin, a.coordinates) - manhattanDistance(origin, b.coordinates));
		int pos = 0;
		int max = 0;
		Set<Character> used = new HashSet<>();
		while (pos < pointsList.size()) {
			Point p = pointsList.get(pos++);
			if (!used.add(p.tag)) {
				break;
			}

			int distance = manhattanDistance(origin, p.coordinates);
			while (pos < pointsList.size() && distance == manhattanDistance(origin, pointsList.get(pos).coordinates)) {
				if (!used.add(pointsList.get(pos++).tag)) {
					break;
				}
			}

			max = used.size();
		}

		return max;
	}

	public int maxPointsInsideSquare(int[][] points, String s) {
		List<Point> pointsList = new ArrayList<>();
		for (int i = 0; i < points.length; i++) {
			pointsList.add(new Point(points[i][0], points[i][1], s.charAt(i)));
		}

		int[] origin = new int[]{0, 0};
		pointsList.sort((a, b) -> manhattanDistance(origin, a.coordinates) - manhattanDistance(origin, b.coordinates));
		int max = 0;
		int left = 0;
		int right = 1_000_000_001;
		while (left <= right) {
			int mid = (left + right) / 2;
			int res = pointsFit(pointsList, mid);
			if (res < 0) {
				right = mid - 1;
			} else {
				max = res;
				left = mid + 1;
			}
		}

		return max;
	}

	private int pointsFit(List<Point> points, int dist) {
		Set<Character> seen = new HashSet<>();
		int[] leftTop = new int[]{-dist, dist};
		int[] rightTop = new int[]{dist, dist};
		int[] leftBottom = new int[]{-dist, -dist};
		int[] rightBottom = new int[]{dist, -dist};

		for (Point p : points) {
			int x = p.coordinates[0];
			int y = p.coordinates[1];
			if (leftTop[0] <= x && leftTop[1] >= y
					&& x <= rightTop[0] && y <= rightTop[1]
					&& leftBottom[0] <= x && leftBottom[1] <= y
					&& rightBottom[0] >= x && y >= rightBottom[1]
			) {
				if (!seen.add(p.tag)) {
					return -1;
				}
			}
		}

		return seen.size();
	}

	public static int manhattanDistance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}