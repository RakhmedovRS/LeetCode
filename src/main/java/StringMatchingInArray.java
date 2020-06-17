import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 17-Jun-20
 */
@LeetCode(id = 1408, name = "String Matching in an Array", url = "https://leetcode.com/problems/string-matching-in-an-array/")
public class StringMatchingInArray
{
	public List<String> stringMatching(String[] words)
	{
		List<String> result = new ArrayList<>();
		Arrays.sort(words, Comparator.comparingInt(String::length));
		for (int left = 0; left < words.length - 1; left++)
		{
			for (int right = left + 1; right < words.length; right++)
			{
				if (words[right].contains(words[left]))
				{
					result.add(words[left]);
					break;
				}
			}
		}

		return result;
	}
}
