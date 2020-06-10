import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Jun-20
 */
@LeetCode(id = 258, name = "Add Digits", url = "https://leetcode.com/problems/add-digits/")
public class AddDigits
{
	public int addDigits(int num)
	{
		int rest;
		while (num >= 10)
		{
			rest = num % 10;
			num /= 10;
			num += rest;
		}

		return num;
	}
}
