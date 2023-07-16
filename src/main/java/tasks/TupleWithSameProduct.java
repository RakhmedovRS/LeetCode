package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/17/2021
 */
@LeetCode(
		id = 1726,
		name = "Tuple with Same Product",
		url = "https://leetcode.com/problems/tuple-with-same-product/",
		difficulty = Difficulty.MEDIUM
)
public class TupleWithSameProduct
{
	public int tupleSameProduct(int[] nums)
	{
		int count = 0;
		int n = nums.length;
		Map<Integer, List<int[]>> map = new HashMap<>();
		int res;
		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
				res = nums[i] * nums[j];
				map.putIfAbsent(res, new ArrayList<>());
				int[] b = new int[]{nums[i], nums[j]};
				for (int[] a : map.get(res))
				{
					if (a[0] != b[0] && a[0] != b[1] && a[1] != b[0] && a[1] != b[1])
					{
						count += 8;
					}
				}

				map.get(res).add(b);
			}
		}

		return count;
	}
}
