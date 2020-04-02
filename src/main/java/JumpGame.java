import common.LeetCode;

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

	public static void main(String[] args)
	{
		System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
		System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
	}
}
