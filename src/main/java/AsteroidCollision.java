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
		Deque<Integer> deque = new LinkedList<>();
		int prev;
		for (int asteroid : asteroids)
		{
			if (asteroid < 0)
			{
				while (!deque.isEmpty() && deque.getLast() > 0 && asteroid < 0)
				{
					prev = deque.removeLast();
					if (prev + asteroid > 0)
					{
						deque.addLast(prev);
						asteroid = 0;
					}
					else if (prev + asteroid == 0)
					{
						asteroid = 0;
					}
				}

				if (asteroid != 0)
				{
					deque.addLast(asteroid);
				}
			}
			else
			{
				deque.addLast(asteroid);
			}
		}

		int i = 0;
		int[] answer = new int[deque.size()];
		while (!deque.isEmpty())
		{
			answer[i++] = deque.removeFirst();
		}

		return answer;
	}
}
