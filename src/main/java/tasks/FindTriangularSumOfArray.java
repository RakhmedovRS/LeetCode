package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 4/3/2022
 */
@LeetCode(
	id = 2221,
	name = "Find Triangular Sum of an Array",
	url = "https://leetcode.com/problems/find-triangular-sum-of-an-array/",
	difficulty = Difficulty.MEDIUM
)
public class FindTriangularSumOfArray
{
	public int triangularSum(int[] nums)
	{
		LinkedList<Integer> prevList = new LinkedList<>();
		for (int num : nums)
		{
			prevList.addLast(num);
		}

		while (prevList.size() > 1)
		{
			LinkedList<Integer> nextList = new LinkedList<>();
			int prevNum = prevList.removeFirst();
			while (!prevList.isEmpty())
			{
				nextList.addLast((prevNum + prevList.getFirst()) % 10);
				prevNum = prevList.removeFirst();
			}

			prevList = nextList;
		}

		return prevList.removeFirst();
	}
}
