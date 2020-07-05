import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Jul-20
 */
@LeetCode(id = 1503, name = "Last Moment Before All Ants Fall Out of a Plank", url = "https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/")
public class LastMomentBeforeAllAntsFallOutOfPlank
{
	public int getLastMoment(int n, int[] left, int[] right)
	{
		int lMax = 0;
		int rMin = n;
		for (int val : left)
		{
			lMax = Math.max(lMax, val);
		}

		for (int val : right)
		{
			rMin = Math.min(rMin, val);
		}

		return Math.max(lMax, n - rMin);
	}
}
