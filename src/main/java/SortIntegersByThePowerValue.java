import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 24-May-20
 */
@LeetCode(id = 1387, name = "Sort Integers by The Power Value", url = "https://leetcode.com/problems/sort-integers-by-the-power-value/")
public class SortIntegersByThePowerValue
{
	public int getKth(int lo, int hi, int k)
	{
		Map<Integer, Integer> powers = new HashMap<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((v1, v2) ->
		{
			int pow1 = powers.getOrDefault(v1, getSteps(v1, powers));
			int pow2 = powers.getOrDefault(v2, getSteps(v2, powers));
			return pow1 == pow2 ? v1 - v2 : pow1 - pow2;
		});

		while (lo <= hi)
		{
			minHeap.add(lo);
			lo++;
		}

		while (k-- > 1)
		{
			minHeap.remove();
		}
		return minHeap.peek();
	}

	private int getSteps(int value, Map<Integer, Integer> memo)
	{
		if (value == 1)
		{
			return 0;
		}

		if (memo.containsKey(value))
		{
			return memo.get(value);
		}

		int steps = 1;
		if (value % 2 == 0)
		{
			steps += getSteps(value / 2, memo);
		}
		else
		{
			steps += getSteps(3 * value + 1, memo);
		}

		memo.put(value, steps);
		return steps;
	}

	public static void main(String[] args)
	{
		System.out.println(new SortIntegersByThePowerValue().getKth(12, 15, 2));
		System.out.println(new SortIntegersByThePowerValue().getKth(10, 20, 5));
	}
}
