import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-Jun-20
 */

@LeetCode(id = 1486, name = "XOR Operation in an Array", url = "https://leetcode.com/problems/xor-operation-in-an-array/")
public class XOROperationInArray
{
	public int xorOperation(int n, int start)
	{
		int val = 0;
		for (int i = 0, j = 0; j < n; j++, i++)
		{
			val ^= start + 2 * i;
		}

		return val;
	}
}
