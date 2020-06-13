import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Jun-20
 */
@LeetCode(id = 717, name = "1-bit and 2-bit Characters", url = "https://leetcode.com/problems/1-bit-and-2-bit-characters/")
public class OneBitAndTwoBitCharacters
{
	public boolean isOneBitCharacter(int[] bits)
	{
		return isOneBitCharacter(bits, 0);
	}

	private boolean isOneBitCharacter(int[] bits, int pos)
	{
		if (pos == bits.length - 1)
		{
			return bits[pos] == 0;
		}

		if (pos >= bits.length)
		{
			return false;
		}

		return ((bits[pos] == 0 && isOneBitCharacter(bits, pos + 1))
			|| (bits[pos] == 1 && bits[pos + 1] == 0 && isOneBitCharacter(bits, pos + 2))
			|| (bits[pos] == 1 && bits[pos + 1] == 1 && isOneBitCharacter(bits, pos + 2))
		);
	}

	public static void main(String[] args)
	{
		System.out.println(new OneBitAndTwoBitCharacters().isOneBitCharacter(new int[]{1, 1, 1, 0}));
	}
}
