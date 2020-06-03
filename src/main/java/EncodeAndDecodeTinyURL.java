import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author RakhmedovRS
 * @created 03-Jun-20
 */
@LeetCode(id = 535, name = "Encode and Decode TinyURL", url = "https://leetcode.com/problems/encode-and-decode-tinyurl/")
public class EncodeAndDecodeTinyURL
{
	public class Codec
	{
		char[][] dictionary = new char[][]
			{
				"0123456789".toCharArray(),
				"abcdefghijklmnopqrstuvwxyz".toCharArray(),
				"ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()
			};

		Map<String, String> urls = new HashMap<>();
		Random random = new Random();

		public String encode(String longUrl)
		{
			StringBuilder sb = new StringBuilder();
			while (sb.length() < 6)
			{
				char[] line = dictionary[random.nextInt(dictionary.length)];
				sb.append(line[random.nextInt(line.length)]);
			}

			String candidate = sb.toString();
			if (urls.containsKey(candidate))
			{
				return encode(longUrl);
			}

			urls.put(candidate, longUrl);
			return candidate;
		}

		public String decode(String shortUrl)
		{
			return urls.get(shortUrl);
		}
	}
}
