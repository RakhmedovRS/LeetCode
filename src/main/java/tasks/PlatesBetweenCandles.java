package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 10/30/2021
 */
@LeetCode(
		id = 2055,
		name = "Plates Between Candles",
		url = "https://leetcode.com/problems/plates-between-candles/",
		difficulty = Difficulty.MEDIUM
)
public class PlatesBetweenCandles
{
	public int[] platesBetweenCandles(String s, int[][] queries)
	{
		int[] memo = new int[s.length()];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '|')
			{
				list.add(i);
				memo[i]++;
			}
		}

		for (int i = 1; i < s.length(); i++)
		{
			memo[i] += memo[i - 1];
		}

		TreeSet<Integer> treeSet = new TreeSet<>(list);
		int[] answer = new int[queries.length];
		for (int i = 0; i < queries.length; i++)
		{
			int left = queries[i][0];
			int right = queries[i][1];

			Integer floor = treeSet.ceiling(left);
			Integer ceiling = treeSet.floor(right);

			if (floor != null && ceiling != null)
			{
				answer[i] = Math.max(0, (1 + ceiling - floor) - (memo[ceiling] - (floor == 0 ? 0 : memo[floor - 1])));
			}
		}

		return answer;
	}
}
