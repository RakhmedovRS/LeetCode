import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author RakhmedovRS
 * @created 03-Jun-20
 */
@LeetCode(
	id = 535,
	name = "Encode and Decode TinyURL",
	url = "https://leetcode.com/problems/encode-and-decode-tinyurl/",
	difficulty = Difficulty.MEDIUM
)
public class EncodeAndDecodeTinyURL
{
	public class Codec
	{
		Random random = new Random();
		Map<String, String> encoded = new HashMap<>();
		Map<String, String> decoded = new HashMap<>();

		// Encodes a URL to a shortened URL.
		public String encode(String longUrl)
		{
			if (encoded.containsKey(longUrl))
			{
				return encoded.get(longUrl);
			}

			String tiny = generate();
			encoded.put(longUrl, tiny);
			decoded.put(tiny, longUrl);

			return tiny;
		}

		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl)
		{
			return decoded.get(shortUrl);
		}

		private String generate()
		{
			char[] chars = new char[6];
			while (true)
			{
				for (int i = 0; i < chars.length; i++)
				{
					chars[i] = (char) (random.nextInt(27) + 'a');
				}

				if (!decoded.containsKey(String.valueOf(chars)))
				{
					break;
				}
			}

			return String.valueOf(chars);
		}
	}
}
