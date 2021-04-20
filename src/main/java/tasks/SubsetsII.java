package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 22-Apr-20
 */
@LeetCode(id = 90, name = "tasks.Subsets II", url = "https://leetcode.com/problems/subsets-ii/")
public class SubsetsII
{
	public List<List<Integer>> subsetsWithDup(int[] nums)
	{
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		req(result, 0, new ArrayList<>(), nums);

		return result;
	}

	private void req(List<List<Integer>> result, int startPos, List<Integer> temp, int[] nums)
	{
		for (int i = startPos; i < nums.length; i++)
		{
			if (i > startPos && nums[i] == nums[i-1])
			{
				continue;
			}
			temp.add(nums[i]);
			result.add(new ArrayList<>(temp));
			req(result, i + 1, temp, nums);
			temp.remove(temp.size() - 1);
		}
	}

	public List<List<Integer>> subsetsWithDup1(int[] nums)
	{
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		List<StringBuilder> builderList = new ArrayList<>();
		result.add(new ArrayList<>());
		builderList.add(new StringBuilder());
		Set<String> cache = new HashSet<>();
		for (int num : nums)
		{
			int size = result.size();
			for (int i = 0; i < size; i++)
			{
				StringBuilder sb = new StringBuilder(builderList.get(i));
				List<Integer> newList = new ArrayList<>(result.get(i));
				sb.append(num);
				newList.add(num);
				if (cache.add(sb.toString()))
				{
					builderList.add(sb);
					result.add(newList);
				}
			}
		}

		return result;
	}
}
