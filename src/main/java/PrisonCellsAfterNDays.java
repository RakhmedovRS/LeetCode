import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 03-Jul-20
 */
@LeetCode(id = 957, name = "Prison Cells After N Days", url = "https://leetcode.com/problems/prison-cells-after-n-days/")
public class PrisonCellsAfterNDays
{
	public int[] prisonAfterNDays(int[] cells, int N)
	{
		int[] aux = new int[cells.length];
		if (N != 0)
		{
			N = (N % 14 == 0) ? 14 : N % 14;
		}
		for (int step = 0; step < N; step++)
		{
			if (step % 2 == 0)
			{
				process(cells, aux);
			}
			else
			{
				process(aux, cells);
			}
		}

		return N % 2 == 0 ? cells : aux;
	}

	private void process(int[] prev, int[] curr)
	{
		for (int i = 0; i < prev.length; i++)
		{
			if (i == 0 || i == prev.length - 1)
			{
				curr[i] = 0;
				continue;
			}

			curr[i] = prev[i - 1] == prev[i + 1] ? 1 : 0;
		}
	}
}
