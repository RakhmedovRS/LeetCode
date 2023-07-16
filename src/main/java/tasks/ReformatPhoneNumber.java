package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/20/2020
 */
@LeetCode(
		id = 1694,
		name = "Reformat Phone Number",
		url = "https://leetcode.com/problems/reformat-phone-number/",
		difficulty = Difficulty.EASY
)
public class ReformatPhoneNumber
{
	public String reformatNumber(String number)
	{
		LinkedList<Integer> nums = new LinkedList<>();
		for (char ch : number.toCharArray())
		{
			if (Character.isDigit(ch))
			{
				nums.add(ch - '0');
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!nums.isEmpty())
		{
			if (nums.size() > 4 || nums.size() == 3)
			{
				sb.append(nums.removeFirst());
				sb.append(nums.removeFirst());
				sb.append(nums.removeFirst());
			}
			else
			{
				sb.append(nums.removeFirst());
				sb.append(nums.removeFirst());
			}

			if (!nums.isEmpty())
			{
				sb.append("-");
			}
		}

		return sb.toString();
	}

	public static void main(String[] args)
	{
		ReformatPhoneNumber clazz = new ReformatPhoneNumber();
		System.out.println(clazz.reformatNumber("1-23-45 6"));
		System.out.println(clazz.reformatNumber("123 4-5678"));
		System.out.println(clazz.reformatNumber("12"));
		System.out.println(clazz.reformatNumber("--17-5 229 35-39475 "));
	}
}
