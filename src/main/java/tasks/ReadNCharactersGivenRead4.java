package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/5/2020
 */
@LeetCode(
        id = 157,
        name = "Read N Characters Given Read4",
        url = "https://leetcode.com/problems/read-n-characters-given-read4/",
        difficulty = Difficulty.EASY,
        premium = true
)
public class ReadNCharactersGivenRead4
{
    class Reader4
    {
        int read4(char[] buf4)
        {
            for (int i = 0; i < 4; i++)
            {
                buf4[i] = (char) ('a' + i);
            }

            return 4;
        }
    }

    class Solution extends Reader4
    {
        LinkedList<Character> buffer = new LinkedList<>();

        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        public int read(char[] buf, int n)
        {
            int count = 0;
            int r4;
            char[] arr4 = new char[4];
            for (int i = 0; i < n; i++)
            {
                if (buffer.isEmpty())
                {
                    r4 = read4(arr4);
                    for (int j = 0; j < r4; j++)
                    {
                        buffer.addLast(arr4[j]);
                    }
                }

                if (buffer.isEmpty())
                {
                    break;
                }

                buf[i] = buffer.removeFirst();
                count++;
            }

            return count;
        }
    }

    public static void main(String[] args)
    {
        char[] buf = new char[4];
        new ReadNCharactersGivenRead4().new Solution().read(buf, 4);
        System.out.println(String.valueOf(buf));
    }
}

