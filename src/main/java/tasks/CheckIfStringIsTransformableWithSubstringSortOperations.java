package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 9/30/2020
 */
@LeetCode(id = 1585, name = "Check If String Is Transformable With Substring Sort Operations", url = "https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/")
public class CheckIfStringIsTransformableWithSubstringSortOperations
{
	public boolean isTransformable(String s, String t)
	{
		char[] source = s.toCharArray();
		char[] target = t.toCharArray();
		if (!consistedOfTheSameNumbers(source, target))
		{
			return false;
		}

		List<Integer>[] indices = new ArrayList[10];
		for (int i = 0; i < 10; i++)
		{
			indices[i] = new ArrayList<>();
		}

		for (int i = 0; i < source.length; i++)
		{
			indices[source[i] - '0'].add(i);
		}

		int[] used = new int[10];
		int number;
		for (char ch : target)
		{
			number = ch - '0';
			if (used[number] >= indices[number].size())
			{
				return false;
			}

			for (int j = 0; j < number; j++)
			{
				if (used[j] < indices[j].size() && indices[j].get(used[j]) < indices[number].get(used[number]))
				{
					return false;
				}
			}
			used[number]++;
		}

		return true;
	}

	private boolean consistedOfTheSameNumbers(char[] source, char[] target)
	{
		int[] memo = new int[26];
		for (char ch : source)
		{
			memo[ch - '0']++;
		}

		for (char ch : target)
		{
			memo[ch - '0']--;
		}

		for (int count : memo)
		{
			if (count != 0)
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new CheckIfStringIsTransformableWithSubstringSortOperations().isTransformable("84532", "34852"));
	}
}
