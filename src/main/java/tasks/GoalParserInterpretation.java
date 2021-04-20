package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/6/2020
 */
@LeetCode(
	id = 1678,
	name = "Goal Parser Interpretation",
	url = "https://leetcode.com/problems/goal-parser-interpretation/",
	difficulty = Difficulty.EASY
)
public class GoalParserInterpretation
{
	public String interpret(String command)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < command.length(); i++)
		{
			if (command.charAt(i) == 'G')
			{
				sb.append('G');
			}
			else if (command.charAt(i) == ')' && command.charAt(i - 1) == '(')
			{
				sb.append('o');
			}
			else if (command.charAt(i) == ')' && command.charAt(i - 1) != '(')
			{
				sb.append("al");
			}
		}

		return sb.toString();
	}
}
