import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 26-Feb-20
 */
@LeetCode(id = 54, name = "Spiral Matrix", url = "https://leetcode.com/problems/spiral-matrix/")
public class SpiralMatrix
{
	enum Direction
	{
		UP,
		DOWN,
		LEFT,
		RIGHT;
	}

	public List<Integer> spiralOrder(int[][] matrix)
	{
		if (matrix == null || matrix.length == 0)
		{
			return new ArrayList<>();
		}

		List<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);
		int topBound = 0;
		int bottomBound = matrix.length - 1;
		int leftBound = 0;
		int rightBound = matrix[0].length - 1;
		Direction currentDirection = Direction.RIGHT;

		while (leftBound <= rightBound && topBound <= bottomBound)
		{
			switch (currentDirection)
			{
				case RIGHT:
				{
					for (int i = leftBound; i <= rightBound; i++)
					{
						result.add(matrix[topBound][i]);
					}
					currentDirection = Direction.DOWN;
					topBound++;
					break;
				}
				case DOWN:
				{
					for (int i = topBound; i <= bottomBound; i++)
					{
						result.add(matrix[i][rightBound]);
					}
					currentDirection = Direction.LEFT;
					rightBound--;
					break;
				}
				case LEFT:
				{
					for (int i = rightBound; i >= leftBound; i--)
					{
						result.add(matrix[bottomBound][i]);
					}
					currentDirection = Direction.UP;
					bottomBound--;
					break;
				}
				case UP:
				{
					for (int i = bottomBound; i >= topBound; i--)
					{
						result.add(matrix[i][leftBound]);
					}
					currentDirection = Direction.RIGHT;
					leftBound++;
					break;
				}
			}
		}

		return result;
	}
}
