import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 19.02.2021
 */
@LeetCode(
        id = 773,
        name = "Sliding Puzzle",
        url = "https://leetcode.com/problems/sliding-puzzle/",
        difficulty = Difficulty.HARD
)
public class SlidingPuzzle
{
    public int slidingPuzzle(int[][] board)
    {
        Set<String> seen = new HashSet<>();
        Queue<int[][]> states = new LinkedList<>();
        states.add(board);
        seen.add(boardToString(board));
        int steps = 0;
        int[][] current;
        int size;
        while (!states.isEmpty())
        {
            size = states.size();
            while (size-- > 0)
            {
                current = states.remove();
                if (isBoardValid(current))
                {
                    return steps;
                }

                outer:
                for (int row = 0; row < current.length; row++)
                {
                    for (int column = 0; column < current[row].length; column++)
                    {
                        if (current[row][column] == 0)
                        {
                            if (row - 1 >= 0)
                            {
                                int[][] copy = createBoardCopy(current);
                                copy[row - 1][column] = current[row][column];
                                copy[row][column] = current[row - 1][column];
                                if (seen.add(boardToString(copy)))
                                {
                                    states.add(copy);
                                }
                            }

                            if (row + 1 < board.length)
                            {
                                int[][] copy = createBoardCopy(current);
                                copy[row + 1][column] = current[row][column];
                                copy[row][column] = current[row + 1][column];
                                if (seen.add(boardToString(copy)))
                                {
                                    states.add(copy);
                                }
                            }

                            if (column - 1 >= 0)
                            {
                                int[][] copy = createBoardCopy(current);
                                copy[row][column - 1] = current[row][column];
                                copy[row][column] = current[row][column - 1];
                                if (seen.add(boardToString(copy)))
                                {
                                    states.add(copy);
                                }
                            }

                            if (column + 1 < board[row].length)
                            {
                                int[][] copy = createBoardCopy(current);
                                copy[row][column + 1] = current[row][column];
                                copy[row][column] = current[row][column + 1];
                                if (seen.add(boardToString(copy)))
                                {
                                    states.add(copy);
                                }
                            }

                            break outer;
                        }
                    }
                }
            }
            steps++;
        }


        return -1;
    }

    private String boardToString(int[][] board)
    {
        return Arrays.toString(board[0]) + Arrays.toString(board[1]);
    }

    private boolean isBoardValid(int[][] board)
    {
        int val = 1;
        for (int row = 0; row < board.length; row++)
        {
            for (int column = 0; column < board[row].length; column++)
            {
                if (board[row][column] != val++ % 6)
                {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] createBoardCopy(int[][] board)
    {
        int[][] copy = new int[board.length][];
        for (int i = 0; i < 2; i++)
        {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return copy;
    }
}
