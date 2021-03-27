import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 26-Jun-20
 */
@LeetCode(
	id = 647,
	name = "Palindromic Substrings",
	url = "https://leetcode.com/problems/palindromic-substrings/",
	difficulty = Difficulty.MEDIUM
)
public class PalindromicSubstrings
{
	public int countSubstrings(String s)
	{
		int count = 0;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < s.length(); i++)
		{
			queue.add(new int[]{i, i});
		}

		int size;
		int left;
		int right;
		int[] current;
		char[] chars = s.toCharArray();
		Set<String> seen = new HashSet<>();
		while (!queue.isEmpty())
		{
			count += queue.size();
			size = queue.size();
			while (size-- > 0)
			{
				current = queue.remove();
				left = current[0];
				right = current[1];
				if (left - 1 >= 0 && isPalindrome(left -1, right, chars) && seen.add((left - 1) + "_" + right))
				{
					queue.add(new int[]{left - 1, right});
				}

				if (right + 1 < chars.length && isPalindrome(left, right + 1, chars) && seen.add(left + "_" + (right + 1)))
				{
					queue.add(new int[]{left, right + 1});
				}

				if (left - 1 >= 0 && right + 1 < chars.length && isPalindrome(left - 1, right + 1, chars) && seen.add((left - 1) + "_" + (right + 1)))
				{
					queue.add(new int[]{left - 1, right + 1});
				}
			}
		}

		return count;
	}

	private boolean isPalindrome(int left, int right, char[] chars)
	{
		while (left <= right)
		{
			if (chars[left++] != chars[right--])
			{
				return false;
			}
		}

		return true;
	}
}
