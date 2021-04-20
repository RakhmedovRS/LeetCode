package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 25-Mar-20
 */
@LeetCode(id = 16, name = "3Sum Closest", url = "https://leetcode.com/problems/3sum-closest/")
public class ThreeSumClosest
{
	public int threeSumClosest(int[] nums, int target)
	{
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int closest = -1;
		int sum;
		int currentDiff;
		for (int left = 0; left < nums.length - 2; left++)
		{
			int middle = left + 1;
			int right = nums.length - 1;
			while (middle != right)
			{
				sum = nums[left] + nums[middle] + nums[right];
				currentDiff = Math.abs(target - sum);
				if (currentDiff < diff)
				{
					closest = sum;
					diff = currentDiff;
				}

				if (sum > target)
				{
					right--;
				}
				else
				{
					middle++;
				}
			}
		}

		return closest;
	}

	public static void main(String[] args)
	{
		System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82)); //82
		System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); //2
	}
}
