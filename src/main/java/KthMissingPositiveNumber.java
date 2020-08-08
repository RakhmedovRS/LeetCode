import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 08-Aug-20
 */
@LeetCode(id = 1539, name = "Kth Missing Positive Number", url = "https://leetcode.com/problems/kth-missing-positive-number/")
public class KthMissingPositiveNumber
{
	public int findKthPositive(int[] arr, int k)
	{
		Set<Integer> set = new HashSet<>();
		for (int num : arr)
		{
			set.add(num);
		}
		int i = 1;
		for (; i < Integer.MAX_VALUE; i++)
		{
			if (!set.contains(i))
			{
				k--;
			}

			if (k == 0)
			{
				break;
			}
		}

		return i;
	}
}
