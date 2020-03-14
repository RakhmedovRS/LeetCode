/**
 * @author RakhmedovRS
 * @created 14-Mar-20
 */
@LeetCode(id = 72, name = "Edit Distance", url = "https://leetcode.com/problems/edit-distance/")
public class EditDistance
{
	public int minDistance(String word1, String word2)
	{
		char[] firstWord = word1.toCharArray();
		char[] secondWord = word2.toCharArray();
		int rowsCount = firstWord.length + 1;
		int columnsCount = secondWord.length + 1;
		int[][] memo = new int[rowsCount][columnsCount];

		for (int row = 1; row < rowsCount; row++)
		{
			memo[row][0] = memo[row - 1][0] + 1;
		}

		for (int column = 1; column < columnsCount; column++)
		{
			memo[0][column] = memo[0][column - 1] + 1;
		}

		for (int row = 1; row < rowsCount; row++)
		{
			for (int column = 1; column < columnsCount; column++)
			{
				if (firstWord[row - 1] == secondWord[column - 1])
				{
					memo[row][column] = memo[row - 1][column - 1];
				}
				else
				{
					memo[row][column] = Math.min(memo[row][column - 1], Math.min(memo[row - 1][column - 1], memo[row - 1][column])) + 1;
				}
			}
		}

		return memo[rowsCount - 1][columnsCount - 1];
	}

	public static void main(String[] args)
	{
		System.out.println(new EditDistance().minDistance("", "a"));
		System.out.println(new EditDistance().minDistance("horse", "ros"));
		System.out.println(new EditDistance().minDistance("abba", "abba"));
	}
}
