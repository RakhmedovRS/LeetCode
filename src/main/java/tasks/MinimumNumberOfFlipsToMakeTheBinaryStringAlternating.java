package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/6/2021
 */
@LeetCode(
		id = 1888,
		name = "Minimum Number of Flips to Make the Binary String Alternating",
		url = "https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating
{
	public int minFlips(String s)
	{
		int n = s.length();
		s += s;

		char[] chars = s.toCharArray();
		char[] validA = new char[s.length()];
		char[] validB = new char[s.length()];

		for (int i = 0, a = 0; i < chars.length; i++, a++)
		{
			validA[i] = a % 2 == 0 ? '0' : '1';
			validB[i] = a % 2 == 0 ? '1' : '0';
		}

		int answer = Integer.MAX_VALUE;
		int currentA = 0;
		int currentB = 0;
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] != validA[i])
			{
				currentA++;
			}

			if (chars[i] != validB[i])
			{
				currentB++;
			}

			if (i >= n)
			{
				if (chars[i - n] != validA[i - n])
				{
					currentA--;
				}

				if (chars[i - n] != validB[i - n])
				{
					currentB--;
				}

				answer = Math.min(answer, Math.min(currentA, currentB));
			}
		}

		return answer;
	}
}
