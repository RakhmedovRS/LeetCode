package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;

/**
 * @author RakhmedovRS
 * @created 7/28/2021
 */
@LeetCode(
		id = 932,
		name = "Beautiful Array",
		url = "https://leetcode.com/problems/beautiful-array/",
		difficulty = Difficulty.MEDIUM
)
public class BeautifulArray
{
	public int[] beautifulArray(int N)
	{
		ArrayList<Integer> res = new ArrayList<>();
		res.add(1);
		while (res.size() < N)
		{
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int i : res)
				if (i * 2 - 1 <= N)
				{
					tmp.add(i * 2 - 1);
				}
			for (int i : res)
				if (i * 2 <= N)
				{
					tmp.add(i * 2);
				}
			res = tmp;
		}

		int[] result = new int[res.size()];
		for (int i = 0; i < result.length; i++)
		{
			result[i] = res.get(i);
		}

		return result;
	}
}
