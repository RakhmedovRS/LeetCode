package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/18/2020
 */
@LeetCode(
	id = 353,
	name = "Design Snake Game",
	url = "https://leetcode.com/problems/design-snake-game/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class DesignSnakeGame
{
	class SnakeGame
	{
		boolean[][] grid;
		int width;
		int height;
		int[] head;
		int[] tail;
		int score;
		int foodPos;
		int[][] food;
		Map<String, int[]> directions;
		LinkedList<String> moves;

		/**
		 * Initialize your data structure here.
		 *
		 * @param width  - screen width
		 * @param height - screen height
		 * @param food   - A list of food positions E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
		 */
		public SnakeGame(int width, int height, int[][] food)
		{
			this.height = height;
			this.width = width;
			this.food = food;

			head = new int[]{0, 0};
			tail = new int[]{0, 0};

			grid = new boolean[height][width];

			directions = new HashMap<>();
			directions.put("U", new int[]{-1, 0});
			directions.put("L", new int[]{0, -1});
			directions.put("R", new int[]{0, 1});
			directions.put("D", new int[]{1, 0});

			moves = new LinkedList<>();
		}

		/**
		 * Moves the snake.
		 *
		 * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
		 * @return The game's score after the move. Return -1 if game over. Game over when snake crosses the screen boundary or bites its body.
		 */
		public int move(String direction)
		{
			if (head[0] < 0 || head[0] >= height || head[1] < 0 || head[1] >= width)
			{
				return -1;
			}

			head[0] += directions.get(direction)[0];
			head[1] += directions.get(direction)[1];

			if (head[0] < 0 || head[0] >= height || head[1] < 0 || head[1] >= width || grid[head[0]][head[1]])
			{
				return -1;
			}

			moves.addLast(direction);

			grid[head[0]][head[1]] = true;

			if (addFood(head[0], head[1]))
			{
				score++;
			}
			else
			{
				String move = moves.removeFirst();

				tail[0] += directions.get(move)[0];
				tail[1] += directions.get(move)[1];

				grid[tail[0]][tail[1]] = false;
			}

			return score;
		}

		private boolean addFood(int row, int column)
		{
			if (foodPos < food.length)
			{
				if (food[foodPos][0] == row && food[foodPos][1] == column)
				{
					foodPos++;
					return true;
				}
			}

			return false;
		}
	}

	public static void main(String[] args)
	{
		SnakeGame snakeGame = new DesignSnakeGame().new SnakeGame(3, 3,
			new int[][]{
				{0, 1},
				{0, 2},
				{1, 2},
				{2, 2},
				{2, 1},
				{2, 0},
				{1, 0},
			});
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("D"));

		System.out.println();

		snakeGame = new DesignSnakeGame().new SnakeGame(3, 2, new int[][]{{1, 2}, {0, 1}});
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("U"));
	}
}
