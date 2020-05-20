import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 20-May-20
 */
@LeetCode(id = 398, name = "Random Pick Index", url = "https://leetcode.com/problems/random-pick-index/")
public class RandomPickIndex
{
	class Solution
	{
		private Map<Integer, List<Integer>> values;
		private Random random;

		public Solution(int[] nums)
		{
			random = new Random();
			values = new HashMap<>();
			for (int i = 0; i < nums.length; i++)
			{
				List<Integer> indices = values.getOrDefault(nums[i], new ArrayList<>());
				indices.add(i);
				values.put(nums[i], indices);
			}
		}

		public int pick(int target)
		{
			List<Integer> indices = values.get(target);
			return indices.get(random.nextInt(indices.size()));
		}
	}
}
