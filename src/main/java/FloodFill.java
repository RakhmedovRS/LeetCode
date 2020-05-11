import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11-May-20
 */
@LeetCode(id = 733, name = "Flood Fill", url = "https://leetcode.com/problems/flood-fill/")
public class FloodFill
{
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
	{
		if (image == null || image.length == 0)
		{
			return image;
		}
		boolean[][] visited = new boolean[image.length][];
		for (int i = 0; i < visited.length; i++)
		{
			visited[i] = new boolean[image[0].length];
		}
		floodFill(image, sr, sc, newColor, image[sr][sc], visited);
		return image;
	}

	public void floodFill(int[][] image, int row, int column, int newColor, int startColor, boolean[][] visited)
	{
		if (row < 0 || row == image.length
			|| column < 0 || column == image[row].length
			|| image[row][column] != startColor || visited[row][column])
		{
			return;
		}

		image[row][column] = newColor;
		visited[row][column] = true;

		floodFill(image, row - 1, column, newColor, startColor, visited);
		floodFill(image, row + 1, column, newColor, startColor, visited);
		floodFill(image, row, column - 1, newColor, startColor, visited);
		floodFill(image, row, column + 1, newColor, startColor, visited);
	}

	public static void main(String[] args)
	{
		int[][] picture = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		System.out.println(Arrays.deepToString(new FloodFill().floodFill(picture, 1, 1, 2)));

		picture = new int[][]{{0, 0, 0}, {0, 0, 1}};
		System.out.println(Arrays.deepToString(new FloodFill().floodFill(picture, 1, 1, 1)));
	}
}
