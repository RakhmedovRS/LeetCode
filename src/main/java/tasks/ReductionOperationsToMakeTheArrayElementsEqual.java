package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 6/6/2021
 */
@LeetCode(
	id = 1887,
	name = "Reduction Operations to Make the Array Elements Equal",
	url = "https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/",
	difficulty = Difficulty.MEDIUM
)
public class ReductionOperationsToMakeTheArrayElementsEqual
{
	public int reductionOperations(int[] nums)
	{
		int operations = 0;
		TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

		for (int num : nums)
		{
			treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
		}

		while (treeMap.size() != 1)
		{
			int current = treeMap.firstKey();
			int count = treeMap.remove(current);
			int next = treeMap.firstKey();
			treeMap.put(next, treeMap.get(next) + count);
			operations += count;
		}

		return operations;
	}
}
