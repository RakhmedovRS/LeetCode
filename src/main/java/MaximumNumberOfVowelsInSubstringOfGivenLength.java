import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 27-May-20
 */
@LeetCode(id = 1456, name = "Maximum Number of Vowels in a Substring of Given Length", url = "https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/")
public class MaximumNumberOfVowelsInSubstringOfGivenLength
{
	public int maxVowels(String s, int k)
	{
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int maxCount = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (i >= k)
			{
				if (vowels.contains(s.charAt(i - k)))
				{
					count--;
				}
			}

			if (vowels.contains(s.charAt(i)))
			{
				count++;
			}

			if (maxCount < count)
			{
				maxCount = count;
			}

			if (maxCount == k)
			{
				return maxCount;
			}
		}

		return maxCount;
	}
}
