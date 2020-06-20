import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Jun-20
 */
@LeetCode(id = 1128, name = "Number of Equivalent Domino Pairs", url = "https://leetcode.com/problems/number-of-equivalent-domino-pairs/")
public class NumberOfEquivalentDominoPairs
{
	public int numEquivDominoPairs(int[][] dominoes)
	{
		int equals = 0;
		int[][] memo = new int[10][10];
		for (int[] domino : dominoes)
		{
			memo[Math.min(domino[0], domino[1])][Math.max(domino[0], domino[1])]++;
		}

		for (int[] row : memo)
		{
			for (int count : row)
			{
				if (count > 1)
				{
					equals += (count * (count - 1)) / 2;
				}
			}
		}

		return equals;
	}

	public static void main(String[] args)
	{
		System.out.println(new NumberOfEquivalentDominoPairs().numEquivDominoPairs(new int[][]
			{
				{1, 2},
				{1, 2},
				{1, 1},
				{1, 2},
				{2, 2},
			}));
	}
}
