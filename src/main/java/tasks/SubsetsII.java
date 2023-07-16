package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 22-Apr-20
 */
@LeetCode(
		id = 90,
		name = "Subsets II",
		url = "https://leetcode.com/problems/subsets-ii/",
		difficulty = Difficulty.MEDIUM
)
public class SubsetsII
{
	public List<List<Integer>> subsetsWithDup(int[] nums)
	{
		Arrays.sort(nums);
		Set<List<Integer>> set = new HashSet<>();
		List<List<Integer>> answer = new ArrayList<>();
		answer.add(new ArrayList<>());
		for (int num : nums)
		{
			int size = answer.size();
			for (int i = 0; i < size; i++)
			{
				List<Integer> list = new ArrayList<>(answer.get(i));
				list.add(num);

				if (set.add(list))
				{
					answer.add(list);
				}
			}
		}

		return answer;
	}
}
