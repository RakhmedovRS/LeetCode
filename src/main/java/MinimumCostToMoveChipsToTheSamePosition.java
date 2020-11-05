import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/19/2020
 */
@LeetCode(id = 1217, name = "Minimum Cost to Move Chips to The Same Position", url = "https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/")
public class MinimumCostToMoveChipsToTheSamePosition
{
	public int minCostToMoveChips(int[] position)
	{
		int even = 0;
		int odd = 0;
		for (int i = 0; i < position.length; i++)
		{
			if (position[i] % 2==  0)
			{
				even++;
			}
			else
			{
				odd++;
			}
		}

		return Math.min(even, odd);
	}
}
