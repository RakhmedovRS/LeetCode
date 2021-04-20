package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
@LeetCode(
	id = 334,
	name = "Increasing Triplet Subsequence",
	url = "https://leetcode.com/problems/increasing-triplet-subsequence/",
	difficulty = Difficulty.MEDIUM)
public class IncreasingTripletSubsequence
{
	public boolean increasingTriplet(int[] nums)
	{
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		for (int num : nums)
		{
			if (first >= num)
			{
				first = num;
			}
			else if (second > num)
			{
				second = num;
			}
			else if (num > second)
			{
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{1, 1, -2, 6}));
		System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
		System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
	}
}
