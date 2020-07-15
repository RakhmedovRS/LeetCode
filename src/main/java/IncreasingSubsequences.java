import common.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 15-Jul-20
 */
@LeetCode(id = 491, name = "Increasing Subsequences", url = "https://leetcode.com/problems/increasing-subsequences/")
public class IncreasingSubsequences
{
	public List<List<Integer>> findSubsequences(int[] nums)
	{
		List<List<List<Integer>>> memo = new ArrayList<>();
		for (int num : nums)
		{
			List<Integer> values = new ArrayList<>();
			values.add(num);
			List<List<Integer>> sub = new ArrayList<>();
			sub.add(values);
			memo.add(sub);
		}

		Set<String> seen = new HashSet<>();
		List<List<Integer>> answer = new ArrayList<>();
		for (int right = 1; right < nums.length; right++)
		{
			for (int left = 0; left < right; left++)
			{
				if (nums[left] <= nums[right])
				{
					for (List<Integer> values : memo.get(left))
					{
						List<Integer> newSeq = new ArrayList<>(values);
						newSeq.add(nums[right]);
						if (seen.add(newSeq.toString()))
						{
							answer.add(newSeq);
						}
						memo.get(right).add(newSeq);
					}
				}
			}
		}

		return answer;
	}
}
