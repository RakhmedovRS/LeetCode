import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-Sep-20
 */
@LeetCode(id = 982, name = "Triples with Bitwise AND Equal To Zero", url = "https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/")
public class TriplesWithBitwiseANDEqualToZero
{
	public int countTriplets(int[] A)
	{
		int count = 0;
		int[] memo = new int[2 << 16];
		int and;
		for (int i : A)
		{
			for (int j : A)
			{
				and = i & j;
				memo[and]++;
			}
		}

		for (int i = 0; i < memo.length; i++)
		{
			if (memo[i] != 0)
			{
				for (int j : A)
				{
					if ((i & j) == 0)
					{
						count += memo[i];
					}
				}
			}
		}

		return count;
	}
}
