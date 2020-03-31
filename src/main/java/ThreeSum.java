import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 31-Mar-20
 */
@LeetCode(id = 15, name = "3Sum", url = "https://leetcode.com/problems/3sum/")
public class ThreeSum
{
	public List<List<Integer>> threeSum(int[] nums)
	{
		Set<List<Integer>> res = new HashSet<>();
		if (nums.length == 0)
		{
			return new ArrayList<>(res);
		}
		Arrays.sort(nums);
		for (int first = 0; first < nums.length - 2; first++)
		{
			if (nums[first] >= 0)
			{
				break;
			}
			int second = first + 1;
			int third = nums.length - 1;
			while (second < third)
			{
				int sum = nums[first] + nums[second] + nums[third];
				if (sum == 0)
				{
					res.add(Arrays.asList(nums[first], nums[second++], nums[third--]));
				}
				else if (sum > 0)
				{
					third--;
				}
				else if (sum < 0)
				{
					second++;
				}
			}
		}
		return new ArrayList<>(res);
	}

	public static void main(String[] args)
	{
		System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0}));
		System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}
}
