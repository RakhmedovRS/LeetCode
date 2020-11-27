import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/27/2020
 */
@LeetCode(
	id = 639,
	name = "Decode Ways II",
	url = "https://leetcode.com/problems/decode-ways-ii/",
	difficulty = Difficulty.HARD
)
public class DecodeWaysII
{
	int mod = 1_000_000_007;

	public int numDecodings(String s)
	{
		char[] chars = s.toCharArray();
		return dfs(0, chars, new int[chars.length]['9' - '*' + 1]);
	}

	private int dfs(int pos, char[] chars, int[][] memo)
	{
		if (pos == chars.length)
		{
			return 1;
		}

		if (memo[pos][chars[pos] - '*'] != 0)
		{
			return memo[pos][chars[pos] - '*'];
		}

		int result = 0;
		if (chars[pos] == '*')
		{
			for (char next = '1'; next <= '9'; next++)
			{
				chars[pos] = next;
				result = (result + dfs(pos, chars, memo) % mod) % mod;
			}

			chars[pos] = '*';
		}
		else if (chars[pos] == '0')
		{
			result = 0;
		}
		else if (chars[pos] == '1')
		{
			if (pos + 1 < chars.length)
			{
				if (chars[pos + 1] == '*')
				{
					result = (result + dfs(pos + 1, chars, memo) % mod);
					for (char next = '1'; next <= '9'; next++)
					{
						result = (result + dfs(pos + 2, chars, memo) % mod) % mod;
					}
				}
				else
				{
					result = ((result + dfs(pos + 1, chars, memo) % mod) % mod +
						(result + dfs(pos + 2, chars, memo) % mod) % mod) % mod;
				}
			}
			else
			{
				result = (result + dfs(pos + 1, chars, memo) % mod) % mod;
			}
		}
		else if (chars[pos] == '2')
		{
			if (pos + 1 < chars.length)
			{
				if (chars[pos + 1] == '*')
				{
					result = (result + dfs(pos + 1, chars, memo) % mod);

					for (char next = '1'; next <= '6'; next++)
					{
						result = (result + dfs(pos + 2, chars, memo) % mod) % mod;
					}
				}
				else if (chars[pos + 1] <= '6')
				{
					result = (result + dfs(pos + 1, chars, memo) % mod) % mod +
						(result + dfs(pos + 2, chars, memo) % mod) % mod;
				}
				else
				{
					result = (result + dfs(pos + 2, chars, memo) % mod) % mod;
				}
			}
			else
			{
				result = (result + dfs(pos + 1, chars, memo) % mod) % mod;
			}
		}
		else
		{
			result = (result + dfs(pos + 1, chars, memo) % mod) % mod;
		}

		memo[pos][chars[pos] - '*'] = result;

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new DecodeWaysII().numDecodings("1101")); //1
		System.out.println(new DecodeWaysII().numDecodings("1*")); //18
		System.out.println(new DecodeWaysII().numDecodings("3*")); //9
		System.out.println(new DecodeWaysII().numDecodings("**")); //96
		System.out.println(new DecodeWaysII().numDecodings("*")); //9
	}
}
