import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12-Jul-20
 */
@LeetCode(id = 1512, name = "Number of Good Pairs", url = "https://leetcode.com/problems/number-of-good-pairs/")
public class NumberOfGoodPairs
{
	public int numIdenticalPairs(int[] nums)
	{
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int num : nums)
		{
			if (map.containsKey(num))
			{
				count += map.get(num);
			}
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		return count;
	}
}
