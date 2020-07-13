import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 13-Jul-20
 */
@LeetCode(id = 735, name = "Asteroid Collision", url = "https://leetcode.com/problems/asteroid-collision/")
public class AsteroidCollision
{
	public int[] asteroidCollision(int[] asteroids)
	{
		Deque<Integer> stack = new LinkedList<>();
		outer:
		for (int asteroid : asteroids)
		{
			if (stack.isEmpty() || asteroid > 0 || stack.peek() < 0)
			{
				stack.push(asteroid);
			}
			else
			{
				boolean rest = false;
				while (!stack.isEmpty() && stack.peek() > 0)
				{
					rest = false;
					int temp = stack.remove();
					if (temp + asteroid == 0)
					{
						continue outer;
					}

					if (Math.abs(asteroid) < temp)
					{
						stack.push(temp);
						continue outer;
					}
					else
					{
						rest = true;
					}
				}

				if (rest)
				{
					stack.push(asteroid);
				}
			}
		}

		int[] answer = new int[stack.size()];
		int pos = stack.size() - 1;
		while (!stack.isEmpty())
		{
			answer[pos--] = stack.pop();
		}

		return answer;
	}
}
