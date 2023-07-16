package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/24/2022
 */
@LeetCode(
		id = 2120,
		name = "Execution of All Suffix Instructions Staying in a Grid",
		url = "https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/",
		difficulty = Difficulty.MEDIUM
)
public class ExecutionOfAllSuffixInstructionsStayingInGrid
{
	public int[] executeInstructions(int n, int[] startPos, String s)
	{
		int[] answer = new int[s.length()];
		char[] chars = s.toCharArray();
		outer:
		for (int i = 0; i < chars.length; i++)
		{
			int row = startPos[0];
			int column = startPos[1];

			for (int j = i; j < chars.length; j++)
			{
				if (chars[j] == 'U')
				{
					row--;
				}
				else if (chars[j] == 'D')
				{
					row++;
				}
				else if (chars[j] == 'L')
				{
					column--;
				}
				else
				{
					column++;
				}

				if (row < 0 || row >= n || column < 0 || column >= n)
				{
					continue outer;
				}

				answer[i]++;
			}
		}

		return answer;
	}
}
