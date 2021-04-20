package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 14-Mar-20
 */
@LeetCode(id = 387, name = "First Unique Character in a String", url = "https://leetcode.com/problems/first-unique-character-in-a-string/")
public class FirstUniqueCharacterInString
{
	public int firstUniqChar(String s)
	{
		if (s == null || s.isEmpty())
		{
			return -1;
		}

		int[] cache = new int[26];
		for (char ch : s.toCharArray())
		{
			cache[ch - 'a']++;
		}

		for (int i = 0; i < s.length(); i++)
		{
			if (cache[s.charAt(i) - 'a'] == 1)
			{
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args)
	{
		System.out.println(new FirstUniqueCharacterInString().firstUniqChar("leetcode"));
		System.out.println(new FirstUniqueCharacterInString().firstUniqChar("loveleetcode"));
	}
}
