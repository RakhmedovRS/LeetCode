package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/10/2022
 */
@LeetCode(
		id = 2232,
		name = "Minimize Result by Adding Parentheses to Expression",
		url = "https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/",
		difficulty = Difficulty.MEDIUM
)
public class MinimizeResultByAddingParenthesesToExpression
{
	public String minimizeResult(String expression)
	{
		String[] parts = expression.split("\\+");
		int[] pos = new int[]{0, parts[1].length()};
		int min = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
		for (int i = 0; i <= parts[0].length() - 1; i++)
		{
			int m1 = i > 0 ? Integer.parseInt(parts[0].substring(0, i)) : 1;
			for (int j = parts[1].length() - 1; j >= 0; j--)
			{
				int m2 = j < parts[1].length() - 1 ? Integer.parseInt(parts[1].substring(j + 1)) : 1;

				if (m1 * (Integer.parseInt(parts[0].substring(i)) + Integer.parseInt(parts[1].substring(0, j + 1))) * m2 < min)
				{
					min = m1 * (Integer.parseInt(parts[0].substring(i)) + Integer.parseInt(parts[1].substring(0, j + 1))) * m2;
					pos[0] = i;
					pos[1] = j + 1;
				}
			}
		}

		return parts[0].substring(0, pos[0]) + '(' + parts[0].substring(pos[0]) + "+" + parts[1].substring(0, pos[1]) + ')' + parts[1].substring(pos[1]);
	}
}
