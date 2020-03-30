import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 01-Mar-20
 */
@LeetCode(id = 59, name = "Spiral Matrix II", url = "https://leetcode.com/problems/spiral-matrix-ii/")
public class SpiralMatrixII
{
	enum Direction
	{
		RIGHT,
		DOWN,
		LEFT,
		UP
	}

	public int[][] generateMatrix(int n)
	{
		int[][] matrix = new int[n][n];
		int actualValue = 1;
		Direction currentDirection = Direction.RIGHT;
		int leftEdge = 0;
		int rightEdge = n - 1;
		int upperEdge = 0;
		int bottomEdge = n - 1;
		while (leftEdge <= rightEdge && upperEdge <= bottomEdge)
		{
			switch (currentDirection)
			{
				case RIGHT:
				{
					for (int i = leftEdge; i <= rightEdge; i++)
					{
						matrix[upperEdge][i] = actualValue++;
					}
					currentDirection = Direction.DOWN;
					upperEdge++;
					break;
				}
				case DOWN:
				{
					for (int i = upperEdge; i <= bottomEdge; i++)
					{
						matrix[i][rightEdge] = actualValue++;
					}
					currentDirection = Direction.LEFT;
					rightEdge--;
					break;
				}
				case LEFT:
				{
					for (int i = rightEdge; i >= leftEdge; i--)
					{
						matrix[bottomEdge][i] = actualValue++;
					}
					currentDirection = Direction.UP;
					bottomEdge--;
					break;
				}
				case UP:
				{
					for (int i = bottomEdge; i >= upperEdge; i--)
					{
						matrix[i][leftEdge] = actualValue++;
					}
					currentDirection = Direction.RIGHT;
					leftEdge++;
					break;
				}
			}
		}

		return matrix;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrix(4)));
	}
}
