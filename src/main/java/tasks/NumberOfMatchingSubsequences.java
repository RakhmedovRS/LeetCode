package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 15-Jul-20
 */
@LeetCode(
		id = 792,
		name = "Number of Matching Subsequences",
		url = "https://leetcode.com/problems/number-of-matching-subsequences/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfMatchingSubsequences
{
	public int numMatchingSubseq(String s, String[] words)
	{
		TreeSet<Integer>[] positions = new TreeSet[26];
		for (int i = 0; i < 26; i++)
		{
			positions[i] = new TreeSet<>();
		}

		for (int i = 0; i < s.length(); i++)
		{
			positions[s.charAt(i) - 'a'].add(i);
		}

		int numberOfMatchingSeq = 0;
		outer:
		for (String word : words)
		{
			int prev = -1;
			for (char ch : word.toCharArray())
			{
				Integer next = positions[ch - 'a'].ceiling(prev + 1);
				if (next == null)
				{
					continue outer;
				}
				prev = next;
			}
			numberOfMatchingSeq++;
		}

		return numberOfMatchingSeq;
	}

	public static void main(String[] args)
	{
		System.out.println(new NumberOfMatchingSubsequences().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
	}
}
