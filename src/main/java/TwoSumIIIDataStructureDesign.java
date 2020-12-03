import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/3/2020
 */
@LeetCode(
	id = 170,
	name = "Two Sum III - Data structure design",
	url = "https://leetcode.com/problems/two-sum-iii-data-structure-design/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class TwoSumIIIDataStructureDesign
{
	class TwoSum
	{

		Map<Integer, Integer> map;

		public TwoSum()
		{
			map = new HashMap<>();
		}

		/**
		 * Add the number to an internal data structure..
		 */
		public void add(int number)
		{
			map.put(number, map.getOrDefault(number, 0) + 1);
		}

		/**
		 * Find if there exists any pair of numbers which sum is equal to the value.
		 */
		public boolean find(int value)
		{
			int current;
			int target;
			for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet())
			{
				current = integerIntegerEntry.getKey();
				target = value - current;
				if (current == target && map.get(current) > 1)
				{
					return true;
				}
				else if (map.containsKey(target) && current != target)
				{
					return true;
				}
			}

			return false;
		}
	}
}
