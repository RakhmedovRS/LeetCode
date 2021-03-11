import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
@LeetCode(
		id = 12,
		name = "Integer to Roman",
		url = "https://leetcode.com/problems/integer-to-roman/",
		difficulty = Difficulty.MEDIUM
)
public class IntegerToRoman
{
	public String intToRoman(int num)
	{
		StringBuilder sb = new StringBuilder();
		while (num != 0)
		{
			if (num >= 1000)
			{
				int c = num / 1000;

				for (int i = 0; i < c; i++)
				{
					sb.append("M");
				}

				num %= 1000;
			}
			else if (num / 900 > 0)
			{
				sb.append("CM");
				num %= 900;
			}
			else if (num >= 500)
			{
				sb.append("D");
				num %= 500;
			}
			else if (num / 400 > 0)
			{
				sb.append("CD");
				num %= 400;
			}
			else if (num >= 100)
			{
				int c = num / 100;

				for (int i = 0; i < c; i++)
				{
					sb.append("C");
				}

				num %= 100;
			}
			else if (num / 90 > 0)
			{
				sb.append("XC");
				num %= 90;
			}
			else if (num >= 50)
			{
				sb.append("L");
				num %= 50;
			}
			else if (num / 40 > 0)
			{
				sb.append("XL");
				num %= 40;
			}
			else if (num >= 10)
			{
				int c = num / 10;

				for (int i = 0; i < c; i++)
				{
					sb.append("X");
				}

				num %= 10;
			}
			else if (num / 9 > 0)
			{
				sb.append("IX");
				num %= 9;
			}
			else if (num >= 5)
			{
				sb.append("V");
				num %= 5;
			}
			else if (num / 4 > 0)
			{
				sb.append("IV");
				num %= 4;
			}
			else
			{
				while (num > 0)
				{
					sb.append("I");
					num--;
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new IntegerToRoman().intToRoman(1));
		System.out.println(new IntegerToRoman().intToRoman(3));
		System.out.println(new IntegerToRoman().intToRoman(4));
		System.out.println(new IntegerToRoman().intToRoman(6));
		System.out.println(new IntegerToRoman().intToRoman(9));
		System.out.println(new IntegerToRoman().intToRoman(10));
	}
}
