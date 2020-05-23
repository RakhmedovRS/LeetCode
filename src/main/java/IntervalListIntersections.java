import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 23-May-20
 */
@LeetCode(id = 986, name = "Interval List Intersections", url = "https://leetcode.com/problems/interval-list-intersections/")
public class IntervalListIntersections
{
	public int[][] intervalIntersection(int[][] A, int[][] B)
	{
		if (A == null || A.length == 0)
		{
			return new int[0][];
		}
		else if (B == null || B.length == 0)
		{
			return new int[0][];
		}

		int aCounter = 0;
		int bCounter = 0;
		List<int[]> intersections = new ArrayList<>();
		while (aCounter < A.length && bCounter < B.length)
		{
			int[] a = A[aCounter];
			int[] b = B[bCounter];

			int[] intersection = new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};

			if (intersection[0] <= intersection[1])
			{
				intersections.add(intersection);
			}

			if (a[1] == intersection[1])
			{
				aCounter++;
			}
			else
			{
				bCounter++;
			}
		}

		int[][] answer = new int[intersections.size()][];
		for (int i = 0; i < intersections.size(); i++)
		{
			answer[i] = intersections.get(i);
		}

		return answer;
	}

	public static void main(String[] args)
	{
		int[][] A = new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}};
		int[][] B = new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 25}};

		System.out.println(Arrays.deepToString(new IntervalListIntersections().intervalIntersection(A, B)));
	}
}
