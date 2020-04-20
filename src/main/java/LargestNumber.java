import common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 20-Apr-20
 */
@LeetCode(id = 179, name = "Largest Number", url = "https://leetcode.com/problems/largest-number/")
public class LargestNumber
{
	public String largestNumber(int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return "";
		}

		Comparator<String> stringComparator = (str1, str2) ->
		{
			String a = str1 + str2;
			String b = str2 + str1;

			return b.compareTo(a);
		};

		List<String> values = new ArrayList<>();
		for (int num : nums)
		{
			values.add(String.valueOf(num));
		}

		values.sort(stringComparator);
		StringBuilder sb = new StringBuilder();
		for (String num : values)
		{
			sb.append(num);
		}

		while (sb.length() > 1 && sb.charAt(0) == '0')
		{
			sb.delete(0, 1);
		}

		return sb.toString();
	}
}
