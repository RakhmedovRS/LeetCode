package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/8/2020
 */
@LeetCode(
	id = 158,
	name = "Read N Characters Given Read4 II - Call multiple times",
	url = "https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/",
	difficulty = Difficulty.HARD,
	premium = true
)
public class ReadNCharactersGivenRead4IICallMultipleTimes
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

	public class Solution extends Reader4
	{
		/**
		 * @param buf Destination buffer
		 * @param n   Number of characters to read
		 * @return The number of actual characters read
		 */
		int pos = 0;
		List<Character> characters = new ArrayList<>();

		public int read(char[] buf, int n)
		{
			int read;
			char[] r4 = new char[4];
			int len = n;
			while (len > 0)
			{
				read = read4(r4);
				if (read == 0)
				{
					break;
				}

				for (int i = 0; i < read; i++)
				{
					characters.add(r4[i]);
					len--;
				}
			}

			int count = 0;
			for (int i = 0; pos < characters.size() && n > 0; i++, n--)
			{
				buf[i] = characters.get(pos++);
				count++;
			}

			return count;
		}
	}
}
