package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
@LeetCode(id = 1108, name = "Defanging an IP Address", url = "https://leetcode.com/problems/defanging-an-ip-address/")
public class DefangingIPAddress
{
	public String defangIPaddr(String address)
	{
		StringBuilder stringBuilder = new StringBuilder();
		for (char ch : address.toCharArray())
		{
			if (ch == '.')
			{
				stringBuilder.append('[').append('.').append(']');
			}
			else
			{
				stringBuilder.append(ch);
			}
		}
		return stringBuilder.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new DefangingIPAddress().defangIPaddr("1.1.1.1"));
		System.out.println(new DefangingIPAddress().defangIPaddr("255.100.50.0"));
	}
}
