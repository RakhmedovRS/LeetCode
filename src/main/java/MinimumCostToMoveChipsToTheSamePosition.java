import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/19/2020
 */
@LeetCode(id = 1217, name = "Minimum Cost to Move Chips to The Same Position", url = "https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/")
public class MinimumCostToMoveChipsToTheSamePosition
{
	public int minCostToMoveChips(int[] chips)
	{
		int even = 0;
		int odd = 0;
		for (int chip : chips)
		{
			if (chip % 2 == 0)
			{
				even += 1;
			}
			else
			{
				odd += 1;
			}
		}

		return Math.min(even, odd);
	}
}
