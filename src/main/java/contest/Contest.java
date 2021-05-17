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
}
