package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Jun-20
 */
@LeetCode(id = 799, name = "Champagne Tower", url = "https://leetcode.com/problems/champagne-tower/")
public class ChampagneTower
{
	public double champagneTower(int poured, int query_row, int query_glass)
	{
		double[][] tower = new double[query_row + 2][];
		for (int row = 0, columns = 1; row <= query_row + 1; row++, columns++)
		{
			tower[row] = new double[columns];
		}

		tower[0][0] = poured;
		double rest;
		for (int row = 0; row <= query_row; row++)
		{
			for (int column = 0; column < tower[row].length; column++)
			{
				if (tower[row][column] > 1)
				{
					rest = tower[row][column] - 1;
					tower[row + 1][column] += rest / 2;
					tower[row + 1][column + 1] += rest / 2;
					tower[row][column] = 1;
				}
			}
		}

		return tower[query_row][query_glass];
	}

	public static void main(String[] args)
	{
		System.out.println(new ChampagneTower().champagneTower(1000000000, 99, 99));
	}
}
