import java.util.HashMap;
import java.util.Map;

/**
 * Roman to Integer
 * LeetCode 13
 *
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
public class RomanToInteger
{
	static Map<String, Integer> dictionary = new HashMap<>();

	static
	{
		dictionary.put("M", 1000);
		dictionary.put("CM", 900);
		dictionary.put("D", 500);
		dictionary.put("CD", 400);
		dictionary.put("C", 100);
		dictionary.put("XC", 90);
		dictionary.put("L", 50);
		dictionary.put("XL", 40);
		dictionary.put("X", 10);
		dictionary.put("IX", 9);
		dictionary.put("V", 5);
		dictionary.put("IV", 4);
		dictionary.put("I", 1);
	}

	public int romanToInt(String s)
	{
		int result = 0;
		for (int i = 0; i < s.length(); )
		{
			if (i + 1 < s.length() && dictionary.containsKey(s.substring(i, i + 2)))
			{
				result += dictionary.get(s.substring(i, i += 2));
			}
			else
			{
				result += dictionary.get(s.substring(i, ++i));
			}
		}

		return result;
	}
}
