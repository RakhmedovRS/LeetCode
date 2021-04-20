package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Apr-20
 */
@LeetCode(id = 415, name = "Add Strings", url = "https://leetcode.com/problems/add-strings/")
public class AddStrings
{
	public String addStrings(String num1, String num2)
	{
		if (num1 == null && num2 == null)
		{
			return null;
		}
		else if (num1 == null)
		{
			return num2;
		}
		else if (num2 == null)
		{
			return num1;
		}

		int n1 = num1.length() - 1;
		int n2 = num2.length() - 1;
		boolean add = false;
		StringBuilder result = new StringBuilder(Math.max(num1.length(), num2.length()) + 1);
		int curr;
		while (n1 >= 0 || n2 >= 0 || add)
		{
			curr = 0;
			if (n1 >= 0)
			{
				curr += num1.charAt(n1) - '0';
				n1--;
			}

			if (n2 >= 0)
			{
				curr += num2.charAt(n2) - '0';
				n2--;
			}

			if (add)
			{
				curr += 1;
				add = false;
			}

			if (curr >= 10)
			{
				add = true;
				result.append(curr % 10);
			}
			else
			{
				result.append(curr);
			}
		}

		return result.reverse().toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new AddStrings().addStrings("0", "10"));
		System.out.println(new AddStrings().addStrings("10", "10"));
	}
}
