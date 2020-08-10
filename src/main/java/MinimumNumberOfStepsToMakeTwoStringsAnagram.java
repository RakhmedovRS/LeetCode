import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Aug-20
 */
@LeetCode(id = 1347, name = "Minimum Number of Steps to Make Two Strings Anagram", url = "https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/")
public class MinimumNumberOfStepsToMakeTwoStringsAnagram
{
	public int minSteps(String s, String t)
	{
		int[] memo = new int[26];
		for (char ch : s.toCharArray())
		{
			memo[ch - 'a']++;
		}

		for (char ch : t.toCharArray())
		{
			memo[ch - 'a']--;
		}

		int steps = 0;
		for (int count : memo)
		{
			if (count < 0)
			{
				steps += count * -1;
			}
		}
		return steps;
	}
}
