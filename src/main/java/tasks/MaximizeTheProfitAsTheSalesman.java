package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Ruslan Rakhmedov
 * @created 8/19/2023
 */
@LeetCode(
		id = 2830,
		name = "Maximize the Profit as the Salesman",
		url = "https://leetcode.com/problems/maximize-the-profit-as-the-salesman/",
		difficulty = Difficulty.MEDIUM
)
public class MaximizeTheProfitAsTheSalesman
{
	public int maximizeTheProfit(int n, List<List<Integer>> offers)
	{
		TreeMap<Integer, List<int[]>> map = new TreeMap<>();
		for (List<Integer> offer: offers)
		{
			map.putIfAbsent(offer.get(0), new ArrayList<>());
			map.get(offer.get(0)).add(new int[]{offer.get(1), offer.get(2)});
		}

		TreeMap<Integer, Integer> memo = new TreeMap<>();

		dfs(map.lastKey(), map, memo);

		return memo.firstEntry().getValue();
	}

	private void dfs(Integer pos, TreeMap<Integer, List<int[]>> map, TreeMap<Integer, Integer> memo)
	{
		if (pos == null)
		{
			return;
		}

		List<int[]> list = map.floorEntry(pos).getValue();
		int max = 0;
		for (int[] pair: list)
		{
			int end = pair[0];
			int gold = pair[1];

			Map.Entry<Integer, Integer> entry = memo.ceilingEntry(end + 1);
			Integer prev = entry == null ? null : entry.getValue();
			max = Math.max(max, gold + (prev == null ? 0 : prev));

			Map.Entry<Integer, Integer> entryD = memo.firstEntry();
			Integer prevD = entryD == null ? null : entryD.getValue();
			max = Math.max(max, prevD == null ? 0 : prevD);
		}

		memo.put(pos, max);

		dfs(map.floorKey(pos - 1), map, memo);
	}
}
