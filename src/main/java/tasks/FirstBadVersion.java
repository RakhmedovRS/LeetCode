package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(id = 278, name = "First Bad Version", url = "https://leetcode.com/problems/first-bad-version/")
public class FirstBadVersion
{
	boolean isBadVersion(int version)
	{
		return false;
	}

	public int firstBadVersion(int n)
	{
		int[] answer = new int[]{n};
		firstBadVersion(answer, 1, n);

		return answer[0];
	}

	public void firstBadVersion(int[] answer, int left, int right)
	{
		if (left > right)
		{
			return;
		}

		int middle = left + (right - left) / 2;
		if (isBadVersion(middle))
		{
			answer[0] = Math.min(answer[0], middle);
			firstBadVersion(answer, left, middle - 1);
		}
		else
		{
			firstBadVersion(answer, middle + 1, right);
		}
	}
}
