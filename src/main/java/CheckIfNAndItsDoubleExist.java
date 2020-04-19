import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 19-Apr-20
 */
@LeetCode(id = 1346, name = "Check If N and Its Double Exist", url = "https://leetcode.com/problems/check-if-n-and-its-double-exist/")
public class CheckIfNAndItsDoubleExist
{
	public boolean checkIfExist(int[] arr)
	{
		if (arr == null || arr.length <= 1)
		{
			return false;
		}

		Set<Integer> set = new HashSet<>();
		for (int val : arr)
		{
			if (!set.add(val) && val == 0)
			{
				return true;
			}
		}

		for (int val : arr)
		{
			if (val != 0 && set.contains(val * 2))
			{
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new CheckIfNAndItsDoubleExist().checkIfExist(new int[]{-10, 12, -20, -8, 15}));
		System.out.println(new CheckIfNAndItsDoubleExist().checkIfExist(new int[]{7, 1, 14, 11}));
		System.out.println(new CheckIfNAndItsDoubleExist().checkIfExist(new int[]{10, 2, 5, 3}));
		System.out.println(new CheckIfNAndItsDoubleExist().checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
		System.out.println(new CheckIfNAndItsDoubleExist().checkIfExist(new int[]{0, 0}));
	}
}
