import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 18-Aug-20
 */
@LeetCode(id = 1049, name = "Last Stone Weight II", url = "https://leetcode.com/problems/last-stone-weight-ii/")
public class LastStoneWeightII
{
	public int lastStoneWeightII(int[] stones)
	{
		Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
		int totalWeight = 0;
		for (int stone : stones)
		{
			totalWeight += stone;
		}

		return calcWeight(stones, 0, 0, totalWeight, memo);
	}

	private int calcWeight(int[] stones, int pos, int currentWeight, int totalWeight, Map<Integer, Map<Integer, Integer>> memo)
	{
		if (pos == stones.length)
		{
			return Math.abs(totalWeight - currentWeight);
		}

		if (memo.containsKey(currentWeight) && memo.get(currentWeight).containsKey(totalWeight))
		{
			return memo.get(currentWeight).get(totalWeight);
		}

		int min = Math.min(calcWeight(stones, pos + 1, currentWeight + stones[pos], totalWeight - stones[pos], memo),
			calcWeight(stones, pos + 1, currentWeight, totalWeight, memo));

		memo.putIfAbsent(currentWeight, new HashMap<>());
		memo.get(currentWeight).put(totalWeight, min);
		return min;
	}
}
