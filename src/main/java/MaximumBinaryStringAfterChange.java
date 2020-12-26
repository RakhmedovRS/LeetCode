import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 12/26/2020
 */
@LeetCode(
	id = 1702,
	name = "Maximum Binary String After Change",
	url = "https://leetcode.com/problems/maximum-binary-string-after-change/",
	difficulty = Difficulty.MEDIUM
)
public class MaximumBinaryStringAfterChange
{
	public String maximumBinaryString(String binary)
	{
		int zeroes = 0;
		char[] chars = new char[binary.length()];
		Arrays.fill(chars, '1');
		for (char ch : binary.toCharArray())
		{
			if (ch == '0')
			{
				zeroes++;
			}
		}

		for (int i = 0; i < binary.length(); i++)
		{
			if (binary.charAt(i) == '0')
			{
				chars[i + zeroes - 1] = '0';
				break;
			}
		}

		return String.valueOf(chars);
	}

	public static void main(String[] args)
	{
		MaximumBinaryStringAfterChange clazz = new MaximumBinaryStringAfterChange();
		System.out.println(clazz.maximumBinaryString("101010111011001101000110010001100001111")); //"111111111111111111101111111111111111111"
		System.out.println(clazz.maximumBinaryString("01111001100000110010")); //"11111111110111111111"
		System.out.println(clazz.maximumBinaryString("01110")); //10111
		System.out.println(clazz.maximumBinaryString("000110")); //111011
	}
}
