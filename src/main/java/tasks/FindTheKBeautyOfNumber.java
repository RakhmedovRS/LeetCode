package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/14/2022
 */
@LeetCode(
	id = 2269,
	name = "Find the K-Beauty of a Number",
	url = "https://leetcode.com/problems/find-the-k-beauty-of-a-number/",
	difficulty = Difficulty.EASY
)
public class FindTheKBeautyOfNumber
{
	public int divisorSubstrings(int num, int k) {
		int res = 0;
		String n = "" + num;
		for (int i = 0; i < n.length(); i++)
		{
			int d = 0;
			for (int j = 0; j < k && j + i < n.length(); j++)
			{
				d *= 10;
				d += (n.charAt(i + j) - '0');

				if (j + 1 == k && d != 0)
				{
					if (num % d == 0)
					{
						res++;
					}
				}
			}
		}

		return res;
	}
}
