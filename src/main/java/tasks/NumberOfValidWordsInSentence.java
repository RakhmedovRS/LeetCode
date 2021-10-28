package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/28/2021
 */
@LeetCode(
	id = 2047,
	name = "Number of Valid Words in a Sentence",
	url = "https://leetcode.com/problems/number-of-valid-words-in-a-sentence/",
	difficulty = Difficulty.EASY
)
public class NumberOfValidWordsInSentence
{
	public int countValidWords(String sentence)
	{
		int count = 0;
		String[] parts = sentence.split(" ");
		outer:
		for (String part : parts)
		{

			if (part.isEmpty())
			{
				continue;
			}

			boolean seenHyphen = false;
			for (int i = 0; i < part.length(); i++)
			{
				char ch = part.charAt(i);
				if (Character.isDigit(ch))
				{
					continue outer;
				}

				if (ch == '-')
				{
					if (seenHyphen)
					{
						continue outer;
					}

					seenHyphen = true;
					boolean left = i == 0 ? false : Character.isAlphabetic(part.charAt(i - 1));
					boolean right = (i + 1) == part.length() ? false : Character.isAlphabetic(part.charAt(i + 1));

					if (!left || !right)
					{
						continue outer;
					}
				}

				if (ch == '!' || ch == '.' || ch == ',')
				{
					if (i != part.length() - 1)
					{
						continue outer;
					}
				}
			}
			count++;
		}

		return count;
	}
}
