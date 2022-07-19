package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 7/19/2022
 */
@LeetCode(
	id = 2343,
	name = "Query Kth Smallest Trimmed Number",
	url = "https://leetcode.com/problems/query-kth-smallest-trimmed-number/",
	difficulty = Difficulty.MEDIUM
)
public class QueryKthSmallestTrimmedNumber
{
	public int[] smallestTrimmedNumbers(String[] nums, int[][] queries)
	{
		int[] answer = new int[queries.length];
		Map<Integer, char[]> chars = new HashMap<>();
		List<Integer> indices = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
		{
			chars.put(i, nums[i].toCharArray());
			indices.add(i);
		}

		for (int i = 0; i < queries.length; i++)
		{
			int pos = queries[i][0];
			int trim = queries[i][1];

			indices.sort((a, b) ->
			{
				char[] aS = chars.get(a);
				char[] bS = chars.get(b);

				int t = trim;
				for (int j = aS.length - t; j < aS.length; j++)
				{
					if ((aS[j] - '0') > (bS[j] - '0'))
					{
						return 1;
					}
					else if ((bS[j] - '0') > (aS[j] - '0'))
					{
						return -1;
					}
				}

				return a - b;
			});

			answer[i] = indices.get(pos - 1);
		}

		return answer;
	}
}
