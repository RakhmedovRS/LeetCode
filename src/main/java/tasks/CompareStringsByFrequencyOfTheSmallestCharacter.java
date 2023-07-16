package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 04-Jul-20
 */
@LeetCode(id = 1170, name = "Compare Strings by Frequency of the Smallest Character", url = "https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/")
public class CompareStringsByFrequencyOfTheSmallestCharacter
{
	public int[] numSmallerByFrequency(String[] queries, String[] words)
	{
		int[] wordsCount = new int[words.length];
		for (int i = 0; i < wordsCount.length; i++)
		{
			wordsCount[i] = countOfLowest(words[i]);
		}
		Arrays.sort(wordsCount);

		int[] answer = new int[queries.length];
		for (int i = 0; i < answer.length; i++)
		{
			int count = countOfLowest(queries[i]);
			if (count < wordsCount[0])
			{
				answer[i] = wordsCount.length;
			}
			else if (count >= wordsCount[wordsCount.length - 1])
			{
				answer[i] = 0;
			}
			else
			{
				answer[i] = wordsCount.length - findPos(wordsCount, count);
			}
		}

		return answer;
	}

	private int findPos(int[] wordsCount, int count)
	{
		int left = 0;
		int right = wordsCount.length - 1;
		int mid;
		while (left <= right)
		{
			mid = left + (right - left) / 2;
			if (count >= wordsCount[mid])
			{
				left = mid + 1;
			}
			else
			{
				right = mid - 1;
			}
		}

		return left;
	}

	private int countOfLowest(String string)
	{
		int[] numbers = new int[26];
		for (char ch : string.toCharArray())
		{
			numbers[ch - 'a']++;
		}

		for (int num : numbers)
		{
			if (num != 0)
			{
				return num;
			}
		}

		return 0;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(
				new CompareStringsByFrequencyOfTheSmallestCharacter().numSmallerByFrequency(
						new String[]{"aabbabbb", "abbbabaa", "aabbbabaa", "aabba", "abb", "a", "ba", "aa", "ba", "baabbbaaaa", "babaa", "bbbbabaa"},
						new String[]{"b", "aaaba", "aaaabba", "aa", "aabaabab", "aabbaaabbb", "ababb", "bbb", "aabbbabb", "aab", "bbaaababba", "baaaaa"})));

		System.out.println(Arrays.toString(
				new CompareStringsByFrequencyOfTheSmallestCharacter().numSmallerByFrequency(
						new String[]{"bbb", "cc"},
						new String[]{"a", "aa", "aaa", "aaaa"})));

		System.out.println(Arrays.toString(
				new CompareStringsByFrequencyOfTheSmallestCharacter().numSmallerByFrequency(
						new String[]{"cbd"},
						new String[]{"zaaaz"})));
	}
}
