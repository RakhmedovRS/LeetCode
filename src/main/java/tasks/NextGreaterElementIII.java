package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 18-Jul-20
 */
@LeetCode(
	id = 556,
	name = "Next Greater Element III",
	url = "https://leetcode.com/problems/next-greater-element-iii/",
	premium = true
)
public class NextGreaterElementIII
{
	public int nextGreaterElement(int n)
	{
		char[] digits = getDigits(n);
		for (int i = digits.length - 1; i > 0; i--)
		{
			if (digits[i] > digits[i - 1])
			{
				int pos = i;
				for (int j = i; j < digits.length; j++)
				{
					if (digits[i - 1] < digits[j] && digits[pos] > digits[j])
					{
						pos = j;
					}
				}

				char temp = digits[i - 1];
				digits[i - 1] = digits[pos];
				digits[pos] = temp;

				sort(digits, i);
				long candidate = Long.parseLong(String.valueOf(digits));
				if (candidate < Integer.MAX_VALUE)
				{
					return (int) candidate;
				}
				else
				{
					return -1;
				}
			}
		}

		return -1;
	}

	private void sort(char[] digits, int startPos)
	{
		int[] table = new int[10];
		for (int i = startPos; i < digits.length; i++)
		{
			table[digits[i] - '0']++;
		}

		for (int i = startPos, j = 0; i < digits.length; i++)
		{
			while (table[j] == 0)
			{
				j++;
			}

			digits[i] = (char) ('0' + j);
			table[j]--;
		}
	}

	private char[] getDigits(int n)
	{
		StringBuilder sb = new StringBuilder();
		while (n > 0)
		{
			sb.append(n % 10);
			n /= 10;
		}

		return sb.reverse().toString().toCharArray();
	}

	public static void main(String[] args)
	{
		System.out.println(new NextGreaterElementIII().nextGreaterElement(12443322));
		System.out.println(new NextGreaterElementIII().nextGreaterElement(230241));
		System.out.println(new NextGreaterElementIII().nextGreaterElement(21));
		System.out.println(new NextGreaterElementIII().nextGreaterElement(315));
		System.out.println(new NextGreaterElementIII().nextGreaterElement(12));
	}
}
