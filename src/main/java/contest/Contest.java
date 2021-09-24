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

	public int tribonacci(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		else if (n <= 2)
		{
			return 1;
		}

		int[] memo = new int[n + 1];
		memo[1] = memo[2] = 1;
		for (int i = 3; i < memo.length; i++)
		{
			memo[i] = memo[i - 3] + memo[i - 2] + memo[i - 1];
		}

		return memo[n];
	}

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
}
