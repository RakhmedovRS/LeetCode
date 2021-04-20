package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11/15/2020
 */
@LeetCode(
	id = 1656,
	name = "Design an Ordered Stream",
	url = "https://leetcode.com/problems/design-an-ordered-stream/",
	difficulty = Difficulty.EASY
)
public class DesignAnOrderedStream
{
	class OrderedStream
	{
		int counter;
		Map<Integer, String> map;

		public OrderedStream(int n)
		{
			counter = 1;
			map = new HashMap<>();
		}

		public List<String> insert(int id, String value)
		{
			map.put(id, value);
			List<String> answer = new ArrayList<>();
			if (id == counter)
			{
				while (map.containsKey(counter))
				{
					answer.add(map.remove(counter++));
				}
			}
			return answer;
		}
	}
}
