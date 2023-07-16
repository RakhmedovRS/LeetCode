package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/20/2020
 */
@LeetCode(
		id = 880,
		name = "Decoded String at Index",
		url = "https://leetcode.com/problems/decoded-string-at-index/",
		difficulty = Difficulty.MEDIUM
)
public class DecodedStringAtIndex
{
	public String decodeAtIndex(String S, long K)
	{
		return decodeAtIndex(S, K, 0);
	}

	private String decodeAtIndex(String S, long K, long len)
	{
		char ch;
		for (int i = 0; i < S.length(); i++)
		{
			ch = S.charAt(i);
			if (Character.isLetter(ch))
			{
				if (++len == K)
				{
					return "" + ch;
				}
			}
			else
			{
				if (len * (ch - '0') >= K)
				{
					return decodeAtIndex(S, K % len == 0 ? len : K % len);
				}
				len *= ch - '0';
			}
		}

		return "";
	}

	public static void main(String[] args)
	{
		DecodedStringAtIndex clazz = new DecodedStringAtIndex();
		System.out.println(clazz.decodeAtIndex("y959q969u3hb22odq595", 222280369));
		System.out.println(clazz.decodeAtIndex("ha22", 5));
		System.out.println(clazz.decodeAtIndex("leet2code3", 10));
		System.out.println(clazz.decodeAtIndex("a2345678999999999999999", 1));
	}
}
