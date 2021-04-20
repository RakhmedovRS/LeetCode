package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/22/2020
 */
@LeetCode(
	id = 293,
	name = "Flip Game",
	url = "https://leetcode.com/problems/flip-game/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class FlipGame
{
	public List<String> generatePossibleNextMoves(String s)
	{
		List<String> answer = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
		{
			if (i + 1 < s.length() && s.charAt(i) == '+' && s.charAt(i + 1) == '+')
			{
				answer.add(sb.toString() + "--" + s.substring(i + 2));
			}
			sb.append(s.charAt(i));
		}

		return answer;
	}
}
