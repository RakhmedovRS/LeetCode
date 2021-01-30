import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 30-Jan-21
 */
@LeetCode(
        id = 348,
        name = "Design Tic-Tac-Toe",
        url = "https://leetcode.com/problems/design-tic-tac-toe/",
        difficulty = Difficulty.MEDIUM,
        premium = true
)
public class DesignTicTacToe
{
    class TicTacToe
    {

        Boolean[][] table;
        int n;

        public TicTacToe(int n)
        {
            this.n = n;
            table = new Boolean[n][n];
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         *
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         * @return The current winning condition, can be either:
         * 0: No one wins.
         * 1: Player 1 wins.
         * 2: Player 2 wins.
         */
        public int move(int row, int col, int player)
        {
            table[row][col] = player % 2 == 0;

            if (playerWon(row, col))
            {
                return player;
            }

            return 0;
        }

        private boolean playerWon(int row, int col)
        {
            boolean target = table[row][col];

            // horizontal line
            int lc = col - 1;
            int rc = col + 1;
            int count = 1;
            while (lc >= 0 && table[row][lc] != null && table[row][lc] == target)
            {
                count++;
                lc--;
            }

            while (rc < n && table[row][rc] != null && table[row][rc] == target)
            {
                count++;
                rc++;
            }

            if (count == n)
            {
                return true;
            }

            // vertical line
            int ru = row - 1;
            int rd = row + 1;
            count = 1;
            while (ru >= 0 && table[ru][col] != null && table[ru][col] == target)
            {
                count++;
                ru--;
            }

            while (rd < n && table[rd][col] != null && table[rd][col] == target)
            {
                count++;
                rd++;
            }

            if (count == n)
            {
                return true;
            }

            // backslash line
            int r1 = row - 1;
            int c1 = col - 1;
            count = 1;
            while (r1 >= 0 && c1 >= 0 && table[r1][c1] != null && table[r1][c1] == target)
            {
                count++;
                r1--;
                c1--;
            }

            int r2 = row + 1;
            int c2 = col + 1;
            while (r2 < n && c2 < n && table[r2][c2] != null && table[r2][c2] == target)
            {
                count++;
                r2++;
                c2++;
            }

            if (count == n)
            {
                return true;
            }

            // slash line
            r1 = row + 1;
            c1 = col - 1;
            count = 1;
            while (r1 < n && c1 >= 0 && table[r1][c1] != null && table[r1][c1] == target)
            {
                count++;
                r1++;
                c1--;
            }

            r2 = row - 1;
            c2 = col + 1;
            while (r2 >= 0 && c2 < n && table[r2][c2] != null && table[r2][c2] == target)
            {
                count++;
                r2--;
                c2++;
            }

            return count == n;
        }
    }

    public static void main(String[] args)
    {
        TicTacToe ticTacToe = new DesignTicTacToe().new TicTacToe(3);
        ticTacToe.move(0, 0, 1);
        ticTacToe.move(0, 2, 2);
        ticTacToe.move(2, 2, 1);
        ticTacToe.move(1, 1, 2);
        ticTacToe.move(2, 0, 1);
        ticTacToe.move(1, 0, 2);
        ticTacToe.move(2, 1, 1);
    }
}
