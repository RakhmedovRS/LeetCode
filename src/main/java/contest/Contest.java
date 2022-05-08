package contest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 9/27/2020
 */
public class Contest
{
	int MOD = 1_000_000_007;

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

	private static void outputFormattedInput(String input)
	{
		System.out.println(Arrays.stream(input.split("\n"))
			.map(Contest::replaceBracketsWithBraces)
			.collect(Collectors.joining(",\n")));
	}

	private static String replaceBracketsWithBraces(String input)
	{
		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			if (chars[i] == '[')
			{
				chars[i] = '{';
			}

			if (chars[i] == ']')
			{
				chars[i] = '}';
			}
		}
		return String.valueOf(chars);
	}
}
