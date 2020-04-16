import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 16-Apr-20
 */
@LeetCode(id = 1306, name = "Jump Game III", url = "https://leetcode.com/problems/jump-game-iii/")
public class JumpGameIII
{
	public boolean canReach(int[] positions, int start)
	{
		return canJump(positions, start, new HashSet<>());
	}

	private boolean canJump(int[] positions, int currentPos, Set<Integer> visited)
	{
		if (currentPos < 0 || currentPos >= positions.length || visited.contains(currentPos))
		{
			return false;
		}

		if (positions[currentPos] == 0)
		{
			return true;
		}

		visited.add(currentPos);

		return canJump(positions, currentPos - positions[currentPos], visited)
			|| canJump(positions, currentPos + positions[currentPos], visited);
	}

	public static void main(String[] args)
	{
		System.out.println(new JumpGameIII().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
		System.out.println(new JumpGameIII().canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));
		System.out.println(new JumpGameIII().canReach(new int[]{3, 0, 2, 1, 2}, 2));
	}
}
