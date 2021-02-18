import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 24-Mar-20
 */
@LeetCode(
	id = 821,
	name = "Shortest Distance to a Character",
	url = "https://leetcode.com/problems/shortest-distance-to-a-character/",
	difficulty = Difficulty.EASY
)
public class ShortestDistanceToCharacter
{
	public int[] shortestToChar(String s, char c)
	{
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == c)
			{
				set.add(i);
			}
		}

		int[] answer = new int[s.length()];
		Integer left;
		Integer right;
		for (int i = 0; i < s.length(); i++)
		{
			left = set.floor(i);
			right = set.ceiling(i);

			if (left != null && right != null)
			{
				answer[i] = Math.min(Math.abs(i - left), Math.abs(i - right));
			}
			else if (left != null)
			{
				answer[i] = i - left;
			}
			else
			{
				answer[i] = right - i;
			}
		}

		return answer;
	}
}
