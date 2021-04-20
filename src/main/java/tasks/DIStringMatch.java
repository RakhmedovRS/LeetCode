package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 30-Mar-20
 */
@LeetCode(id = 942, name = "DI String Match", url = "https://leetcode.com/problems/di-string-match/")
public class DIStringMatch
{
	public int[] diStringMatch(String S)
	{
		if (S == null || S.length() == 0)
		{
			return new int[0];
		}

		int min = 0;
		int max = S.length();

		int[] answer = new int[S.length() + 1];
		for (int i = 0; i < S.length(); i++)
		{
			if (S.charAt(i) == 'D')
			{
				answer[i] = max--;
			}
			else
			{
				answer[i] = min++;
			}
		}
		answer[S.length()] = min;

		return answer;
	}
}
