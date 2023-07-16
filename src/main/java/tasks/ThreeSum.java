package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 31-Mar-20
 */
@LeetCode(id = 15, name = "3Sum", url = "https://leetcode.com/problems/3sum/")
public class ThreeSum
{
	public List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> answer = new ArrayList<>();
		if (nums.length < 3)
		{
			return answer;
		}

		Arrays.sort(nums);
		int val;
		int right;
		for (int left = 0; left < nums.length - 2 && nums[left] <= 0; left++)
		{
			if (left != 0 && nums[left - 1] == nums[left])
			{
				continue;
			}

			for (int middle = left + 1; middle < nums.length - 1; middle++)
			{
				val = 0 - nums[left] - nums[middle];
				right = binarySearch(nums, middle + 1, nums.length - 1, val);
				if (right != -1)
				{
					if (answer.isEmpty() ||
							(answer.get(answer.size() - 1).get(0) != nums[left]
									|| answer.get(answer.size() - 1).get(1) != nums[middle]
									|| answer.get(answer.size() - 1).get(2) != nums[right]
							)
					)
					{
						answer.add(Arrays.asList(nums[left], nums[middle], nums[right]));
					}
				}
			}
		}

		return answer;
	}

	private int binarySearch(int[] nums, int left, int right, int searchValue)
	{
		int middle;
		while (left <= right)
		{
			middle = (left + right) / 2;
			if (nums[middle] == searchValue)
			{
				return middle;
			}
			else if (nums[middle] > searchValue)
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0}));
		System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}
}
