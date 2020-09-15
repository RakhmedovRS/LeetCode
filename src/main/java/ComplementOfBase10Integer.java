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
		int complement = 0;
		int pos = 0;
		int bit;
		while (N > 0)
		{
			bit = N & 1;
			bit = Math.abs(bit - 1);
			complement = (complement ^ (bit << pos));
			N >>= 1;
			pos++;
		}

		return complement;
	}
}
