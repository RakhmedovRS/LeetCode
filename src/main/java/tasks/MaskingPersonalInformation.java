package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/27/2021
 */
@LeetCode(
	id = 831,
	name = "Masking Personal Information",
	url = "https://leetcode.com/problems/masking-personal-information/",
	difficulty = Difficulty.MEDIUM
)
public class MaskingPersonalInformation
{
	public String maskPII(String S)
	{
		StringBuilder sb = new StringBuilder();
		int dogIndex = S.indexOf('@');
		if (dogIndex != -1)
		{
			S = S.toLowerCase();
			sb.append(S.charAt(0));
			sb.append("*****");
			sb.append(S.charAt(dogIndex - 1));
			sb.append(S.substring(dogIndex));
		}
		else
		{
			int digits = 0;
			for (int i = 0; i < S.length(); i++)
			{
				if (Character.isDigit(S.charAt(i)))
				{
					digits++;
				}
			}

			if (digits == 10)
			{
				sb.append("***-***-");
			}
			else
			{
				sb.append("+");
				for (int i = 0; i < digits - 10; i++)
				{
					sb.append("*");
				}
				sb.append("-***-***-");
			}

			int c = 4;
			for (int i = S.length() - 1; i >= 0; i--)
			{
				if (Character.isDigit(S.charAt(i)))
				{
					c--;
				}
				if (c == 0)
				{
					for (int j = i; j < S.length(); j++)
					{
						if (Character.isDigit(S.charAt(j)))
						{
							sb.append(S.charAt(j));
						}
					}

					break;
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		MaskingPersonalInformation clazz = new MaskingPersonalInformation();
		System.out.println(clazz.maskPII("LeetCode@LeetCode.com"));
		System.out.println(clazz.maskPII("AB@qq.com"));
		System.out.println(clazz.maskPII("+(501321)-50-23431"));
		System.out.println(clazz.maskPII("1(234)567-890"));
		System.out.println(clazz.maskPII("86-(10)12345678"));
	}
}
