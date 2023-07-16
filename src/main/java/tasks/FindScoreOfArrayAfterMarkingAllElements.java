package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

@LeetCode(
		id = 2593,
		name = "Find Score of an Array After Marking All Elements",
		url = "https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/",
		difficulty = Difficulty.MEDIUM
)
public class FindScoreOfArrayAfterMarkingAllElements
{
	public long findScore(int[] nums)
	{
		Set<Integer> marked = new HashSet<>();
		TreeMap<Integer, LinkedList<Integer>> treeMap = new TreeMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			treeMap.putIfAbsent(nums[i], new LinkedList<>());
			treeMap.get(nums[i]).addLast(i);
		}

		long score = 0;
		while (marked.size() != nums.length)
		{
			Map.Entry<Integer, LinkedList<Integer>> entry = treeMap.firstEntry();
			while (!entry.getValue().isEmpty() && marked.contains(entry.getValue().getFirst()))
			{
				entry.getValue().removeFirst();
			}

			if (entry.getValue().isEmpty())
			{
				treeMap.remove(entry.getKey());
				continue;
			}

			int index = entry.getValue().removeFirst();
			marked.add(index);

			score += entry.getKey();

			if (index - 1 >= 0)
			{
				marked.add(index - 1);
			}
			if (index + 1 < nums.length)
			{
				marked.add(index + 1);
			}

			if (entry.getValue().isEmpty())
			{
				treeMap.remove(entry.getKey());
			}
		}

		return score;
	}
}
