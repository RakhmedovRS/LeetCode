package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/23/2021
 */
@LeetCode(
		id = 1182,
		name = "Shortest Distance to Target Color",
		url = "https://leetcode.com/problems/shortest-distance-to-target-color/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class ShortestDistanceToTargetColor
{
	public List<Integer> shortestDistanceColor(int[] colors, int[][] queries)
	{
		int[][] left = new int[colors.length][3];
		int[][] right = new int[colors.length][3];

		left[0] = new int[]{-1, -1, -1};
		right[colors.length - 1] = new int[]{-1, -1, -1};

		for (int i = 0; i < colors.length; i++)
		{
			if (i > 0)
			{
				left[i] = Arrays.copyOf(left[i - 1], 3);
			}

			left[i][colors[i] - 1] = i;
		}

		for (int i = colors.length - 1; i >= 0; i--)
		{
			if (i < colors.length - 1)
			{
				right[i] = Arrays.copyOf(right[i + 1], 3);
			}

			right[i][colors[i] - 1] = i;
		}

		List<Integer> answer = new ArrayList<>();
		for (int[] query : queries)
		{
			int pos = query[0];
			int color = query[1] - 1;

			if (left[pos][color] != -1 && right[pos][color] != -1)
			{
				answer.add(Math.min(pos - left[pos][color], right[pos][color] - pos));
			}
			else if (left[pos][color] != -1)
			{
				answer.add(pos - left[pos][color]);
			}
			else if (right[pos][color] != -1)
			{
				answer.add(right[pos][color] - pos);
			}
			else
			{
				answer.add(-1);
			}
		}

		return answer;
	}
}
