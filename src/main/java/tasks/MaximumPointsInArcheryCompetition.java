package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/20/2022
 */
@LeetCode(
		id = 2212,
		name = "Maximum Points in an Archery Competition",
		url = "https://leetcode.com/problems/maximum-points-in-an-archery-competition/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumPointsInArcheryCompetition
{
	public int[] maximumBobPoints(int numArrows, int[] aliceArrows)
	{
		int[] bobArrows = new int[12];
		dfs(0, 11, numArrows, aliceArrows, new int[12], bobArrows, new int[]{0});
		return bobArrows;
	}

	private void dfs(int score, int pos, int numArrows, int[] aliceArrows, int[] temp, int[] bobArrows, int[] max)
	{
		if (pos == 0 || numArrows == 0)
		{
			temp[pos] = numArrows;
			if (score > max[0])
			{
				System.arraycopy(temp, 0, bobArrows, 0, 12);
				max[0] = score;
			}

			temp[pos] = 0;

			return;
		}

		if (aliceArrows[pos] < numArrows)
		{
			temp[pos] = aliceArrows[pos] + 1;
			dfs(score + pos, pos - 1, numArrows - aliceArrows[pos] - 1, aliceArrows, temp, bobArrows, max);
			temp[pos] = 0;
		}

		dfs(score, pos - 1, numArrows, aliceArrows, temp, bobArrows, max);
	}
}
