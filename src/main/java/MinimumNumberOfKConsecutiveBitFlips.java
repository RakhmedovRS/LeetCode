import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/26/2020
 */
@LeetCode(
	id = 995,
	name = "Minimum Number of K Consecutive Bit Flips",
	url = "https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/",
	difficulty = Difficulty.HARD
)
public class MinimumNumberOfKConsecutiveBitFlips
{
	public int minKBitFlips(int[] A, int K)
	{
		int[] memo = new int[A.length];
		int flips = 0;
		int right = 0;
		int[] bits = new int[2];
		while (right < K)
		{
			bits[A[right]]++;
			right++;
		}
		right--;

		int left = 0;
		int add = 0;
		while (right < A.length)
		{
			while (right + 1 < A.length && (A[left] + add) % 2 == 1)
			{
				bits[(A[left] + add) % 2]--;
				bits[A[right + 1]]++;
				left++;
				right++;
				add += memo[left];
			}

			if (bits[0] != 0)
			{
				add++;
				if (right + 1 < A.length)
				{
					memo[right + 1]--;
				}
				int temp = bits[0];
				bits[0] = bits[1];
				bits[1] = temp;
				flips++;
			}

			if (right == A.length - 1)
			{
				if (bits[0] != 0)
				{
					return -1;
				}

				break;
			}
		}

		return flips;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[]{0, 0, 0, 0, 0, 0}, 2)); //3
		System.out.println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[]{0, 1, 0}, 3)); //-1
		System.out.println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[]{1, 1, 0}, 2)); //-1
		System.out.println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[]{0, 1, 0}, 1)); //2
		System.out.println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3)); //3
		System.out.println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[1000], 3));
		System.out.println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[1000], 2));
		System.out.println(new MinimumNumberOfKConsecutiveBitFlips().minKBitFlips(new int[1000], 1));
	}
}
