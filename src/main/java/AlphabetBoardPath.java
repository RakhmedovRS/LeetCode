import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12-Jun-20
 */
@LeetCode(id = 1138, name = "Alphabet Board Path", url = "https://leetcode.com/problems/alphabet-board-path/")
public class AlphabetBoardPath
{
	public String alphabetBoardPath(String target)
	{
		Map<Character, int[]> board = new HashMap<>();
		int row = 0;
		int column = 0;
		for (char ch : "abcdefghijklmnopqrstuvwxyz".toCharArray())
		{
			board.putIfAbsent(ch, new int[]{row, column});
			column++;
			if (column == 5)
			{
				column = 0;
				row++;
			}
		}

		StringBuilder path = new StringBuilder();
		int[] currentPos = new int[]{0, 0};
		int[] targetPos;
		for (char ch : target.toCharArray())
		{
			targetPos = board.get(ch);
			while (currentPos[0] > targetPos[0])
			{
				currentPos[0]--;
				path.append('U');
			}

			while (currentPos[1] > targetPos[1])
			{
				currentPos[1]--;
				path.append('L');
			}

			while (currentPos[0] < targetPos[0])
			{
				currentPos[0]++;
				path.append('D');
			}

			while (currentPos[1] < targetPos[1])
			{
				currentPos[1]++;
				path.append('R');
			}
			path.append('!');
		}

		return path.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new AlphabetBoardPath().alphabetBoardPath("code"));
		System.out.println(new AlphabetBoardPath().alphabetBoardPath("leet"));
	}
}
