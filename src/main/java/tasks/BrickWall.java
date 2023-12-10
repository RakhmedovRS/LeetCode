package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
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
public class BrickWall {
	public int leastBricks(List<List<Integer>> walls) {
		Map<Integer, Integer> memo = new HashMap<>();
		for (List<Integer> wall : walls) {
			int pos = 0;
			for (int i = 0; i < wall.size() - 1; i++) {
				pos += wall.get(i);
				memo.put(pos, memo.getOrDefault(pos, 0) + 1);
			}
		}

		int min = walls.size();
		for (Map.Entry<Integer, Integer> entry : memo.entrySet()) {
			min = Math.min(min, walls.size() - entry.getValue());
		}

		return min;
	}

	public static void main(String[] args) {
		BrickWall clazz = new BrickWall();
		System.out.println(clazz.leastBricks(Arrays.asList(
				Arrays.asList(1, 2, 2, 1),
				Arrays.asList(3, 1, 2),
				Arrays.asList(1, 3, 2),
				Arrays.asList(2, 4),
				Arrays.asList(3, 1, 2),
				Arrays.asList(1, 3, 1, 1))));
	}
}
