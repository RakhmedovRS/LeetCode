package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 17-May-20
 */
@LeetCode(id = 438, name = "Find All Anagrams in a String", url = "https://leetcode.com/problems/find-all-anagrams-in-a-string/")
public class FindAllAnagramsInString
{
	public List<Integer> findAnagrams(String s, String p)
	{
		List<Integer> result = new ArrayList<>();
		if (s == null || s.isEmpty() || p == null || p.isEmpty() || s.length() < p.length())
		{
			return result;
		}

		int[] pattern = new int[26];
		for (char ch : p.toCharArray())
		{
			pattern[ch - 'a']++;
		}

		int pLength = p.length();
		int[] window = new int[26];
		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			window[ch - 'a']++;
			if (i < pLength - 1)
			{
				continue;
			}

			if (i >= pLength)
			{
				window[s.charAt(i - pLength) - 'a']--;
			}

			if (match(window, pattern))
			{
				result.add(i - pLength + 1);
			}
		}

		return result;
	}

	private boolean match(int[] window, int[] pattern)
	{
		for (int i = 0; i < window.length; i++)
		{
			if (window[i] < pattern[i])
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new FindAllAnagramsInString().findAnagrams("cbaebabacd", "abc"));
	}
}
