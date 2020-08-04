import common.LeetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 04-Aug-20
 */
@LeetCode(id = 826, name = "Most Profit Assigning Work", url = "https://leetcode.com/problems/most-profit-assigning-work/")
public class MostProfitAssigningWork
{
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers)
	{
		int maxProfit = 0;
		int[][] diffAndProfit = new int[difficulty.length][];
		for (int pos = 0; pos < difficulty.length; pos++)
		{
			diffAndProfit[pos] = new int[]{difficulty[pos], profit[pos]};
		}

		Arrays.sort(diffAndProfit, (arr1, arr2) ->
		{
			if (arr1[0] == arr2[0])
			{
				return arr2[1] - arr1[1];
			}
			else
			{
				return arr1[0] - arr2[0];
			}
		});

		int max = 0;
		for (int[] dAp : diffAndProfit)
		{
			max = Math.max(max, dAp[1]);
			dAp[1] = max;
		}

		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for (int[] dAp : diffAndProfit)
		{
			treeMap.put(dAp[0], dAp[1]);
		}

		for (int worker : workers)
		{
			Map.Entry<Integer, Integer> entry = treeMap.floorEntry(worker);
			if (entry != null)
			{
				maxProfit += entry.getValue();
			}
		}

		return maxProfit;
	}
}
