package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/9/2021
 */
@LeetCode(
	id = 1717,
	name = "Maximum Score From Removing Substrings",
	url = "https://leetcode.com/problems/maximum-score-from-removing-substrings/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumScoreFromRemovingSubstrings
{
	public int maximumGain(String s, int x, int y)
	{
		int points = 0;
		boolean containsAB = s.contains("ab");
		boolean containsBA = s.contains("ba");

		while (containsAB || containsBA)
		{
			StringBuilder sb = new StringBuilder();
			if (containsAB && containsBA)
			{
				if (x >= y)
				{
					for (int i = 0; i < s.length(); i++)
					{
						if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 'a' && s.charAt(i) == 'b')
						{
							points += x;
							sb.deleteCharAt(sb.length() - 1);
						}
						else
						{
							sb.append(s.charAt(i));
						}
					}
				}
				else
				{
					for (int i = 0; i < s.length(); i++)
					{
						if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 'b' && s.charAt(i) == 'a')
						{
							points += y;
							sb.deleteCharAt(sb.length() - 1);
						}
						else
						{
							sb.append(s.charAt(i));
						}
					}
				}
			}
			else if (containsAB)
			{
				for (int i = 0; i < s.length(); i++)
				{
					if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 'a' && s.charAt(i) == 'b')
					{
						points += x;
						sb.deleteCharAt(sb.length() - 1);
					}
					else
					{
						sb.append(s.charAt(i));
					}
				}
			}
			else
			{
				for (int i = 0; i < s.length(); i++)
				{
					if (sb.length() > 0 && sb.charAt(sb.length() - 1) == 'b' && s.charAt(i) == 'a')
					{
						points += y;
						sb.deleteCharAt(sb.length() - 1);
					}
					else
					{
						sb.append(s.charAt(i));
					}
				}
			}

			s = sb.toString();

			containsAB = s.contains("ab");
			containsBA = s.contains("ba");
		}

		return points;
	}

	public static void main(String[] args)
	{
		MaximumScoreFromRemovingSubstrings clazz = new MaximumScoreFromRemovingSubstrings();
		System.out.println(clazz.maximumGain("abab", 2, 2));
		System.out.println(clazz.maximumGain("abab", 2, 3));
		System.out.println(clazz.maximumGain("cdbcbbaaabab", 4, 5));
		System.out.println(clazz.maximumGain("aabbaaxybbaabb", 5, 4));
	}
}
