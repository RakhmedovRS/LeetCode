package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 3/13/2022
 */
@LeetCode(
		id = 2201,
		name = "Count Artifacts That Can Be Extracted",
		url = "https://leetcode.com/problems/count-artifacts-that-can-be-extracted/",
		difficulty = Difficulty.MEDIUM
)
public class CountArtifactsThatCanBeExtracted
{
	public int digArtifacts(int n, int[][] artifacts, int[][] dig)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int[][] memo = new int[n + 1][n + 1];
		int artifactID = 0;
		for (int[] artifact : artifacts)
		{
			artifactID++;
			int pieces = 0;
			for (int row = artifact[0]; row <= artifact[2]; row++)
			{
				for (int column = artifact[1]; column <= artifact[3]; column++)
				{
					pieces++;
					memo[row][column] = artifactID;
				}
			}

			map.put(artifactID, pieces);
		}

		int answer = 0;
		for (int[] d : dig)
		{
			int r = d[0];
			int c = d[1];

			artifactID = memo[r][c];
			if (artifactID != 0)
			{
				memo[r][c] = 0;
				map.put(artifactID, map.get(artifactID) - 1);

				if (map.get(artifactID) == 0)
				{
					answer++;
				}
			}
		}

		return answer;
	}
}
