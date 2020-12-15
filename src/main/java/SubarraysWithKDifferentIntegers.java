import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/15/2020
 */
@LeetCode(
	id = 992,
	name = "Subarrays with K Different Integers",
	url = "https://leetcode.com/problems/subarrays-with-k-different-integers/",
	difficulty = Difficulty.HARD
)
public class SubarraysWithKDifferentIntegers
{
	public int subarraysWithKDistinct(int[] A, int K)
	{
		int count = 0;
		int left = 0;
		int right = 0;
		int[] table = new int[20001];
		int unique = 0;
		int num;
		int prefix = 0;
		while (right < A.length)
		{
			num = A[right++];
			if (table[num]++ == 0)
			{
				unique++;
			}

			if (unique > K)
			{
				unique--;
				table[A[left++]]--;
				prefix = 0;
			}

			while (table[A[left]] > 1)
			{
				table[A[left++]]--;
				prefix++;
			}

			if (unique == K)
			{
				count += prefix + 1;
			}
		}

		return count;
	}
}
