package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 11/22/2020
 */
@LeetCode(
		id = 804,
		name = "Unique Morse Code Words",
		url = "https://leetcode.com/problems/unique-morse-code-words/",
		difficulty = Difficulty.EASY
)
public class UniqueMorseCodeWords
{
	public int uniqueMorseRepresentations(String[] words)
	{
		String[] codes = new String[]
				{
						".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
						".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
						"...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
				};

		Set<String> set = new HashSet<>();
		for (String word : words)
		{
			StringBuilder sb = new StringBuilder();
			for (char ch : word.toCharArray())
			{
				sb.append(codes[ch - 'a']);
			}

			set.add(sb.toString());
		}

		return set.size();
	}
}
