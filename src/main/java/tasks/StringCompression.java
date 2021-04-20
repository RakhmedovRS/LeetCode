package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 05-Jun-20
 */
@LeetCode(id = 443, name = "String Compression", url = "https://leetcode.com/problems/string-compression/")
public class StringCompression
{
	public int compress(char[] chars)
	{
		int count = 0;
		char prev = chars[0];
		List<Character> compressed = new ArrayList<>();
		for (char ch : chars)
		{
			if (prev == ch)
			{
				count++;
			}
			else
			{
				compressed.add(prev);
				if (count > 1)
				{
					for (char c : String.valueOf(count).toCharArray())
					{
						compressed.add(c);
					}
				}
				prev = ch;
				count = 1;
			}
		}

		compressed.add(prev);
		if (count > 1)
		{
			for (char c : String.valueOf(count).toCharArray())
			{
				compressed.add(c);
			}
		}

		if (chars.length >= compressed.size())
		{
			for (int i = 0; i < compressed.size(); i++)
			{
				chars[i] = compressed.get(i);
			}

			return compressed.size();
		}
		else
		{
			return chars.length;
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new StringCompression().compress("aabbccc".toCharArray()));
		System.out.println(new StringCompression().compress("a".toCharArray()));
		System.out.println(new StringCompression().compress("abbbbbbbbbbb".toCharArray()));
	}
}
