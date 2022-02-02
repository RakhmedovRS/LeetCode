package contest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 9/27/2020
 */
public class Contest
{



	public static void main(String[] args) throws Exception
	{
		Contest clazz = new Contest();
	}

	private static String readBigTestCase() throws IOException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(Thread.currentThread().getContextClassLoader().getResource("TestCase.txt").getFile())))
		{
			return br.lines().collect(Collectors.joining());
		}
	}

	public long powerMod(long base, long exp, long mod)
	{
		long result = 1;
		base %= mod;
		while (exp > 0)
		{
			if ((exp & 1) != 0)
			{
				result = (result * base) % mod;
			}
			exp >>= 1;
			base = base * base % mod;
		}
		return result < 0 ? result + mod : result;
	}

	public int[] createCharFrequencyTable(String word)
	{
		int[] pattern = new int[26];
		for (char ch : word.toCharArray())
		{
			if (Character.isAlphabetic(ch))
			{
				pattern[Character.toLowerCase(ch) - 'a']++;
			}
		}

		return pattern;
	}

	public int manhattanDistance(int[] a, int[] b)
	{
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}
