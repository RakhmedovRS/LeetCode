import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 13-Jun-20
 */
@LeetCode(id = 368, name = "Largest Divisible Subset", url = "https://leetcode.com/problems/largest-divisible-subset/")
public class LargestDivisibleSubset
{
	public List<Integer> largestDivisibleSubset(int[] nums)
	{
		Map<Integer, List<Integer>> memo = new HashMap<>();
		Arrays.sort(nums);
		return largestDivisibleSubset(nums, 0, new HashMap<>());
	}

	private List<Integer> largestDivisibleSubset(int[] nums, int pos, Map<Integer, List<Integer>> memo)
	{
		if (memo.containsKey(pos))
		{
			return memo.get(pos);
		}

		List<Integer> maxList = new ArrayList<>();
		int div = pos == 0 ? 1 : nums[pos - 1];
		for (int i = pos; i < nums.length; i++)
		{
			if (nums[i] % div == 0)
			{
				List<Integer> temp = new ArrayList<>(largestDivisibleSubset(nums, i + 1, memo));
				temp.add(nums[i]);
				if (temp.size() > maxList.size())
				{
					maxList = temp;
				}
			}
		}

		memo.put(pos, maxList);
		return maxList;
	}
}
