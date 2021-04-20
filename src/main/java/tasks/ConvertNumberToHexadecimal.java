package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-Jul-20
 */
@LeetCode(id = 405, name = "Convert a Number to Hexadecimal", url = "https://leetcode.com/problems/convert-a-number-to-hexadecimal/")
public class ConvertNumberToHexadecimal
{
	public String toHex(int num)
	{
		if (num == 0)
		{
			return "0";
		}
		char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		StringBuilder sb = new StringBuilder();
		while (num != 0)
		{
			sb.append(map[(num & 15)]);
			num = (num >>> 4);
		}
		return sb.reverse().toString();
	}
}
