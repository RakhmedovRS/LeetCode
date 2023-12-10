package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Jul-20
 */
@LeetCode(id = 1041, name = "Robot Bounded In Circle", url = "https://leetcode.com/problems/robot-bounded-in-circle/")
public class RobotBoundedInCircle {
	enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}

	class Position {
		int x;
		int y;
		Direction direction;

		public Position(int x, int y, Direction direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}
	}

	public boolean isRobotBounded(String instructions) {
		char[] chars = instructions.toCharArray();
		Position position = new Position(0, 0, Direction.UP);
		for (int i = 0; i < chars.length * 5; i++) {
			if (chars[i % chars.length] == 'G') {
				switch (position.direction) {
					case UP: {
						position.y++;
						break;
					}
					case DOWN: {
						position.y--;
						break;
					}
					case LEFT: {
						position.x--;
						break;
					}
					case RIGHT: {
						position.x++;
						break;
					}
				}
			}
			else if (chars[i % chars.length] == 'L') {
				switch (position.direction) {
					case UP: {
						position.direction = Direction.LEFT;
						break;
					}
					case DOWN: {
						position.direction = Direction.RIGHT;
						break;
					}
					case LEFT: {
						position.direction = Direction.DOWN;
						break;
					}
					case RIGHT: {
						position.direction = Direction.UP;
						break;
					}
				}
			}
			else {
				switch (position.direction) {
					case UP: {
						position.direction = Direction.RIGHT;
						break;
					}
					case DOWN: {
						position.direction = Direction.LEFT;
						break;
					}
					case LEFT: {
						position.direction = Direction.UP;
						break;
					}
					case RIGHT: {
						position.direction = Direction.DOWN;
						break;
					}
				}
			}
		}

		return position.direction != Direction.UP || (position.x == 0 && position.y == 0);
	}

	public static void main(String[] args) {
		System.out.println(new RobotBoundedInCircle().isRobotBounded("GL"));
		System.out.println(new RobotBoundedInCircle().isRobotBounded("GLGLGGLGL"));
		System.out.println(new RobotBoundedInCircle().isRobotBounded("GGLLGG"));
	}
}
