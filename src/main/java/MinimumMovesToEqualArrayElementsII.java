import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 9/24/2020
 */
@LeetCode(id = 462, name = "Minimum Moves to Equal Array Elements II", url = "https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/")
public class MinimumMovesToEqualArrayElementsII
{
	public int minMoves2(int[] nums)
	{
		int moves = 0;
		Arrays.sort(nums);
		int middle = nums[nums.length / 2];
		for (int num : nums)
		{
			moves += Math.abs(num - nums[middle]);
		}

		return moves;
	}
}
