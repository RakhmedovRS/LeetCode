import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 21-Aug-20
 */
@LeetCode(id = 336, name = "Palindrome Pairs", url = "https://leetcode.com/problems/palindrome-pairs/")
public class PalindromePairs
{
	public List<List<Integer>> palindromePairs(String[] words)
	{
		List<List<Integer>> answer = new ArrayList<>();
		for (int i = 0; i < words.length; i++)
		{
			for (int j = i + 1; j < words.length; j++)
			{
				if (isPalindrome(words[i], words[j]))
				{
					answer.add(Arrays.asList(i, j));
				}

				if (isPalindrome(words[j], words[i]))
				{
					answer.add(Arrays.asList(j, i));
				}
			}
		}

		return answer;
	}

	private boolean isPalindrome(String word1, String word2)
	{
		if (word1.isEmpty())
		{
			int left = 0;
			int right = word2.length() - 1;
			while (left < right)
			{
				if (word2.charAt(left++) != word2.charAt(right--))
				{
					return false;
				}
			}
		}
		else if (word2.isEmpty())
		{
			int left = 0;
			int right = word1.length() - 1;
			while (left < right)
			{
				if (word1.charAt(left++) != word1.charAt(right--))
				{
					return false;
				}
			}
		}
		else
		{
			int left = 0;
			int right = word1.length() + word2.length() - 1;
			while (left < right)
			{
				char ch1 = left < word1.length() ? word1.charAt(left) : word2.charAt(left - word1.length());
				char ch2 = right >= word1.length() ? word2.charAt(right - word1.length()) : word1.charAt(right);

				if (ch1 != ch2)
				{
					return false;
				}

				left++;
				right--;
			}
		}

		return true;
	}
}
