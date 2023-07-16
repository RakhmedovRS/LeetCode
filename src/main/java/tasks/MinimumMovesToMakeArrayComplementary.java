package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/29/2020
 */
@LeetCode(
		id = 1674,
		name = "Minimum Moves to Make Array Complementary",
		url = "https://leetcode.com/problems/minimum-moves-to-make-array-complementary/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumMovesToMakeArrayComplementary
{
	public int minMoves(int[] nums, int limit)
	{
		int[] diffs = new int[2 * limit + 2];
		for (int i = 0, j = nums.length - 1; i < j; i++, j--)
		{
			diffs[2] += 2;
			diffs[Math.min(nums[i], nums[j]) + 1]--;
			diffs[nums[i] + nums[j]]--;
			diffs[nums[i] + nums[j] + 1]++;
			diffs[Math.max(nums[i], nums[j]) + limit + 1]++;
		}

		int minSteps = 2 * nums.length;
		int current = 0;
		for (int i = 2; i <= 2 * limit; i++)
		{
			current += diffs[i];
			minSteps = Math.min(minSteps, current);
		}

		return minSteps;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumMovesToMakeArrayComplementary().minMoves(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1)); //0
		System.out.println(new MinimumMovesToMakeArrayComplementary().minMoves(new int[]{1, 3, 1, 1, 1, 2, 3, 2, 3, 1, 3, 2, 1, 3}, 3)); //4
		System.out.println(new MinimumMovesToMakeArrayComplementary().minMoves(new int[]{1, 2, 2, 2, 2, 2, 2, 2}, 2)); //1
		System.out.println(new MinimumMovesToMakeArrayComplementary().minMoves(new int[]{1, 2, 2, 1}, 2)); //2
		System.out.println(new MinimumMovesToMakeArrayComplementary().minMoves(new int[]{1, 2, 4, 3}, 4)); //1
		System.out.println(new MinimumMovesToMakeArrayComplementary().minMoves(new int[]{1, 2, 1, 2}, 2)); //0
	}
}
