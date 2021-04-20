package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Jul-20
 */
@LeetCode(id = 984, name = "String Without AAA or BBB", url = "https://leetcode.com/problems/string-without-aaa-or-bbb/")
public class StringWithoutAAAOrBBB
{
	public String strWithout3a3b(int A, int B)
	{
		char[] chars = new char[A + B];
		int pos = 0;
		boolean useA;
		while (A > 0 || B > 0)
		{
			useA = false;
			if (pos > 1 && chars[pos - 1] == chars[pos - 2])
			{
				if (chars[pos - 1] == 'b')
				{
					useA = true;
				}
			}
			else if (A > B)
			{
				useA = true;
			}

			if (useA)
			{
				chars[pos++] = 'a';
				A--;
			}
			else
			{
				chars[pos++] = 'b';
				B--;
			}
		}

		return String.valueOf(chars);
	}
}
