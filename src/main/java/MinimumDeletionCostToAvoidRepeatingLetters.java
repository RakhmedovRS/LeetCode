import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 06-Sep-20
 */
@LeetCode(id = 1578, name = "Minimum Deletion Cost to Avoid Repeating Letters", url = "https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/")
public class MinimumDeletionCostToAvoidRepeatingLetters
{
	public int minCost(String s, int[] cost)
	{
		LinkedList<int[]> pairs = new LinkedList<>();
		int totalCost = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (!pairs.isEmpty() && pairs.getLast()[0] == (int) s.charAt(i))
			{
				if (pairs.getLast()[1] < cost[i])
				{
					totalCost += pairs.getLast()[1];
					pairs.removeLast();
					pairs.addLast(new int[]{s.charAt(i), cost[i]});
				}
				else
				{
					totalCost += cost[i];
				}
			}
			else
			{
				pairs.addLast(new int[]{s.charAt(i), cost[i]});
			}
		}

		return totalCost;
	}
}
