package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 9/12/2021
 */
@LeetCode(
		id = 2001,
		name = "Number of Pairs of Interchangeable Rectangles",
		url = "https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfPairsOfInterchangeableRectangles
{
	public long interchangeableRectangles(int[][] rectangles)
	{
		Map<String, Long> map = new HashMap<>();
		long answer = 0;
		for (int[] rectangle : rectangles)
		{
			int gcd = gcd(rectangle[0], rectangle[1]);

			String ratio = (rectangle[0] / gcd) + "/" + (rectangle[1] / gcd);
			map.put(ratio, map.getOrDefault(ratio, 0L) + 1);

			long count = map.get(ratio);
			if (count > 1)
			{
				answer += count - 1;
			}
		}

		return answer;
	}

	private int gcd(int x, int y)
	{
		if (y == 0)
		{
			return x;
		}
		return gcd(y, x % y);
	}
}
