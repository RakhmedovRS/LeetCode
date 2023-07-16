package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 5/24/2021
 */
@LeetCode(
		id = 1871,
		name = "Jump Game VII",
		url = "https://leetcode.com/problems/jump-game-vii/",
		difficulty = Difficulty.MEDIUM
)
public class JumpGameVII
{
	public boolean canReach(String s, int minJump, int maxJump)
	{
		char[] chars = s.toCharArray();
		boolean[] visited = new boolean[chars.length];
		visited[0] = true;

		int count = 0;
		for (int i = minJump; i < chars.length; i++)
		{
			count += visited[i - minJump] ? 1 : 0;
			if (i - maxJump > 0)
			{
				count -= visited[i - maxJump - 1] ? 1 : 0;
			}

			visited[i] = chars[i] == '0' && count > 0;
		}

		return visited[visited.length - 1];
	}
}
