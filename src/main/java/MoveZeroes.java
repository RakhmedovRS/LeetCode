/**
 * Move Zeroes
 * LeetCode 283
 *
 * @author RakhmedovRS
 * @created 03-Mar-20
 */
public class MoveZeroes
{
	public void moveZeroes(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return;
		}

		int startPos = 0;
		int countOfZeros = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] == 0)
			{
				countOfZeros++;
			}
			else
			{
				nums[startPos] = nums[i];
				startPos++;
			}
		}

		for (int i = nums.length - 1; countOfZeros > 0; i--, countOfZeros--)
		{
			nums[i] = 0;
		}
	}
}
