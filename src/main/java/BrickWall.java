import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 2/24/2021
 */
@LeetCode(
	id = 554,
	name = "Brick Wall",
	url = "https://leetcode.com/problems/brick-wall/",
	difficulty = Difficulty.MEDIUM
)
public class BrickWall
{
	public int leastBricks(List<List<Integer>> wall)
	{
		int max = 0;
		int temp;
		Map<Integer, Integer> map = new HashMap<>();
		int current;
		for (List<Integer> bricks : wall)
		{
			current = 0;
			for (int i = 0; i < bricks.size() - 1; i++)
			{
				current += bricks.get(i);
				temp = map.getOrDefault(current, 0) + 1;
				map.put(current, temp);
				max = Math.max(max, temp);
			}
		}

		return wall.size() - max;
	}
}
