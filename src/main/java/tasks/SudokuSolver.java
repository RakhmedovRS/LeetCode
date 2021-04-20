package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 14-Jul-20
 */
@LeetCode(id = 37, name = "Sudoku Solver", url = "https://leetcode.com/problems/sudoku-solver/")
public class SudokuSolver
{
	public void solveSudoku(char[][] board)
	{
		solve(board, 0,0);
	}

	private boolean solve(char[][] board, int row, int column)
	{
		if (column == 9)
		{
			row++;
			column = 0;
		}

		if (row == board.length)
		{
			return true;
		}

		if (board[row][column] != '.')
		{
			return solve(board, row, column + 1);
		}

		for (int i = 1; i <= 9; i++)
		{
			board[row][column] = (char)(i + '0');
			if (isBoardValid(board, row, column))
			{
				if (solve(board, row, column))
				{
					return true;
				}
			}
			board[row][column] = '.';
		}

		return false;
	}

	private boolean isBoardValid(char[][] board, int row, int column)
	{
		int r = row < 4 ? 0 : row < 7 ? 3 : 6;
		int c = column < 4 ? 0 : column < 7 ? 3 : 6;

		Set<Character> set = new HashSet<>();

		//check row
		for (char ch: board[row])
		{
			if (ch != '.' && ! set.add(ch))
			{
				return false;
			}
		}

		//check column
		set = new HashSet<>();
		for (char[] chars : board)
		{
			char ch = chars[column];
			if (ch != '.' && !set.add(ch))
			{
				return false;
			}
		}

		//check sub square
		set = new HashSet<>();
		for (int i = r; i < r + 3; i++)
		{
			for (int j = c; j < c + 3; j++)
			{
				char ch = board[i][j];
				if (ch != '.' && ! set.add(ch))
				{
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		char[][] board = new char[][]
			{
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
			};

		new SudokuSolver().solveSudoku(board);

		for (char[] row :board)
		{
			System.out.println(Arrays.toString(row));
		}
	}
}
