import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
		List<List<Integer>> res = new LinkedList<>();
		if (nums.length == 0)
		{
			return new ArrayList<>(res);
		}
		Arrays.sort(nums);
		for (int first = 0; first < nums.length - 2; first++)
		{
			if (nums[first] > 0)
			{
				break;
			}

			if (first > 0 && nums[first - 1] == nums[first])
			{
				continue;
			}

			int second = first + 1;
			int third = nums.length - 1;
			while (second < third)
			{
				int sum = nums[first] + nums[second] + nums[third];
				if (sum == 0)
				{
					res.add(Arrays.asList(nums[first], nums[second], nums[third]));
					while (second + 1 < third && nums[second] == nums[second + 1])
					{
						second++;
					}
					while (third - 1 > second && nums[third] == nums[third - 1])
					{
						third--;
					}
					second++;
					third--;
				}
				else if (sum > 0)
				{
					third--;
				}
				else
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
