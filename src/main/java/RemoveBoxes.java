import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/14/2020
 */
@LeetCode(
	id = 546,
	name = "Remove Boxes",
	url = "https://leetcode.com/problems/remove-boxes/",
	difficulty = Difficulty.HARD)
public class RemoveBoxes
{
	public int removeBoxes(int[] boxes)
	{
		return dfs(boxes, 0, boxes.length - 1, 0, new Integer[boxes.length][boxes.length][boxes.length]);
	}

	private int dfs(int[] boxes, int left, int right, int used, Integer[][][] memo)
	{
		if (left > right)
		{
			return 0;
		}

		if (left == right)
		{
			return (used + 1) * (used + 1);
		}

		if (memo[left][right][used] != null)
		{
			return memo[left][right][used];
		}

		memo[left][right][used] = dfs(boxes, left + 1, right, 0, memo) + (used + 1) * (used + 1);
		for (int middle = left + 1; middle <= right; middle++)
		{
			if (boxes[left] == boxes[middle])
			{
				memo[left][right][used] = Math.max(memo[left][right][used],
					dfs(boxes, left + 1, middle - 1, 0, memo) + dfs(boxes, middle, right, used + 1, memo));
			}
		}

		return memo[left][right][used];
	}

	public static void main(String[] args)
	{
		System.out.println(new RemoveBoxes().removeBoxes(new int[]{3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7}));
		System.out.println(new RemoveBoxes().removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
	}
}
