package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 16-Jun-20
 */
@LeetCode(
		id = 306,
		name = "Additive Number",
		url = "https://leetcode.com/problems/additive-number/",
		difficulty = Difficulty.MEDIUM
)
public class AdditiveNumber
{
	public boolean isAdditiveNumber(String num)
	{
		return isAdditiveNumber(num, 0, new ArrayList<>());
	}

	private boolean isAdditiveNumber(String num, int pos, List<String> prev)
	{
		if (pos == num.length() && prev.size() > 2)
		{
			return true;
		}

		for (int numCount = 1; pos + numCount <= num.length(); numCount++)
		{
			String currNum = num.substring(pos, pos + numCount);
			if (currNum.length() > 1 && currNum.charAt(0) == '0')
			{
				return false;
			}

			if (prev.size() < 2 || currNum.equals(add(prev.get(prev.size() - 2), prev.get(prev.size() - 1))))
			{
				prev.add(currNum);
				if (isAdditiveNumber(num, pos + numCount, prev))
				{
					return true;
				}
				prev.remove(prev.size() - 1);
			}
		}

		return false;
	}

	private String add(String a, String b)
	{
		int rest = 0;
		int indexA = a.length() - 1;
		int indexB = b.length() - 1;
		int res = 0;
		StringBuilder value = new StringBuilder();
		while (indexA >= 0 || indexB >= 0 || rest > 0)
		{
			res += rest;
			res += indexA < 0 ? 0 : a.charAt(indexA--) - '0';
			res += indexB < 0 ? 0 : b.charAt(indexB--) - '0';
			rest = res / 10;
			res %= 10;
			value.append(res);
			res = 0;
		}

		return value.reverse().toString();
	}
}
