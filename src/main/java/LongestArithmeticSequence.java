import java.util.HashMap;

/**
 * Longest Arithmetic Sequence
 * LeetCode 1027
 *
 * @author RakhmedovRS
 * @created 17-Feb-20
 */
public class LongestArithmeticSequence
{
	public int longestArithSeqLength(int[] A)
	{
		int res = 2;
		HashMap<Integer, Integer>[] dp = new HashMap[A.length];
		for (int j = 0; j < A.length; j++)
		{
			dp[j] = new HashMap<>();
			for (int i = 0; i < j; i++)
			{
				int d = A[j] - A[i];
				dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
				res = Math.max(res, dp[j].get(d));
			}
		}
		return res;
	}
}
