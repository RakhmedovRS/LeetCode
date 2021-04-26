package contest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

	private static String readBigTestCase() throws FileNotFoundException
	{
		return new BufferedReader(new FileReader(Thread.currentThread().getContextClassLoader().getResource("TestCase.txt").getFile())).lines().collect(Collectors.joining());
	}
}
