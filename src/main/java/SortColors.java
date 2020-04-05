import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 05-Apr-20
 */
@LeetCode(id = 75, name = "Sort Colors", url = "https://leetcode.com/problems/sort-colors/")
public class SortColors
{
	public void sortColors(int[] nums)
	{
		int zeroPos = 0;
		int twoPos = nums.length - 1;
		for (int i = 0; i <= twoPos; i++)
		{
			if (nums[i] == 0 && zeroPos != i)
			{
				swap(nums, zeroPos++, i--);
			}
			else if (nums[i] == 2 && i != twoPos)
			{
				swap(nums, twoPos--, i--);
			}
		}
	}

	private void swap(int[] nums, int first, int second)
	{
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}

	public void sortColors1(int[] nums)
	{
		int[] colors = new int[3];
		for (int num : nums)
		{
			colors[num]++;
		}

		int counter = 0;
		for (int i = 0; i < 3; i++)
		{
			while (colors[i]-- > 0)
			{
				nums[counter++] = i;
			}
		}
	}

	public static void main(String[] args)
	{
		int[] colors = new int[]{2, 0, 2, 1, 1, 0};
		new SortColors().sortColors(colors);
		System.out.println(Arrays.toString(colors));

		colors = new int[]{0};
		new SortColors().sortColors(colors);
		System.out.println(Arrays.toString(colors));
	}
}
