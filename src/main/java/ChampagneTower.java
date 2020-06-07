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
		double[][] tower = new double[102][];
		for (int i = 0; i < 102; i++)
		{
			tower[i] = new double[i + 1];
		}

		tower[0][0] = poured;

		for (int row = 0; row < 100; row++)
		{
			for (int column = 0; column <= row; column++)
			{
				if (tower[row][column] >= 1)
				{
					tower[row + 1][column] += (tower[row][column] - 1) / 2;
					tower[row + 1][column + 1] += (tower[row][column] - 1) / 2;
					tower[row][column] = 1;
				}
				else
				{
					break;
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
