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
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		for (int i = 0; i < sChars.length; i++)
		{
			memo[sChars[i] - 'a']++;
			memo[tChars[i] - 'a']--;
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
