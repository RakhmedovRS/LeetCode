import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 09-Aug-20
 */
@LeetCode(id = 1545, name = "Find Kth Bit in Nth Binary String", url = "https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/")
public class FindKthBitInNthBinaryString
{
	public char findKthBit(int n, int k)
	{
		StringBuilder curr = new StringBuilder();
		curr.append(0);
		StringBuilder prev;
		while (--n > 0)
		{
			prev = curr;
			curr = new StringBuilder(prev).append(1);
			prev.reverse();
			for (int i = 0; i < prev.length(); i++)
			{
				if (prev.charAt(i) == '0')
				{
					curr.append('1');
				}
				else
				{
					curr.append('0');
				}
			}
		}

		return curr.charAt(k - 1);
	}
}
