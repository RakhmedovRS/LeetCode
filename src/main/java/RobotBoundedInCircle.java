import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Jul-20
 */
@LeetCode(id = 1041, name = "Robot Bounded In Circle", url = "https://leetcode.com/problems/robot-bounded-in-circle/")
public class RobotBoundedInCircle
{
	public boolean isRobotBounded(String instructions)
	{
		int x = 0;
		int y = 0;
		int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		int direction = 0;
		for (char instruction : instructions.toCharArray())
		{
			if (instruction == 'R')
			{
				direction = direction + 1 == 4 ? 0 : direction + 1;
			}
			else if (instruction == 'L')
			{
				direction = direction - 1 < 0 ? 3 : direction - 1;
			}
			else
			{
				x += directions[direction][0];
				y += directions[direction][1];
			}
		}

		return x == 0 && y == 0 || direction != 0;
	}

	public static void main(String[] args)
	{
		System.out.println(new RobotBoundedInCircle().isRobotBounded("GL"));
		System.out.println(new RobotBoundedInCircle().isRobotBounded("GLGLGGLGL"));
		System.out.println(new RobotBoundedInCircle().isRobotBounded("GGLLGG"));
	}
}
