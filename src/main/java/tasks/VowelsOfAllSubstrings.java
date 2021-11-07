package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 11/7/2021
 */
@LeetCode(
	id = 2063,
	name = "Vowels of All Substrings",
	url = "https://leetcode.com/problems/vowels-of-all-substrings/",
	difficulty = Difficulty.MEDIUM
)
public class VowelsOfAllSubstrings
{
	public long countVowels(String word)
	{
		long count = 0;
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		for (int i = 0; i < word.length(); i++)
		{
			if (vowels.contains(word.charAt(i)))
			{
				count += (i + 1L) * (word.length() - i);
			}
		}

		return count;
	}
}
