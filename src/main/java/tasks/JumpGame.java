package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 02-Apr-20
 */
@LeetCode(id = 55, name = "Jump Game", url = "https://leetcode.com/problems/jump-game/")
public class JumpGame
{
	public boolean canJump(int[] nums)
	{
		int goodPos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--)
		{
			if (i + nums[i] >= goodPos)
			{
				goodPos = i;
			}
		}

		return goodPos == 0;
	}

	public boolean canJump1(int[] nums)
	{
		return canJump(nums, nums.length - 1);
	}

	private boolean canJump(int[] nums, int currentPos)
	{
		if (currentPos == 0)
		{
			return true;
		}

		for (int i = 0; i < currentPos; i++)
		{
			if (nums[i] >= currentPos - i)
			{
				return canJump(nums, i);
			}
		}

		return false;
	}

	public boolean canJump2(int[] nums)
	{
		boolean[] memo = new boolean[nums.length];
		Arrays.fill(memo, true);
		return canJump(nums, 0, memo);
	}

	private boolean canJump(int[] nums, int startPos, boolean[] memo)
	{
		if (startPos >= nums.length - 1)
		{
			return true;
		}

		if (!memo[startPos])
		{
			return false;
		}

		for (int i = nums[startPos]; i > 0; i--)
		{
			if (!canJump(nums, startPos + i, memo))
			{
				memo[startPos] = false;
			}
			else
			{
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
		System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
	}
}
