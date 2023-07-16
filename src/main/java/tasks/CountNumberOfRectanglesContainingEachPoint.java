package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 4/24/2022
 */
@LeetCode(
		id = 2250,
		name = "Count Number of Rectangles Containing Each Point",
		url = "https://leetcode.com/problems/count-number-of-rectangles-containing-each-point/",
		difficulty = Difficulty.MEDIUM
)
public class CountNumberOfRectanglesContainingEachPoint
{
	public int[] countRectangles(int[][] rectangles, int[][] points)
	{
		TreeMap<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());
		for (int[] rectangle : rectangles)
		{
			int l = rectangle[0];
			int h = rectangle[1];

			map.putIfAbsent(h, new ArrayList<>());
			map.get(h).add(l);
		}

		for (List<Integer> list : map.values())
		{
			list.add(0);
			list.sort(null);
		}

		int[] answer = new int[points.length];
		for (int i = 0; i < points.length; i++)
		{
			int x = points[i][0];
			int y = points[i][1];
			for (Integer j : map.keySet())
			{
				if (j < y)
				{
					break;
				}

				List<Integer> list = map.getOrDefault(j, Collections.emptyList());
				int left = 0;
				int mid;
				int right = list.size() - 1;
				while (left <= right)
				{
					mid = (left + right) / 2;
					if (list.get(mid) < x)
					{
						left = mid + 1;
					}
					else
					{
						right = mid - 1;
					}
				}

				answer[i] += Math.max(0, list.size() - left);
			}
		}

		return answer;
	}
}
