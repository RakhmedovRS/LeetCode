import common.Difficulty;
import common.LeetCode;

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
		/**
		 * @param buf Destination buffer
		 * @param n   Number of characters to read
		 * @return The number of actual characters read
		 */
		public int read(char[] buf, int n)
		{
			int read = 0;
			int i = 0;
			while (n > 0)
			{
				char[] buf4 = new char[4];
				int pos = read4(buf4);
				if (pos == 0)
				{
					break;
				}

				for (int j = 0; j < pos && n > 0; j++)
				{
					buf[i++] = buf4[j];
					n--;
					read++;
				}
			}

			return read;
		}
	}

	public static void main(String[] args)
	{
		char[] buf = new char[4];
		new ReadNCharactersGivenRead4().new Solution().read(buf, 4);
		System.out.println(String.valueOf(buf));
	}
}

