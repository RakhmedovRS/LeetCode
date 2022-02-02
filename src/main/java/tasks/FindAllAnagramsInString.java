package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 17-May-20
 */
@LeetCode(
	id = 438,
	name = "Find All Anagrams in a String",
	url = "https://leetcode.com/problems/find-all-anagrams-in-a-string/",
	difficulty = Difficulty.MEDIUM
)
public class FindAllAnagramsInString
{
	public List<Integer> findAnagrams(String s, String p)
	{
		List<Integer> answer = new ArrayList<>();
		int[] origin = createCharFrequencyTable(p);
		int[] current = new int[26];
		int left = 0;
		int right = 0;
		while (right <= s.length())
		{
			if (right - left == p.length())
			{
				if (containsSameChars(origin, current))
				{
					answer.add(left);
				}
				current[s.charAt(left++) - 'a']--;
			}

			if (right < s.length())
			{
				current[s.charAt(right) - 'a']++;
			}
			right++;
		}

		return answer;
	}

	private boolean containsSameChars(int[] origin, int[] current)
	{
		for (int i = 0; i < origin.length; i++)
		{
			if (origin[i] > current[i])
			{
				return false;
			}
		}

		return true;
	}

	public int[] createCharFrequencyTable(String word)
	{
		int[] pattern = new int[26];
		for (char ch : word.toCharArray())
		{
			if (Character.isAlphabetic(ch))
			{
				pattern[Character.toLowerCase(ch) - 'a']++;
			}
		}

		return pattern;
	}

	public static void main(String[] args)
	{
		System.out.println(new FindAllAnagramsInString().findAnagrams("cbaebabacd", "abc"));
	}
}
