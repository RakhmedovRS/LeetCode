import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 31-Mar-20
 */
@LeetCode(id = 461, name = "Hamming Distance", url = "https://leetcode.com/problems/hamming-distance/")
public class HammingDistance
{
	public int hammingDistance(int x, int y)
	{
		int diff = 0;
		for (int i = 0; i < 32; i++)
		{
			if ((x & 1) != (y & 1))
			{
				diff++;
			}
			x >>= 1;
			y >>= 1;
		}

		return diff;
	}

	public static void main(String[] args)
	{
		System.out.println(new HammingDistance().hammingDistance(1, 4));
	}
}
