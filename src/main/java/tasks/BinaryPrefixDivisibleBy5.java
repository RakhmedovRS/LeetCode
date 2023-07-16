package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10-Jul-20
 */
@LeetCode(
		id = 1018,
		name = "Binary Prefix Divisible By 5",
		url = "https://leetcode.com/problems/binary-prefix-divisible-by-5/",
		difficulty = Difficulty.EASY
)
public class BinaryPrefixDivisibleBy5
{
	public List<Boolean> prefixesDivBy5(int[] A)
	{
		if (A == null || A.length <= 0)
		{
			return Collections.emptyList();
		}

		List<Boolean> result = new ArrayList<>();
		int num = 0;
		for (int value : A)
		{
			num = (num * 2 + value) % 5;
			result.add(num == 0);
		}

		return result;
	}
}
