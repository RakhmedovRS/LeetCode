import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 04-Jun-20
 */
@LeetCode(id = 1078, name = "Occurrences After Bigram", url = "https://leetcode.com/problems/occurrences-after-bigram/")
public class OccurrencesAfterBigram
{
	public String[] findOcurrences(String text, String first, String second)
	{
		List<String> temp = new ArrayList<>();

		String[] words = text.split(" ");
		for (int i = 2; i < words.length; i++)
		{
			if (words[i - 2].equals(first) && words[i - 1].equals(second))
			{
				temp.add(words[i]);
			}
		}

		return temp.toArray(new String[0]);
	}
}
