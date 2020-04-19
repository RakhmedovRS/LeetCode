import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 19-Apr-20
 */
@LeetCode(id = 27, name = "Remove Element", url = "https://leetcode.com/problems/remove-element/")
public class RemoveElement
{
	public int removeElement(int[] nums, int val)
	{
		int pos = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != val)
			{
				nums[pos++] = nums[i];
			}
		}

		return pos;
	}

	public static void main(String[] args)
	{
		int[] arr = new int[]{3, 2, 2, 3};
		int pos = new RemoveElement().removeElement(arr, 3);
		System.out.println(Arrays.toString(Arrays.copyOf(arr, pos)));
	}
}
