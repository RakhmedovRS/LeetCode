package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 25-Mar-20
 */
@LeetCode(
		id = 16,
		name = "3Sum Closest",
		url = "https://leetcode.com/problems/3sum-closest/",
		difficulty = Difficulty.MEDIUM
)
public class ThreeSumClosest
{
	public int threeSumClosest(int[] nums, int target)
	{
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int num : nums)
		{
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Arrays.sort(nums);

		int closest = 1_000_000_000;
		for (int i = 0; i < nums.length; i++)
		{
			int countI = map.remove(nums[i]);
			if (countI - 1 > 0)
			{
				map.put(nums[i], countI - 1);
			}
			for (int j = i + 1; j < nums.length; j++)
			{
				int countJ = map.remove(nums[j]);
				if (countJ - 1 > 0)
				{
					map.put(nums[j], countJ - 1);
				}

				Integer left = map.ceilingKey(target - (nums[i] + nums[j]));
				Integer right = map.floorKey(target - (nums[i] + nums[j]));
				if (left != null)
				{
					if (Math.abs(target - closest) > Math.abs(target - (left + nums[i] + nums[j])))
					{
						closest = left + nums[i] + nums[j];
					}
				}

				if (right != null)
				{
					if (Math.abs(target - closest) > Math.abs(target - (right + nums[i] + nums[j])))
					{
						closest = right + nums[i] + nums[j];
					}
				}

				map.put(nums[j], countJ);
			}

			map.put(nums[i], countI);
		}

		return closest;
	}

	public static void main(String[] args)
	{
		System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82)); //82
		System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); //2
	}
}
