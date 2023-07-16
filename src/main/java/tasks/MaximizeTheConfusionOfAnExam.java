package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/2/2021
 */
@LeetCode(
		id = 2024,
		name = "Maximize the Confusion of an Exam",
		url = "https://leetcode.com/problems/maximize-the-confusion-of-an-exam/",
		difficulty = Difficulty.MEDIUM
)
public class MaximizeTheConfusionOfAnExam
{
	public int maxConsecutiveAnswers(String answerKey, int k)
	{
		int max = 0;
		int left = 0;
		int right = 0;
		char[] chars = answerKey.toCharArray();
		int miss = 0;
		while (right < chars.length)
		{
			if (chars[right++] == 'T')
			{
				miss++;
			}

			while (miss > k)
			{
				if (chars[left++] == 'T')
				{
					miss--;
				}
			}

			max = Math.max(max, right - left);
		}

		left = 0;
		right = 0;
		miss = 0;
		while (right < chars.length)
		{
			if (chars[right++] == 'F')
			{
				miss++;
			}

			while (miss > k)
			{
				if (chars[left++] == 'F')
				{
					miss--;
				}
			}

			max = Math.max(max, right - left);
		}

		return max;
	}
}
