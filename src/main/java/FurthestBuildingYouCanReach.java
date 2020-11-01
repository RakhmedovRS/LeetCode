import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/1/2020
 */
@LeetCode(id = 1642, name = "Furthest Building You Can Reach", url = "https://leetcode.com/problems/furthest-building-you-can-reach/")
public class FurthestBuildingYouCanReach
{
	public int furthestBuilding(int[] heights, int bricks, int ladders)
	{
		int[][][] memo = new int[heights.length][2][2];
		memo[0][0] = new int[]{bricks, ladders};
		memo[0][1] = new int[]{bricks, ladders};

		int diff;
		int max = 0;
		boolean stepped;
		for (int i = 1; i < heights.length; i++)
		{
			stepped = false;
			if (heights[i - 1] >= heights[i])
			{
				memo[i][0] = memo[i - 1][0];
				memo[i][1] = memo[i - 1][1];
				max = i;
			}
			else
			{
				diff = heights[i] - heights[i - 1];
				if (memo[i - 1][0][0] >= diff)
				{
					memo[i][0][0] = memo[i - 1][0][0] - diff;
					memo[i][0][1] = memo[i - 1][0][1];
					max = i;
					stepped = true;
				}
				else if (memo[i - 1][0][1] > 0)
				{
					memo[i][0][0] = memo[i - 1][0][0];
					memo[i][0][1] = memo[i - 1][0][1] - 1;
					max = i;
					stepped = true;
				}

				if (memo[i - 1][1][1] > 0)
				{
					memo[i][1][0] = memo[i - 1][1][0];
					memo[i][1][1] = memo[i - 1][1][1] - 1;
					max = i;
					stepped = true;
				}
				else if (memo[i - 1][1][0] >= diff)
				{
					memo[i][1][0] = memo[i - 1][1][0] - diff;
					memo[i][1][1] = memo[i - 1][1][1];
					max = i;
					stepped = true;
				}

				if (!stepped)
				{
					break;
				}
			}
		}

		return max;
	}
}
