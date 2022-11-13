package contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/20/2022
 */
public final class Helper
{
	public static long powerMod(long base, long exp, long mod)
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

	public static int[] createCharFrequencyTable(String word)
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

	public static int manhattanDistance(int[] a, int[] b)
	{
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

	public static List<int[]> getCommonDivisors(int k)
	{
		List<int[]> answer = new ArrayList<>();
		for (int i = 1; i <= Math.sqrt(k - 1); i++)
		{
			if (k % i == 0)
			{
				if (k / i == i)
				{
					answer.add(new int[]{i, i});
				}
				else
				{
					answer.add(new int[]{i, k / i});
				}
			}
		}

		return answer;
	}

	public static int gcd(int a, int b)
	{
		return a == 0 ? b : gcd(b % a, a);
	}

	public static int lcm(int a, int b)
	{
		return (a / gcd(a, b)) * b;
	}

	public static boolean isPalindrome(char[] chars, int left, int right)
	{
		while (left <= right)
		{
			if (chars[left++] != chars[right--])
			{
				return false;
			}
		}
		return true;
	}
}
