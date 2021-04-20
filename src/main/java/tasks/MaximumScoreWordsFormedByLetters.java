package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 01-Sep-20
 */
@LeetCode(id = 1255, name = "Maximum Score Words Formed by Letters", url = "https://leetcode.com/problems/maximum-score-words-formed-by-letters/")
public class MaximumScoreWordsFormedByLetters
{
	public int maxScoreWords(String[] words, char[] letters, int[] score)
	{
		int result = 0;
		int[] chars = createFreqTable(String.valueOf(letters));
		int[][] wordsFreqTables = new int[words.length][];
		for (int i = 0; i < words.length; i++)
		{
			wordsFreqTables[i] = createFreqTable(words[i]);
		}

		return dsf(wordsFreqTables, 0, chars, score);
	}

	private int dsf(int[][] wordsFreqTables, int index, int[] chars, int[] scores)
	{
		if (index == wordsFreqTables.length)
		{
			return 0;
		}

		int max = 0;
		for (int i = index; i < wordsFreqTables.length; i++)
		{
			if (canBeUsed(chars, wordsFreqTables[i]))
			{
				max = Math.max(max, useWordAndCalculateScore(chars, wordsFreqTables[i], scores) + dsf(wordsFreqTables, i + 1, chars, scores));
				rollbackUsage(chars, wordsFreqTables[i]);
			}
		}

		return max;
	}

	private int[] createFreqTable(String word)
	{
		int[] chars = new int[26];
		for (int i = 0; i < word.length(); i++)
		{
			chars[word.charAt(i) - 'a']++;
		}
		return chars;
	}

	private boolean canBeUsed(int[] chars, int[] freqTable)
	{
		for (int i = 0; i < 26; i++)
		{
			if (freqTable[i] > chars[i])
			{
				return false;
			}
		}
		return true;
	}

	private int useWordAndCalculateScore(int[] chars, int[] freqTable, int[] scores)
	{
		int score = 0;
		for (int i = 0; i < 26; i++)
		{
			chars[i] -= freqTable[i];
			score += freqTable[i] * scores[i];
		}
		return score;
	}

	private void rollbackUsage(int[] chars, int[] freqTable)
	{
		for (int i = 0; i < 26; i++)
		{
			chars[i] += freqTable[i];
		}
	}
}
