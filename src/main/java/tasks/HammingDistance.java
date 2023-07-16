package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 31-Mar-20
 */
@LeetCode(
		id = 461,
		name = "Hamming Distance",
		url = "https://leetcode.com/problems/hamming-distance/",
		difficulty = Difficulty.EASY
)
public class HammingDistance
{
	public int hammingDistance(int x, int y)
	{
		int count = 0;
		while (x != 0 || y != 0)
		{

			count += ((1 & x) == (1 & y) ? 0 : 1);

			x = x >> 1;
			y = y >> 1;
		}
		return count;
	}

	public static void main(String[] args)
	{
		System.out.println(new HammingDistance().hammingDistance(1, 4));
	}
}
