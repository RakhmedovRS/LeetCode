package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/25/2020
 */
@LeetCode(id = 1629, name = "Slowest Key", url = "https://leetcode.com/problems/slowest-key/")
public class SlowestKey
{
	public char slowestKey(int[] releaseTimes, String keysPressed)
	{
		int current;
		int max = 0;
		char answer = ' ';
		char[] chars = keysPressed.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			current = releaseTimes[i] - (i == 0 ? 0 : releaseTimes[i - 1]);
			if (current > max)
			{
				max = current;
				answer = chars[i];
			}
			else if (current == max && chars[i] > answer)
			{
				answer = chars[i];
			}
		}

		return answer;
	}
}
