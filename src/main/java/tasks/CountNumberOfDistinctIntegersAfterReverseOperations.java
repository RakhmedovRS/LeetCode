package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 10/18/2022
 */
@LeetCode(
		id = 2442,
		name = "Count Number of Distinct Integers After Reverse Operations",
		url = "https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/",
		difficulty = Difficulty.MEDIUM
)
public class CountNumberOfDistinctIntegersAfterReverseOperations
{
	public int countDistinctIntegers(int[] nums)
	{
		Set<Integer> vals = new HashSet<>();
		for (int num : nums)
		{
			vals.add(num);
			vals.add(Integer.parseInt(new StringBuilder("" + num).reverse().toString()));
		}

		return vals.size();
	}
}
