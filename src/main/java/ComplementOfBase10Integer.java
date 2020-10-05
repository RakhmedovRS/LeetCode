import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Sep-20
 */
@LeetCode(id = 1009, name = "Complement of Base 10 Integer", url = "https://leetcode.com/problems/complement-of-base-10-integer/")
public class ComplementOfBase10Integer
{
	public int bitwiseComplement(int N)
	{
		if (N == 0)
		{
			return 1;
		}

		boolean seen = false;
		int complement = 0;
		for (int i = 31; i >= 0; i--)
		{
			if (seen || (N & (N & 1 << i)) != 0)
			{
				if ((N & (1 << i)) == 0)
				{
					complement ^= 1 << i;
				}
				seen = true;
			}
		}

		return complement;
	}
}
