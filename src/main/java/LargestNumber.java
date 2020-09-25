import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 20-Apr-20
 */
@LeetCode(id = 179, name = "Largest Number", url = "https://leetcode.com/problems/largest-number/")
public class LargestNumber
{
	public String largestNumber(int[] nums)
	{
		String[] numbers = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
		{
			numbers[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(numbers, (num1, num2) ->
		{
			String a = num1 + num2;
			String b = num2 + num1;
			return b.compareTo(a);
		});

		StringBuilder sb = new StringBuilder();
		for (String num : numbers)
		{
			if (sb.length() == 0 && num.equals("0"))
			{
				continue;
			}
			sb.append(num);
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}
}
